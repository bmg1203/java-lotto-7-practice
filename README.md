# java-lotto-precourse

![Static Badge](https://img.shields.io/badge/precourse-week3-green)
![Static Badge](https://img.shields.io/badge/test_passed-2%2F2-blue)

---

### 미션 소개 및 다짐

우아한테크코스의 3주차 프리코스 미션으로 `로또`를 구현합니다! 3주차의 학습 목표는 관련 메서드를 묶어 
클래스를 만들고 객체들이 협력하여 하나의 큰 기능을 수행하도록 하는 것입니다. 또한 클래스와 함수에
대해 단위테스트를 수행하여 의도대로 동작하게 하는 것입니다. 객체의 협력, 올바른 단위 테스트가 
이번주차의 목표인만큼 더욱이 메서드의 단일 책임이 중요해진 것 같습니다.

코드 리뷰를 통해 enum으로 상수나 데이터를 묶는 것, 확장성을 조금 더 고려할 것, 더 면밀한 예외처리가
부족하다는 것으르 알았습니다. 이번주차에서는 이들을 보완하려 합니다. 추가적으로 비즈니스 로직과 도메인은 대체 무엇인지
학습할 것입니다.

3주차의 다짐과 목표는 일급 컬렉션과 wrapper 객체에 대해 알아보려 합니다. 또한 원시타입과 참조타입이 어떤 것이고 
장단점에 맞게 올바르게 사용할 예정입니다. 개인적으로 2주차 테스트가 조금 부족하다고 생각합니다. 개발 초기엔 많은 테스트가
있었지만 리팩터링하면서 겹치는 부분이나 테스트를 하지 못하는 메서드가 생겨 삭제하였습니다. 이번엔 테스트를 없애는 경우가 
잦지 않도록 노력해보려 합니다. 공동 학습 목표에서 `객체의 협력을 통해 큰 기능을 수행하는 것`을 통해 테스트는 어디까지
수행되어야 하는지에 대해서도 생각해보려합니다. (ex. Controller도 테스트를 해야할까요?)


# 로또

사용자로부터 로또 구입 금액과 당첨 번호를 입력받아 생성된 로또 N매와 당첨 통계를 확인할 수 있는 애플리케이션입니다.
사용자는 잘못된 입력 시 해당 부분을 재입력해야 하며 생성되는 로또는 완전히 랜덤한 값입니다. 

### 기능 요구 사항

-[ ] 로또 번호의 숫자 범위는 1~45까지이다.
-[ ] 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
-[ ] 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
-[ ] 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
  > 1등: 6개 번호 일치 / 2,000,000,000원 <br>
  > 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원<br>
  > 3등: 5개 번호 일치 / 1,500,000원<br>
  > 4등: 4개 번호 일치 / 50,000원<br>
  > 5등: 3개 번호 일치 / 5,000원
-[ ] 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
-[ ] 로또 1장의 가격은 1,000원이다.
-[ ] 당첨 번호와 보너스 번호를 입력받는다.
-[ ] 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
-[ ] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
-[ ] Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

# 주요 기능

## 로또

- [x] 로또 번호의 숫자 범위는 1~45까지이다.
- [x] 중복되지 않는 6개의 숫자를 가진다.
- [ ] 보너스 번호를 가진다.
- [ ] 가격을 가진다.

## 입력

- [ ] 사용자로부터 로또 구입 금액을 입력 받는다.
- [ ] 6개의 당첨 번호를 입력 받는다.
  - [ ] 번호는 쉼표(,)를 기준으로 구분한다.
- [ ] 보너스 번호를 입력 받는다.
- [ ] 예외 상황 시 해당 부분을 다시 입력받는다.

## 출력

- [x] 발행한 로또 수량 및 번호를 출력한다.
  - [ ] 로또 번호는 오름차순으로 정렬하여 보여준다.
- [ ] 당첨 내역을 출력한다.
- [ ] 수익률은 소수점 둘째 자리에서 반올림한다.
- [ ] 예외 상황 시 에러 문구를 출력한다.
  - [ ] 에러 문구는 `[ERROR]`로 시작한다.

## 추가 고려 사항

- [ ] 

# TDD

- 테스트의 메서드 이름은 [Unit Test Naming Conventions](https://dzone.com/articles/7-popular-unit-test-naming)
  를 참고하여 <i>Given_Preconditions_When_StateUnderTest_Then_ExpectedBehavior</i> 방법으로 한다.
- 이번 미션에서 TDD를 구현하는 방법은 다음과 같다.

```markdown
1. 구현하고자 하는 기능을 정한다.
2. 실패하는 테스트를 작성한다.
3. 객체의 메서드를 적절히 구현한다.
4. 테스트를 실행하여 결과를 확인한다.
5. 구현 도중 더욱 구체적인 요구사항이나 예외사항은 README에 적고 구현완료한 기능과 함께 커밋한다.
```
