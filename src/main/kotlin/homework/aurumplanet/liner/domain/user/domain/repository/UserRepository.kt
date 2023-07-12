package homework.aurumplanet.liner.domain.user.domain.repository

import homework.aurumplanet.liner.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long>{

}
