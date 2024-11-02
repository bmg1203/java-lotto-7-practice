### 📄 기능 명세서
---

### 📋 기능 목록

#### 1. 로또 구입 금액 입력

- [x] **사용자에게 로또 구입 금액을 입력 받는다**
    - 사용자에게 로또 구입 금액을 1,000원 단위로 입력받습니다.
    - 입력 값이 조건에 맞지 않으면 예외 메시지를 출력하고 재입력을 요청합니다.

- **입력 형식**
    - [ ] 숫자만 입력 가능, 1,000원 단위로 나누어 떨어져야 함.

- **예외 처리**
    - [x] 1,000원 단위가 아닌 금액 입력 시:
        - `[ERROR] 로또 구입 금액은 1,000원 단위로 입력해야 합니다.` 메시지 출력 후 재입력 요청
    - [x] 1,000원 미만인 금액 입력 시:
        - `[ERROR] 최소 구입 금액은 1,000원 입니다.` 메시지 출력 후 재입력 요청
    - [ ] 숫자 외 문자가 포함된 경우:
        - `[ERROR] 금액 입력에는 숫자만 입력할 수 있습니다.` 메시지 출력 후 재입력 요청
    - [ ] 빈 값이 입력된 경우:
        - `[ERROR] 금액을 입력해 주세요.` 메시지 출력 후 재입력 요청

<br/>

#### 2. 당첨 번호 입력

- [x] **사용자에게 당첨 번호를 입력 받는다**
    - 사용자에게 당첨 번호를 쉼표(,)로 구분하여 입력받습니다.
    - 숫자가 아닌 문자, 중복 숫자, 범위를 벗어난 숫자 입력 시 예외를 발생시키고 다시 입력을 받습니다.

- **입력 형식**
    - [ ] 쉼표(,)로 구분된 6개의 숫자, 각 숫자는 1~45 범위 내.

- **예외 처리**
    - [ ] 숫자 외 문자나 특수기호가 포함된 경우:
        - `[ERROR] 당첨 번호는 숫자만 입력해야 합니다.` 메시지 출력 후 재입력 요청
    - [ ] 숫자가 1~45 범위를 벗어난 경우:
        - `[ERROR] 당첨 번호는 1부터 45 사이의 숫자로 입력해야 합니다.` 메시지 출력 후 재입력 요청
    - [ ] 6개의 숫자보다 적거나 많은 경우:
        - `[ERROR] 당첨 번호는 정확히 6개의 숫자를 입력해야 합니다.` 메시지 출력 후 재입력 요청
    - [ ] 중복된 숫자가 입력된 경우:
        - `[ERROR] 당첨 번호에 중복된 숫자가 포함될 수 없습니다.` 메시지 출력 후 재입력 요청
    - [ ] 빈 값이나 공백이 포함된 경우:
        - `[ERROR] 당첨 번호를 입력해 주세요.` 메시지 출력 후 재입력 요청
    - [ ] 쉼표(,) 위치가 잘못된 경우 (예: ",1,2,3" 또는 "1,2,3,4,5,"):
        - `[ERROR] 당첨 번호는 쉼표로만 구분해야 합니다.` 메시지 출력 후 재입력 요청

<br/>

#### 3. 보너스 번호 입력

- [x] **사용자에게 보너스 번호를 입력 받는다**
    - 사용자에게 보너스 번호를 입력받습니다.
    - 범위를 벗어나거나 당첨 번호와 중복된 경우 예외 메시지를 출력하고 다시 입력받습니다.

- **입력 형식**
    - [ ] 1~45 범위 내의 숫자 1개.

- **예외 처리**
    - [ ] 1~45 범위 외 숫자가 입력된 경우:
        - `[ERROR] 보너스 번호는 1부터 45 사이의 숫자로 입력해야 합니다.` 메시지 출력 후 재입력 요청
    - [ ] 보너스 번호가 당첨 번호와 중복된 경우:
        - `[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.` 메시지 출력 후 재입력 요청

<br/>

#### 출력 관련 기능

- [ ] **구매한 로또 번호 출력**: 사용자가 구매한 로또 번호를 오름차순으로 출력합니다.
- [ ] **당첨 통계 출력**: 사용자의 당첨 통계를 등급별로 출력합니다.
- [ ] **수익률 출력**: 사용자의 수익률을 계산하여 출력합니다.
- [x] **예외 메세지 출력**: 예외 발생 시 에러 문구를 출력합니다.

<br/>

#### 핵심 기능

- [x] **로또 번호 생성 기능**: 1에서 45 사이의 중복되지 않은 정수 6개 반환합니다.
- [x] **로또 발급 기능**: 사용자가 구입한 금액만큼 로또를 생성합니다.
- [ ] **번호 정렬 기능**: 생성된 로또 번호를 오름차순으로 정렬하여 반환합니다.
- [ ] **구매 단위별 로또 번호 생성 기능**: 입력된 구입 금액에 따라 로또 번호를 생성합니다.
- [ ] **로또 번호 비교 기능**: 생성된 로또 번호와 당첨 번호를 비교하여 결과를 반환합니다.
- [ ] **등급 반환 기능**: 당첨 번호와 비교 후 등급을 계산해 반환합니다.
- [ ] **수익률 반환 기능**: 사용자의 수익률을 계산해 반환합니다.
- [ ] **당첨 등수 개수 반환 기능**: 사용자의 당첨 등급별 개수를 반환합니다.

---

#### 📄 시나리오

| 단계 | 설명                                                |
|----|---------------------------------------------------|
| 1  | **사용자가 로또샵에 방문하여 로또를 구매한다.**                      |
| 2  | **사용자는 구입할 금액을 입력한다.** 예: 5,000원                  |
| 3  | **시스템은 사용자가 입력한 금액을 바탕으로 로또를 발행한다.** 예: 5장의 로또 발행 |
| 4  | **시스템은 당첨 번호와 보너스 번호를 입력받는다.**                    |
| 5  | **시스템은 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역을 출력한다.** |
| 6  | **시스템은 전체 당첨 내역과 수익률을 출력한다.**                     |
