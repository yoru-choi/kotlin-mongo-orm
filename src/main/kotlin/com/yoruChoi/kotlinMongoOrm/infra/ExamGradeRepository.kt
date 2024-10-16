package com.yoruChoi.kotlinMongoOrm.infra

import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface ExamGradeRepository : MongoRepository<ExamGrade, ObjectId> {
}
