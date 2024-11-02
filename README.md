# java-lotto-precourse

## 개인 목표

- [ ] 누군가 내 코드를 읽을때, 중간에 멈추지 않을 수 있을 정도로 추상화 레벨을 맞춘다.
- [ ] 여러 객체로 나누어 책임을 분산시키고 SRP 를 준수한다.
- [ ] 필연적으로 도메인 객체들이 생길텐데, 객체의 값을 강제로 Getter 로 꺼내어 값을 비교하지 않고, `객체에게 질문` 을 던져 객체지향적인 사고를 넓힌다.
- [ ] 단위 테스트를 작성할때, HappyCase 와 EdgeCase 의 구분을 명확히 하기 위해 `Inner Class` 와 `@Nested` 를 활용한다.
- [ ] Commit 을 찍을 때, Header 뿐만아니라 Body 를 이용해, 하나의 Commit 에서 이루어진 모든 행동들을 표현한다.
- [ ] 무작성 MVC 구조를 사용하지 않고, 객체를 객체답게 사용하는 것을 목표로 한다.

## 기능 명세

### 입력

- [x] [입력] 구입 금액 입력 기능
- [x] [입력] 당첨 번호 입력 기능 (, 로 구분)
- [x] [입력] 보너스 번호 입력 기능

**사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.**

### 출력

- [x] [출력] 구입 금액 입력 안내 메시지 출력 기능
- [x] [출력] 발행한 로또 수량 및 번호 출력 기능 (로또 번호는 오름차순)
- [x] [출력] 당첨 번호 입력 안내 메시지 출력 기능
- [x] [출력] 보너스 번호 입력 안내 메시지 출력 기능
- [ ] [출력] 당첨 내역과 수익률 출력 기능
    - [ ] [출력] 당첨 내역 출력 기능
    - [ ] [출력] 수익률 출력 기능

### 주요 기능

- [x] 로또를 구매한다.
- [x] 로또를 추첨한다.
- [ ] 추첨을 통해 통계를 낸다. (수익률은 소수점 둘째 자리에서 반올림한다.)

## 프로그래밍 요구사항

- [ ] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- [ ] 3항 연산자를 쓰지 않는다.
- [ ] 함수 또는 메서드가 한 가지 일만 하도록 최대한 작게 만들어라.
- [ ] JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
- [ ] Java Enum을 적용하여 프로그램을 구현한다.
  구현한 기능에 대한 단위 테스트를 작성한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
  단위 테스트 작성이 익숙하지 않다면 LottoTest를 참고하여 학습한 후 테스트를 작성한다.

## 1,2주차 피드백 수용

- [ ] 커밋 메시지를 의미 있게 작성한다.
- [ ] 배열을 사용하지 않고, Collection 을 사용한다.
- [ ] 기능을 구현하기 전, Java API 에서 기본으로 제공하는 API 가 있는지 확인하고, 있다면 이를 사용한다.
- [ ] 코드 포맷팅을 사용한다. (Actions On Save 를 사용한다)
- [ ] 공백도 코딩 컨벤션이다. (if, for, while문 사이의 공백도 코딩 컨벤션이다.)
- [ ] 공백 라인을 의미 있게 사용한다.
- [ ] 값을 하드 코딩하지 않는다.
- [ ] 한 메서드가 한 가지 기능만 담당하게 한다.
