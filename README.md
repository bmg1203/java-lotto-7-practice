# java-lotto-precourse

### 안내 사항
##### 기능 요구 사항
간단한 로또 발매기 구현
- 로또 번호의 숫자 **범위는 1~45**
- 1개의 로또를 발행할 때 **중복되지 않는** 숫자 **6개**를 뽑는다.
- 당첨 번호 **추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개**를 뽑는다.
- 당첨은 1등부터 5등까지 존재
  - 1등 : 6개 번호 일치 / 2십억
  - 2등 : 5개 번호 일치 + 보너스 번호 일치 / 3천만원
  - 3등 : 5개 번호 일치 / 150만원
  - 4등 : 4개 번호 일치 / 5만원
  - 5등 : 3개 번호 일치 / 5천원
- 로또 구입 금액 입력, 해당하는 만큼의 로또 발행
- 로또 1장의 가격 = 1000원
- 당첨 번호와 보너스 번호 입력받기
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률 출력, 로또 게임 종료
- 잘못된 값 입력의 경우, IllegalArgumentException을 발생. \[ERROR]로 시작하는 에러 메시지 출력. 그 부분부터 재 입력받기
  - Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형 처리

##### 입출력 요구 사항
입력
- 로또 구입 금액 입력: 1,000원 단위 입력, 나누어떨어지지 않는 경우 예외 처리
- 당첨 번호 입력: 쉼표 기준 구분
출력
- 발행한 로또 수량 및 번호 출력, 오름차순 정렬
- 수익률은 소수점 둘째자리에서 반올림
- 예외 상황 시 에러 문구 출력. \[ERROR]로 시작

##### 프로그래밍 요구 사항
1주차
- JDK 21 버전에서 실행 가능해야 한다.
- 프로그램 실행의 시작점은 Application의 main()이다.
- build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- 프로그램 종료 시 System.exit()를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
- 기본적으로 Java Style Guide를 원칙으로 한다.
2주차
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
- 테스트 도구 사용법이 익숙하지 않다면 아래 문서를 참고하여 학습한 후 테스트를 구현한다.
3주차(New!)
- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
  - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
- else 예약어를 쓰지 않는다.
  - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
  - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
- Java Enum을 적용하여 프로그램을 구현한다.
- 구현한 기능에 대한 단위 테스트를 작성한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
  - 단위 테스트 작성이 익숙하지 않다면 LottoTest를 참고하여 학습한 후 테스트를 작성한다.

### 추가 인지 내용
##### 기능 목록
1. 금액 입력 받기
2. 금액으로 로또 구매하기
3. 구매한 로또 번호 추첨하기
4. 당첨 번호 입력 받기
5. 보너스 번호 입력 받기
6. 통계 내기

##### 구현 클래스 목록
- View
  - PurchaseInput 클래스: 구매할 금액을 입력받는 클래스
  - WinningInput 클래스: 당첨 번호를 입력받는 클래스
  - StatisticsOutput 클래스: 당첨 통계를 출력하는 클래스
- Controller
  - LottoController 클래스: 전체적인 흐름을 제어하는 클래스
  - PurchaseController 클래스: 입력받은 금액을 PurchaseService클래스에 업데이트 해주는 클래스
  - WinningController 클래스: 입력받은 당첨 번호를 WinningService클래스에 업데이트 해주고 각 로또의 당첨 순위를 StastisticsOutput클래스에 업데이트 해주는 클래스
- Service
  - PurchaseService 클래스: 로또를 구매하고 예외처리하는 클래스
  - WinningService 클래스: 입력받은 당첨 번호를 통해 총 당첨 통계를 내주는 클래스
- Lotto 클래스: 로또의 길이를 검증하고 로또 번호를 추첨해주는 클래스