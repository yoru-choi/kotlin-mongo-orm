package com.yoruChoi.kotlinMongoOrm


import com.yoruChoi.kotlinMongoOrm.repository.StudentRepository
import org.bson.types.ObjectId
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class StudentService(
    private val studentRepository: StudentRepository,
) {
    @Transactional(readOnly = true)
    fun getStudent(studentId: String): StudentServiceOutputDto {
        val student =
            studentRepository.findById(ObjectId(studentId)).orElse(null)
                ?: throw Error("")
        return StudentServiceOutputDto(student.name, student.emailAddress)
    }

//    @Transactional
//    fun test() {
//
//        println("")
//        val matchOperation = organizationRepository.Test(ObjectId("66e10d52193b091bb1e47ac9"))
//        println(matchOperation)
//        println("")
//    }
}

data class StudentServiceOutputDto(
    val name: String,
    val emailAddress: String
)