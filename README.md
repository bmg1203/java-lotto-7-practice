# java-lotto-precourse

이 프로젝트는 간이 로또 발매기 프로그램을 구현하여 로또 구매와 당첨 결과를 확인하는 기능을 제공한다. 
사용자는 구입 금액 입력부터 당첨 결과 확인, 수익률 계산까지 모든 로또 발행 과정을 경험할 수 있다.

## 기능 목록

1. **구입 금액 입력**
    - 구입 금액을 입력받아 로또 발행 개수를 계산한다.
    - 금액은 1,000원 단위로 입력하며, 최소 금액은 1,000원이다.
    - 예외 처리: 1,000원으로 나누어 떨어지지 않거나 정수가 아닐 경우 오류를 발생시킨다.

2. **로또 발행**
    - 1,000원당 한 장의 로또를 발행하고, 로또 번호는 오름차순으로 정렬하여 출력한다.
    - 각 로또는 중복 없는 6개의 숫자로 구성된다.
    - 예외 처리: 로또 번호는 1에서 45 사이의 숫자로 구성된다.

3. **당첨 번호 입력**
    - 당첨 번호 6개와 보너스 번호를 입력받는다.
    - 예외 처리:
        - 당첨 번호와 보너스 번호는 중복이 없어야 한다.
        - 번호는 쉼표(`,`)로 구분하며, 총 6개의 번호와 보너스 번호 1개를 입력한다.

4. **당첨 결과 계산**
    - 구매한 로또 번호와 당첨 번호를 비교하여 일치하는 번호의 개수를 계산하고 등수를 판별한다.
    - 등수는 다음과 같이 구분된다:
        - **1등**: 6개 일치 - 2,000,000,000원
        - **2등**: 5개 일치 + 보너스 번호 - 30,000,000원
        - **3등**: 5개 일치 - 1,500,000원
        - **4등**: 4개 일치 - 50,000원
        - **5등**: 3개 일치 - 5,000원

5. **수익률 계산**
    - 전체 수익을 기반으로 수익률을 소수점 둘째 자리까지 계산하여 출력한다.

6. **통계 출력**
    - 당첨 결과와 수익률을 출력한다.
    - 예시 출력:
      ```
      당첨 통계
      ---
      3개 일치 (5,000원) - 1개
      4개 일치 (50,000원) - 0개
      5개 일치 (1,500,000원) - 0개
      5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
      6개 일치 (2,000,000,000원) - 0개
      총 수익률은 62.5%입니다.
      ```

## 프로그래밍 요구 사항

- JDK 21에서 실행 가능하도록 구현한다.
- `System.exit()`를 호출하지 않으며, `build.gradle` 설정은 변경하지 않는다.
- 들여쓰기 depth는 2까지만 허용한다.
- `else` 예약어나 `switch` 문을 사용하지 않는다.
- `Java Enum`을 활용하여 등급별 상금을 관리한다.
- `JUnit 5`와 `AssertJ`를 사용해 기능별 단위 테스트를 작성한다.

## 참고 사항

- `Randoms.pickUniqueNumbersInRange(1, 45, 6);` 메서드를 사용해 1에서 45 사이의 중복되지 않은 정수 6개를 생성한다.
- 사용자 입력은 `Console.readLine()`을 활용한다.
- 예외 발생 시 "[ERROR]"로 시작하는 오류 메시지를 출력한다.
