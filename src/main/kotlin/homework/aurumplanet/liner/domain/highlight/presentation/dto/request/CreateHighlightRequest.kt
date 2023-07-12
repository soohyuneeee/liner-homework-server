package homework.aurumplanet.liner.domain.highlight.presentation.dto.request

data class CreateHighlightRequest(
    val userId: Long,
    val pageUrl: String,
    val colorHex: String,
    val text: String,

    )
