java-lotto-precourse
=========================
* * *

🚀 입력 요구 사항
-----------------
- [x] 로또 구입 금액을 입력 받습니다.
  - [x] 금액이 1000 단위로 나누어 떨어지지 않으면 예외를 발생합니다.
    - [x] 기준 금액 1000을 상수화합니다.
- [x] 당첨 번호 6개를 입력 받습니다.
  - [x] 번호는 쉼표(,)를 기준으로 구분합니다.
  - [x] 쉼표가 두 개 이상 연속으로 입력했다면 예외를 발생합니다.
  - [x] 번호의 범위는 1~45 까지입니다.
    - [x] 기준점 1, 45를 상수화합니다.
  - [x] 번호가 중복되면 예외를 발생합니다.
  - [x] 당첨 번호 개수가 6개가 아니면 예외를 발생합니다.
    - [x] 당첨 번호 개수 6을 상수화합니다. 
- [x] 보너스 번호를 입력 받습니다.
  - [x] 번호의 범위 1~45 까지입니다.
  - [x] 보너스 번호는 당첨 번호와 중복되면 예외를 발생합니다.
- [x] 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킵니다.

🚀 출력 요구 사항
-----------------
- [ ] 발행한 로또 수량 및 번호를 출력합니다.
  - [ ] 발행 로또 번호는 오름차순 정렬되어 보여줍니다.
  - [ ] 발행 로또 번호는 쉼표(,)로 구분됩니다.
- [ ] 당첨 내역을 출력합니다.
  - [ ] 당첨 금액 출력 형식은 천 단위 구분 기호를 사용합니다.
  - 당첨 기준과 금액은 아래와 같습니다:
    - 1등: 6개 번호 일치 / 2,000,000,000원
    -  2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    -  3등: 5개 번호 일치 / 1,500,000원
    -  4등: 4개 번호 일치 / 50,000원
    -  5등: 3개 번호 일치 / 5,000원
- [ ] 수익률을 출력합니다.
  - [ ] 형식은 "총 수익률은 [수익률] %입니다."
    - [ ] 수익률 출력 형식은 천 단위 구분 기호를 사용합니다. (ex. 100.0%, 51.5%, 1,000,000.0%)
- [ ] 예외 상황 시 에러 문구를 출력해야 합니다.
  - [ ] 에러 문구는 "[ERROR]"로 시작해야 한다.
    - [ ] "[ERROR]" 를 상수화한다.

🚀 기능 요구 사항
-----------------
- [x] 사용자에게 입력 받은 당첨 번호를 쉼표(,)로 나눕니다.
- [x] 구매 금액을 1000으로 나누어 발행 횟수를 구합니다.
- [x] 랜덤 로또를 발행합니다.
  - [x] 발행된 로또 번호들을 오름차순 정렬합니다.
- [ ] 발행한 로또들을 저장합니다.
- [ ] 로또 번호에 대해 당첨 번호와 보너스 번호를 비교합니다.
- [ ] 수익률을 계산합니다.
    - [ ] 수익률을 소수점 둘째 자리에서 반올림합니다.

* * *
## 개인 목표
- [ ] TDD로 구현하기