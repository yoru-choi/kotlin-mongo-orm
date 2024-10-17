package com.yoruChoi.kotlinMongoOrm.persistence

import com.yoruChoi.kotlinMongoOrm.persistence.entity.ExamGrade
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface ExamGradeRepository : MongoRepository<ExamGrade, ObjectId> {
}
