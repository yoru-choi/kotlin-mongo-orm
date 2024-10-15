package jp.coconev.coconeapphub.apps.v1.userAndAuthService.infrastructure.entity

import jp.coconev.coconeapphub.config.MongoCollection
import jp.coconev.coconeapphub.config.MongoField
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.time.LocalDateTime

@Document(collection = MongoCollection.USER)
data class User(
    @Id val id: ObjectId = ObjectId.get(),
    @Field(MongoField.NAME) var name: String,
    @Field(MongoField.EMAIL_ADDRESS) var emailAddress: String,
    @Field(MongoField.IS_ACTIVATED) val isActivated: Boolean = true,
    @Field(MongoField.CREATED_AT) var createdAt: LocalDateTime = LocalDateTime.now(),
)

