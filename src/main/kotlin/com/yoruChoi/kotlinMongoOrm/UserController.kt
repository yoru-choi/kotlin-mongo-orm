package com.yoruChoi.kotlinMongoOrm


import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("students")
class StudentController(
    private val studentService: StudentService,
) {
    @GetMapping("detail")
    fun getStudents(
    ): ResponseEntity<StudentServiceOutputDto> {
        val outputService = studentService.getStudent("studentId")
        return ResponseEntity(outputService, HttpStatus.OK)
    }

    //test
//    @PostMapping
//    fun getAppddd(
//        @RequestAttribute("studentId") @ObjectIdOnly studentId: String,
//        @RequestParam(required = true) @ObjectIdOnly test: String,
//        @RequestBody(required = true) @Validated requestBody: UpdateAppCollaboratorRequestBodyDto,
//    ): ResponseEntity<ApiSuccessResponseDto<StudentServiceOutputDto>> {
//        requestBody.logger().info("studentId: $studentId")
//
//        logger().info("studentId: $studentId")
//        val outputService = studentService.getStudent(studentId)
//        val responseBody = ApiSuccessResponseDto(data = outputService)
//        logger().info(responseBody.toString())
//
//        return ResponseEntity(responseBody, HttpStatus.OK)
//    }
}
