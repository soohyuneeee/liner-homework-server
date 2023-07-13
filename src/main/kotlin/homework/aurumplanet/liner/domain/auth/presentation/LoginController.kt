package homework.aurumplanet.liner.domain.auth.presentation

import homework.aurumplanet.liner.domain.auth.presentation.dto.request.LoginRequest
import homework.aurumplanet.liner.domain.auth.presentation.dto.response.TokenResponse
import homework.aurumplanet.liner.domain.auth.service.LoginService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/login")
class LoginController(private val loginService: LoginService) {
    @PostMapping
    fun login(@RequestBody request: LoginRequest): TokenResponse {
        return loginService.execute(request)
    }
}