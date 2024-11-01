# java-lotto-precourse

## 기능 요구 사항
간단한 로또 발매기를 구현한다.

- 로또 번호의 숫자 범위는 **1~45까지**이다.
- 1개의 로또를 발행할 때 **중복되지 않는 6개의 숫자**를 뽑는다.
- 당첨 번호 추첨 시 **중복되지 않는 숫자 6개와 보너스 번호 1개**를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
  - 1등: 6개 번호 일치 / 2,000,000,000원
  - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
  - 3등: 5개 번호 일치 / 1,500,000원
  - 4등: 4개 번호 일치 / 50,000원
  - 5등: 3개 번호 일치 / 5,000원
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
- 로또 1장의 가격은 **1,000원**이다.
- 당첨 번호와 보너스 번호를 입력받는다.
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
  - `Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리한다.

## 입출력 요구 사항
### 입력
- 로또 구입 금액을 입력 받는다. 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.
- 당첨 번호를 입력 받는다. 번호는 **쉼표(,)를 기준**으로 구분한다.
- 보너스 번호를 입력 받는다.
### 출력
- 발행한 로또 수량 및 번호를 출력한다. 로또 번호는 **오름차순**으로 정렬하여 보여준다.
- 당첨 내역을 출력한다.
- 수익률은 **소수점 둘째 자리에서 반올림**한다. (ex. 100.0%, 51.5%, 1,000,000.0%)
- 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.

## 프로그래밍 요구 사항
- 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 **테스트 코드**로 확인한다.
- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- else 예약어와 switch/case는 쓰지 않는다.
- **Java Enum**을 적용하여 프로그램을 구현한다.
- 구현한 기능에 대한 **단위 테스트**를 작성한다.

## TODO
- 사용자 입력 기능
  - [ ] 로또 구입 금액 입력
  - [ ] 당첨 번호 입력
  - [ ] 보너스 번호 입력


- 로또 발행 기능
  - [ ] 구입 금액에 해당하는 발행 로또 수량
  - [ ] 로또 발행


- 당첨 결과
  - [ ] 발행한 로또 수량 출력
  - [ ] 발행한 로또 번호 오름차순으로 출력
  - [ ] 당첨 통계 출력
  - [ ] 수익률 출력


- 잘못된 입력값 처리 기능
  - [ ] 로또 구입 금액이 1,000원으로 나누어 떨어지지 않을 때
  - [ ] 로또 구입 금액에 문자를 입력했을 때
  
  - [ ] 당첨 번호에 문자를 입력했을 때
  - [ ] 입력한 당첨 번호가 6개 보다 적거나 많을 때
  - [ ] 입력한 당첨 번호가 로또 번호의 숫자 범위에 해당하지 않을 때
  - [ ] 중복된 당첨 번호를 입력했을 때

  - [ ] 보너스 번호에 문자를 입력했을 때
  - [ ] 입력한 보너스 번호가 1개 보다 적거나 많을 때
  - [ ] 입력한 보너스 번호가 로또 번호의 숫자 범위에 해당하지 않을 때
  - [ ] 입력한 당첨 번호와 중복된 보너스 번호를 입력했을 때