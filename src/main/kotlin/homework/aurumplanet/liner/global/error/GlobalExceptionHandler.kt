package homework.aurumplanet.liner.global.error

import jakarta.servlet.http.HttpServletRequest
import homework.aurumplanet.liner.global.error.exception.ErrorCode
import homework.aurumplanet.liner.global.error.exception.LinerException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(LinerException::class)
    fun handleMakerException(request: HttpServletRequest, ex: LinerException): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(ex.errorCode)
        return ResponseEntity<ErrorResponse>(errorResponse, errorResponse.status)
    }


    @ExceptionHandler(Exception::class)
    fun handleException(
        e: Exception,
        request: HttpServletRequest
    ): ErrorResponse {
        return ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR)
    }
}