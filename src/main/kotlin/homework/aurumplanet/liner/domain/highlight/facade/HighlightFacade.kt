package homework.aurumplanet.liner.domain.highlight.facade

import homework.aurumplanet.liner.domain.highlight.domain.Highlight
import homework.aurumplanet.liner.domain.highlight.domain.repository.HighlightRepository
import homework.aurumplanet.liner.domain.highlight.exception.HighlightNotFoundException
import jakarta.transaction.Transactional
import org.springframework.stereotype.Component

@Component
class HighlightFacade(
    private val highlightRepository: HighlightRepository
) {
    @Transactional
    fun findById(highlightId: Long): Highlight {
        return highlightRepository.findById(highlightId)
            .orElseThrow { throw HighlightNotFoundException() }
    }
}