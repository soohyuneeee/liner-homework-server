package homework.aurumplanet.liner.domain.page.presentation.dto.response

data class GetHighlightResponse(
    val highlightId : Long?,
    val colorHex : String,
    val text : String,
)