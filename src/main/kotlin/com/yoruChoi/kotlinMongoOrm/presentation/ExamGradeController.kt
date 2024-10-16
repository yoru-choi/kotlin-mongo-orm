package com.yoruChoi.kotlinMongoOrm.presentation


import com.yoruChoi.kotlinMongoOrm.business.GetStudentsServiceOutputDto
import com.yoruChoi.kotlinMongoOrm.business.StudentService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("exam-grades")
class ExamGradeController(
    private val studentService: StudentService,
) {
    @GetMapping("")
    fun getExamGrades(
    ): ResponseEntity<List<GetStudentsServiceOutputDto>> {
        val outputService = studentService.getStudents()
        return ResponseEntity(outputService, HttpStatus.OK)
    }

//    @GetMapping("{studentId}")
//    fun getExamGrade(
//        @PathVariable(required = true) studentId: String,
//    ): ResponseEntity<GetExamGradeServiceOutputDto> {
//        val outputService = studentService.getExamGrade(studentId)
//        return ResponseEntity(outputService, HttpStatus.OK)
//    }
//    @PostMapping("{studentId}")
//    fun createExamGrade(
//        @RequestBody(required = true) requestBody: CreateStudentRequestBody,
//    ): ResponseEntity<GetStudentServiceOutputDto> {
//        val (name, emailAddress) = requestBody
//        studentService.createStudent(name, emailAddress)
//        return ResponseEntity(HttpStatus.OK)
//    }
}
//
//data class CreateStudentRequestBody(
//    val name: String,
//    val emailAddress: String,
//)