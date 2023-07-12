package homework.aurumplanet.liner.domain.page.presentation

import homework.aurumplanet.liner.domain.page.presentation.dto.request.CreatePageRequest
import homework.aurumplanet.liner.domain.page.presentation.dto.request.GetFeedsRequest
import homework.aurumplanet.liner.domain.page.presentation.dto.response.GetFeedListResponse
import homework.aurumplanet.liner.domain.page.service.CreatePageService
import homework.aurumplanet.liner.domain.page.service.GetFeedsService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/page")
@Tag(name = "페이지 서버")
class PageController(
    private val createPageService: CreatePageService,
    private val getFeedsService: GetFeedsService
) {
    @Operation(summary = "페이지 생성")
    @PostMapping
    fun createPage(@RequestBody request: CreatePageRequest) {
        createPageService.execute(request)
    }

    @Operation(summary = "피드 보기")
    @PostMapping("/feed")
    fun getFeed(@RequestBody request: GetFeedsRequest): GetFeedListResponse {
        return getFeedsService.execute(request)
    }

}