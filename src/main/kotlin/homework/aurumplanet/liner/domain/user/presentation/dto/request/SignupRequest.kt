package homework.aurumplanet.liner.domain.user.presentation.dto.request

data class SignupRequest (
    val userId: Long,
    val nickname: String,
    val username: String,
    val password: String,
)
