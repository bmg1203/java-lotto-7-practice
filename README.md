# java-lotto-precourse

## 🚀 구현할 기능 목록

### 1️⃣ 로또 구입 금액 입력 ⌨️

#### 1-1. 로또 구입 금액 입력

- [x] 로또 구입 금액 입력 안내 메시지를 출력한다.
- [x] 로또 구입 금액을 입력받는다.

#### 1-2. 로또 구입 금액 입력값 초기 검증

- [x] 입력값이 빈 문자열인지 검증한다.
- [x] 구입 금액이 정수인지 검증한다.
- [x] 구입 금액이 양수인지 검증한다.

#### 1-3. 로또 구입 금액 입력값 비즈니스 검증

- [x] 구입 금액이 1,000원 이상인지 검증한다.
- [x] 구입 금액이 1,000원 단위로 나누어 떨어지는지 검증한다.
- [ ] 예외 발생 시, 해당 부분부터 다시 입력받는다. 

#### 1-4. 로또 구입 금액 저장

- [x] 로또 구압 금액을 저장한다.

### 2️⃣ 당첨 번호 입력 ⌨️

#### 2-1. 당첨 번호 입력

- [x] 당첨 번호 입력 안내 메시지를 출력한다.
- [x] 당첨 번호를 입력받는다.

#### 2-2. 당첨 번호 입력값 초기 검증

- [x] 입력값이 빈 문자열이 아닌지 검증한다.

#### 2-3. 당첨 번호를 쉼표(,)를 기준으로 파싱

- [ ] 당첨 번호를 쉼표(,)를 기준으로 파싱한다.

#### 2-4. 당첨 번호 입력값 비즈니스 검증

- [ ] 분리된 각 번호가 정수인지 검증한다.
- [x] 분리된 각 번호가 1부터 45 사이의 숫자인지 검증한다.
- [x] 각 번호가 중복되지 않는지 검증한다.
- [ ] 예외 발생 시, 해당 부분부터 다시 입력받는다.

#### 2-4. 당첨 번호 목록 저장

- [x] 당첨 번호 목록을 저장한다.

### 3️⃣ 보너스 번호 입력 ⌨️

#### 3-1. 보너스 번호 입력

- [x] 보너스 번호 입력 안내 메시지를 출력한다.
- [x] 보너스 번호를 입력받는다.

#### 3-2. 보너스 번호 입력값 초기 검증

- [x] 입력값이 빈 문자열이 아닌지 검증한다.
- [x] 구입 금액이 정수인지 검증한다.
- [x] 구입 금액이 양수인지 검증한다.

#### 3-3. 보너스 번호 입력값 비즈니스 검증

- [ ] 보너스 번호가 1부터 45 사이의 숫자인지 검증한다.
- [ ] 보너스 번호가 당첨 번호와 중복되지 않는지 검증한다.
- [ ] 예외 발생 시, 해당 부분부터 다시 입력받는다.

#### 3-4. 보너스 번호 저장

- [ ] 보너스 번호를 저장한다.

### 4️⃣ 로또 발행 결과 출력 📄

#### 4-1. 발행한 로또 수량 출력

- [x] 로또 구입 금액에서 1,000을 나눈 몫을 계산하여 반환한다.
- [x] 발행한 로또 수량을 출력한다.

#### 4-2. 로또 발행

- [x] 랜덤한 숫자를 6개 뽑는다.
- [x] 뽑힌 숫자들을 하나의 로또로 발행한다.
- [x] 위 과정을 발행한 로또 수량만큼 반복한다.

#### 4-3. 로또 발행 결과 출력

- [x] 발행된 로또를 포맷에 맞게 출력한다.

### 5️⃣ 로또 당첨 내역 출력 🏆

#### 5-1.  로또 당첨 내역 계산

- [ ] 발행한 로또를 순회하면서 사용자가 입력한 당첨 번호와 얼마나 일치하는지 확인한다.
- [ ] 일치한 숫자, 그리고 해당하는 당첨 갯수를 포맷에 맞춰 출력한다.

#### 5-2. 로또 당첨 내역 출력

- [ ] 계산된 당첨 내역을 포맷에 맞게 출력한다.

### 6️⃣ 총 수익률 출력 💵

#### 6-1. 총 수익률 계산

- [ ] 구매 금액을 계산한다.
- [ ] 당첨 금액을 계산한다.
- [ ] 당첨 금액에서 구매 금액을 나눈 값에 100을 곱하여 수익률을 계산한다.

#### 6-2. 총 수익률 출력

- [ ] 계산된 수익률을 포맷에 맞게 출력한다.
