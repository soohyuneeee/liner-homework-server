package homework.aurumplanet.liner.domain.page.presentation

import homework.aurumplanet.liner.domain.page.presentation.dto.request.CreatePageRequest
import homework.aurumplanet.liner.domain.page.service.CreatePageService
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

    ) {
    @Operation(summary = "페이지 생성")
    @PostMapping
    fun createPage(@RequestBody request: CreatePageRequest) {
        createPageService.execute(request)
    }

}