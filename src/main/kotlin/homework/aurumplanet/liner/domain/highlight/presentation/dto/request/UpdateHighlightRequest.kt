package homework.aurumplanet.liner.domain.highlight.presentation.dto.request

data class UpdateHighlightRequest(
    val highlightId: Long,
    val colorHex: String,
    val text: String,
)
