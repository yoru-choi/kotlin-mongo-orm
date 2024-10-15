package jp.coconev.coconeapphub.apps.v1.userAndAuthService.business.service

import jp.coconev.coconeapphub.apps.v1.collaboratorService.infrastructure.repository.OrganizationRepository
import jp.coconev.coconeapphub.apps.v1.userAndAuthService.business.dto.UserServiceOutputDto
import jp.coconev.coconeapphub.apps.v1.userAndAuthService.infrastructure.repository.UserRepository
import jp.coconev.coconeapphub.utility.exception.AppHubException
import jp.coconev.coconeapphub.utility.exception.ErrorCodes
import org.bson.types.ObjectId
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val userRepository: UserRepository,
    private val organizationRepository: OrganizationRepository,
) {
    @Transactional(readOnly = true)
    fun getUser(userId: String): UserServiceOutputDto {
        val user =
            userRepository.findById(ObjectId(userId)).orElse(null)
                ?: throw AppHubException(ErrorCodes.DATABASE_DATA_IS_NULL)
        return UserServiceOutputDto(user.name, user.emailAddress)
    }

    @Transactional
    fun test() {

        println("")
        val matchOperation = organizationRepository.Test(ObjectId("66e10d52193b091bb1e47ac9"))
        println(matchOperation)
        println("")
    }
}