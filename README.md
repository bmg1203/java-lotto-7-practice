# java-lotto-precourse
## 기능 목록
### 로또 구매 기능
- 로또 구매 금액을 입력받는 기능
  - 올바른 금액이 입력되지 않은 경우, (정수가 아니거나, 1000원으로 나누어떨어지지 않는 경우) 예외 발생
- 입력된 금액이 올바른지 검사하는 기능
- 구매 금액만큼 로또를 구매하는 기능
  - 금액만큼 `Randoms.pickUniqueNumbersInRange`를 통해 생성한 6개의 번호로 Lotto를 생성한 뒤, 리스트에 저장한다.
### 로또 추첨 기능
- 사용자로부터 당첨 번호와 보너스 번호를 입력받는 기능
  - 입력받은 값이 유효한 범위 내 정수가 아닌 경우, 예외 발생
- 각 로또 번호를 순회하며, 등수별 당첨 정보를 갱신하는 기능
- 등수별 당첨 내역을 출력하는 기능 