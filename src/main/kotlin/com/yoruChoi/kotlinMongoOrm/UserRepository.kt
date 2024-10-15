package jp.coconev.coconeapphub.apps.v1.userAndAuthService.infrastructure.repository

import jp.coconev.coconeapphub.apps.v1.userAndAuthService.infrastructure.entity.User
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

interface UserRepository : MongoRepository<User, ObjectId> {
    fun findAllByIdIn(userIds: List<ObjectId>): List<User>

    fun findByEmailAddress(emailAddress: String): Optional<User>
}

