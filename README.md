> ### [노션 : 프로젝트 정리](https://grand-calcium-138.notion.site/3-12e8d7f5b233803ab356c497a7070de8?pvs=4)
# 로또 발매기 기능 구현

> 간단한 로또 발매기를 구현한다.

---

## 📋 기능 목록

1. [README.md](README.md) 작성
2. 다음 순서 대로, 테스트 코드를 작성한다.
3. 지시사항을 출력한다.
4. 구입 금액을 입력 받는다.
5. 금액 만큼 로또를 발행한다.
6. 구매한 로또 개수 및 번호를 출력한다.
7. 당첨 번호를 입력 받는다.
8. 보너스 번호를 입력 받는다.
9. 당첨을 확인한다.
10. 당첨 통계를 출력한다.
11. 입력의 예외사항을 추가한다.
12. 코드 구조를 리팩터링한다.

---

## 🔍 세부 기능

| **기능** | **구현 세부사항** |
| --- | --- |
| 테스트 코드 작성 | - 모든 테스트가 실패 상태에서 시작 |
| 지시사항 출력 | - 사용자가 구매 금액을 입력하도록 메시지 출력 |
| 구입 금액 입력 | - 사용자로부터 구입 금액을 입력 받음<br> - 입력의 유효성 검증 |
| 입력 유효성 검증 | - 입력이 숫자이며 양의 정수인지 확인 |
| 로또 발행 | - 구입 금액에 맞는 수량의 로또 발행 |
| 로또 개수 및 번호 출력 | - 구매한 로또 개수 출력<br> - 각 로또 번호 출력 |
| 당첨 번호 입력 | - 당첨 번호 입력받고 유효성 검증 |
| 당첨 확인 | - 입력한 번호와 로또 당첨 여부 확인<br> - 총 수익률 계산 |
| 당첨 통계 출력 | - 당첨 통계를 출력 |
| 입력 예외사항 처리 | - 입력의 예외사항 처리 |
| 코드 리팩터링 | - 객체 지향적으로 코드 구조를 개선 |

---

## 🚫 예외 사항

### 구입 금액 예외
- **1000원 단위가 아님** : `1220`
- **숫자가 아님** : `천원`
- **음수 입력** : `-1999`
- **빈 입력** : `""`
- **0원 입력**
    - 결과 : 0개 로또 구매 가능

### 당첨 번호 입력 예외
- **빈 입력** : `""`, `"1, 2, , 5"`
- **숫자가 아닌 요소** : `"a, 1, 2"`, `"?, 1, 2"`
- **허용된 범위 외 숫자** : `65`
- **허용된 공백 포함** : `"    12    , 1"` (허용)

### 보너스 숫자 입력 예외
- **빈 입력** : `""`
- **숫자가 아님** : `"일"`
- **음수 입력** : `-2`
- **허용된 범위 외 숫자** : `65`

--- 

### 🔄 개발 과정 요약

- 초기 테스트 코드 작성 후, 모든 테스트가 실패해야 함.
- 입력과 유효성 검증을 반복하며 기능을 추가하고 테스트 진행.
- 입력 예외 사항을 처리한 뒤, 전체 코드를 객체 지향적으로 리팩터링.


## 리펙터링 일지

### **DDD 적용**

### 기존 개발 방식과 새로운 접근법

지금까지는 MVC 패턴으로 개발을 해왔지만, 조금 더 객체지향적으로 접근할 수 있는 패턴이 필요했다.

---

## Lotto 클래스 예시

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


도메인 자체로

→ 유효성 검증, 변경로직 등이 일어나도록 설계함

지난주 부터 개발해왔던, 일급 클래스

→  불변성을 유지하며, 로직을 엔티티 클래스에 모두 구현한 형식

**아!  도메인 패턴을 사용할 수 있겠다.**

그러면 도메인 패턴이란 뭘까

---

## DDD (Domain Driven Design) : 도메인 주도 개발

**복잡한 도메인 문제를 해결하기 위해 도메인 모델을 중심으로 설계하는 개발론**

복잡한 도메인?

> 현실세계

예를 들면
- 팀내에서 사용하는 유비쿼터스 언어
- 모두에게 통용되는 단어를 기준으로  

→ 서비스가 어떻게 흘러가는 지를 기준으로 도메인 영역을 나눈다.

