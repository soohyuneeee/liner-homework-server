package homework.aurumplanet.liner.domain.user.facade

import homework.aurumplanet.liner.domain.user.domain.User
import homework.aurumplanet.liner.domain.user.domain.repository.UserRepository
import homework.aurumplanet.liner.domain.user.exception.UserAlreadyExistsException
import homework.aurumplanet.liner.domain.user.exception.UserNotFoundException
import homework.aurumplanet.liner.global.security.auth.AuthDetails
import jakarta.transaction.Transactional
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class UserFacade(
    val userRepository: UserRepository,
) {
    @Transactional
    fun findUserByUserId(userId: Long): User {
        return userRepository.findUserByUserId(userId)
            .orElseThrow { throw UserNotFoundException() }
    }

    @Transactional
    fun findUserByUserIdAsString(userId: String): User {
        return userRepository.findUserByUserId(userId.toLong())
            .orElseThrow { throw UserNotFoundException() }
    }

    @Transactional
    fun getCurrentUser(): User {
        val auth = SecurityContextHolder.getContext().authentication.principal as AuthDetails
        return auth.user
    }

    @Transactional
    fun checkUserId(userId: Long?) {
        if (userRepository.existsUserByUserId(userId)) throw UserAlreadyExistsException()
    }
}