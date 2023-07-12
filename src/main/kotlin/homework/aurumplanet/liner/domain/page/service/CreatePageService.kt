package homework.aurumplanet.liner.domain.page.service

import homework.aurumplanet.liner.domain.page.domain.Page
import homework.aurumplanet.liner.domain.page.domain.repository.PageRepository
import homework.aurumplanet.liner.domain.page.presentation.dto.request.CreatePageRequest
import homework.aurumplanet.liner.domain.user.facade.UserFacade
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class CreatePageService(
    private val pageRepository: PageRepository,
    private val userFacade: UserFacade
) {
    @Transactional
    fun execute(request: CreatePageRequest): Page {
        val user = userFacade.findUserByUserId(request.userId)
        return pageRepository.save(
            Page(
                url = request.pageUrl,
                user = user,
                title = request.title,
                openStatus = request.openStatus
            )
        )
    }
}