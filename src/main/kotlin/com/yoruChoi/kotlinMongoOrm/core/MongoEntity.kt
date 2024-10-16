package com.yoruChoi.kotlinMongoOrm.core

object MongoField {
    const val ID = "_id"
    const val STUDENT_ID = "student_id"
    const val EXAM_GRADE_ID = "exam_grade_id"
    const val NAME = "name"
    const val EMAIL_ADDRESS = "email_address"
    const val IS_ACTIVATED = "is_activated"
    const val CREATED_AT = "created_at"
    const val MATH = "math"
    const val ENGLISH = "english"
    const val SCIENCE = "science"
    const val HISTORY = "history"
}

object MongoCollection {
    const val STUDENT = "student"
    const val EXAM_GRADE = "exam_grade"
}
