package homework.aurumplanet.liner.domain.user.domain.repository

import homework.aurumplanet.liner.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface UserRepository: JpaRepository<User, Long>{
    fun findUserByUserId(userId: Long): Optional<User>
    fun existsUserByUserId(userId: Long?): Boolean
}
