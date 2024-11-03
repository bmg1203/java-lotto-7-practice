# ✨ 자동차 경주
## 기능 요구 사항
- 간단한 로또 발매기를 구현한다.
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
Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.
# ✅ 구현할 기능 목록

### 로또 구입
- [x] 로또 구입 금액 입력
  - [x] 1000원 단위로 나누어 떨어지지 않는 경우 예외 처리
### 당첨 번호 입력
- [x] 로또 당첨 번호 입력
  - [x] 중복되지 않는 숫자 6개와 보너스 번호 1개
  - [x] 당첨 번호와 보너스 번호가 1~45 사이인지 검증
  - [x] 당첨 번호와 보너스 번호가 중복되지 않는지 검증
### 로또 발행
- [x] 구입 금액에 해당하는 만큼 로또 발행
- [x] 로또 번호 생성 시, 번호들이 오름차순으로 자동 정렬되도록 설정
- [x] 구매한 로또 번호 출력
### 당첨내역 확인
- [x] 사용자가 구매한 로또 번호와 당첨 번호를 비교
- [x] 등수별 당첨 개수를 카운트하여 통계 출력
- [ ] 등수별 당첨 개수에 따른 당첨금 계산
### 수익률 확인
- [ ] 구입 금액과 당첨 금액을 비교하여 수익률 계산
  - [ ] 소수점 둘째 자리에서 반올림


