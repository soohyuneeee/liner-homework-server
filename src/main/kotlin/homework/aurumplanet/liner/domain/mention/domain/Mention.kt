package homework.aurumplanet.liner.domain.mention.domain

import homework.aurumplanet.liner.domain.page.domain.PageEntity
import homework.aurumplanet.liner.domain.user.domain.User
import homework.aurumplanet.liner.global.entity.BaseTimeEntity
import jakarta.persistence.*

@Entity
@Table(name = "tbl_mention")
class Mention(
    @ManyToOne
    @JoinColumn(name = "user_id")
    var user: User,
    @ManyToOne
    @JoinColumn(name = "page_id")
    var page: PageEntity,
    @Column
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
) : BaseTimeEntity() {
}