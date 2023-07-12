package homework.aurumplanet.liner.domain.page.service

import homework.aurumplanet.liner.domain.collection.domain.enums.OpenStatus
import homework.aurumplanet.liner.domain.page.domain.PageEntity
import homework.aurumplanet.liner.domain.page.domain.repository.PageRepository
import homework.aurumplanet.liner.domain.page.presentation.dto.request.GetFeedsRequest
import homework.aurumplanet.liner.domain.page.presentation.dto.response.GetFeedResponse
import homework.aurumplanet.liner.domain.page.presentation.dto.response.GetHighlightResponse
import homework.aurumplanet.liner.domain.page.presentation.dto.response.GetPageResponse
import homework.aurumplanet.liner.domain.user.facade.UserFacade
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class GetFeedsService(
    private val userFacade: UserFacade,
    private val pageRepository: PageRepository

) {
    fun execute(request: GetFeedsRequest): Page<GetFeedResponse> {
        val user = userFacade.findUserByUserId(request.userId)
        val pageable: Pageable = PageRequest.of(request.page - 1, request.size, Sort.by("h.createdAt").descending())
        val pages: Page<PageEntity> = pageRepository.findPagesWithMentionsOrPublic(user, OpenStatus.PUBLIC, pageable)
        return pages.map {
            GetFeedResponse(
                feed = GetPageResponse(
                    nickname = it.user.nickname,
                    username = it.user.username,
                    pageCreateAt = it.createdAt.toString(),
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
            )
        }

    }
}