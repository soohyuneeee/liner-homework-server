package homework.aurumplanet.liner.domain.page.service

import homework.aurumplanet.liner.domain.collection.domain.enums.OpenStatus
import homework.aurumplanet.liner.domain.mention.domain.Mention
import homework.aurumplanet.liner.domain.mention.domain.repository.MentionRepository
import homework.aurumplanet.liner.domain.page.domain.Page
import homework.aurumplanet.liner.domain.page.domain.repository.PageRepository
import homework.aurumplanet.liner.domain.page.presentation.dto.request.CreatePageRequest
import homework.aurumplanet.liner.domain.user.domain.User
import homework.aurumplanet.liner.domain.user.facade.UserFacade
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class CreatePageService(
    private val pageRepository: PageRepository,
    private val userFacade: UserFacade,
    private val mentionRepository: MentionRepository
) {
    @Transactional
    fun execute(request: CreatePageRequest) {
        val user = userFacade.findUserByUserId(request.userId)
        if (request.openStatus == OpenStatus.MENTIONED) {
            if (request.mentionedUserName.isNotEmpty()) {
                val mentionedUserList: List<String> = request.mentionedUserName.split(",")
                val mentionedUsers: List<User> = mentionedUserList.map { userFacade.findByUsername(it) }
                val page = pageRepository.save(
                    Page(
                        url = request.pageUrl,
                        user = user,
                        title = request.title,
                        openStatus = request.openStatus
                    )
                )
                mentionedUsers.map {
                    mentionRepository.save(
                        Mention(
                            user = it,
                            page = page,
                        )
                    )
                }

            }
        } else {
            pageRepository.save(
                Page(
                    url = request.pageUrl,
                    user = user,
                    title = request.title,
                    openStatus = request.openStatus
                )
            )
        }
    }

}