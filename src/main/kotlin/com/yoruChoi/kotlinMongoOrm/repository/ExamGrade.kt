package com.yoruChoi.kotlinMongoOrm.repository

import com.yoruChoi.kotlinMongoOrm.MongoCollection
import com.yoruChoi.kotlinMongoOrm.MongoField
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.time.LocalDateTime


@Document(collection = MongoCollection.EXAM_GRADE)
data class ExamGrade(
    @Id val id: ObjectId = ObjectId.get(),
    @Field(MongoField.NAME) var name: String,
    @Field(MongoField.EMAIL_ADDRESS) var emailAddress: String,
    @Field(MongoField.IS_ACTIVATED) val isActivated: Boolean = true,
    @Field(MongoField.CREATED_AT) var createdAt: LocalDateTime = LocalDateTime.now(),
)

