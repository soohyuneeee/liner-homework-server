package homework.aurumplanet.liner.domain.page.service

import homework.aurumplanet.liner.domain.page.domain.enums.OpenStatus
import homework.aurumplanet.liner.domain.mention.service.CreateMentionService
import homework.aurumplanet.liner.domain.page.domain.PageEntity
import homework.aurumplanet.liner.domain.page.domain.repository.PageRepository
import homework.aurumplanet.liner.domain.page.facade.PageFacade
import homework.aurumplanet.liner.domain.page.presentation.dto.request.CreatePageRequest
import homework.aurumplanet.liner.domain.user.facade.UserFacade
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class CreatePageService(
    private val pageRepository: PageRepository,
    private val userFacade: UserFacade,
    private val pageFacade: PageFacade,
    private val createMentionService: CreateMentionService
) {
    @Transactional
    fun execute(request: CreatePageRequest) {
        val user = userFacade.findUserByUserId(request.userId)
        pageFacade.existsByUserAndUrl(user, request.pageUrl)
        if (request.openStatus == OpenStatus.MENTIONED) {
            if (!request.mentionedUserName.isNullOrEmpty()) {
                val mentionedUserList: List<String> = request.mentionedUserName.split(",")
                val page = pageRepository.save(
                    PageEntity(
                        url = request.pageUrl,
                        user = user,
                        title = request.title,
                        openStatus = request.openStatus,
                        mentionedUserList = request.mentionedUserName
                    )
                )
                mentionedUserList.map {
                    createMentionService.execute(it, page)
                }

            }
        } else {
            pageRepository.save(
                PageEntity(
                    url = request.pageUrl,
                    user = user,
                    title = request.title,
                    openStatus = request.openStatus
                )
            )
        }
    }

}