- 사용자가 메뉴에서 음식을 골라 주문하면, 결제를 진행하고, 주문 정보가 가게에 전달된다.
  - 이 컨텍스트를 나누면 다음과 같다.
  - 주문 관리 : 주문을 생성하고, 상태를 관리한다. 주문의 한 주기를 관리.
  - 고객 관리 : 고객의 정보를 관리한다. 프로필, 주문기록, 선호 음식 등
  - 결제 관리 : 결제 처리를 하는 기능을 수행한다.

이렇게 나뉘게 되면 각각의 컨텍스트에는 다음과 같은 엔티티들의 관계가 있다.

- **주문**과 **메뉴** : 메뉴를 선택하고 이를 기준으로 주문을 생성
- **고객**과 **주문 기록** : 고객은 주문 기록을 가지며, 고객의 행동에 따라서 주문기록이 달라짐
- **결제** 관련 : 결제 id, **결제 방법**, 상태, 결제 금액 등을 표현

모델들간에 관계에 따라서 도메인을 설정하고, 이를 코드 설계에 적용한 방법이 DDD 이다.

> 즉, 현실 세계에서 어떤 서비스를 제공하기 위해 얽혀있는 여러 모델(엔티티)를 이해관계에 따라 묶어 이를 기준으로 프로그램을 설계하는 것이다.

--- 
## 도메인 주도 개발 (DDD) 및 이벤트 중심 설계 (EDA) 적용

도메인 주도의 로직을 짜다 보니, 레포지토리나 서비스가 서로 얽혀있는 것이 객체지향적이지 못하다는 느낌을 많이 받았다. 

예를 들면, DI를 해 줘야 하는 서비스들이 지속적으로 중복되고, 어떤 한 기능만을 위해서 컨트롤러, 서비스를 인자로 넘겨줘야 하는 경우도 생겼다. 
이를 해결하기 위한 방법을 고민하다가, 도메인들이 서로 독립적으로 작용하지만 관계성을 유지하도록 하는 이벤트 중심 설계 패턴(Event-Driven Architecture, EDA)을 학습하게 되었고 이를 코드에 적용했다.

### 코드를 재구성 하면서 어려웠던 점
- 처음 적용해보는 디자인 패턴이다 보니, 어떤 패키지 구조를 가지고 있으며, 각각이 어떤 역할을 수행해야 하는지 조차를 몰라서 이를 이해하고, 적용하는데 시간이 많이 걸렸음. **구조 설계가 너무 어려웠다.**
- 가장 헷갈렸던 점은, 기존의 **MVC 패턴과의 차이점을 이해 못함.**   

---

### DDD 패턴의 구조
핵심 4가지 영역:
- **도메인 (Domain)**
- **애플리케이션 (Application)**
- **인프라스트럭처 (Infrastructure)**
- **인터페이스 (Interface)**

### 도메인
- 가장 핵심적인 패키지
- 비즈니스 로직 구현
- 리포지토리, 서비스, 이벤트, 엔티티 등이 이곳에 속함.

### 애플리케이션
- 도메인 모델을 사용해서 비즈니스 시나리오를 구현
- 트랜젝션 관리, 도메인 로직 호출 비즈니스 프로세스를 처리
- DTO를 활용해 도메인 객체를 전달.

### 인프라스트럭처
- 외부 시스템과의 통신, 데이터베이스 접근, 브로커와의 연결
- 리포지토리 구현체
- 이벤트 퍼블리셔 → 도메인 이벤트를 외부로 퍼블리시 하거나 소비.

### 인터페이스
- EST 컨트롤러, 웹소켓, GraphQL 핸들러 등 사용자와의 접점을 제공
- **컨트롤러**: HTTP 요청을 받아서 애플리케이션 서비스에 전달하고, 결과를 반환.
- **뷰 모델 (View Model)**: 프레젠테이션 계층에서 사용될 데이터를 포함.  
--- 

가장 이해가 안 되었던 부분은 **애플리케이션 계층**이다.
- 애플리케이션의 비즈니스 흐름을 담당하는 계층
- 도메인 로직을 직접 포함하지 않지만, 도메인 계층의 여러 요소(엔티티, 도메인 서비스 등)를 조합하여 비즈니스 작업을 수행.

이것이 애플리케이션 계층의 역할인데 → 이거는 컨트롤러의 역할이 아닌가 했다. 하지만 컨트롤러와는 엄연히 다름.

