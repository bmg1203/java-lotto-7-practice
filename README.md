# Lotto Application

로또 번호를 생성하고, 사용자가 구매한 로또와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하는 로또 발매기 구현

## 주요 기능

1. **로또 구입 기능**
    - 사용자가 입력한 금액에 따라 로또를 발행합니다. 로또 한 장의 가격은 1,000원입니다.
    - 구입 금액이 1,000원 단위로 입력되지 않으면 예외를 발생시킵니다.

2. **로또 번호 생성**
    - 1~45 범위 내에서 중복되지 않는 6개의 숫자를 랜덤으로 생성합니다.

3. **당첨 번호 입력**
    - 사용자가 당첨 번호와 보너스 번호를 입력할 수 있도록 합니다.
    - 입력값이 올바르지 않으면 예외를 발생시킵니다.

4. **당첨 내역 확인**
    - 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역을 출력합니다.
    - 1등부터 5등까지의 당첨 내역을 집계하여 표시합니다.

5. **수익률 계산**
    - 사용자가 구매한 로또의 총 수익률을 계산하여 출력합니다.

## 예외 처리
- 잘못된 입력이 들어올 경우 `IllegalArgumentException`을 발생시키며, 에러 메시지를 출력합니다.

## 사용 예시
- 구입 금액 입력
- 로또 번호 및 당첨 번호 입력
- 당첨 통계 출력