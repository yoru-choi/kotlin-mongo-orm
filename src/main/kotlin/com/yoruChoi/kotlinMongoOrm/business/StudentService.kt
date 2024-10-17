package com.yoruChoi.kotlinMongoOrm.business

import com.yoruChoi.kotlinMongoOrm.persistence.StudentRepository
import com.yoruChoi.kotlinMongoOrm.persistence.entity.Student
import org.bson.types.ObjectId
import org.springframework.stereotype.Service

@Service
class StudentService(
    private val studentRepository: StudentRepository,
) {
    fun getStudents(): List<GetStudentsServiceOutputDto> {
        val students =
            studentRepository.findAll().ifEmpty { throw Error("") }
        return students.map {
            GetStudentsServiceOutputDto(id = it.id.toString(), name = it.name, emailAddress = it.emailAddress)
        }
    }

    fun getStudent(studentId: String): GetStudentServiceOutputDto {
        val student =
            studentRepository.findByStudentIdWithExamGrade(ObjectId(studentId))
                .orElseThrow { Error("Student not found") }
        if (student.examGrade == null) throw Error("examGrade not found")
        return GetStudentServiceOutputDto(
            id = student.id.toString(),
            name = student.name,
            emailAddress = student.emailAddress,
            math = student.examGrade.math,
            english = student.examGrade.english,
            science = student.examGrade.science,
            history = student.examGrade.history,
        )
    }

    fun createStudent(name: String, emailAddress: String) {
        val student = Student(name = name, emailAddress = emailAddress)
        studentRepository.save(student)
    }
}

data class GetStudentsServiceOutputDto(
    val id: String,
    val name: String,
    val emailAddress: String
)

data class GetStudentServiceOutputDto(
    val id: String,
    val name: String,
    val emailAddress: String,
    val math: String,
    val english: String,
    val science: String,
    val history: String,
)