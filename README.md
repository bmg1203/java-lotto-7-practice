# java-lotto-precourse

## 학습 목표
- [ ] 관련 함수를 묶어 클래스를 만들고, 객체들이 협력하여 하나의 큰 기능을 수행하도록 한다.
- [ ] 클래스와 함수에 대한 단위 테스트를 통해 의도한 대로 정확하게 작동하는 영역을 확보한다. 
- [ ] 2주 차 공통 피드백을 최대한 반영한다.

### LottoGame
- 전체적인 게임 흐름을 조정하는 역할
  - [x] 게임을 시작하는 기능
  - [ ] 흐름에 맞는 객체 호출 기능

### Money
- 로또 구입 금액 관련 역할
  - [x] 로또 구입 금액 저장
  - [x] 로또 구입 금액 검증

### LottoMachine
- [X] 로또 구입 금액 단위 검증 기능
- [x] 임의의 로또 번호 생성 기능

### Random
- [x] 비즈니스 랜덤과 모킹 랜덤 분리를 위한 인터페이스

### Lotto
- 로또 번호 관련 역할
  - [x] 로또 번호 저장 기능
  - [x] 특정 로또 번호가 있는지 확인하는 기능
  - [x] 로또 번호 목록 조회 기능

### WinningLotto
- 로또 당첨 번호 관련 역할, Lotto 상속
  - [x] 특정 로또와 비교하여 Rank 반환 기능
    - [x] 당첨 횟수 계산 기능
    - [x] 보너스 당첨 여부 계산 기능

### Rank
- 순위 관련된 enum
  - [x] 당첨횟수와 보너스 당첨 유무에 따라 순위 반환 기능

### BonusNumber
- 보너스 번호 관련 역할
  - [x] 보너스 번호 저장
  - [x] 보너스 번호 범위 검증

### GameResult
- 결과 관련 역할
  - [ ] 당첨 로또 계산하기 위한 기능 호출
  - [ ] 각각의 로또들의 결과를 종합하는 기능
  - [ ] 수익률 계산

### InputView
- 사용자 입력 관련 역할
  - [x] 로또 구입 금액 입력
    - [x] 숫자 입력 검증
  - [x] 로또 당첨 번호 입력
    - [x] 숫자 입력 검증
  - [ ] 보너스 번호 입력

### OutputView
- 출력 관련 역할
  - [ ] 구입금액 입력 요구
  - [ ] 구입 로또 출력
  - [ ] 당첨번호 입력 요구
  - [ ] 보너스 번호 입력 요구
  - [ ] 당첨 통계 출력


## 기능 요구 사항
간단한 로또 발매기를 구현한다.

* 로또 번호의 숫자 범위는 1~45까지이다. 
* 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다. 
* 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다. 
* 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다. 
  * 1등: 6개 번호 일치 / 2,000,000,000원 
  * 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원 
  * 3등: 5개 번호 일치 / 1,500,000원 
  * 4등: 4개 번호 일치 / 50,000원 
  * 5등: 3개 번호 일치 / 5,000원
* 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다. 
* 로또 1장의 가격은 1,000원이다.
* 당첨 번호와 보너스 번호를 입력받는다. 
* 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다. 
* 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다. 
  * Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.