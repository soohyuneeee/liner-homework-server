# API 명세서

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


#### 이 컬럼은 왜 존재할까요?
- `tbl_user`의 `userId`는 다른사용자의 사칭 방지하기 위해서, 그리고 구글 로그인 시 반환되는 `userId`를 저장하기 위하여 추가한 컬럼입니다.
- `tbl_page`의 `mentioned_user_list`는 이전에 멘션된 사용자들을 저장하기 위해 추가한 컬럼입니다.

# 요구사항
제가 판단한 라이너 사전과제의 요구사항은 아래의 사항입니다!
또한 좀 더 유연한 서비스 흐름을 위해 몇몇개의 요구사항은 제가 추가하였습니다.
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
