package homework.aurumplanet.liner.domain.highlight.service

import homework.aurumplanet.liner.domain.highlight.domain.repository.HighlightRepository
import homework.aurumplanet.liner.domain.highlight.presentation.dto.request.DeleteHighlightRequest
import homework.aurumplanet.liner.domain.user.facade.UserFacade
import org.springframework.stereotype.Service

@Service
class DeleteHighlightService(
    private val highlightRepository: HighlightRepository,
    private val userFacade: UserFacade
) {
    fun execute(request: DeleteHighlightRequest) {
        val user = userFacade.findUserByUserId(request.userId)
        val highlight = highlightRepository.findById(request.highlightId)
        highlightRepository.delete(highlight.get())
    }
}