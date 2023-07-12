package homework.aurumplanet.liner.domain.user.domain

import homework.aurumplanet.liner.global.entity.BaseTimeEntity
import jakarta.persistence.*

@Entity
@Table(name = "tbl_user")
class User(
    @Column(length = 50, nullable = false, unique = true)
    var userId: Long,

    @Column(length = 20, nullable = false)
    var nickname: String,

    @Column(length = 100, nullable = false)
    var password: String,

    @Column(length = 20, nullable = false)
    var username: String,

    @Column
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
) : BaseTimeEntity() {
}