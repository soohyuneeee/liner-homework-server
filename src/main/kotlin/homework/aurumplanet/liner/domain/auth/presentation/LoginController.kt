package homework.aurumplanet.liner.domain.auth.presentation

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import homework.aurumplanet.liner.domain.auth.presentation.dto.request.LoginRequest
import homework.aurumplanet.liner.domain.auth.presentation.dto.response.TokenResponse
import homework.aurumplanet.liner.domain.auth.service.LoginService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/login")
@Tag(name = "로그인 서버")
class LoginController(private val loginService: LoginService) {
    @Operation(summary = "로그인")
    @PostMapping
    fun login(@RequestBody request: LoginRequest): TokenResponse {
        return loginService.execute(request)
    }
}