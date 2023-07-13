# API 명세서

<details>
<summary> user</summary>
<div markdown="1">

1. **회원가입**
   <label style="color: yellow"><POST\></label>
   <br>
   <br>

   request
   ```json
   {
    "userId" :12333,
    "nickname" : "조수현테스트테스트",
    "username" : "@05tngus99",
    "password" : "1234"
   }
   ```
   response
   ```
   200 Ok
   ```

2. **로그인**
   <label style="color: yellow"><POST\></label>
   <br>
   <br>

   request
   ```json
   {
    "userId" : 12345,
    "password" : "1234"
   }
   ```
   response
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

1. **페이지 생성**
   <label style="color: yellow"><POST\></label>
   <br>
   <br>

request

   ```json
{
  "userId": 123,
  "pageUrl": "null",
  "title": "보이냐?",
  "openStatus": "PUBLIC",
  "mentionedUserName": null
}
   ```

response
이미 해당 pageUrl를 저장한 페이지가 있을 경우

   ```json
   {
  "status": "UNPROCESSABLE_ENTITY",
  "message": "페이지가 이미 존재합니다."
}

   ```

```

200 Ok

   ```

해당 pageUrl를 저장한 페이지가 없을 경우

```json
{
  "status": "NOT_FOUND",
  "message": "페이지가 없습니다."
}
```

</div>
</details>

<details>
<summary> highlight</summary>
<div markdown="1">

1. **하이라이트 생성**
   <label style="color: yellow"><POST\></label>
   <br>
   <br>

request

   ```json
   {
  "pageUrl": "google.comaaae",
  "colorHex": "#ffff8d",
  "text": "다른거추가"
}
   ```

response

   ```
   200 Ok
   ```
</div>
</details>

# 데이터 스키마와 인덱스

![img.png](img.png)

# 요구사항

1. 유저
    - [ ] 유저는 회원가입을 할 수 있다.
    - [ ] 유저는 로그인을 할 수 있다.
    - [ ] 유저는 하이라이트를 생성할 수 있다.

2. 페이지
    - [ ] 유저는 페이지를 생성할 수 있다.
    - [ ] 유저는 페이지의 제목, 공개범위를 수정할 수 있다.
    - [ ] 유저는 페이지의 공개범위(공개, 비공개, 일부공개)를 지정할 수 있다.
3. 하이라이트
    - [ ] 유저는 하이라이트를 추가하면 자동으로 페이지에 추가된다.
4. 피드
    - [ ] 유저는 피드에서 공개 페이지나 일부공개에 포함되어 있는 페이지만 조회할 수 있다.
    - [ ] 피드는 유저가 해당 페이지에 최초로 하이라이트한 시간을 기준으로 내림차순 된다.
    - [ ] 피드의 페이지에 조회되는 하이라이트는 최대 3개이다.
    - [ ] 피드는 페이징처리가 된다.


- 