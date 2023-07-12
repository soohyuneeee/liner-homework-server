package homework.aurumplanet.liner.domain.highlight.service

import homework.aurumplanet.liner.domain.highlight.domain.Highlight
import homework.aurumplanet.liner.domain.highlight.domain.repository.HighlightRepository
import homework.aurumplanet.liner.domain.highlight.presentation.dto.request.CreateHighlightRequest
import homework.aurumplanet.liner.domain.page.facade.PageFacade
import homework.aurumplanet.liner.domain.user.facade.UserFacade
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class CreateHighlightService(
    private val userFacade: UserFacade,
    private val pageFacade: PageFacade,
    private val highlightRepository: HighlightRepository,

    ) {
    @Transactional
    fun execute(request: CreateHighlightRequest) {
        val user = userFacade.getCurrentUser()
        val page = pageFacade.findByUserAndUrl(user, request.pageUrl)
        highlightRepository.save(
            Highlight(
                page = page,
                colorHex = request.colorHex,
                text = request.text,
            )
        )
    }
}