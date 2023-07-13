package homework.aurumplanet.liner.domain.page.service

import homework.aurumplanet.liner.domain.page.domain.enums.OpenStatus
import homework.aurumplanet.liner.domain.mention.service.CleanUpMentionMemberService
import homework.aurumplanet.liner.domain.mention.service.CreateMentionService
import homework.aurumplanet.liner.domain.mention.service.DeleteMentionService
import homework.aurumplanet.liner.domain.page.facade.PageFacade
import homework.aurumplanet.liner.domain.page.presentation.dto.request.UpdatePageRequest
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class UpdatePageService(
    private val pageFacade: PageFacade,
    private val cleanUpMentionMemberService: CleanUpMentionMemberService,
    private val createMentionService: CreateMentionService,
    private val deleteMentionService: DeleteMentionService

) {
    @Transactional
    fun execute(request: UpdatePageRequest) {
        val page = pageFacade.findById(request.pageId)
        if (request.openStatus == OpenStatus.MENTIONED) {
            if (!request.mentionedUserName.isNullOrEmpty()) {
                val mentionedUserList = page.mentionedUserList?.split(",")
                val newMentionedUserList = request.mentionedUserName.split(",")
                if (mentionedUserList != null) {
                    cleanUpMentionMemberService.execute(mentionedUserList, newMentionedUserList, page)
                } else {
                    newMentionedUserList.forEach {
                        createMentionService.execute(it, page)
                    }
                }
            }
            page.updatePage(request.title, request.openStatus, request.mentionedUserName)
        } else {
            if (page.mentionedUserList != null) {
                page.mentionedUserList?.split(",")?.forEach {
                    deleteMentionService.execute(it, page)
                }
            }
            page.updatePage(request.title, request.openStatus, null)
        }

    }
}
