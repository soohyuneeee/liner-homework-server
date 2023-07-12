package homework.aurumplanet.liner.domain.page.presentation.dto.response

data class GetFeedListResponse(
    var currentPage: Int,
    val hasMorePage: Boolean,
    val feedList: List<GetFeedResponse>
)