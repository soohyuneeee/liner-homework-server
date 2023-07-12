package homework.aurumplanet.liner.domain.page.presentation

import homework.aurumplanet.liner.domain.page.presentation.dto.request.CreatePageRequest
import homework.aurumplanet.liner.domain.page.presentation.dto.request.UpdatePageRequest
import homework.aurumplanet.liner.domain.page.presentation.dto.response.GetFeedListResponse
import homework.aurumplanet.liner.domain.page.service.CreatePageService
import homework.aurumplanet.liner.domain.page.service.GetFeedsService
import homework.aurumplanet.liner.domain.page.service.GetMyPageService
import homework.aurumplanet.liner.domain.page.service.UpdatePageService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/page")
@Tag(name = "페이지 서버")
class PageController(
    private val createPageService: CreatePageService,
    private val getFeedsService: GetFeedsService,
    private val updatePageService: UpdatePageService,
    private val getMyPageService: GetMyPageService
) {
    @Operation(summary = "페이지 생성")
    @PostMapping
    fun createPage(@RequestBody request: CreatePageRequest) {
        createPageService.execute(request)
    }

    @Operation(summary = "피드 보기")
    @GetMapping("/feed")
    fun getFeed(@RequestParam userId: Long, @RequestParam page: Int, @RequestParam size: Int): GetFeedListResponse {
        return getFeedsService.execute(userId, page, size)
    }

    @Operation(summary = "페이지 수정")
    @PatchMapping
    fun updatePage(@RequestBody request: UpdatePageRequest) {
        updatePageService.execute(request)
    }

    @Operation(summary = "나의 페이지")
    @GetMapping("/my")
    fun getMyPage(@RequestParam page: Int, @RequestParam size: Int): GetFeedListResponse {
        return getMyPageService.execute(page, size)
    }

}