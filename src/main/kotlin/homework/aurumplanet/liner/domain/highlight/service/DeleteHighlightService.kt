package homework.aurumplanet.liner.domain.highlight.service

import homework.aurumplanet.liner.domain.highlight.domain.repository.HighlightRepository
import homework.aurumplanet.liner.domain.highlight.presentation.dto.request.DeleteHighlightRequest
import org.springframework.stereotype.Service

@Service
class DeleteHighlightService(
    private val highlightRepository: HighlightRepository,
) {
    fun execute(request: DeleteHighlightRequest) {
        val highlight = highlightRepository.findById(request.highlightId)
        highlightRepository.delete(highlight.get())
    }
}