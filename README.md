# java-lotto-precourse

## 로또

### 프로그래밍 요구사항
프로그래밍 요구 사항 1
JDK 21 버전에서 실행 가능해야 한다.
프로그램 실행의 시작점은 Application의 main()이다.
build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
프로그램 종료 시 System.exit()를 호출하지 않는다.
프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
자바 코드 컨벤션을 지키면서 프로그래밍한다.
기본적으로 Java Style Guide를 원칙으로 한다.
프로그래밍 요구 사항 2
indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
3항 연산자를 쓰지 않는다.
함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
테스트 도구 사용법이 익숙하지 않다면 아래 문서를 참고하여 학습한 후 테스트를 구현한다.
JUnit 5 User Guide
AssertJ User Guide
AssertJ Exception Assertions
Guide to JUnit 5 Parameterized Tests
프로그래밍 요구 사항 3
함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
else 예약어를 쓰지 않는다.
else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
Java Enum을 적용하여 프로그램을 구현한다.
구현한 기능에 대한 단위 테스트를 작성한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
단위 테스트 작성이 익숙하지 않다면 LottoTest를 참고하여 학습한 후 테스트를 작성한다.

### 기능 명세서
1. 구입금액을 입력받아야 한다.
   1. 로또는 한 장에 1000원이다.
   2. 이때 반드시 1000원 단위로 입력받아야 하며, 아니면 에러를 반환한다.
   3. 예를 들어 15000원을 지불했다면 반드시 로또 15장을 구매해야 한다.
2. 구매 개수와 해당 로또의 랜덤 숫자 6개를 출력한다. 이때 출력은 오름차순으로 해야 한다.
3. 당첨 번호 6개를 입력한다. 구분자는 쉼표(,)을 사용한다.
4. 보너스 번호 1개를 입력받는다.

5. 당첨 번호 추첨은 6개의 숫자와 1개의 보너스 숫자를 뽑는다.
   1. 보너스 번호는 2등을 가릴 때 사용한다. (5개의 숫자 일치 + 보너스 숫자 일치)
6. 당첨 내역을 출력한다. 역순으로 5,4,3,2,1등에 해당하는 로또가 몇 개가 있는지 출력한다. 없으면 0개로 출력한다.
7. 수익률도 같이 출력한다. 수익률은 소수점 둘째 자리에서 반올림한다.
8. 예외 상황 시 에러 문구를 출력해야 한다. 이때 반드시 [ERROR] 로 시작해야 한다. => Java Enum 을 사용하라고 했으므로 에러 메시지 구현하면 될 듯


### 예외 처리
1. IllegalArgumentException, IllegalStateException 와 같이 에러를 명확하게 출력한다.


### 기능 명세서 2?
1. 로또 하나는 6개의 숫자를 가진다.
    1. Randoms.pickUniqueNumbersInRange() 메서드를 사용하여 랜덤하게 6개의 숫자를 반환한다.