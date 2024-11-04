# **로또**

---

## **기능 요구 사항**

간단한 로또 발매기를 구현한다.

- 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
- 로또 1장의 가격은 1,000원이다.
- 당첨 번호와 보너스 번호를 입력받는다.
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    - `Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리한다.

### **입출력 요구 사항**

### **입력**

- 로또 구입 금액을 입력 받는다. 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.

```
14000

```

- 당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.

```
1,2,3,4,5,6

```

- 보너스 번호를 입력 받는다.

```
7

```

### **출력**

- 발행한 로또 수량 및 번호를 출력한다. 로또 번호는 오름차순으로 정렬하여 보여준다.

```prolog
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

- 당첨 내역을 출력한다.

```
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개

```

- 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)

```erlang
총 수익률은 62.5%입니다.

```

- 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.

```prolog
[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.

```

### **실행 결과 예시**

```prolog
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
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다.
```

### **라이브러리**

- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickUniqueNumbersInRange()`를 활용한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

### **사용 예시**

- 1에서 45 사이의 중복되지 않은 정수 6개 반환

```java
Randoms.pickUniqueNumbersInRange(1, 45, 6);

```

### **Lotto 클래스**

- 제공된 `Lotto` 클래스를 사용하여 구현해야 한다.
- `Lotto`에 `numbers` 이외의 필드(인스턴스 변수)를 추가할 수 없다.
- `numbers`의 접근 제어자인 `private`은 변경할 수 없다.
- `Lotto`의 패키지를 변경할 수 있다.

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

---

## 구현할 기능 목록

### 기능

- [x]  구입금액을 입력받는다.
- [x]  입력한 금액에 맞춰 로또의 구입 개수를 구한다.
- [x]  1~45까지 랜덤값 6개로 로또를 생성한다.
    - [x]  구입 개수만큼 로또를 생성한다.
- [x]  구입한 로또들을 로또 저장소에 저장한다.
- [x]  로또를 출력형식에 맞게 변환시킨다.
- [x]  구입 개수와 구입한 로또들을 모두 출력한다.
- [x]  당첨 번호와 보너스 번호를 입력받는다.
- [x]  당첨 번호를 정수로된 리스트로 파싱한다.
- [x]  당첨 번호와 보너스 번호를 가진 당첨 로또를 생성하고 저장한다.
- [x]  입력한 당첨 번호와 보너스 번호에 대해 로또 당첨 결과를 계산한다.
   - [x]  구입한 로또 개수만큼 당첨 결과를 계산하고 반환한다.
- [x]  당첨 결과에 따른 로또 순위를 계산한다.
- [x]  최종적으로 로또 순위에 몇 개 로또가 당첨되었는 지 내역을 저장한다.
- [x]  당첨 결과를 출력한다.
- [x]  수익률(순이익/투자 비용 X 100)을 계산한다.
- [x]  수익률을 출력한다.

### 예외

- [x]  구입 금액이 1000원으로 나누어 떨어지지 않는 경우
- [x]  구입 금액이 음수인 경우
- [x]  구입 금액이 문자열인 경우
- [x]  입력한 당첨 번호의 범위가 1~45가 아닌 경우
- [x]  입력한 당첨 번호가 숫자가 아닌 경우
- [x]  입력한 당첨 번호가 중복될 경우
- [x]  입력한 당첨 번호 개수가 6개가 아닐 경우
- [x]  보너스 번호의 범위가 1~45가 아닌 경우
- [x]  보너스 번호가 숫자가 아닌 경우
- [x]  보너스 번호가 당첨 번호와 겹칠 경우

### 테스트
- [x]  숫자가 아닌 문자열을 입력할 경우 예외를 발생시킨다.
- [x]  보너스 번호가 1~45 범위 밖에 있으면 예외를 발생시킨다.
- [x]  입력한 개수만큼 로또를 생성한다.
- [x]  당첨로또와 구매로또를 비교하여 맞춘 개수와 보너스번호 맞춤 여부를 가진 객체를 반환한다.
- [x]  금액을 음수로 입력하면 예외를 발생시킨다.
- [x]  입력한 금액이 1000원으로 나누어 떨어지지 않으면 예외를 발생시킨다.
- [x]  로또 객체들을 출력형식과 맞게 변환시켜준다.
- [x]  로또 번호에 중복된 숫자가 있으면 예외가 발생한다.
- [x]  숫자로된 리스트를 입력하면 해당 숫자들로 구성된 로또가 생성된다.
- [x]  로또 번호는 1 ~ 45 범위 밖이면 예외가 발생한다.

## 패키지 구조

```
lotto
├── Application.java
├── LottoApplication.java
│
├── application
│   ├── CalculateProfitUseCase.java
│   ├── FacadeLottoUseCase.java
│   ├── LottoResultUseCase.java
│   ├── PurchaseLottoUseCase.java
│   ├── RetrieveLottoUseCase.java
│   │
│   └── service
│       ├── CalculateProfitService.java
│       ├── FacadeLottoService.java
│       ├── LottoResultService.java
│       ├── PurchaseLottoService.java
│       ├── RetrieveLottoService.java
│       └── vo
│           └── MatchingInfo.java
│
├── common
│   ├── ConsoleMessage.java
│   ├── ExceptionMessage.java
│   ├── LottoConfig.java
│   ├── LottoConstant.java
│   ├── NumberParser.java
│   └── RandomNumbersCreator.java
│
├── domain
│   ├── BonusNumber.java
│   ├── Lotto.java
│   ├── LottoFactory.java
│   ├── LottoMatcher.java
│   ├── LottoRank.java
│   ├── Money.java
│   ├── WinLotto.java
│   ├── WinResult.java
│   │
│   └── repository
│       ├── InMemoryLottoRepository.java
│       ├── InMemoryWinLottoRepository.java
│       ├── LottoRepository.java
│       ├── WinLottoRepository.java
│       └── WinResultHistory.java
│
└── view
    ├── ApplicationConsoleView.java
    ├── ApplicationView.java
    │
    ├── converter
    │   ├── LottoMessageParser.java
    │   └── MessageParser.java
    │
    └── dto
        └── WinningInfo.java
```
