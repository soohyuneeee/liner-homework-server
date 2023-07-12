package homework.aurumplanet.liner.global.security.jwt.exception

import homework.aurumplanet.liner.global.error.exception.ErrorCode
import homework.aurumplanet.liner.global.error.exception.LinerException

object InvalidTokenException : LinerException(ErrorCode.INVALID_TOKEN) {
    val EXCEPTION by lazy { this }
}