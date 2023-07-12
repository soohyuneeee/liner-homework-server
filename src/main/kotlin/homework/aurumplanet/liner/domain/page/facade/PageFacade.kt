package homework.aurumplanet.liner.domain.page.facade

import homework.aurumplanet.liner.domain.page.domain.PageEntity
import homework.aurumplanet.liner.domain.page.domain.repository.PageRepository
import homework.aurumplanet.liner.domain.page.exception.PageAlreadyExistsException
import homework.aurumplanet.liner.domain.page.exception.PageNotFoundException
import homework.aurumplanet.liner.domain.user.domain.User
import jakarta.transaction.Transactional
import org.springframework.stereotype.Component

@Component
class PageFacade(
    private val pageRepository: PageRepository
) {
    @Transactional
    fun findByUserAndUrl(user:User, url: String): PageEntity {
        return pageRepository.findByUserAndUrl(user, url)
            .orElseThrow { throw PageNotFoundException() }
    }
    @Transactional
    fun existsByUserAndUrl(user:User, url: String) {
        if(pageRepository.existsByUserAndUrl(user, url))
            throw PageAlreadyExistsException()
    }
    @Transactional
    fun findById(pageId: Long): PageEntity {
        return pageRepository.findById(pageId)
            .orElseThrow { throw PageNotFoundException() }
    }
}