- **컨트롤러**
  - 사용자의 요청을 처리하고, 응답을 반환.
  - 비즈니스 로직을 포함하지 않음.
  - 사용자가 서비스를 이용하는 시작점이라고 생각할 수 있음.

→ 애플리케이션 계층은 컨트롤러와는 다르게 → 사용자와의 데이터를 직접 주고받는 부분이 없다. → 이는 프레젠터션 패키지에서 구현되며 이곳에 컨트롤러가 속한다. 또한 서비스 로직을 단순히 호출만 하는 것이 아니라, 비즈니스 흐름에 따라서 여러 엔티티를 조율하고 관리하는 역할을 맡는다.

> 아니, 그러면 DDD에서는 어차피 도메인에서 로직을 처리하는데 → 서비스 계층이, MVC의 컨트롤러와 같은 역할을 하고 있는거 아니야?
>
→ 이에 대한 고민을 했다.
- 서비스 계층은 → 도메인 간의 로직을 조직화 하고, 조합하는 경우가 많음.
- 근데 왜, 내가 **개발한 미션에서는 단순 호출**처럼 느껴졌을까?
- 복잡성이 낮기 때문.
- 추후 복잡성이 높아지고, 모델과 도메인이 복잡해지면 이와 같은 패턴이 필연적으로 필요하게 됨.

---

## 이벤트 적용

도메인 로직을 직접 호출하는 것이 아니라 ⇒ 이벤트에 따라서 다음 동작을 하도록 구현.

- **EventPublisher**
  - 리스너들에게 이벤트를 전달하는 역할을 함.

    ```java
    package lotto.shared.event;
    
    import java.util.List;
    
    public class EventPublisher {
        private final List<EventListener> listeners;
    
        public EventPublisher(List<EventListener> listeners) {
            this.listeners = listeners;
        }
    
        public void registerListener(EventListener listener) {
            listeners.add(listener);
        }
    
        public void publish(DomainEvent event) {
            for (EventListener listener : listeners) {
                listener.handle(event);
            }
        }
    }
    ```

  - 이벤트에 따라 → 리스너들이 행동하도록 로직을 구성.

- **DomainEvent**
  - 도메인의 행위를 하는 이벤트를 받는 리스너들이 존재.
  - 이 리스너로 들어가 다음 행위를 하도록 트리거 시킴.

이 둘을 적절하게 이용해서 → 행위가 끝나면 이벤트를 발생시키고 → 이를 watch하고 있는 리스너의 로직이 발동되는 식으로 함수를 구성한다.

이렇게 구현하다 보니 → 앞선 로직에서 생성된 객체가 필요한 경우가 생김.

- 이를 저장하기 위한 오케스트라 클래스를 함수로 둠.

    ```java
    package lotto.shared.event;

    import lotto.checker.domain.BonusNumber;
    import lotto.checker.domain.Lottos;
    import lotto.checker.domain.WinningNumbers;
    import lotto.checker.event.BonusNumberCreatedEvent;
    import lotto.checker.event.WinningNumbersCreatedEvent;
    import lotto.purchase.domain.Money;
    import lotto.purchase.event.MoneyCreatedEvent;
    import lotto.results.dto.ResultsRequest;

    public class EventOrchestrator {
        private Money money;
        private Lottos lottos;
        private WinningNumbers winningNumbers;
        private BonusNumber bonusNumber;

        public Money getMoney() {
            return money;
        }

        public Lottos getLottos() {
            return lottos;
        }

        public WinningNumbers getWinningNumbers() {
            return winningNumbers;
        }

        public void register(MoneyCreatedEvent event) {
            this.money = event.getMoney();
        }

        public void register(LottosCreatedEvent event) {
            this.lottos = event.getLottos();
        }

        public void register(WinningNumbersCreatedEvent event) {
            this.winningNumbers = event.getWinningNumbers();
        }

        public void register(BonusNumberCreatedEvent event) {
            this.bonusNumber = event.getBonusNumber();
        }

        public ResultsRequest createResultRequest() {
            return new ResultsRequest(lottos, winningNumbers, bonusNumber);
        }
    }
    ```

필드로 후순위 로직에 필요한 엔티티를 저장하도록 함  
이후 오케스트라를 사용해서 → 필요한 객체를 생성해 사용.
