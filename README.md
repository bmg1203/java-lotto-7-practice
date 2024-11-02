# java-lotto-precourse

## 기능 목록

### 게임 진행
-[ ] 로또 구입 금액 입력
-[ ] 로또 발행
  - 로또 구입 개수 n 계산
  - n개의 로또 발행
-[ ] 발행한 로또 출력

-[ ] 당첨 번호 입력
-[ ] 보너스 번호 입력
-[ ] 당첨 로또 설정
  - 당첨 로또 번호 작성
  - 보너스 번호 작성

### 결과 도출
-[ ] 로또 당첨 확인
  - 로또마다 순위 확인
-[ ] 통계 계산
  - 전체 당첨 금액 계산
  - 당첨 금액 대비 수익률 계산
-[ ] 당첨 결과와 통계 출력
  - 수익율은 %로, 소수점 둘째 자리에서 반올림


### 입력 예외
-[ ] 구입 금액
  - null이나 공백, 빈 칸이 입력된 경우
  - 1000 단위 정수가 아닌 경우
-[ ] 당첨 번호
  - null이나 공백, 빈 칸이 입력된 경우
  - 구분자와 공백을 제외한 문자가 있는 경우
  - 정수가 아닌 수가 있는 경우
-[ ] 보너스 번호
  - null이나 공백, 빈 칸이 입력된 경우
  - 정수가 아닌 경우

### 도메인 예외
-[ ] 로또 번호 (당첨 번호 포함)
  - 숫자 6개가 아닌 경우
  - 1-45 범위를 벗어나는 수가 있는 경우
-[ ] 보너스 번호
  - 1-45 범위를 벗어나는 경우
  - 보너스 번호가 당첨 번호 안에 있는 경우

### 예외 처리
-[ ] [ERROR]로 시작하는 메시지를 출력한다.
-[ ] 예외가 발생한 부분부터 다시 입력받는다.