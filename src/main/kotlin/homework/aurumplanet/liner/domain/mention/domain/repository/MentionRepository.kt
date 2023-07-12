package homework.aurumplanet.liner.domain.mention.domain.repository

import homework.aurumplanet.liner.domain.mention.domain.Mention
import homework.aurumplanet.liner.domain.page.domain.PageEntity
import homework.aurumplanet.liner.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface MentionRepository : JpaRepository<Mention, Long> {
    fun deleteByUserAndPage(user: User, page: PageEntity)
}