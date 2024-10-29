# java-lotto-precourse


# java-racingcar-precourse

# 프로젝트 개요

"로또" 프로젝트는 사용자가 로또 게임에 참여하여 얻을 수 있는 수익에 대해 알려주는 프로젝트입니다. 로또 한 1장의
가격은 1,000원이며 사용자는 구매하고 싶은 만큼의 로또를 구입할 수 있습니다. 사용자가 구매한 로또 번호와
당첨 번호를 비교하여 당첨 내역 및 수익률을 알려줍니다.

# 주요 기능

1. 로또의 당첨 번호와 보너스 번호 입력 기능
2. 로또 구입 금액을 입력 기능
3. 구매한 로또들의 번호를 출력하는 기능
4. 로또 당첨 통계를 출력하는 기능

# 구현 기능 목록

### 1. 입력 기능
- [x] : **로또 구입 금액을 입력 받는 기능**
    - 금액이 숫자 형식이 아닌 경우 예외 처리
    - 금액이 1000원 보다 작은 경우 예외 처리
    - 금액이 1000으로 나누어 떨어지지 않는 경우 예외 처리
- [x] : **로또 당첨 번호를 입력 받는 기능**
    - 입력에서 당첨 숫자의 개수가 6개 이하인 경우 예외 처리
    - 숫자가 1 ~ 45 범위 내에 있지 않은 경우 예외 처리
    - 중복된 숫자가 있는 경우 예외처리
- [x] : **보너스 번호를 입력 받는 기능**
    - 보너스 번호와 당첨 번호가 중복되면 예외 처리

### 2. 비즈니스 로직 처리 기능
- [x] : **구매할 수 있는 로또의 개수를 구하는 기능**
- [x] : **구매할 수 있는 로또의 개수만큼 로또를 생성하는 기능**
    - 로또 번호는 오름 차순으로 저장한다
- [x] : **로또 당첨 여부를 판단하는 기능**
- [x] : **수익률을 계산하는 기능**

### 3. 출력 기능
- [x] : **구매한 로또의 개수를 출력하는 기능**
- [x] : **구매한 로또의 번호를 출력하는 기능**
- [x] : **로또 당첨 통계를 출력하는 기능**
- [x] : **수익률을 출력하는 기능**