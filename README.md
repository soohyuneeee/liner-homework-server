# 안녕하세요. 아우름플래닛 백엔드 사전과제 5.0을 수행하게 된 조수현입니다!
안녕하세요. 저는 조수현이라고 합니다. <br>
부산소프트웨어마이스터고등학교를 떠나 취업을 위해 아우름플래닛 백엔드 사전과제를 수행하게 되었습니다. <br>
이번 과제를 진행하면서 사용자 친화적인 기능을 어떻게 구현할 수 있을지에 대해 많은 고민을 해보게 되었던 것 같습니다. <br><br>
중간에 공개범위 지정에 대한 의문점이 있어서 라이너팀에 질문을 하였는데, 친절하게 답변을 주셔서 정말 감사했습니다. <br><br>
이렇게 사전과제를 통해 도전하고, 성장하며 발전하는 경험을 쌓는 것은 정말 의미있는 시간이었습니다.<br>
사전과제를 성공적으로 완료하여 아우름플래닛의 일원이 되고자 합니다. 감사합니다.

# API 명세서
`토글을 펼쳐서 api 문서를 확인해 보세요!`
<details>
<summary> user</summary>
<div markdown="1">

1. `POST` **회원가입**

   URL :
   `/user`
   <br>
   <br>
   `REQUEST`
   ---
   ```json
   {
    "userId" :12333,
    "nickname" : "조수현테스트테스트",
    "username" : "@05tngus99",
    "password" : "1234"
   }
   ```
   `RESPONSE`
   ---
   사용자가 이미 존재할 경우
   ```json
   {
    "status": "UNPROCESSABLE_ENTITY",
    "message": "사용자가 이미 존재합니다."
   }
   ```
   ---
   정상적인 작동
   ```
   200 Ok
   ```

3. `POST` **로그인**

   URL :
   `/login`
   <br>
   <br>
   `REQUEST`
   ---
   ```json
   {
    "userId" : 12345,
    "password" : "1234"
   }
   ```
   `RESPONSE`
   ---

   존재하지 않는 userId를 입력한 경우
   ```json
   {
    "status": "NOT_FOUND",
    "message": "사용자가 없습니다."
   }
   ```
   ---
   잘못된 비밀번호를 입력한 경우
   ```json
   {
    "status": "UNAUTHORIZED",
    "message": "비밀번호가 틀렸습니다."
   }
   ```
   ---
   정상적인 작동
   ```json
   {
    "accessToken": "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOiIxMjM0NSIsImlhdCI6MTY4OTE3ODI0NywiZXhwIjoxNjg5MTgxODQ3fQ.QV1KvxG2GKFcZ3VhR7PU5NLY16LytJpBIZ7dSyjpbUQ",
    "refreshToken": "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOiIxMjM0NSIsImlhdCI6MTY4OTE3ODI0NywiZXhwIjoxNjg5MjY0NjQ3fQ.cJ01_yCmky2Y9SsA9_sGqp8okRlodeRyz5ZVjxBaMJg",
    "userId": 12345,
    "nickname": "조수현"
   }
   ```

</div>
</details>

<details>
<summary> page</summary>
<div markdown="1">

1. `POST` **페이지 생성**

   URL :
   `/page`
   <br>
   <br>
   `REQUEST`
   ---
   
   `openStatus`를 `PUBLIC`또는 `PRIVATE`로 하는 경우
   ```json
   {
     "userId": 123,
     "pageUrl": "google.com",
     "title": "보이나?",
     "openStatus": "PUBLIC",
     "mentionedUserName": null
   }
   ```
   ---
   `openStatus`를 `MENTIONED`로 하는 경우
   ```json
   {
     "userId": 123,
     "pageUrl": "google.com",
     "title": "보이나?",
     "openStatus": "MENTIONED",
     "mentionedUserName": "@05tngus,@05tngus95,@05tngus959595"
   }
   ```

   `RESPONSE`
   ---
   
   이미 해당 pageUrl를 저장한 페이지가 있을 경우

   ```json
   {
     "status": "UNPROCESSABLE_ENTITY",
     "message": "페이지가 이미 존재합니다."
   }

   ```
   ---
   `mentionedUserName`에 존재하지 않는 값이 들어갔을 경우
   ```json
   {
    "status": "NOT_FOUND",
    "message": "사용자가 없습니다."
   }
   ```
   ---
   정상적인 작동
   ```

   200 Ok

   ```
