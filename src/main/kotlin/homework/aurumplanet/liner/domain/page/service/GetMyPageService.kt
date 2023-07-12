package homework.aurumplanet.liner.domain.page.service

import homework.aurumplanet.liner.domain.page.domain.repository.PageRepository
import homework.aurumplanet.liner.domain.page.presentation.dto.response.GetFeedListResponse
import homework.aurumplanet.liner.domain.page.presentation.dto.response.GetHighlightResponse
import homework.aurumplanet.liner.domain.page.presentation.dto.response.GetPageResponse
import homework.aurumplanet.liner.domain.user.facade.UserFacade
import jakarta.transaction.Transactional
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

@Service
class GetMyPageService(
    private val userFacade: UserFacade,
    private val pageRepository: PageRepository
) {
    @Transactional
    fun execute(page: Int, size: Int): GetFeedListResponse {
        val user = userFacade.getCurrentUser()
        val pageable: Pageable = PageRequest.of(page - 1, size)
        val pages = pageRepository.findPagesByUser(user, pageable)
        return GetFeedListResponse(
            currentPage = pages.number + 1,
            hasMorePage = (pages.totalPages - 2 > pages.number),
            feedList = pages.content.map {
                GetPageResponse(
                    nickname = it.user.nickname,
                    username = it.user.username,
                    pageCreateAt = formatToLocalDateTime(it.createdAt),
                    pageId = it.id,
                    pageUrl = it.url,
                    pageTitle = it.title,
                    highlights = it.highlights.take(3).map { highlight ->
                        GetHighlightResponse(
                            highlightId = highlight.id,
                            colorHex = highlight.colorHex,
                            text = highlight.text
                        )
                    }
                )
            }
        )
    }

    fun formatToLocalDateTime(localDateTime: LocalDateTime?): String {
        val formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy", Locale.ENGLISH)
        return localDateTime?.format(formatter).toString()
    }
}