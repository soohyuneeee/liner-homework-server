package homework.aurumplanet.liner.domain.user.service

import homework.aurumplanet.liner.domain.user.domain.User
import homework.aurumplanet.liner.domain.user.domain.repository.UserRepository
import homework.aurumplanet.liner.domain.user.facade.UserFacade
import homework.aurumplanet.liner.domain.user.presentation.dto.request.SignupRequest
import jakarta.transaction.Transactional
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class SignupService(
    private val userFacade: UserFacade,
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {
    @Transactional
    fun execute(request: SignupRequest) {
        userFacade.checkUserId(request.userId)
        userRepository.save(
            User(
                userId = request.userId,
                nickname = request.nickname,
                password = passwordEncoder.encode(request.password),
                username = request.username
            )
        )
    }
}