package homework.aurumplanet.liner.domain.user.presentation

import homework.aurumplanet.liner.domain.user.presentation.dto.request.SignupRequest
import homework.aurumplanet.liner.domain.user.service.SignupService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
@Tag(name = "회원가입 서버")
class UserController(
    private val signupService: SignupService,
) {
    @Operation(summary = "회원가입")
    @PostMapping
    fun signup(@RequestBody request: SignupRequest) {
        signupService.execute(request)
    }
}