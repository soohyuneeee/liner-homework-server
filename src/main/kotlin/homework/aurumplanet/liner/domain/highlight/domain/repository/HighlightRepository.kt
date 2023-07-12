package homework.aurumplanet.liner.domain.highlight.domain.repository

import homework.aurumplanet.liner.domain.highlight.domain.Highlight
import org.springframework.data.jpa.repository.JpaRepository

interface HighlightRepository : JpaRepository<Highlight, Long> {
}