//package com.yoruChoi.kotlinMongoOrm.core
//
//import jakarta.annotation.PostConstruct
//import org.reflections.Reflections
//import org.reflections.scanners.SubTypesScanner
//import org.springframework.stereotype.Component
//import kotlin.reflect.full.memberProperties
//
//@Component
//class ReflectionLogger {
//    private val ENTITY_PACKAGE = ".entity"
//    private val BASE_PACKAGE = "com.yoruChoi.kotlinMongoOrm"
//
//    @PostConstruct
//    fun logFields() {
//        val reflections = Reflections(BASE_PACKAGE, SubTypesScanner(false))
//        val entityClasses = reflections.getSubTypesOf(Any::class.java)
//        // '.entity.'가 포함된 패키지에서 데이터 클래스만 필터링
//        val dataClasses = entityClasses.filter { clazz ->
//            val packageName = clazz.`package`.name
//            packageName.contains(ENTITY_PACKAGE) && clazz.kotlin.isData // 데이터 클래스 필터링
//        }
//        // 필드 정보를 출력
//        dataClasses.forEach { clazz ->
//            println("Fields of ${clazz.simpleName}:")
//            clazz.kotlin.memberProperties.forEach { property ->
//
//                if (property.returnType.toString().contains(ENTITY_PACKAGE)) {
//                    println(property.name)
//                    var test = true
//                    MongoCollection::class.memberProperties.forEach { property2 ->
//                        if (property.name == property2.name) {
//                            test = false
//                        }
//                    }
//                    throw Error("mongoOrm naming Error")
//                }
//            }
//        }
//    }
//}
//