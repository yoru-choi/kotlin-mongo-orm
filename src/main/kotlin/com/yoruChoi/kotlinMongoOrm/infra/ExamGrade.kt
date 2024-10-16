package com.yoruChoi.kotlinMongoOrm.infra

import com.yoruChoi.kotlinMongoOrm.core.MongoCollection
import com.yoruChoi.kotlinMongoOrm.core.MongoField
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.time.LocalDateTime


@Document(collection = MongoCollection.EXAM_GRADE)
data class ExamGrade(
    @Id val id: ObjectId = ObjectId.get(),
    @Field(MongoField.STUDENT_ID) var studentId: String,
    @Field(MongoField.MATH) var math: String,
    @Field(MongoField.ENGLISH) val english: String,
    @Field(MongoField.SCIENCE) val science: String,
    @Field(MongoField.HISTORY) val history: String,
    @Field(MongoField.CREATED_AT) var createdAt: LocalDateTime = LocalDateTime.now(),
)
