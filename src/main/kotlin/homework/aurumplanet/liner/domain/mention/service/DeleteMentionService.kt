package homework.aurumplanet.liner.domain.mention.service

import homework.aurumplanet.liner.domain.mention.domain.repository.MentionRepository
import homework.aurumplanet.liner.domain.page.domain.PageEntity
import homework.aurumplanet.liner.domain.user.facade.UserFacade
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class DeleteMentionService(
    private val mentionRepository: MentionRepository,
    private val userFacade: UserFacade

) {
    @Transactional
    fun execute(userName: String, page: PageEntity) {
        val user = userFacade.findByUsername(userName)
        mentionRepository.deleteByUserAndPage(user, page)
    }
}