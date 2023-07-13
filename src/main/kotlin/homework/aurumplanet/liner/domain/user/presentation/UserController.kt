package homework.aurumplanet.liner.domain.user.presentation

import homework.aurumplanet.liner.domain.user.presentation.dto.request.SignupRequest
import homework.aurumplanet.liner.domain.user.service.SignupService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(
    private val signupService: SignupService,
) {
    @PostMapping
    fun signup(@RequestBody request: SignupRequest) {
        signupService.execute(request)
    }
}