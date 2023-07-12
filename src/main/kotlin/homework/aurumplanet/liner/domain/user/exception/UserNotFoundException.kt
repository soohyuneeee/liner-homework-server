package homework.aurumplanet.liner.domain.user.exception

import homework.aurumplanet.liner.global.error.exception.ErrorCode
import homework.aurumplanet.liner.global.error.exception.LinerException

class UserNotFoundException : LinerException(ErrorCode.USER_NOT_FOUND) {
}
