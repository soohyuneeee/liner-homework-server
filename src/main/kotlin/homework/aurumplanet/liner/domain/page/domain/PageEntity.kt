package homework.aurumplanet.liner.domain.page.domain

import homework.aurumplanet.liner.domain.collection.domain.enums.OpenStatus
import homework.aurumplanet.liner.domain.highlight.domain.Highlight
import homework.aurumplanet.liner.domain.mention.domain.Mention
import homework.aurumplanet.liner.domain.user.domain.User
import homework.aurumplanet.liner.global.entity.BaseTimeEntity
import jakarta.persistence.*

@Entity
@Table(name = "tbl_page")
class PageEntity(
    @Column(length = 50, nullable = false)
    var url: String,
    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    var openStatus: OpenStatus,
    @Column(length = 100, nullable = false)
    var title: String,
    @Column(length = 100)
    var mentionedUserList: String? = null,
    @ManyToOne
    @JoinColumn(name = "user_id")
    var user: User,
    @OneToMany(mappedBy = "page")
    var highlights: MutableList<Highlight> = mutableListOf(),
    @OneToMany(mappedBy = "page")
    var mentions: MutableList<Mention> = mutableListOf(),
    @Column
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    ) : BaseTimeEntity() {

    fun updatePage(title: String, openStatus: OpenStatus, mentionedUserList: String? = null) {
        this.openStatus = openStatus
        this.title = title
        this.mentionedUserList = mentionedUserList
    }

}