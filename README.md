# java-lotto-precourse

간단한 로또 발매기를 구현한다.

- [X] **입력**
- [X] 로또 금액을 입력받는다.
    - [X] **로또 금액 예외사항**
        - [X] 1000원기준이기 때문에 1000으로 나누어 떨어지는 자연수가 입력되어야한다.
- [X] 당첨 번호를 입력받는다.
    - [X] **당첨번호 예외사항**
        - [X] ","를 구분자로 입력받는다.
        - [X] 6개의 값만 입력되어야한다.
        - [X] 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- [X] 보너스 번호를 입력받는다.
    - [X] **보너스 번호 예외사항**
        - [X] 중복되는 숫자가 입력되선 안된다.
    - [X] **당첨번호, 보너스 번호, 숫자에 대한 예외사항**
        - [X] 로또 번호의 숫자 범위는 1~45까지의 자연수이다.
        - [X] 숫자가 아닌 값을 입력받으면 안된다.
- [X] 위의 예외사항들은 IllegalArgumentException을 발생시키는 사항들이다.
    - [X] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨다.
    - [X] "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.

---

- [X] **로직**
- [X] **당첨번호, 보너스 번호, 숫자에 대한 예외사항**
    - [X] 로또 번호의 숫자 범위는 1~45까지의 자연수이다.
    - [X] 숫자가 아닌 값을 입력받을 경우 IllegalArgumentException을 발생시킨다.
    - [X] 중복되는 숫자가 입력되선 안된다.
- [X] 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
    - [X] 구입 금액만큼 로또를 발행합니다.
        - [X] 로또를 숫자만큼 발행하고 정렬하여 저장합니다.
    - [X] 가격을 로또가격으로 나눈 갯수만큼 저장한다.
        - [X] 입력된 숫자가 로또가격으로 나누어떨어지지 않으면 IllegalStateException 발생
        - [X] 가격이 0으로 입력된다면 IllegalArgumentException을 발생시키고 재입력을 수행한다.
    - [X] 위의 숫자에 대한 예외사항을 준수한다.
- [X] 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 구한다.
    - [X] 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
        - 1등: 6개 번호 일치 / 2,000,000,000원
        - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
        - 3등: 5개 번호 일치 / 1,500,000원
        - 4등: 4개 번호 일치 / 50,000원
        - 5등: 3개 번호 일치 / 5,000원
    - [X] 로또엔 당첨결과가 기록된다.
    - [X] 최종 결과물로 당첨률, 당첨 내역을 총합해서 내보낸다.

---

- [X] **출력**
- [X] 로또금액이 입력되면 발행된 로또에 대한 정보를 출력한다.
- [X] 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.

---

- **기타**
- Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.