package homework.aurumplanet.liner.global.security.jwt

import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import jakarta.servlet.http.HttpServletRequest
import homework.aurumplanet.liner.domain.auth.domain.RefreshToken
import homework.aurumplanet.liner.domain.auth.domain.repository.RefreshTokenRepository
import homework.aurumplanet.liner.global.config.properties.JwtProperties
import homework.aurumplanet.liner.global.security.jwt.exception.ExpiredTokenException
import homework.aurumplanet.liner.global.security.jwt.exception.InvalidTokenException
import org.springframework.stereotype.Component
import java.security.Key
import java.util.*

@Component
class JwtTokenProvider(
    val jwtProperties: JwtProperties,
    val refreshTokenRepository: RefreshTokenRepository
) {

    fun createAccessToken(userId: String): String {
        return createToken(userId, jwtProperties.accessTokenValidTime);
    }

    fun createRefreshToken(userId: String): String {
        val token = createToken(userId, jwtProperties.refreshTokenValidTime)
        refreshTokenRepository.save(
            RefreshToken(token = token, email = userId)
        )
        return token
    }

    private fun createToken(userId: String, time: Long): String {
        val claims = Jwts.claims()
        claims["userId"] = userId
        val now = Date()

        return Jwts.builder()
            .setClaims(claims)
            .setIssuedAt(now)
            .setExpiration(Date(now.time + time))
            .signWith(getSigningKey(jwtProperties.secretKey), SignatureAlgorithm.HS256)
            .compact()
    }

    private fun getSigningKey(secretKey: String): Key {
        val keyBytes = secretKey.toByteArray(Charsets.UTF_8)
        return Keys.hmacShaKeyFor(keyBytes)
    }

    fun getUserId(token: String): String {
        return extractAllClaims(token)
            .get("userId", String::class.java)
    }

    private fun extractAllClaims(token: String): Claims {
        try {
            return Jwts.parserBuilder()
                .setSigningKey(getSigningKey(jwtProperties.secretKey))
                .build()
                .parseClaimsJws(token).body
        } catch (e: ExpiredJwtException) {
            throw ExpiredTokenException.EXCEPTION
        } catch (e: Exception) {
            throw InvalidTokenException.EXCEPTION
        }
    }

    fun resolveToken(request: HttpServletRequest): String? {
        val bearer = request.getHeader(jwtProperties.header)
        return parseToken(bearer)
    }

    private fun parseToken(bearer: String?): String? {
        if (bearer != null && bearer.startsWith(jwtProperties.prefix)) {
            return bearer.replace(jwtProperties.prefix, "")
        }

        return null
    }

}