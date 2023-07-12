package homework.aurumplanet.liner.domain.page.exception

import homework.aurumplanet.liner.global.error.exception.ErrorCode
import homework.aurumplanet.liner.global.error.exception.LinerException

class PageAlreadyExistsException : LinerException(ErrorCode.PAGE_ALREADY_EXISTS) {
}