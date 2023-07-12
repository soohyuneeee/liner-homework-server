package homework.aurumplanet.liner.domain.page.presentation.dto.response

data class GetPageResponse(
    val nickname: String?,
    val username: String,
    val pageCreateAt: String,
    val pageId: Long?,
    val pageUrl: String,
    val pageTitle: String,
    val highlights: List<GetHighlightResponse>
)