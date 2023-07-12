package homework.aurumplanet.liner.global.error.exception

import org.springframework.http.HttpStatus

enum class ErrorCode(
    val status: HttpStatus,
    val message: String,
) {
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버에 오류가 발생했습니다."),

    EXPIRED_TOKEN(HttpStatus.UNAUTHORIZED, "만료된 토큰입니다."),
    INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "유효하지 않은 토큰입니다."),

    USER_ALREADY_EXISTS(HttpStatus.UNPROCESSABLE_ENTITY, "사용자가 이미 존재합니다."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "사용자가 없습니다."),
    PASSWORD_MISMATCH(HttpStatus.UNAUTHORIZED, "비밀번호가 틀렸습니다."),
    HIGHLIGHT_NOT_FOUND(HttpStatus.NOT_FOUND, "하이라이트가 없습니다."),
    PAGE_NOT_FOUND(HttpStatus.NOT_FOUND, "페이지가 없습니다."),
    PAGE_ALREADY_EXISTS(HttpStatus.UNPROCESSABLE_ENTITY, "페이지가 이미 존재합니다."),



}