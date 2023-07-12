package homework.aurumplanet.liner.domain.highlight.domain

import homework.aurumplanet.liner.domain.page.domain.Page
import homework.aurumplanet.liner.global.entity.BaseTimeEntity
import jakarta.persistence.*

@Entity
@Table(name = "tbl_highlight")
class Highlight(
    @Column(length = 50, nullable = false)
    var text: String,
    @Column(length = 50, nullable = false)
    var colorHex: String,
    @ManyToOne
    @JoinColumn(name = "page_id")
    var page: Page,
    @Column
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
) : BaseTimeEntity() {
    fun update(text: String, colorHex: String) {
        this.text = text
        this.colorHex = colorHex
    }
}