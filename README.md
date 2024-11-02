## ✅ 기능 요구 사항

-[X] 로또 구입 금액을 입력 받는다.
    -[X] 로또 구입 금액이 양의 정수가 아니면 예외 처리한다.
    -[X] 로또 구입 금액이 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.
-[X] 로또 구입 금액만큼 로또를 발행한다.
    -[X] 1개의 로또를 발행할 때 중복된 숫자가 있는 경우 예외 처리한다.
    -[X] 1개의 로또를 발행할 때 번호가 6개가 아니면 예외 처리한다.
-[X] 당첨 번호를 입력 받는다.
    -[X] 당첨 번호가 6개가 아니면 예외 처리한다.
    -[X] 당첨 번호가 1~45 사이의 양의 정수가 아니면 예외 처리한다.
    -[X] 당첨 번호 추첨 시 중복된 숫자가 있는 경우 예외 처리한다.
-[X] 보너스 번호를 입력 받는다.
    -[X] 보너스 번호가 1~45 사이의 양의 정수가 아니면 예외 처리한다.
    -[X] 보너스 번호가 당첨 번호와 중복되면 예외 처리한다.
-[X] 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 계산한다.
-[X] 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.

## ☑️ 프로그래밍 요구 사항

-[X] indent depth를 3이 넘지 않도록 구현한다.
-[X] 3항 연산자를 쓰지 않는다.
-[X] 함수의 길이가 15라인을 넘어가지 않도록, 한 가지 일만 하도록 구현한다.
-[X] else 예약어를 사용하지 않는다.
-[X] Enum을 적용하여 프로그램을 구현한다.
-[ ] 구현 기능에 대한 단위 테스트를 작성한다.
-[X] 사용자가 잘못된 값을 입력할 경우 그 부분부터 다시 입력 받는다.

## ❕추가 고려 사항

- 잘못된 입력에 대한 예외 처리는 어디에서 하는 것이 좋을까?
    