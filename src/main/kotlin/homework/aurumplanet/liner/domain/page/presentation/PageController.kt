package homework.aurumplanet.liner.domain.page.presentation

import homework.aurumplanet.liner.domain.page.presentation.dto.request.CreatePageRequest
import homework.aurumplanet.liner.domain.page.presentation.dto.request.UpdatePageRequest
import homework.aurumplanet.liner.domain.page.presentation.dto.response.GetFeedListResponse
import homework.aurumplanet.liner.domain.page.presentation.dto.response.GetPageResponse
import homework.aurumplanet.liner.domain.page.service.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/page")
class PageController(
    private val createPageService: CreatePageService,
    private val getFeedsService: GetFeedsService,
    private val updatePageService: UpdatePageService,
    private val getMyPageService: GetMyPageService,
    private val getPageService: GetPageService
) {
    @PostMapping
    fun createPage(@RequestBody request: CreatePageRequest) {
        createPageService.execute(request)
    }

    @GetMapping("/feed")
    fun getFeed(@RequestParam userId: Long, @RequestParam page: Int, @RequestParam size: Int): GetFeedListResponse {
        return getFeedsService.execute(userId, page, size)
    }

    @PatchMapping
    fun updatePage(@RequestBody request: UpdatePageRequest) {
        updatePageService.execute(request)
    }

    @GetMapping("/my")
    fun getMyPage(@RequestParam page: Int, @RequestParam size: Int): GetFeedListResponse {
        return getMyPageService.execute(page, size)
    }

    @GetMapping("/{pageId}")
    fun getPage(@PathVariable pageId: Long): GetPageResponse {
        return getPageService.execute(pageId)
    }

}