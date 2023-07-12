package homework.aurumplanet.liner.domain.mention.domain.repository

import homework.aurumplanet.liner.domain.mention.domain.Mention
import org.springframework.data.jpa.repository.JpaRepository

interface MentionRepository : JpaRepository<Mention, Long> {
}