3. `PATCH` **페이지 수정**
 
   URL :
   `/page`
   <br>
   <br>
   `REQUEST`
   ---
   
   `openStatus`를 `PUBLIC`또는 `PRIVATE`로 하는 경우
   ```json
   {
    "pageId" : 8,
    "title" : "테스트페이지",
    "openStatus" : "PRIVATE",
    "mentionedUserName" : null

   }
   ```
   ---
   `openStatus`를 `MENTIONED`로 하는 경우
   ```json
   {
    "pageId" : 8,
    "title" : "테스트페이지",
     "title": "보이나?",
     "openStatus": "MENTIONED",
     "mentionedUserName": "@05tngus,@05tngus95,@05tngus959595"
   }
   ```

   `RESPONSE`
   ---
   
   이미 해당 pageUrl를 저장한 페이지가 있을 경우

   ```json
   {
     "status": "UNPROCESSABLE_ENTITY",
     "message": "페이지가 이미 존재합니다."
   }

   ```
   ---
   `mentionedUserName`에 존재하지 않는 값이 들어갔을 경우
   ```json
   {
    "status": "NOT_FOUND",
    "message": "사용자가 없습니다."
   }
   ```
   ---
   정상적인 작동
   ```

   200 Ok

   ```
3. `GET` **해당 페이지 조회**
   
   URL :
   `/page?{pageId}`
   <br>
   <br>
   `RESPONSE`
   ---
   
   `pageId`에 존재하지 않는 값이 들어왔을 경우

   ```json
   {
    "status": "NOT_FOUND",
    "message": "페이지가 없습니다."
   }
   ```
   ---
   정상적인 작동
   ```json
   {
    "nickname": "조수현",
    "username": "@05tngus",
    "pageCreateAt": "Jul 12, 2023",
    "pageId": 3,
    "pageUrl": "google.come",
    "pageTitle": "안보이겠지?",
    "highlights": [
        {
            "highlightId": 2,
            "colorHex": "#ffff8d",
            "text": "dldldlaa"
        }
    ]
   }
   ```
3. `GET` **내가만든 페이지 조회**
   
   URL :
   `/page/my`
   <br>
   <br>
   `REQUEST`
   ---
   
   파라미터로
   
   `page` : Int
   
   `size` : Int

   
   `RESPONSE`
   ---
   
   정상적인 작동
   ```json
   {
    "currentPage": 1,
    "hasMorePage": false,
    "feedList": [
        {
            "nickname": "조수현",
            "username": "@05tngus",
            "pageCreateAt": "Jul 12, 2023",
            "pageId": 4,
            "pageUrl": "google.comaaae",
            "pageTitle": "보이나?",
            "highlights": [
                {
                    "highlightId": 4,
                    "colorHex": "#ffff8d",
                    "text": "다른거추가"
                },
                {
                    "highlightId": 3,
                    "colorHex": "#ffff8d",
                    "text": "dldldlaa"
                }
            ]
        },
        {
            "nickname": "조수현",
            "username": "@05tngus",
            "pageCreateAt": "Jul 12, 2023",
            "pageId": 3,
            "pageUrl": "google.come",
            "pageTitle": "안보이겠지?",
            "highlights": [
                {
                    "highlightId": 2,
                    "colorHex": "#ffff8d",
                    "text": "dldldlaa"
                }
            ]
        },
        {
            "nickname": "조수현",
            "username": "@05tngus",
            "pageCreateAt": "Jul 12, 2023",
            "pageId": 1,
            "pageUrl": "google.com",
            "pageTitle": "테스트페이지",
            "highlights": [
                {
                    "highlightId": 1,
                    "colorHex": "#ffff8d",
                    "text": "dldldl"
                }
            ]
        }
    ]
   }
   ```
