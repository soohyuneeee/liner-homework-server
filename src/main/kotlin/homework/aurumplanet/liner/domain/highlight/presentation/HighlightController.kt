package homework.aurumplanet.liner.domain.highlight.presentation

import homework.aurumplanet.liner.domain.highlight.presentation.dto.request.CreateHighlightRequest
import homework.aurumplanet.liner.domain.highlight.presentation.dto.request.DeleteHighlightRequest
import homework.aurumplanet.liner.domain.highlight.presentation.dto.request.UpdateHighlightRequest
import homework.aurumplanet.liner.domain.highlight.service.CreateHighlightService
import homework.aurumplanet.liner.domain.highlight.service.DeleteHighlightService
import homework.aurumplanet.liner.domain.highlight.service.UpdateHighlightService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/highlight")
class HighlightController(
    private val createHighlightService: CreateHighlightService,
    private val updateHighlightService: UpdateHighlightService,
    private val deleteHighlightService: DeleteHighlightService
) {
    @PostMapping
    fun createHighlight(@RequestBody request: CreateHighlightRequest) {
        createHighlightService.execute(request)
    }

    @PatchMapping
    fun updateHighlight(@RequestBody request: UpdateHighlightRequest) {
        updateHighlightService.execute(request)
    }

    @DeleteMapping
    fun deleteHighlight(@RequestBody request: DeleteHighlightRequest) {
        deleteHighlightService.execute(request)
    }
}