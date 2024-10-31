# java-lotto-precourse

---
### 로또

---

### 기능목록

- 구입 금액을 입력 기능
  - [예외] 1000단위로 나눠 떨어지지 않는 경우
  - [예외] 입력값이 숫자가 아닌 경우
  - [예외] 입력값이 0 이거나 음수 인 경우
- 발행한 로또 수량 및 번호를 출력 기능
  - 로또 1개의 금액은 1000원
  - 로또 수량만큼 1 ~ 45 까지의 수중 6개 중복 없이 랜덤으로 생성 후 리스트에 저장
- 당첨번호 + 보너스 번호 입력
  - [예외] 입력한 패턴이 적합하지 않은 경우
  - [예외] 입력한 값이 숫자가 아닌 경우
  - [예외] 입력한 번호중 중복값이 있을 경우
  - [예외] 입련한 번호들이 1 ~ 45 범위안에 없을 경우
- 당첨 통계 출력 기능
  - 당첨된 로또 카운팅
  - 전체 수익금 계산
  - 수익률 계산


---

1. domain
   - Lotto
     - 당첨번호 6개 + 보너스번호 1개 저장
     - 당첨 번호가 6개인지 검증
     - 당첨 번호끼리 중복이 있는지 검증
     - 보너스 번호가 로또 번호랑 중복이 없는지 검증
   - User
     - 구매 금액, 구매한 로또, 획득한 상금 관리
   - UserLottoNumber
     - 유저가 구매한 로또 번호를 담는 클래스
   - LottoRanking
     - 로또 등수 (enum)
2. service
   - InputService
     - 입력받은 구매 금액으로 유저의 로또 생성
     - 구매 금액과 로또를 유저에 반환
   - LottoCalculatorService
     - 당첨 결과 계산
3. controller
   - LottoController
     - aaa
4. util
   - CreateLootNumber
     - 1 ~ 45 범위중 6개의 숫자 추출 + 정렬로 자동 로또 생성
5. validate
   - PriceValidate
     - 구매 금액이 숫자인지 검증
     - 구매 금액이 양수인지 검증
   - LottoNumberValidate
       - 로또 번호의 범위가 1 ~ 45 인지 검증
   - BonusNumberValidate
       - 보너스 번호의 범위가 1 ~ 45 인지 검증
6. view
   - InputView
     - 구매 금액을 입력
     - 당첨 번호를 입력
     - 보너스 번호를 입력
   - OutputView
     - 로또 구매시 자동 생성된 로또 번호 출력
     - 당첨 통계 출력
7. constants
   - Constants
     - 상수를 정리
