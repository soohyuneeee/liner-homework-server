package homework.aurumplanet.liner.domain.page.service

import homework.aurumplanet.liner.domain.page.facade.PageFacade
import homework.aurumplanet.liner.domain.page.presentation.dto.response.GetHighlightResponse
import homework.aurumplanet.liner.domain.page.presentation.dto.response.GetPageResponse
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

@Service
class GetPageService(
    private val pageFacade: PageFacade,

    ) {
    @Transactional
    fun execute(pageId: Long): GetPageResponse {
        val page = pageFacade.findById(pageId)
        return GetPageResponse(
            nickname = page.user.nickname,
            username = page.user.username,
            pageCreateAt = formatToLocalDateTime(page.createdAt),
            pageId = page.id,
            pageUrl = page.url,
            pageTitle = page.title,
            highlights = page.highlights.map {
                GetHighlightResponse(
                    highlightId = it.id,
                    colorHex = it.colorHex,
                    text = it.text
                )
            }
        )
    }

    fun formatToLocalDateTime(localDateTime: LocalDateTime?): String {
        val formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy", Locale.ENGLISH)
        return localDateTime?.format(formatter).toString()
    }
}