# java-lotto-precourse (로또 게임)

## 프로젝트 설명
로또 발매와 당첨 확인을 구현한 프로젝트입니다.

## 🎯 구현할 기능 목록

### 1. 로또 구매
- [x] 구매 금액 입력 받기
    - 입력값이 null 또는 공백인지 검증
    - 1,000원 단위인지 검증
    - 입력값이 정수로 변환 가능한지 검증
- [ ] 구매 수량에 맞는 로또 발행
    - 1~45 사이의 중복되지 않는 6개 숫자 생성
    - 생성된 번호를 오름차순으로 정렬
    - 발행된 로또 목록 출력

### 2. 당첨 번호 설정
- [ ] 당첨 번호 입력 받기
    - 쉼표(,)로 구분된 6개의 숫자 입력 검증
    - 각 번호가 1~45 사이인지 검증
    - 중복된 숫자가 있는지 검증
- [ ] 보너스 번호 입력 받기
    - 1~45 사이의 숫자인지 검증
    - 당첨 번호와 중복되는지 검증

### 3. 당첨 확인
- [ ] 당첨 번호 매칭 확인
    - 각 로또별 일치하는 번호 개수 계산
    - 보너스 번호 일치 여부 확인
- [ ] 당첨 통계 출력
    - 각 등수별 당첨 개수 계산
    - 당첨금 계산
    - 수익률 계산 (소수점 둘째 자리에서 반올림)

### 4. 예외 처리
- [x] 구매 금액 관련 예외 처리
    - 1,000원으로 나누어떨어지지 않는 경우 IllegalArgumentException 발생
    - 정수가 아닌 경우 IllegalArgumentException 발생
- [ ] 로또 번호 관련 예외 처리
    - 번호가 1~45 범위를 벗어난 경우 IllegalArgumentException 발생
    - 중복된 번호가 있는 경우 IllegalArgumentException 발생
    - 숫자가 6개가 아닌 경우 IllegalArgumentException 발생


## 📝 입출력 요구사항

## 입력

### 구매 금액 입력
- 로또 구입 금액을 입력 받는다.
- 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.
```
    14000
```

### 당첨 번호 입력
- 당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.
```
    1,2,3,4,5,6
```

### 보너스 번호 입력
- 보너스 번호를 입력 받는다.
```
    7
```

## 출력

### 구매 내역 출력
- 발행한 로또 수량 및 번호를 출력한다. 로또 번호는 오름차순으로 정렬하여 보여준다.
```
8개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[1, 3, 5, 14, 22, 45]
```

### 당첨 내역 출력
- 당첨 내역을 출력한다.
```
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
```

### 수익률 출력
- 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)
```
총 수익률은 62.5%입니다.
```

### 예외 상황 출력
- 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.
```
[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.
```

## 💻 실행 결과 예시
```
구입금액을 입력해 주세요.
8000
8개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[1, 3, 5, 14, 22, 45]
당첨 번호를 입력해 주세요.
1,2,3,4,5,6
보너스 번호를 입력해 주세요.
7
당첨 통계
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다.
```

# 💻 프로그래밍 요구사항

## 기본 요구사항
- JDK 21 버전에서 실행 가능해야 한다.
- 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- `build.gradle` 파일은 변경할 수 없으며, **제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.**
- 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
- 기본적으로 Java Style Guide를 원칙으로 한다.

## 코드 구현 요구사항
### 코드 가독성
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
- 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.

### 메서드 구현
- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
- else 예약어를 쓰지 않는다.
- else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
- 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
- Java Enum을 적용하여 프로그램을 구현한다.

### 테스트 요구사항
- JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
- 구현한 기능에 대한 단위 테스트를 작성한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
- 테스트 도구 사용법이 익숙하지 않다면 아래 문서를 참고하여 학습한 후 테스트를 구현한다.
- JUnit 5 User Guide
- AssertJ User Guide
- AssertJ Exception Assertions
- Guide to JUnit 5 Parameterized Tests
- 단위 테스트 작성이 익숙하지 않다면 `LottoTest`를 참고하여 학습한 후 테스트를 작성한다.

## 🛠 기술 스펙

### 라이브러리
- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
- Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickUniqueNumbersInRange()`를 활용한다.
- 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

#### 사용 예시
- 1에서 45 사이의 중복되지 않은 정수 6개 반환
```
Randoms.pickUniqueNumbersInRange(1, 45, 6);
```

## 📦 제공되는 Lotto 클래스

## Lotto 클래스 요구사항
- 제공된 `Lotto` 클래스를 사용하여 구현해야 한다.
- `Lotto`에 `numbers` 이외의 필드(인스턴스 변수)를 추가할 수 없다.
- `numbers`의 접근 제어자인 `private`은 변경할 수 없다.
- `Lotto`의 패키지를 변경할 수 있다.
```
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