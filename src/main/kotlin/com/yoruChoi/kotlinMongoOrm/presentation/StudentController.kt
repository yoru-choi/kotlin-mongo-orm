package com.yoruChoi.kotlinMongoOrm.presentation


import com.yoruChoi.kotlinMongoOrm.business.GetStudentServiceOutputDto
import com.yoruChoi.kotlinMongoOrm.business.GetStudentsServiceOutputDto
import com.yoruChoi.kotlinMongoOrm.business.StudentService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("students")
class StudentController(
    private val studentService: StudentService,
) {
    @GetMapping("")
    fun getStudents(
    ): ResponseEntity<List<GetStudentsServiceOutputDto>> {
        val outputService = studentService.getStudents()
        return ResponseEntity(outputService, HttpStatus.OK)
    }

    @GetMapping("{studentId}")
    fun getStudent(
        @PathVariable(required = true) studentId: String,
    ): ResponseEntity<GetStudentServiceOutputDto> {
        val outputService = studentService.getStudent(studentId)
        return ResponseEntity(outputService, HttpStatus.OK)
    }

    @PostMapping("")
    fun createStudent(
        @RequestBody(required = true) requestBody: CreateStudentRequestBody,
    ): ResponseEntity<GetStudentServiceOutputDto> {
        val (name, emailAddress) = requestBody
        studentService.createStudent(name, emailAddress)
        return ResponseEntity(HttpStatus.OK)
    }
}

data class CreateStudentRequestBody(
    val name: String,
    val emailAddress: String,
)