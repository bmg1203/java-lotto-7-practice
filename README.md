# ✨ 프리코스 3주차 미션 - 로또

> 우아한테크코스 7기 3주차 미션, 로또를 구현한 저장소입니다.
---

## 📝 구현할 기능 목록

### ☑️ 로또 구입 금액 입력

- [x] `구입금액을 입력해 주세요.` 가 콘솔에 출력된다.
- [x] 사용자로부터 금액을 입력 받는다. (1,000원 단위)
    - 1,000원으로 나누어 떨어지지 않을 때 `예외` 발생시킨다.
    - 1,000원보다 낮은 금액을 입력할 경우 `예외` 발생시킨다.

### ☑️ 발행할 로또 수량 및 번호 출력

- [ ] 발행할 로또 수량을 계산하여 출력한다.
  - 발행할 로또의 수량은 `구입 금액 / 1,000` 개이다.
  - `$로또 수량개를 구매했습니다.` 와 같이 콘솔에 출력한다.
- [ ] 수량만큼 로또를 출력한다. 
  - 1장에 6개의 1에서 45 사이의 랜덤 번호로 이루어진 로또 번호를 콘솔에 오름차순으로 정렬하여 출력한다.

### ☑️ 당첨 번호 입력

- [ ] `당첨 번호를 입력해 주세요.` 가 콘솔에 출력된다.
- [ ] 당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.
    - 구분자가 쉼표(,)가 아닐 경우 `예외` 발생시킨다.
    - 당첨 번호가 6개가 아닐 경우 `예외` 발생시킨다.
    - 1부터 45 사이의 수가 아닌 숫자 혹은 문자가 존재할 경우 `예외` 발생시킨다.

### ☑️ 보너스 번호 입력

- [ ] `보너스 번호를 입력해 주세요.` 가 콘솔에 출력된다.
- [ ]  보너스 번호를 입력 받는다.
    - 한 개의 숫자가 아닐 경우 `예외` 발생시킨다.
    - 1부터 45 사이의 숫자가 아닌 숫자 혹은 문자일 경우 `예외` 발생시킨다.

### ☑️ 당첨 내역 출력

- [ ] `당첨 통계` 가 콘솔에 출력된다.
- [ ] 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 통계를 출력한다.
  - 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다. 
    - 1등: 6개 번호 일치 / 2,000,000,000원 
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원 
    - 3등: 5개 번호 일치 / 1,500,000원 
    - 4등: 4개 번호 일치 / 50,000원 
    - 5등: 3개 번호 일치 / 5,000원

- [ ] 수익률을 계산하여 출력한다.
  - 수익률은 `(당첨금액 / 구입금액) * 100`%이다.
  - `총 수익률은 $수익률%입니다.` 와 같이 콘솔에 출력한다.

### ❗ 예외 상황 시 
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, `[ERROR]`로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
  - Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.
