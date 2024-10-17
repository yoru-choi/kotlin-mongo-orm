package com.yoruChoi.kotlinMongoOrm.core

import com.yoruChoi.kotlinMongoOrm.KotlinMongoOrmApplication
import jakarta.annotation.PostConstruct
import org.reflections.Reflections
import org.reflections.scanners.SubTypesScanner
import org.springframework.stereotype.Component
import kotlin.reflect.full.memberProperties

@Component
class EntityFieldValidator {
    private val entityPackageSuffix = ".entity"
    private val basePackageName = KotlinMongoOrmApplication::class.java.`package`.name

    private val mongoCollectionFieldNames =
        MongoCollection::class.memberProperties.map { it.getter.call().toString().snakeToCamel() }.toSet()

    @PostConstruct
    fun validateMongoFieldNames() {
        val entityClasses = fetchEntityClasses()
        verifyFieldNames(entityClasses)
    }

    private fun fetchEntityClasses(): List<Class<out Any>> {
        //TODO 'SubTypesScanner' is deprecated. Deprecated in Java
        val reflections = Reflections(basePackageName, SubTypesScanner(false))
        val allClasses = reflections.getSubTypesOf(Any::class.java)
        return allClasses.filter { clazz ->
            val packageName = clazz.`package`.name
            packageName.contains(entityPackageSuffix)
        }
    }

    private fun verifyFieldNames(entityClasses: List<Class<out Any>>) {
        entityClasses.forEach { clazz ->
            clazz.kotlin.memberProperties.forEach { property ->
                if (property.returnType.toString().contains(entityPackageSuffix)) {
                    if (!mongoCollectionFieldNames.contains(property.name)) {
                        throw Error("Invalid MongoDB field name: ${property.name}, type: ${property.returnType}")
                    }
                }
            }
        }
    }
}
