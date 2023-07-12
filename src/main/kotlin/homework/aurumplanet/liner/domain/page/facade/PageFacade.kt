package homework.aurumplanet.liner.domain.page.facade

import homework.aurumplanet.liner.domain.page.domain.Page
import homework.aurumplanet.liner.domain.page.domain.repository.PageRepository
import homework.aurumplanet.liner.domain.page.exception.PageNotFoundException
import homework.aurumplanet.liner.domain.user.domain.User
import jakarta.transaction.Transactional
import org.springframework.stereotype.Component

@Component
class PageFacade(
    private val pageRepository: PageRepository
) {
    @Transactional
    fun findByUserAndUrl(user:User, url: String): Page {
        return pageRepository.findByUserAndUrl(user, url)
            .orElseThrow { throw PageNotFoundException() }
    }
}