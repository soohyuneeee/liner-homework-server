package homework.aurumplanet.liner.domain.highlight.exception

import homework.aurumplanet.liner.global.error.exception.ErrorCode
import homework.aurumplanet.liner.global.error.exception.LinerException

class HighlightNotFoundException:LinerException(ErrorCode.HIGHLIGHT_NOT_FOUND) {
}