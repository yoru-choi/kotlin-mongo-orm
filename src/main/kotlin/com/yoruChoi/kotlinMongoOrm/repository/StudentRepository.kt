package com.yoruChoi.kotlinMongoOrm.repository

import com.yoruChoi.kotlinMongoOrm.MongoCollection
import com.yoruChoi.kotlinMongoOrm.MongoField
import com.yoruChoi.kotlinMongoOrm.snakeToCamel
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.aggregation.Aggregation
import org.springframework.data.mongodb.core.aggregation.AggregationResults
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.*

interface StudentRepository : MongoRepository<Student, ObjectId>, ExamGradeRepositoryAggregation {

}


interface ExamGradeRepositoryAggregation {

    fun findByStudentIdAndOrganizationIdAndStateWithOrganization(
        studentId: ObjectId,
        organizationId: ObjectId,
    ): Optional<ExamGrade>
}

@Repository
class ExamGradeRepositoryAggregationImpl : ExamGradeRepositoryAggregation {
    @Autowired
    private lateinit var mongoTemplate: MongoTemplate


    override fun findByStudentIdAndOrganizationIdAndStateWithOrganization(
        studentId: ObjectId,
        organizationId: ObjectId,
    ): Optional<ExamGrade> {
        val matchStage = Aggregation.match(
            Criteria.where(MongoField.USER_ID).`is`(studentId)
        )
        val lookupStage = Aggregation.lookup(
            MongoCollection.EXAM_GRADE, // collection name
            MongoField.EXAM_GRADE_ID, // localField
            MongoField.ID, // foreignField
            MongoCollection.EXAM_GRADE.snakeToCamel() // as
        )
        val unwindStage = Aggregation.unwind(MongoCollection.EXAM_GRADE.snakeToCamel(), true)
        val aggregation = Aggregation.newAggregation(
            matchStage,
            lookupStage,
            unwindStage
        )
        val results: AggregationResults<ExamGrade> =
            mongoTemplate.aggregate(
                aggregation, MongoCollection.STUDENT, ExamGrade::class.java
            )
        return Optional.ofNullable(results.mappedResults.firstOrNull())
    }
}