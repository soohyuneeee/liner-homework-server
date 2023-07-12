package homework.aurumplanet.liner.domain.page.domain.repository

import homework.aurumplanet.liner.domain.page.domain.Page
import org.springframework.data.jpa.repository.JpaRepository

interface PageRepository:JpaRepository<Page, Long> {

}