5. `GET` **피드보기**

   URL :
   `/page/feed`
   <br>
   <br>
   `REQUEST`
   ---
   
   파라미터로

   `userId` : Long (토큰으로 사용자 정보를 부를 수 있지만 API명세에 필수값이라 추가)
   
   `page` : Int
   
   `size` : Int




   `RESPONSE`
   ---
   

   정상적인 작동
   ```json
   {
    "currentPage": 1,
    "hasMorePage": false,
    "feedList": [
        {
            "nickname": "조수현",
            "username": "@05tngus",
            "pageCreateAt": "Jul 12, 2023",
            "pageId": 4,
            "pageUrl": "google.comaaae",
            "pageTitle": "보이나?",
            "highlights": [
                {
                    "highlightId": 4,
                    "colorHex": "#ffff8d",
                    "text": "다른거추가"
                },
                {
                    "highlightId": 3,
                    "colorHex": "#ffff8d",
                    "text": "dldldlaa"
                }
            ]
        },
        {
            "nickname": "조수현",
            "username": "@05tngus",
            "pageCreateAt": "Jul 12, 2023",
            "pageId": 1,
            "pageUrl": "google.com",
            "pageTitle": "테스트페이지",
            "highlights": [
                {
                    "highlightId": 1,
                    "colorHex": "#ffff8d",
                    "text": "dldldl"
                }
            ]
        }
    ]
   }
   ```
   
</div>
</details>

<details>
<summary> highlight</summary>
<div markdown="1">

1. `POST` **하이라이트 생성**
   
   URL :
   `/highlight`
   <br>
   <br>
   `REQUEST`
   ---
   
      ```json
      {
     "pageUrl": "google.comaaae",
     "colorHex": "#ffff8d",
     "text": "다른거추가"
      }
      ```
   
   `RESPONSE`
   ---
   
   해당 `pageUrl`의 페이지가 저장되어있지 않은 경우
   ```json
   {
     "status": "NOT_FOUND",
     "message": "페이지가 없습니다."
   }
   ```
   ---
   정상적인 작동
   ```
   200 Ok
   ```
3. `PATCH` **하이라이트 수정**

   URL :
   `/highlight`
   <br>
   <br>
   `REQUEST`
   ---
   
      ```json
      {
     "highlightId": 123",
     "colorHex": "#ffff8d",
     "text": "다른거추가"
      }
      ```
   
   `RESPONSE`
   ---
   
   정상적인 작동
   ```
   200 Ok
   ```
5. `DELETE` **하이라이트 삭제**

   URL :
   `/highlight`
   <br>
   <br>
   `REQUEST`
   ---
   
      ```json
      {
     "highlightId": 123
      }
      ```
   
   `RESPONSE`
   ---
   
   정상적인 작동
   ```
   200 Ok
   ```

   
</div>
</details>

# 데이터 스키마와 인덱스

<img width="429" alt="image" src="https://github.com/soohyuneeee/liner-homework-server/assets/80656686/7a6e3391-55a8-4cd8-a645-4051e41de4b6">

#### 설명
- `tbl_user`는 유저 테이블로 사용자 인증에 사용됩니다.
- `tbl_page`는 페이지 테이블로 유저 테이블과 양방향 연관관계를 맺고 하이라이트를 포함하는 페이지를 저장하고 공개범위를 지정할 수 있습니다.
- `tbl_highlight`는 하이라이트 테이블로 페이지 테이블과 양방향 연관관계를 맺고 페이지에 생성할 하이라이트를 저장합니다.
- `tbl_mention`은 멘션 테이블로 페이지의 공개범위가 `MENTIONED`일 때 해당 페이지에 멘션된 사용자를 저장하기 위해 생성된 테이블입니다. 유저와 페이지 테이블과 양방향 연관관계를 맺습니다.


