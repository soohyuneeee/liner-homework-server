package homework.aurumplanet.liner.domain.highlight.service

import homework.aurumplanet.liner.domain.highlight.facade.HighlightFacade
import homework.aurumplanet.liner.domain.highlight.presentation.dto.request.UpdateHighlightRequest
import homework.aurumplanet.liner.domain.user.facade.UserFacade
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class UpdateHighlightService(
    private val userFacade: UserFacade,
    private val highlightFacade: HighlightFacade
) {
    @Transactional
    fun execute(request: UpdateHighlightRequest) {
        val user = userFacade.findUserByUserId(request.userId)
        val highlight = highlightFacade.findById(request.highlightId)
        highlight.update(
            request.text,
            request.colorHex
        )
    }
}