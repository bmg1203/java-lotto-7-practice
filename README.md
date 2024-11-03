# 로또

## 기능 구현 목록

### 1. 로또 구입 금액 입력 받기
로또 구입 금액을 사용자로부터 입력 받는다.

- [x] `구입 금액을 입력해 주세요.`를 출력
- [x] 구입 금액 입력 (1,000원 단위로 입력)
- [x] 예외 처리 
  - [x] 빈 문자열이 입력될 경우
  - [x] 숫자가 아닌 값이 입력되었을 경우
  - [x] 양의 정수가 아닌 값일 경우
    - [x] 로또 구매 가능 금액인 10만원이 넘어갈 경우
  - [x] 1000원 단위의 입력 값이 아닐 경우

### 2. 로또 구매 하기
금액에 맞춰 로또 구매한다.

- [x] 구입금액에 맞추어 로또 구매
- [x] 각 로또 번호는 1 에서 45 사이의 중복되지 않은 정수만 될 수 있음
  - [x] 랜덤으로 부여 받은 로또를 오름차순 정렬

### 3. 로또 번호 출력 하기
중복되지 않은 6개의 번호 n개 로또를 제공한다.

- [x] 구입한 금액에 맞춰 `n개를 구매했습니다.` 메시지 출력
- [x] n개의 줄에 `[ 숫자, 숫자, 숫자, 숫자, 숫자, 숫자]`의 형태로 출력

### 4. 당첨 번호 입력 받기
당첨 번호를 입력 받는다.

- [x] `당첨 번호를 입력해 주세요.` 메시지 출력
- [x] `, `를 기준으로 6개의 중복되지 않은 숫자 입력 받기
- [x] 예외 처리
  - [x] 빈 문자열이 입력될 경우
  - [x] 숫자 + , 이 아닌 형식으로 입력할 경우
    - [x] 쉼표가 연속적으로 입력될 경우
    - [x] 쉼표 이외의 기호가 입력될 경우
    - [x] 숫자가 아닌 문자일 경우
  - [x] 6개보다 많은 수가 입력될 경우
  - [x] 정수 범위 넘어갔을 경우
  - [x] 1부터 45범위의 숫자가 아닐 경우
  - [x] 중복된 숫자가 입력되었을 경우

### 5. 보너스 번호 입력 받기
당첨 번호와 중복되지 않은 보너스 번호를 입력 받는다.

- [x] `보너스 번호를 입력해 주세요.` 메시지 출력
- [x] 1부터 45범위의 숫자 하나 입력
- [x] 예외 처리
  - [x] 빈 문자열이 입력될 경우
  - [x] 문자열이 입력될 경우
  - [x] 1부터 45범위의 숫자가 아닐 경우
  - [x] 중복된 숫자가 입력되었을 경우

### 6. 로또 등수 확인 하기
당첨번호와 n개의 로또 번호들이 얼마나 일치하는지 확인한다.

- [x] 각 로또 번호가 당첨번호와 일치하는 정도 확인
- [x] 1등부터 5등까지의 상수를 만듦
  - [x] 1등: 6개 일치 / 2등: 5개 + 보너스 / 3등: 5개 일치 / 4등: 4개 일치 / 5등: 3개 일치
- [x] 일치하는 번호 개수에 따라 횟수를 누적하여 기록

### 7. 당첨 통계 출력 하기
로또 등수를 토대로 통계와 총 수익률을 출력한다.

- [x] `당첨 통계\n---`를 출력
- [x] 담아둔 로또 등수 토대로 등수 출력
- [x] `총 수익률은` + 계산한 수익률 + `%입니다.`출력
- [x] 총 수익률 = 당첨된 금액 / 입력한 금액 * 100
  - [x] 당첨된 금액은 리스트를 토대로 더하기
  - [x] 수익률은 소수점 둘째 자리에서 반올림하기

### 🚨예외 발생

- [x] `[ERROR]` 문구 출력후, 어떤 에러인지 정확히 출력하기
- [x] 재대로된 입력이 나올 때까지 반복함