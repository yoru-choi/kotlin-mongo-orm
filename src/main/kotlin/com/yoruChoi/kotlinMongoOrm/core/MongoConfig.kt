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

//    @Bean
//    fun mongoDatabaseFactory(): MongoDatabaseFactory {
//        val mongoUri = "mongodb://localhost:27017/test?retryWrites=false"
//        val connectionString = ConnectionString(mongoUri)
//        val settings = MongoClientSettings.builder()
//            .applyConnectionString(connectionString)  // Apply connection string
//            .applyToConnectionPoolSettings { builder ->
//                builder
//                    .maxSize(5) // Maximum connections in the pool, 1 core = 1~3 pool and We use 2core server
//                    .minSize(2) // Minimum connections in the pool
//                    .maxWaitTime(1500, TimeUnit.MILLISECONDS) // Max time to wait for a connection
//            }
//            .applyToSocketSettings { builder ->
//                builder
//                    .connectTimeout(30000, TimeUnit.MILLISECONDS) // Connection timeout
//                    .readTimeout(30000, TimeUnit.MILLISECONDS) // Read timeout
//            }.applyToClusterSettings { builder ->
//                builder.serverSelectionTimeout(50000, TimeUnit.MILLISECONDS) // Server selection timeout
//            }.build()
//        val mongoClient = MongoClients.create(settings)
//        val databaseName = connectionString.database
//            ?: throw IllegalArgumentException("Database name not found in URI: $mongoUri")
//        return SimpleMongoClientDatabaseFactory(mongoClient, databaseName)
//    }

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