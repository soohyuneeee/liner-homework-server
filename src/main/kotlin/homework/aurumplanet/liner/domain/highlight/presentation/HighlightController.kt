package homework.aurumplanet.liner.domain.highlight.presentation

import homework.aurumplanet.liner.domain.highlight.presentation.dto.request.CreateHighlightRequest
import homework.aurumplanet.liner.domain.highlight.service.CreateHighlightService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/highlight")
@Tag(name = "하이라이트 서버")
class HighlightController(
    private val createHighlightService: CreateHighlightService,
) {
    @Operation(summary = "하이라이트 생성")
    @PostMapping
    fun createHighlight(@RequestBody request: CreateHighlightRequest) {
        createHighlightService.execute(request)
    }
}