package com.yoruChoi.kotlinMongoOrm.persistence

import com.yoruChoi.kotlinMongoOrm.core.MongoCollection
import com.yoruChoi.kotlinMongoOrm.core.MongoField
import com.yoruChoi.kotlinMongoOrm.core.snakeToCamel
import com.yoruChoi.kotlinMongoOrm.persistence.entity.Student
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.aggregation.Aggregation
import org.springframework.data.mongodb.core.aggregation.AggregationResults
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.*

interface StudentRepository : MongoRepository<Student, ObjectId>, StudentAggregationRepository {
}

interface StudentAggregationRepository {
    fun findByStudentIdWithExamGrade(
        studentId: ObjectId,
    ): Optional<Student>
}

@Repository
class StudentAggregationRepositoryImpl : StudentAggregationRepository {
    @Autowired
    private lateinit var mongoTemplate: MongoTemplate

    override fun findByStudentIdWithExamGrade(
        studentId: ObjectId,
    ): Optional<Student> {
        val matchStage = Aggregation.match(
            Criteria.where(MongoField.ID).`is`(studentId)
        )
        val lookupStage = Aggregation.lookup(
            MongoCollection.EXAM_GRADE, // collection name
            MongoField.ID, // localField
            MongoField.STUDENT_ID, // foreignField
            MongoCollection.EXAM_GRADE.snakeToCamel() // as
        )
        val unwindStage = Aggregation.unwind(MongoCollection.EXAM_GRADE.snakeToCamel(), true)
        val aggregation = Aggregation.newAggregation(
            matchStage,
            lookupStage,
            unwindStage
        )
        val aggregationResults: AggregationResults<Student> =
            mongoTemplate.aggregate(
                aggregation, MongoCollection.STUDENT, Student::class.java
            )
        return Optional.ofNullable(aggregationResults.mappedResults.firstOrNull())
    }
}
