package homework.aurumplanet.liner.domain.auth.presentation.dto.response

data class TokenResponse(
    val accessToken: String,
    val refreshToken: String,
    val userId: Long,
    val nickname: String
)