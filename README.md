# 프리코스 3주차 Lotto

## 기능 목록
> 간단한 **자동** 로또 발매기 이다.

- [X] 로또 번호의 숫자 범위는 1~45까지이다.
  - 로또 번호가 숫자가 아닌 경우 예외 처리한다.
  - 로또 번호가 1~45사이가 아닌 경우 예외 처리한다.
- [X] 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- [ ] 로또 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- [ ] 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
  - 1등: 6개 번호 일치 / 2,000,000,000원
  - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
  - 3등: 5개 번호 일치 / 1,500,000원
  - 4등: 4개 번호 일치 / 50,000원
  - 5등: 3개 번호 일치 / 5,000원
- [ ] 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
- [ ] 로또 1장의 가격은 1,000원이다.
  - 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.
  - 가격은 0원 보다 커야 한다.
  - 가격은 숫자여야 한다.
- [ ] 당첨 번호와 보너스 번호를 입력받는다.
  - 당첨 번호는 6개여야 한다.
  - 당첨 번호는 중복될수 없다.
  - 당첨 번호는 1~45 사이의 숫자여야 한다.
  - 보너스 번호는 1~45 사이의 숫자여야 한다.
- [ ] 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
  - 로또는 당첨 번호의 순서가 정확해야 한다. 
  - 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)
- [ ] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
  - Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.
