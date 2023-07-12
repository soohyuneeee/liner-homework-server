package homework.aurumplanet.liner.global.error.exception


open class LinerException(val errorCode: ErrorCode) : RuntimeException(errorCode.message)
