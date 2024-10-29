# java-lotto-precourse
**로또**

## 학습 목표

---

* 관련 함수를 묶어 클래스를 만들고, 객체들이 협력하여 하나의 큰 기능을 수행하도록 한다.
* 클래스와 함수에 대한 단위 테스트를 통해 의도한 대로 정확하게 작동하는 영역을 확보한다.

---

## 과제 진행 요구 사항
* 기능을 구현하기 전 `README.md`에 구현할 기능 목록을 정리해 추가한다.
* `Git`의 커밋 단위는 앞 단계에서 `README.md`에 정리한 기능 목록 단위로 추가한다.
  * `AngularJS Git Commit Message Conventions`을 참고해 커밋 메시지를 작성한다.

---

## 기능 요구 사항
* [ ] Lotto 금액을 입력 받을 수 있어야 한다.
  * 입력 받는 금액이 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.
  * 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException` 을 발생시킨다.
  * `[ERROR]` 로 시작하는 에러 메시지를 출력 후 그 부분부터 다시 입력 받는다.


* [ ] 당첨 번호를 입력 받을 수 있어야 한다.
  * 번호는 쉼표(,)를 기준으로 구분되어야 한다.
  * 당첨 번호는 1 ~ 45 까지의 숫자여야 한다.
  * 당첨 번호는 중복되지 않는 6개의 숫자여야 한다.
  * 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException` 을 발생시킨다.
  * `[ERROR]` 로 시작하는 에러 메시지를 출력 후 그 부분부터 다시 입력 받는다.


* [ ] 보너스 번호를 입력 받을 수 있어야 한다.
  * 보너스 번호는 1 ~ 45 까지의 숫자여야 한다.
  * 보너스 번호는 당첨 번호와 중복되지 않는 1개의 숫자여야 한다.
  * 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException` 을 발생시킨다.
  * `[ERROR]` 로 시작하는 에러 메시지를 출력 후 그 부분부터 다시 입력 받는다.


* [ ] 입력 받은 금액으로 Lotto 를 발행할 수 있어야한다.
  * 입력 받은 금액을 1,000원으로 나누어 떨어지는 만큼 발행되어야 한다.
  * 발행되는 Lotto 번호는 1 ~ 45 까지의 숫자여야 한다.
  * 발행되는 Lotto 번호는 중복되지 않는 6개의 숫자여야 한다.
  * `[ERROR]` 로 시작하는 에러 메시지를 출력 후 그 부분부터 다시 입력 받는다.

  <br>

* [ ] 사용자가 구매한 Lotto 번호에 대해 당첨 되었는지 비교할 수 있어야한다.

  <br>

* [ ] 당첨 내역과 수익률을 출력할 수 있어야한다.
  * 수익률은 소수점 둘째 자리에서 반올림해야 한다.
  * 당첨 기준과 금액은 아래와 같이 선정되어야 한다.
      * 1등 : 6개 번호 일치 / 2,000,000,000원
      * 2등 : 5개 번호 + 보너스 번호 일치 / 30,000,000원
      * 3등 : 5개 번호 일치 / 1,500,000원
      * 4등 : 4개 번호 일치 / 50,000원
      * 5등 : 3개 번호 일치 / 5,000원

---

## 프로그래밍 요구 사항 1
* JDK 21 버전에서 실행 가능해야 한다.
* 프로그램 실행의 시작점은 `Application`의 `main()`이다.
* build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
* 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
* 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
* 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  * 기본적으로 `Java Style Guide`를 원칙으로 한다.

## 프로그래밍 요구 사항 2
* `indent`(인덴트, 들여쓰기) `depth`를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
  * 예를 들어 `while`문 안에 `if`문이 있으면 들여쓰기는 2이다.
  * 힌트: `indent`(인덴트, 들여쓰기) `depth`를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.


* 3항 연산자를 쓰지 않는다. 
* 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라. 
* `JUnit 5`와 `AssertJ`를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.

## 프로그래밍 요구 사항 3
* 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
* 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
* `else` 예약어를 쓰지 않는다.
  * `else`를 쓰지 말라고 하니 `switch/case`로 구현하는 경우가 있는데 `switch/case`도 허용하지 않는다.
  * 힌트: `if` 조건절에서 값을 `return`하는 방식으로 구현하면 `else`를 사용하지 않아도 된다.


* `Java Enum`을 적용하여 프로그램을 구현한다. 
* 구현한 기능에 대한 단위 테스트를 작성한다. 단, `UI(System.out, System.in, Scanner)` 로직은 제외한다. 
  * 단위 테스트 작성이 익숙하지 않다면 LottoTest를 참고하여 학습한 후 테스트를 작성한다.

### 라이브러리
* `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console API`를 사용하여 구현해야 한다.
  * `Random` 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickUniqueNumbersInRange()`를 활용한다.
  * 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

#### 사용예시
* 1에서 45 사이의 중복되지 않은 정수 6개 반환
```java
Randoms.pickUniqueNumbersInRange(1, 45, 6);
```

---

#### `Lotto` 클래스
* 제공된 `Lotto` 클래스를 사용하여 구현해야 한다.
* `Lotto`에 `numbers` 이외의 필드(인스턴스 변수)를 추가할 수 없다.
* `numbers`의 접근 제어자인 `private`은 변경할 수 없다.
* `Lotto`의 패키지를 변경할 수 있다.


```java
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
}
```