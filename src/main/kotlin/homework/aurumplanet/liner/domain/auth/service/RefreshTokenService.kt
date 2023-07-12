package homework.aurumplanet.liner.domain.auth.service

import jakarta.transaction.Transactional
import homework.aurumplanet.liner.domain.auth.domain.RefreshToken
import homework.aurumplanet.liner.domain.auth.domain.repository.RefreshTokenRepository
import homework.aurumplanet.liner.domain.auth.presentation.dto.response.AccessTokenResponse
import homework.aurumplanet.liner.global.security.jwt.JwtTokenProvider
import homework.aurumplanet.liner.global.security.jwt.exception.ExpiredTokenException
import org.springframework.stereotype.Service

@Service
class RefreshTokenService(
    private val refreshTokenRepository: RefreshTokenRepository,
    private val jwtTokenProvider: JwtTokenProvider
) {
    fun execute(token: String): AccessTokenResponse {
        val refreshToken = getRefreshToken(token)
        val accessToken = jwtTokenProvider.createAccessToken(refreshToken.email)
        return AccessTokenResponse(accessToken)
    }

    @Transactional
    private fun getRefreshToken(token: String): RefreshToken {
        return refreshTokenRepository.findById(token)
            .orElseThrow { ExpiredTokenException.EXCEPTION }
    }
}
