package com.yoruChoi.kotlinMongoOrm.business

import com.yoruChoi.kotlinMongoOrm.infra.ExamGrade
import com.yoruChoi.kotlinMongoOrm.infra.ExamGradeRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ExamGradeService(
    private val examGradeRepository: ExamGradeRepository,
) {
    @Transactional(readOnly = true)
    fun createExamGrade() {
        val test = ExamGrade(studentId = "", math = "", english = "", science = "", history = "")
        examGradeRepository.save(test)
    }

}

data class GetExamGradesServiceOutputDto(
    val id: String,
    val name: String,
    val emailAddress: String
)

data class GetExamGradeServiceOutputDto(
    val id: String,
    val name: String,
    val emailAddress: String,
    val math: String,
    val english: String,
    val science: String,
    val history: String,
)