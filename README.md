# java-lotto-precourse

## 🗣️ 간단한 로또 발매기
 - 1~45 랜덤한 번호 6자리를 뽑아 로또 발매기를 만든다.
 - 로또 1장의 가격은 1,000원이며 입력된 구입 금액에 해당하는 만큼 로또를 발행한다.
 - 발행된 로또는 사용자가 입력한 당첨 번호와 보너스 번호와 매칭하여 당첨 여부를 파악한다.
 - 당첨 기준과 금액은 다음과 같다.
   - 1등: 6개 번호 일치 / 2,000,000,000원
   - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
   - 3등: 5개 번호 일치 / 1,500,000원
   - 4등: 4개 번호 일치 / 50,000원
   - 5등: 3개 번호 일치 / 5,000원
 - 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력한다


## 📜 기능 목록 정리

### 1. 입력 처리
- [x] 로또 구입 금액을 입력 받는다.
- [x] 당첨 번호를 입력 받는다. 
- [x] 보너스 번호를 입력 받는다.

### 2. 로또 발행
- [x] 입력 받은 구입 금액에 해당하는 로또 수량을 계산한다.
- [x] 1~45 범위의 중복되지 않는 6개의 숫자를 뽑는다.
  - [X] 계산된 로또 수량 만큼 반복한다.
  - [x] 뽑힌 로또 번호를 오름차순으로 정렬한다.

### 3. 당첨 추첨
- [x] 발행된 로또와 입력 받은 당첨 번호를 비교해 당첨 여부를 확인한다.
- [x] 5개 일치 시, 보너스 볼 일치 여부를 확인한다.

### 4. 수익률 계산
- [ ] 총 당첨 금액을 계산한다.
- [ ] 로또를 구입한 금액과, 총 당첨 금액을 통해 수익률을 계산한다.

### 5. 출력 처리
- [ ] 발행한 로또 수량 및 번호를 출력한다.
- [ ] 당첨 내역을 출력한다.
- [ ] 수익률을 출력한다.
- [ ] 예외 상황 문구를 출력한다.

### 6. 검증
- [x] 입력 받은 구입 금액이 1,000원으로 나누어 떨어지는지 검증한다. 만약, 나누어 떨어지지 않는다면 예외를 발생시킨다.
- [x] 입력 받은 당첨 번호가 중복되지 않는 6개의 숫자인지 검증한다. 만약, 중복되거나 6개의 숫자가 아니라면 예외를 발생시킨다.
- [x] 입력 받은 구입 금액 또는 당첨 번호가 숫자인지 검증한다. 만약, 숫자가 아니라면 예외를 발생시킨다.
- [ ] 입력 받은 보너스 번호가 당첨 번호와 다른 번호인지 검증한다. 만약, 당첨 번호와 같은 숫자라면 예외를 발생시킨다.
- [x] 입력 받은 구입 금액, 당첨 번호 그리고 보너스 번호가 양수인지 검증한다. 만약, 0 또는 음수라면 예외를 발생시킨다.
- [x] 입력 받은 당첨 번호와 보너스 번호가 1~45 사이의 숫자인지 검증한다. 만약, 1~45 사이의 숫자가 아니라면 예외를 발생시킨다.

### 7. 반복 입력 처리
- [ ] 잘못된 입력이 들어 왔을 때 예외 메시지 출력 후 그 부분부터 입력을 다시 받도록 한다.

### 8. 리팩토링 및 테스트 코드
- [ ] 관련 함수를 묶어 클래스를 만들고, 객체들이 협력하여 하나의 큰 기능을 수행한다.
- [ ] JUnit 5와 AssertJ를 통해 클래스와 함수에 대한 단위 테스트를 진행한다.
- [ ] 인덴트는 3이 넘지 않도록 한다.
- [ ] 3항 연산자를 쓰지 않는다.
- [ ] 메서드의 길이가 15라인을 넘어가지 않도록 한다.
- [ ] else 예약어를 쓰지 않는다.  * switch/case도 허용하지 않는다.
- [ ] Enum을 적용한다.