package homework.aurumplanet.liner.domain.page.presentation.dto.request

import homework.aurumplanet.liner.domain.collection.domain.enums.OpenStatus

data class UpdatePageRequest(
    val pageId: Long,
    val title: String,
    val openStatus: OpenStatus,
    val mentionedUserName: String?
)
