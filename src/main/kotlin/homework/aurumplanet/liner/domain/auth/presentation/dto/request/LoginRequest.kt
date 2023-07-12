package homework.aurumplanet.liner.domain.auth.presentation.dto.request

data class LoginRequest(
    val userId: Long,
    val password: String
)