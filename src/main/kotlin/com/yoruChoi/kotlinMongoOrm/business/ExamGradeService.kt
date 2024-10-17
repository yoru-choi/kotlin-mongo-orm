package com.yoruChoi.kotlinMongoOrm.business

import com.yoruChoi.kotlinMongoOrm.persistence.ExamGradeRepository
import com.yoruChoi.kotlinMongoOrm.persistence.entity.ExamGrade
import org.bson.types.ObjectId
import org.springframework.stereotype.Service

@Service
class ExamGradeService(
    private val examGradeRepository: ExamGradeRepository,
) {
    fun createExamGrade(param: CreateExamGradeServiceInputDto) {
        val examGrade = ExamGrade(
            studentId = ObjectId(param.studentId),
            math = param.math,
            english = param.english,
            science = param.science,
            history = param.history
        )
        examGradeRepository.save(examGrade)
    }
}

data class CreateExamGradeServiceInputDto(
    val studentId: String,
    val math: String,
    val english: String,
    val science: String,
    val history: String,
)