package homework.aurumplanet.liner.domain.mention.service

import homework.aurumplanet.liner.domain.page.domain.PageEntity
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class CleanUpMentionMemberService(
    private val createMentionService: CreateMentionService,
    private val deleteMentionService: DeleteMentionService

) {
    @Transactional
    fun execute(mentionedUserList: List<String>, newMentionedUserList: List<String>, page: PageEntity) {
        val usersToDelete = mentionedUserList.filterNot { newMentionedUserList.contains(it) }
        val usersToInsert = newMentionedUserList.filterNot { mentionedUserList.contains(it) }
        usersToInsert.forEach { userName ->
            createMentionService.execute(userName, page)
        }
        usersToDelete.forEach { userName ->
            deleteMentionService.execute(userName, page)
        }
    }
}