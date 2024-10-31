## 지난주 피드백
- 도메인을 불변 객체로 만들어서 객체를 새로 생성할 경우 메모리 용량의 문제나 이후 Spring을 사용했을 때 Proxy 객체의 참조에 문제가 발생할 수도 있다. 도메인은 가변할 수 있도록 만들자.
- 도메인에서 서비스 의존성을 주입받는 것은 의존성 역전 원칙에 어긋난다. 도메인에서 서비스로 데이터가 흘러가는 계층적 흐름을 유지하자.
- Util에는 도메인 로직이 포함되면 안된다.
- 검증 메소드가 도메인에 존재하면 생성 로직과 함께 처리 가능해서 코드가 간결해진다.
- 입력이 같은 타입이고 같은 반환을 테스트한다면 @ParameterizedTest를 사용해보는걸 추천한다.

## 공통 피드백 중 해당하는 부분
- README.md를 상세히 작성하라
  - 기능 목록 뿐만 아니라 예외 상황도 정리할 것
  - 기능을 구현하면서 지속적으로 업데이트할 것
- 값을 하드코딩하지 않는다
- 구현 순서를 지키자
- 변수 이름에 자료형은 사용하지 않는다

## **로또 미션**
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
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
- Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.
---

### 실행결과 예시
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
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다.
```

### **구현할 기능 목록 정리**
- **Model**
    - [ ] **LotteryMachine** : AutoLotteryNumbers(자동 추첨 복권 모델)와 몇 매 구매했는지에 대한 책임을 갖는 로또 발매기 모델
    - [ ] **AutoLotteryNumbers** : 로또를 발행했을 때 뽑는 중복되지 않는 6개의 번호에 대한 모델
    - [ ] **Lotto** : 입력 로또 번호에 관련한 책임을 갖는 모델
- **기능**
    - [ ] 안내문 출력
    - [ ] 구입금액 입력
    - [ ] 구입금액 검증(빈값, 숫자 여부, 금액 부족, 1,000원 단위, 최대 수량 확인)
        - [ ] 예외 발생 시 재입력
    - [ ] 구입금액에 따른 AutoLotteryNumbers 생성 및 LotteryMachine 생성
    - [ ] LotteryMachine 결과 출력
    - [ ] 당첨 번호 입력
    - [ ] 콤마(,) delimiter로 문자열 parse 기능
    - [ ] 당첨 번호 검증(빈값, 숫자/콤마 여부, 1~45 범위 여부, 중복 여부 확인)
        - [ ] 예외 발생 시 재입력
    - [ ] 보너스 번호 입력
    - [ ] 보너스 번호 검증(빈값, 숫자 여부, 1~45 범위 여부, 중복 여부 확인)
        - [ ] 예외 발생 시 재입력
    - [ ] LotteryMachine과 당첨 번호, 보너스 번호를 비교하여 당첨 통계 계산
    - [ ] 당첨 통계 출력
    - [ ] 수익률 계산
    - [ ] 수익률 출력

### **예외 처리 목록**
- 빈값 예외
- 숫자가 아닌 문자 예외
- 1,000원 단위로 구매 가능합니다 예외
- 금액이 부족합니다 예외
- 로또 최대 구매 수량 초과 예외
- 숫자, 콤마(,)가 아닌 문자 예외
- 로또 숫자 1~45 범위가 아닌 예외
- 로또 숫자 중복 예외

## **프로그래밍 요구 사항**
- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
    - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
- else 예약어를 쓰지 않는다.
    - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
    - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
- Java Enum을 적용하여 프로그램을 구현한다.
- 구현한 기능에 대한 단위 테스트를 작성한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
    - 단위 테스트 작성이 익숙하지 않다면 `LottoTest`를 참고하여 학습한 후 테스트를 작성한다.

### 라이브러리
- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console API`를 사용하여 구현해야 한다.
    - `Random` 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickUniqueNumbersInRange()`를 활용한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

#### 사용 예시
- 1에서 45 사이의 중복되지 않은 정수 6개 반환
```
Randoms.pickUniqueNumbersInRange(1, 45, 6);
```

### Lotto 클래스
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
