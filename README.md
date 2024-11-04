# java-lotto-precourse

- 간단한 로또 발매기를 구현한 코드입니다.

# 기능

- 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
- 로또 1장의 가격은 1,000원이다.
- 당첨 번호와 보너스 번호를 입력받는다.
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    - `Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리한다.

## 기능 목록

- [ ]  로또 발행 (1~45까지 중복되지 않는 수 6개)
- [ ]  입력된 금액에 맞는 수량의 로또 발행

### 입력

- [ ]  로또 구입 금액 입력
- [ ]  당첨번호 입력
- [ ]  보너스 번호 입력

### 출력

- [ ]  로또 구입 수량 출력
- [ ]  발급된 로또 번호 리스트 출력
- [ ]  당첨 내역 출력
- [ ]  수익률 출력(소수점 둘째 자리에서 반올림)

## 예외

### 입력

- [x]  로또 구입 금액이 1,000원으로 나누어 떨어지지 않는 경우
- [x]  입력된 구입 금액이 int 형을 초과하는 경우
- [ ]  당첨 번호 입력이 적절하지 않은 경우
    - [ ]  같은 숫자가 들어온 경우
        - [ ]  복권 번호 내에서 같은 숫자
        - [ ]  보너스 번호가 기존 번호와 같은 숫자
    - [ ]  1~45 사이의 수가 아닌 경우
    - [ ]  숫자나 쉼표가 아닌 값이 들어온 경우
    - [ ]  숫자가 6개가 아닌 경우

### 로또

- [x]  번호가 적절하지 않은 경우
    - [x]  같은 숫자가 들어온 경우
        - [x]  복권 번호 내에서 같은 숫자
    - [x]  1~45 사이의 수가 아닌 경우
    - [x]  숫자가 6개가 아닌 경우