#### 이 컬럼은 왜 존재할까요?
- `userId` : `tbl_user`의 `userId`는 다른사용자의 사칭 방지하기 위해서, 그리고 구글 로그인 시 반환되는 `userId`를 저장하기 위하여 추가한 컬럼입니다.
- `mentioned_user_list` : `tbl_page`의 `mentioned_user_list`는 이전에 멘션된 사용자들을 저장하기 위해 추가한 컬럼입니다.

# 요구사항
제가 판단한 라이너 사전과제의 요구사항은 아래의 사항입니다!

또한 좀 더 유연한 서비스 흐름을 위해 몇 개의 요구사항은 제가 추가하였습니다.
1. 유저
    - [ ] 유저는 회원가입을 할 수 있다.
    - [ ] 유저는 로그인을 할 수 있다.
    - [ ] 유저는 하이라이트를 생성할 수 있다.

2. 페이지
    - [ ] 유저는 페이지를 생성할 수 있다.
    - [ ] 유저는 페이지의 제목, 공개범위를 수정할 수 있다.
    - [ ] 유저는 페이지의 공개범위(공개, 비공개, 일부공개)를 지정할 수 있다.
3. 하이라이트
    - [ ] 유저는 하이라이트를 생성할 수 있다.
    - [ ] 유저는 하이라이트를 추가하면 자동으로 페이지에 추가된다.
5. 피드
    - [ ] 유저는 피드에서 공개 페이지나 일부공개에 포함되어 있는 페이지만 조회할 수 있다.
    - [ ] 피드는 유저가 해당 페이지에 최초로 하이라이트한 시간을 기준으로 내림차순 된다.
    - [ ] 피드의 페이지에 조회되는 하이라이트는 최대 3개이다.
    - [ ] 피드는 페이징처리가 된다.
  
          
# 기능 설명
1. 피드 조회
   ```kotlin
   @Query("select p from PageEntity p join fetch p.highlights h where p in (select m.page from Mention m where m.user = :user) or p.openStatus = :openStatus order by h.createdAt desc")
       fun findPagesWithMentionsOrPublic(user: User, openStatus: OpenStatus, pageable: Pageable): Page<PageEntity>
   ```
   이 쿼리어노테이션을 sql문으로 변환하면
   ```sql
   SELECT p.*
   FROM tbl_page p
   JOIN tbl_highlight h ON p.id = h.page_id
   WHERE p.id IN (SELECT m.page_id FROM tbl_mention m WHERE m.user = :user)
      OR p.open_status = :openStatus
   ORDER BY h.created_at DESC;
   ```
   이렇게 됩니다.
   ### 설명
   멘션된 사용자와 openStatus가 PUBLIC인 페이지를 조회합니다.<br>
   이 때 페이지의 가장 처음 만든 하이라이트를 기준으로 내림차순 정렬합니다.<br><br>
   이렇게 조회한 페이지는
   ```kotlin
   GetFeedListResponse(
            currentPage = pages.number + 1,
            hasMorePage = (pages.totalPages - 2 > pages.number),
            feedList = pages.content.map {
                GetPageResponse(
                    nickname = it.user.nickname,
                    username = it.user.username,
                    pageCreateAt = formatToLocalDateTime(it.createdAt),
                    pageId = it.id,
                    pageUrl = it.url,
                    pageTitle = it.title,
                    highlights = it.highlights.take(3).map { highlight -> //3개만
                        GetHighlightResponse(
                            highlightId = highlight.id,
                            colorHex = highlight.colorHex,
                            text = highlight.text
                        )
                    }
                )
            })
   ```
   해당 형태에 맞춰 리턴됩니다.
   ```kotlin
    fun formatToLocalDateTime(localDateTime: LocalDateTime?): String {
        val formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy", Locale.ENGLISH)
        return localDateTime?.format(formatter).toString()
    }
   ```
   또한 `formatToLocalDateTime`함수를 사용하여 LocalDateTime의 형태를 변환하여 가독성을 고려하였습니다.<br><br>
