package homework.aurumplanet.liner.domain.page.presentation.dto.request

data class GetFeedsRequest(
    val userId: Long,
    val page: Int,
    val size: Int
)