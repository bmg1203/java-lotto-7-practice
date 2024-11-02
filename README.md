# java-lotto-precourse

## 프로젝트 소개

해당 프로젝트는 로또 게임을 구현하는 프로젝트입니다.

사용자는 로또 구입 금액을 입력하고 당첨번호와 보너스 번호를 입력합니다.

그 후, 구입한 로또의 번호와 당첨번호를 비교하여 당첨 결과와 수익률을 출력합니다.

## 3주차 목표

- 로또 게임 구현 및 테스트 코드 작성
- 2주차 공통 피드백 적용
- MVC 패턴 적용
- 의미 있는 메소드 이름 적용
- 상수를 의미 있는 이름으로 적용
- 회고

---

## 구현할 기능 목록

- [x] 사용자
    - [x] 로또 구입 금액을 입력한다.
    - [x] 당첨 번호를 입력한다.
    - [x] 보너스 번호를 입력한다.
- [x] 로또 발행기
    - [x] 로또를 발행한다.
- [x] 당첨 통계 계산기
    - [x] 로또 번호를 비교하여 당첨 통계를 계산한다.
    - [x] 수익률을 계산한다.

## 출력

- [x] 로또 구입 금액 입력 메시지
- [x] 구입 금액 만큼 로또 발행 메시지
    - 오름차순으로 정렬하여 출력
- [x] 당첨 번호 입력 메시지
- [x] 보너스 번호 입력 메시지
- [x] 당첨 통계 출력
- [x] 수익률 출력

## 예외 상황

- [x] 사용자가 구입 금액을 입력하지 않은 경우
- [x] 사용자가 구입 금액을 숫자가 아닌 값으로 입력한 경우
- [x] 사용자가 구입 금액을 음수로 입력한 경우
- [x] 사용자가 구입 금액을 1000으로 나누어 떨어지지 않는 수로 입력한 경우
- [x] 사용자가 당첨 번호를 입력하지 않은 경우
- [x] 사용자가 당첨 번호를 6개 초과해서 입력한 경우
- [x] 사용자가 당첨 번호를 6개 미만으로 입력한 경우
- [x] 사용자가 당첨 번호를 1부터 45 사이의 숫자로 입력하지 않은 경우
- [x] 사용자가 당첨 번호를 쉼표(,) 기준으로 구분하지 않은 경우
- [x] 사용자가 입력한 당첨 번호에 중복된 번호가 있는 경우
- [x] 사용자가 보너스 번호를 입력하지 않은 경우
- [x] 사용자가 보너스 번호를 1부터 45 사이의 숫자로 입력하지 않은 경우
- [x] 당첨 번호와 보너스 번호가 중복된 경우

## 테스트 구현 목록

- [x] PurchaseAmountTest.java
    - [x] 구입 금액 입력에 성공한다.
    - [x] 구입 금액을 입력하지 않은 경우 예외가 발생한다.
    - [x] 구입 금액을 숫자가 아닌 값으로 입력한 경우 예외가 발생한다.
    - [x] 구입 금액을 음수로 입력한 경우 예외가 발생한다.
    - [x] 구입 금액을 1000으로 나누어 떨어지지 않는 수로 입력한 경우 예외가 발생한다.

- [x] LottoTest.java
    - [x] 당첨 번호 입력에 성공한다.
    - [x] 로또 번호의 개수가 6개가 초과하면 예외가 발생한다.
    - [x] 로또 번호의 개수가 6개 미만이면 예외가 발생한다.
    - [x] 6개의 로또 번호가 1부터 45 사이의 숫자가 아니면 예외가 발생한다.
    - [x] 로또 번호에 중복이 있으면 예외가 발생한다.

- [x] LottosTest.java
    - [x] 로또가 리스트에 추가되는데 성공한다.

- [x] BonusNUmberTest.java
    - [x] 보너스 번호 입력에 성공한다.
    - [x] 보너스 번호를 입력하지 않은 경우 예외가 발생한다.
    - [x] 보너스 번호를 1부터 45 사이의 숫자로 입력하지 않은 경우 예외가 발생한다.
    - [x] 당첨 번호와 보너스 번호가 중복된 경우 예외가 발생한다.

- [x] LottoIssuerTest.java
    - [x] 구입 금액에 맞게 로또 발행에 성공한다.

- [ ] WinningRankTest.java
    - [ ] 매치 횟수와 보너스매치가 1등에 부합할 때 True를 반환한다.
    - [ ] 매치 횟수와 보너스매치가 2등에 부합할 때 True를 반환한다.
    - [ ] 매치 횟수와 보너스매치가 2등에 부합하지 않을 때 False를 반환한다.
    - [ ] 매치 횟수와 보너스매치가 3등에 부합할 때 True를 반환한다.
    - [ ] 매치 횟수와 보너스매치가 4등에 부합할 때 True를 반환한다.
    - [ ] 매치 횟수와 보너스매치가 5등에 부합할 때 True를 반환한다.

- [ ] WinningStatisticsTest.java
    - [ ] 각 랭크별 당첨 횟수는 0으로 초기화한다.
    - [ ] 각 랭크별 당첨 횟수를 증가한다.

- [ ] WinningStatisticsCalculatorTest.java
    - [ ] 당첨 통계를 계산한다.
    - [ ] 수익률을 계산한다.