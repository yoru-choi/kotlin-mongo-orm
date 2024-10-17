package com.yoruChoi.kotlinMongoOrm.core


import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.MongoDatabaseFactory
import org.springframework.data.mongodb.MongoTransactionManager
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory


@Configuration
class MongoConfig {
    @Bean
    fun mongoDatabaseFactory(): MongoDatabaseFactory {
        val mongoUri = "mongodb://localhost:27017/kotlin-mongo-orm"
        return SimpleMongoClientDatabaseFactory(mongoUri)
    }

    @Bean
    fun mongoTemplate(): MongoTemplate {
        return MongoTemplate(mongoDatabaseFactory())
    }

    //forTransactionRollback
    @Bean
    fun transactionManager(dbFactory: MongoDatabaseFactory): MongoTransactionManager {
        return MongoTransactionManager(dbFactory)
    }
}