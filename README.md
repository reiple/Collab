# Collab

## 그라운드 룰

  1. 하루에 한 번 인사하기
  2. git push를 작은 단위로 자주 하기
  3. Naming Rule 지키기
  4. 테스트 코드 활용하기
  5. 의견은 서로 존중하기
  6. 긍정적인 마인드 가지기
  7. 함수는 작게 만들기
  8. 의견 충돌 시 다수결(2:2면 팀장이 결정)
  9. 자기 맡은 부분은 최선을 다하기

----

## 팀 프로젝트 진행

### 1. Commit message Rule
  - Type, 제목, 본문, 꼬리말(선택사항)
  - 본문의 한 줄에 72자를 넘기면 안 됩니다.
  - Github의 issue를 남기고, 꼬리말에 이슈번호를 최대한 남긴다.
  - 어떻게(How)보다 무엇을, 왜(What, Why)에 맞춰 작성합니다.
  - Type
    - Feat: 새로운 기능 추가
    - Fix: 버그 수정
    - Docs: 문서 (문서 추가, 수정, 삭제)
    - Style: 스타일 (코드 형식, 세미콜론 추가: 비즈니스 로직에 변경 없는 경우)
    - Refactor: 코드 리팩토링
    - 참고: https://junhyunny.github.io/information/github/git-commit-message-rule/

### 2. 제목 Prefix

  - Feat: 새로운 기능 추가
  - Fix: 버그 수정
  - Docs: 문서 (문서 추가, 수정, 삭제)
  - Style: 스타일 (코드 형식, 세미콜론 추가: 비즈니스 로직에 변경 없는 경우)
  - Refactor: 코드 리팩토링

### 3. Branch Rule

  - 별도 branch로 각자 작업한 다음 PR 올리기
  - 신규/수정 등의 브랜치는 dev로 시작하고 뒤에 원하는 글자 아무거나 붙여서 만든다.
  - main: 개발된 것들 합치는 브랜치
  - release: 제출용 브랜치

### 4. Coding Style
  - Google 코딩 스타일을 따른다.
  - 열제한: 100자
  - 멤버변수는 클래스 상단에 사용한다.
  - 참고: https://nowonbun.tistory.com/378
  - intellij-google-code-style.xml 또는 eclipse-java-google-style.xml를 IDE의 Code Style에 반영한다.

### 5. Naming Rule
  - 카멜 표기법, Class는 첫글자 대문자 등
  - 각 단어의 첫문자를 대문자로 표기하고 붙여쓰되, 맨처음 문자는 소문자로 표기함
  - 띄어쓰기 대신 대문자로 단어를 구분하는 표기 방식
  - 예시: backgroundColor, typeName, iPhone
  - 참고: https://cornswrold.tistory.com/389
  
### 6. 리뷰 정책
  - 리뷰 코드 500라인 이하로 한다.
  - 리뷰를 받으면 2시간 이내에 처리
  - 긍정적으로 리뷰하기(권유나 의문으로 리뷰하기)

### 7. 요구사항 분배
  - DB / DAO / Database: 김영상
  - CMD Add / print Option: 박대영
  - CMD Search / Modify / Delete / filter Option: 이준훈
  - MAIN / Parser / EmployeeManager: 전형준
  - File I/O 관련은 먼저 끝낸 사람이 구현한다.

----

## 주요 일정
  * 3월 21일 14:00 
    - DS 코딩스타일, DS 코드리뷰봇 수업
  * 3월 22일 오전까지 
    - TC 10개 사전 점검 1회 지원
  * 3월 23일 14:30 
    - Release branch에 소스코드 제출
    - 최상위 경로에 실행파일(jar) 반두시 추가 (파일명은 팀이름)
    - 실행되는지 확인 필수
