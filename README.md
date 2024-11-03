## 기능 목록
### 로또 구입 
- [x] 사용자가 입력한 구입 금액을 받는다.  

### 로또 발행 
- [x] 구입 금액을 바탕으로 발행할 로또 수량을 계산한다. 
- [x] 각 로또는 1에서 45까지의 중복되지 않는 숫자 6개로 구성된다. 
- [x] 발행된 각 로또 번호는 오름차순으로 정렬한다.  
- [x] 로또 수량만큼 로또를 발행한다.  

### 당첨 번호 및 보너스 번호 입력
- [x] 당첨 번호 6개를 입력받는다.
- [x] 보너스 번호를 입력받는다.  
- [x] 당첨 번호 입력에서 당첨 번호만 파싱한다.
- [x] 공백이 존재하면 공백을 삭제한다.
- [x] 입력받은 당첨 번호를 Integer 타입으로 변경한다.
- [x] 입력받은 보너스 번호를 Integer 타입으로 변경한다.

### 당첨 통계 계산
- [x] 사용자가 구매한 각 로또 번호와 당첨 번호를 비교하여 일치하는 숫자의 개수를 계산한다.
- [x] 보너스 번호가 로또 번호와 일치하는지 확인한다.
- [x] 각 로또에 대해 아래 기준으로 당첨 등수를 결정한다.
  - 1등: 6개 번호 일치
  - 2등: 5개 번호 + 보너스 번호 일치
  - 3등: 5개 번호 일치
  - 4등: 4개 번호 일치
  - 5등: 3개 번호 일치
- [x] 수익률 계산
  - 계산된 총 수익을 통해 수익률을 계산한다.
  - 수익률을 계산하고, 소수점 둘째 자리에서 반올림한다.
- [x] 통계를 만든다.
- [x] 총 수익을 계산한다.

### 결과 출력
- [ ] 구입금액 입력 메시지를 출력한다.
- [ ] 구매한 로또의 수량을 출력한다.
- [ ] 당첨 번호 입력 메시지를 출력한다.
- [ ] 보너스 번호 입력 메시지를 출력한다.
- [ ] 당첨 통계를 출력한다.
- [ ] 총 수익률을 출력한다.  

## 예외 처리
- 입력값이 잘못되었을 경우 [ERROR]로 시작하는 에러 메시지를 출력하고 해당 부분부터 입력을 다시 받는다.
- IllegalArgumentException, IllegalStateException 등 명확한 예외 유형을 처리하여 올바른 오류 메시지를 출력한다.  

### 로또 구입
- [x] 구입 금액이 숫자가 아닐 경우
- [x] 구입 금액이 1,000원 단위로 나누어 떨어지지 않을 경우
- [x] 구입 금액이 음수이거나 0일 경우
### 당첨 번호 및 보너스 번호 입력
- [x] 당첨 번호 입력 시 쉼표와 숫자만으로 구성되지 않은 경우
- [x] 당첨 번호가 숫자가 아닐 경우
- [x] 당첨 번호가 숫자 6개가 아닌 경우
- [x] 당첨 번호가 1~45 사이의 숫자가 아닐 경우
- [x] 당첨 번호에 중복된 숫자가 있을 경우
- [x] 보너스 번호가 숫자가 아닐 경우
- [x] 보너스 번호가 1~45 사이의 숫자가 아닐 경우
- [x] 보너스 번호가 당첨 번호와 중복될 경우