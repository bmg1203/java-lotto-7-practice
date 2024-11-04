# java-racingcar-precourse

## 로또 과제 핵심 기능

- 사용자가 입력한 금액에 맞춰, 로또들을 생성하고 구매한 로또들의 정보를 출력한다.
- 당첨번호들과 보너스 번호를 입력하고 구매한 로또들과 비교하여 당첨 결과를 확인한다.
- 당첨 결과를 사용하여 필요한 정보들을 출력한다.


## 예외 처리할 사항

- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션을 종료한다.
    - 구입 금액이 숫자가 아닌 경우, 음수인 경우, 구입 금액이 1000으로 나눠 떨어지지 않는 경우 예외 처리
    - 당첨번호들이 숫자가 아니거나, 1~45 사이의 숫자가 아닌 경우
    - 보너스번호가 숫자가 아니거나, 1~45 사이의 숫자가 아닌 경우
    - 당첨 번호들과 보너스 번호 간에 중복된 번호가 존재하는 경우


## 기능 구현 목록

### 1. 주어진 가격에 맞춰 로또를 생성한다.

- [x] 주어진 가격에 맞춰 로또 개수만큼 로또를 생성한다.
- [x] 1~45 사이의 랜덤한 수 6개를 뽑는다.
- [x] 랜덤한 6개의 숫자들로 로또를 생성한다.
- [x] 로또의 번호들은 오름차순으로 정렬한다.


### 2. 당첨 로또를 생성한다.

- [x] 주어진 당첨번호 6개와 보너스 번호 1개를 가지는 당첨 로또를 생성한다.


### 3. 입력된 구입 금액, 당첨번호, 보너스번호 유효성 검사를 진행한다.

- 구입 금액이 정상적인지 확인한다.
    - [x] 구입 금액이 음수 혹은 부족한 경우 `IllegalArgumentException`을 발생시킨다.
    - [x] 구입 금액이 1000으로 나눠 떨어지지 않는 경우 `IllegalArgumentException`을 발생시킨다.
    - [ ] 구입 금액이 숫자가 아닌 경우 `IllegalArgumentException`을 발생시킨다.
- 로또가 정상적인지 확인한다. (구매 이후 랜덤 생성된 로또, 당첨 로또)
    - [x] 6개의 숫자를 가지고 있지 않은 경우 `IllegalArgumentException`을 발생시킨다. 
    - [x] 1~45 내의 수가 아닌 경우 `IllegalArgumentException`을 발생시킨다.
    - [x] 당첨번호들이 중복된 숫자를 가지는 경우 `IllegalArgumentException`을 발생시킨다.
    - [ ] 당첨번호가 숫자가 아닌 경우 `IllegalArgumentException`을 발생시킨다.
- 보너스번호가 정상적인지 확인한다.
    - [x] 1~45 내의 수가 아닌 경우 `IllegalArgumentException`을 발생시킨다.
    - [x] 당첨번호들 중에 하나와 같은 경우 `IllegalArgumentException`을 발생시킨다.
    - [ ] 보너스번호가 숫자가 아닌 경우 `IllegalArgumentException`을 발생시킨다.

### 4. 로또 당첨 결과를 만들어낸다.

- [x] 당첨 로또와 구매된 로또들 간 비교를 통해 당첨 통계를 만들어낸다.
- [x] 구매한 금액과 총 당첨 금액을 통해 수익률을 계산한다.


### 5. 로또를 구매할 금액, 당첨 로또 번호와 보너스 번호를 입력받는다.

- [ ] 로또를 구매할 금액을 입력받는다.
- [ ] 1~45 사이의 당첨번호 6개를 ',' 구분자 단위로 입력받는다.
- [ ] 1~45 사이의 보너스 번호 1개를 입력받는다.


### 6. 로또 구매 결과와 당첨 결과를 출력한다.

- [ ] 구매 금액에 맞추어, 구매된 로또 정보를 출력한다.
- [ ] 주어진 형식에 맞추어, 당첨된 결과들을 출력한다.
- [ ] 주어진 형식에 맞추어, 수익률을 출력한다.
