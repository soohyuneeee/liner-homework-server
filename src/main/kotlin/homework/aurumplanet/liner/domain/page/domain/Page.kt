package homework.aurumplanet.liner.domain.page.domain

import homework.aurumplanet.liner.domain.user.domain.User
import homework.aurumplanet.liner.global.entity.BaseTimeEntity
import jakarta.persistence.*

@Entity
@Table(name = "tbl_page")
class Page(
    @Column(length = 50, nullable = false, unique = true)
    var url: String,
    @ManyToOne
    @JoinColumn(name = "user_id")
    var user: User,
    @Column
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    ) : BaseTimeEntity() {

}