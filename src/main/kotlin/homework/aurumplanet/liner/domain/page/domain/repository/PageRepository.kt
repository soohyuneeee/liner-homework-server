package homework.aurumplanet.liner.domain.page.domain.repository

import homework.aurumplanet.liner.domain.collection.domain.enums.OpenStatus
import homework.aurumplanet.liner.domain.page.domain.PageEntity
import homework.aurumplanet.liner.domain.user.domain.User
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface PageRepository : JpaRepository<PageEntity, Long> {
    fun findByUrlAndUser(url: String, user: User): Optional<PageEntity>
    fun existsByUrlAndUser(url: String, user: User): Boolean
    fun findByUserAndUrl(user: User, url: String): Optional<PageEntity>

    @Query("select p from PageEntity p join fetch p.highlights h where p.user = :user order by h.updatedAt desc")
    fun findPagesWithHighlightsOrderByUpdatedAtDesc(user: User): List<PageEntity>

    @Query("select p from PageEntity p join fetch p.highlights h where p in (select m.page from Mention m where m.user = :user) or p.openStatus = :openStatus or p.user = :user order by h.createdAt desc")
    fun findPagesWithMentionsOrPublic(user: User, openStatus: OpenStatus, pageable: Pageable): Page<PageEntity>
}