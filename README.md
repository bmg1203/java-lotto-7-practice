# java-lotto-precourse

# 기능 요구 사항


- 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.

- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
- - 1등: 6개 번호 일치 / 2,000,000,000원
- - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
- - 3등: 5개 번호 일치 / 1,500,000원
- - 4등: 4개 번호 일치 / 50,000원
- - 5등: 3개 번호 일치 / 5,000원
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
- 로또 1장의 가격은 1,000원이다.
- 당첨 번호와 보너스 번호를 입력받는다.
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
- Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.


# 기능 구현

- [x] 로또 구입 금액을 입력 받은 뒤 몇 개의 로또를 살 것인지 확인
- [x] 금액에 해당 하는 만큼의 중복되지 않는 6개의 숫자를 발행후 오름차 순으로 정렬
- [x] 쉼표를 구성으로 당첨 번호를 입력한다.
- [x] 보너스 번호를 입력한다
- [ ] 로또 수량 및 번호를 출력하고 오름차순으로 보여지게 한다.
- [ ] 당첨내역을 출력한다.
- [ ] 수익률은 소수점 둘 째 자리에서 반올림한다.(ex. 100.0%, 51.5%, 1,000,000.0%)

# 예외 사항
###  예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.
### ex) [ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.

- [x] 로또 번호는 1부터 45 사이의 숫자여야한다.
- [x] 로또 번호는 중복된 숫자가 있으면 안된다.
- [x] 로또 번호는 6자리의 숫자여야 한다.
- [x] 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.
- [x] 구입 금액이 숫자가 아닌 수가 나올 시 에러 발생
- [x] 당첨 번호를 입력 시 쉼표로 기준을 하였을 때 정상적인 수가 나오지 않거나 쉼표 이외에 특수문자가 나오면 안된다.
- [x] 추가 로또 번호 1부터 45사이의 숫자여야한다.
- [x] 추가 로또 번호는 숫자만 들어와야 한다.
- [x] 추가 로또 번호는 로또 번호와 동일한 숫자이면 안된다.