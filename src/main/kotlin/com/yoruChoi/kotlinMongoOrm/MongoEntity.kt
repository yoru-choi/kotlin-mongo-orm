package com.yoruChoi.kotlinMongoOrm

object MongoField {
    const val ID = "_id"
    const val USER_ID = "student_id"
    const val EXAM_GRADE_ID = "student_id"
    const val NAME = "name"
    const val EMAIL_ADDRESS = "email_address"
    const val IS_ACTIVATED = "is_activated"
    const val CREATED_AT = "created_at"
}

object MongoCollection {
    const val STUDENT = "student"
    const val EXAM_GRADE = "exam_grade"
}
