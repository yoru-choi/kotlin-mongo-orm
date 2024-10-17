package com.yoruChoi.kotlinMongoOrm.presentation


import com.yoruChoi.kotlinMongoOrm.business.CreateExamGradeServiceInputDto
import com.yoruChoi.kotlinMongoOrm.business.ExamGradeService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("exam-grades")
class ExamGradeController(
    private val examGradeService: ExamGradeService,
) {
    @PostMapping("")
    fun createExamGrade(
        @RequestBody(required = true) requestBody: CreateExamGradeRequestBody,
    ): ResponseEntity<HttpStatus> {
        val (studentId, math, english, science, history) = requestBody
        val serviceInput = CreateExamGradeServiceInputDto(
            studentId = studentId, math = math, english = english, science = science, history = history
        )
        examGradeService.createExamGrade(serviceInput)
        return ResponseEntity(HttpStatus.OK)
    }
}

data class CreateExamGradeRequestBody(
    val studentId: String,
    val math: String,
    val english: String,
    val science: String,
    val history: String,
)
