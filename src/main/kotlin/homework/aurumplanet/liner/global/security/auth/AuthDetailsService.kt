package homework.aurumplanet.liner.global.security.auth

import homework.aurumplanet.liner.domain.user.facade.UserFacade
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class AuthDetailsService(
    val userFacade: UserFacade,
) : UserDetailsService {

    override fun loadUserByUsername(userId: String): UserDetails {
        return AuthDetails(userFacade.findUserByUserId(userId.toLong()))
    }
}