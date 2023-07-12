package homework.aurumplanet.liner.global.error

import homework.aurumplanet.liner.global.error.exception.ErrorCode
import org.springframework.http.HttpStatus

class ErrorResponse(errorCode: ErrorCode) {
    val status: HttpStatus
    val message: String

    init {
        status = errorCode.status
        message = errorCode.message
    }
}
