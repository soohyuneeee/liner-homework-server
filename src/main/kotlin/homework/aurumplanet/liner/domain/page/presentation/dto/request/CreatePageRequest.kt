package homework.aurumplanet.liner.domain.page.presentation.dto.request

import homework.aurumplanet.liner.domain.collection.domain.enums.OpenStatus

data class CreatePageRequest(
    val userId: Long,
    val pageUrl: String,
    val title: String,
    val openStatus: OpenStatus
)