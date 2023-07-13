package homework.aurumplanet.liner.domain.auth.presentation

import homework.aurumplanet.liner.domain.auth.presentation.dto.response.AccessTokenResponse
import homework.aurumplanet.liner.domain.auth.service.RefreshTokenService
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(private val refreshTokenService: RefreshTokenService) {


    @PutMapping
    fun refreshToken(@RequestHeader("Refresh-Token") refreshToken: String): AccessTokenResponse {
        return refreshTokenService.execute(refreshToken)
    }
}
