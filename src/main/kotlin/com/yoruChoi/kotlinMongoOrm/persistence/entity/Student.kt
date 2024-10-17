package com.yoruChoi.kotlinMongoOrm.persistence.entity

import com.yoruChoi.kotlinMongoOrm.core.MongoCollection
import com.yoruChoi.kotlinMongoOrm.core.MongoField
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.time.LocalDateTime

@Document(collection = MongoCollection.STUDENT)
data class Student(
    @Id val id: ObjectId = ObjectId.get(),
    @Field(MongoField.NAME) var name: String,
    @Field(MongoField.EMAIL_ADDRESS) var emailAddress: String,
    @Field(MongoField.IS_ACTIVATED) val isActivated: Boolean = true,
    @Field(MongoField.CREATED_AT) var createdAt: LocalDateTime = LocalDateTime.now(),

    val examGrade: ExamGrade? = null
)

//class Test {
//
//    @PostConstruct
//    fun test(T: class) {
//        println(T.class.memberProperties.foreach{property -> println(property.name)}
//    }
//}

//{
//    companion object {
//        init {
//            val variableName = Student::class.memberProperties
//                .firstOrNull { it.name == MongoCollection.EXAM_GRADE.snakeToCamel() }
//            if (variableName == null) throw Error("examGrade field name is not same MongoCollection.EXAM_GRADE.snakeToCamel()")
//            println("test")
//        }
//    }
//}