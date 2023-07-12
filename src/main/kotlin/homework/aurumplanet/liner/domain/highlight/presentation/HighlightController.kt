package homework.aurumplanet.liner.domain.highlight.presentation

import homework.aurumplanet.liner.domain.highlight.presentation.dto.request.CreateHighlightRequest
import homework.aurumplanet.liner.domain.highlight.presentation.dto.request.DeleteHighlightRequest
import homework.aurumplanet.liner.domain.highlight.presentation.dto.request.UpdateHighlightRequest
import homework.aurumplanet.liner.domain.highlight.service.CreateHighlightService
import homework.aurumplanet.liner.domain.highlight.service.DeleteHighlightService
import homework.aurumplanet.liner.domain.highlight.service.UpdateHighlightService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/highlight")
@Tag(name = "하이라이트 서버")
class HighlightController(
    private val createHighlightService: CreateHighlightService,
    private val updateHighlightService: UpdateHighlightService,
    private val deleteHighlightService: DeleteHighlightService
) {
    @Operation(summary = "하이라이트 생성")
    @PostMapping
    fun createHighlight(@RequestBody request: CreateHighlightRequest) {
        createHighlightService.execute(request)
    }

    @Operation(summary = "하이라이트 수정")
    @PatchMapping
    fun updateHighlight(@RequestBody request: UpdateHighlightRequest) {
        updateHighlightService.execute(request)
    }

    @Operation(summary = "하이라이트 삭제")
    @DeleteMapping
    fun deleteHighlight(@RequestBody request: DeleteHighlightRequest) {
        deleteHighlightService.execute(request)
    }
}