2. 공개 범위
   
   공개 범위는 `PUBLIC`, `PRIVATE`, `MENTIONED` 이렇게 세 개가 존재합니다.<br><br>
   `MENTIONED`는 공개할 사용자를 지정할 수 있어서<br>
   `tbl_mention`이라는 테이블을 생성하고 페이지와 멘션된 사용자를 저장하도록 하였습니다.<br><br>
   그리고 위에도 언급했던
   ```kotlin
   @Query("select p from PageEntity p join fetch p.highlights h where p in (select m.page from Mention m where m.user = :user) or p.openStatus = :openStatus order by h.createdAt desc")
       fun findPagesWithMentionsOrPublic(user: User, openStatus: OpenStatus, pageable: Pageable): Page<PageEntity>
   ```
   를 사용하여 멘션된 사용자만 조회가 가능하도록 구현하였습니다.<br><br>
   또한 공개 범위는 동적으로 변경될 수 있어야 합니다.<br><br>
   그래서 어떻게 하면 쿼리문을 적게 부르면서 공개범위를 변경할 수 있을까 고민해 보았습니다.<br>
   그리고 제가 구현한 방법은
   UpdatePageService
   ```kotlin
   @Transactional
    fun execute(request: UpdatePageRequest) {
        val page = pageFacade.findById(request.pageId)
        
        //페이지를 MENTIONED으로 변경하려 할 때
        if (request.openStatus == OpenStatus.MENTIONED) {
            if (!request.mentionedUserName.isNullOrEmpty()) {

                //tbl_page에 저장되어 있던 멘션된 사용자 리스트
                val mentionedUserList = page.mentionedUserList?.split(",")

                //새로 변경하는 멘션된 사용자 리스트
                val newMentionedUserList = request.mentionedUserName.split(",")

                //tbl_page에 저장되어 있던 멘션된 사용자 리스트가 null이 아닐 경우
                if (mentionedUserList != null) {

                    //cleanUpMentionMemberService 실행
                    cleanUpMentionMemberService.execute(mentionedUserList, newMentionedUserList, page)
                }

                //tbl_page에 저장되어 있던 멘션된 사용자 리스트가 null일 경우
                else {

                    //newMentionedUserList의 사용자를 Mention으로 생성
                    newMentionedUserList.forEach {
                        createMentionService.execute(it, page)
                    }
                }
            }

            //Mention생성이 다 저장된 후 page를 update(영속성컨텍스트)
            page.updatePage(request.title, request.openStatus, request.mentionedUserName)
        }

        //tbl_page에 저장되어 있던 멘션된 사용자 리스트가 존재하면
        else {

            //tbl_page에 저장되어 있던 멘션된 사용자 리스트가 존재하면
            if (page.mentionedUserList != null) {

                //해당 Mention들 삭제
                page.mentionedUserList?.split(",")?.forEach {
                    deleteMentionService.execute(it, page)
                }
            }
            //위의 로직 수행 후 page를 update, mentionedUserList는 null로 입력
            page.updatePage(request.title, request.openStatus, null)
        }

    }
   ```
   CleanUpMentionMemberService
   ```kotlin
   @Transactional
    fun execute(mentionedUserList: List<String>, newMentionedUserList: List<String>, page: PageEntity) {
   
        // newMentionedUserList에는 없고 mentionedUserList에는 있는 사용자는 usersToDelete에 저장
        val usersToDelete = mentionedUserList.filterNot { newMentionedUserList.contains(it) }
   
        // newMentionedUserList에는 있고 mentionedUserList에는 없는 사용자는 usersToInsert에 저장
        val usersToInsert = newMentionedUserList.filterNot { mentionedUserList.contains(it) }
   
        //Mention 추가(저장)
        usersToInsert.forEach { userName ->
            createMentionService.execute(userName, page)
        }

        //Mention 삭제
        usersToDelete.forEach { userName ->
            deleteMentionService.execute(userName, page)
        }
    }
   ```
  입니다.
