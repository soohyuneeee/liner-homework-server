package homework.aurumplanet.liner.domain.auth.service

import jakarta.transaction.Transactional
import homework.aurumplanet.liner.domain.auth.presentation.dto.request.LoginRequest
import homework.aurumplanet.liner.domain.auth.presentation.dto.response.TokenResponse
import homework.aurumplanet.liner.domain.user.exception.PasswordMismatchException
import homework.aurumplanet.liner.domain.user.facade.UserFacade
import homework.aurumplanet.liner.global.security.jwt.JwtTokenProvider
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class LoginService(
    private val userFacade: UserFacade,
    private val jwtTokenProvider: JwtTokenProvider,
    private val passwordEncoder: PasswordEncoder
) {
    @Transactional
    fun execute(request: LoginRequest): TokenResponse {
        val user = userFacade.findUserByUserId(request.userId)
        checkPassword(request.password, user.password)
        return TokenResponse(
            jwtTokenProvider.createAccessToken(user.userId.toString()),
            jwtTokenProvider.createRefreshToken(user.userId.toString()),
            user.userId,
            user.nickname
        )

    }

    fun checkPassword(password: String, encodedPassword: String) {
        if (!passwordEncoder.matches(password, encodedPassword)) {
            throw PasswordMismatchException()
        }
    }
}