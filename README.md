# java-lotto-precourse

---

### 기능 요구 사항

- 로또 구입 금액을 입력하면 구매 가능한 수만큼 로또 번호를 발급받는다.
  - 1장의 가격은 1000원
  - 한 번 발행 시 중복되지 않는 숫자 6개를 뽑는다.
- 당첨 번호와 보너스 번호를 입력받는다.
  - 당첨 번호는 중복되지 않는 6개의 숫자, 1개의 보너스 번호로 구성된다.
  - 당첨 번호는 ","를 기준으로 구분한다.
- 당첨된 번호를 기반으로 생성된 당첨 내역과 수익률을 출력하고 종료한다.
  - 발행된 로또 번호는 오름차순으로 정렬하여 출력한다.
  - 수익률은 소수점 둘째 자리에서 반올림한다.
- 사용자가 잘못된 값을 입력할 시 예외를 발생시킨다.
  - 에러 문구는 "[ERROR]"로 시작해야 한다.
  - 예외가 발생한 부분을 다시 실행한다.


- 예외사항
  - 로또 번호의 범위가 1~45가 아닌 경우
  - 구입 금액은 1000원 단위로 나누어 떨어지지 않는 경우
  - 구입 금액이 로또를 구매하기 부족한 경우
  - 로또 번호에 중복된 값이 존재하는 경우
  - 당첨번호의 수가 6개가 아닌 경우
  - 보너스 번호를 정수로 변환할 수 없는 경우
  - 보너스 번호가 당첨번호에 포함되어있는 경우
    - 이 때 잘못된 번호가 어디에 속해있는지 모르기 때문에 모든 번호를 다시 입력