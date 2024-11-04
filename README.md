# 🎲 로또 게임 기능 목록

## 📋 기능 목록

### 1. 로또 구입 금액 입력
- 사용자가 로또 구입 금액을 입력합니다.
- 입력 금액은 **1,000원 단위**로 나누어 떨어져야 하며, 그렇지 않으면 예외가 발생합니다.
- **입력이 null이거나 공백인 경우** 예외를 발생시킵니다.

### 2. 로또 발행
- 구입 금액에 따라 **발행할 로또 개수를 계산**하고, 각각의 로또 번호를 발행합니다.
- 로또 번호는 **1에서 45 사이**의 중복되지 않는 **6개의 숫자**로 구성되며, 오름차순으로 정렬하여 출력합니다.

### 3. 당첨 번호 입력
- 당첨 번호 6개와 보너스 번호 1개를 입력받습니다.
- **공백이 포함된 입력**(예: `1, 2, 3, 4, 5, 6`)의 경우, **공백을 제거**하고 처리합니다.
- 당첨 번호는 쉼표(,)로 구분하며, **중복되지 않아야 합니다**.
- 입력이 **null이거나 공백**인 경우 예외를 발생시킵니다.

### 4. 당첨 번호 및 보너스 번호 유효성 검사
- 입력된 번호가 **1에서 45 사이**의 숫자인지 확인합니다.
- 중복된 번호가 없는지 검사하여 유효하지 않은 경우 예외를 발생시킵니다.
- **공백이 포함된 입력**을 처리하기 위해 **공백을 제거**하고 검증합니다.
- 입력이 **null이거나 공백**인 경우 예외를 발생시킵니다.

### 5. 당첨 결과 확인
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 **각 등수에 맞는 당첨 횟수**를 계산합니다.
- 당첨 기준:
   - **1등**: 6개 번호 일치 / 2,000,000,000원
   - **2등**: 5개 번호 + 보너스 번호 일치 / 30,000,000원
   - **3등**: 5개 번호 일치 / 1,500,000원
   - **4등**: 4개 번호 일치 / 50,000원
   - **5등**: 3개 번호 일치 / 5,000원

### 6. 수익률 계산 및 출력
- 당첨 내역에 따른 **총 수익금**을 계산하고, 사용자가 지불한 **구입 금액을 기준으로 수익률**을 계산하여 출력합니다.
- 수익률은 **소수점 둘째 자리에서 반올림**하여 표시합니다.

### 7. 예외 처리
- 잘못된 값을 입력하면 `IllegalArgumentException`을 발생시키고, **"[ERROR]"로 시작하는 에러 메시지**를 출력합니다. 또한 에러가 발생한 부분부터 입력을 다시 받습니다.
- `IllegalArgumentException`, `IllegalStateException` 등의 예외 유형을 사용하여 입력 오류를 처리합니다.

---

## 📥 입출력 요구 사항

### ➡️ 입력
- **로또 구입 금액**: 구입 금액은 1,000원 단위로 입력하며, 나누어 떨어지지 않으면 예외가 발생합니다.
- **당첨 번호**: 쉼표(,)로 구분하여 입력하며, 중복되지 않아야 합니다.
- **보너스 번호**: 당첨 번호와 **겹치지 않아야 합니다**.
- **공백이 포함된 입력**을 처리하기 위해 **공백을 제거**하고 검증합니다.

### ⬅️ 출력

1. **발행한 로또 번호 출력**
   - 구매한 로또 수량과 각 로또 번호를 출력합니다.
   - 예시:
     ```
     8개를 구매했습니다.
     [8, 21, 23, 41, 42, 43]
     [3, 5, 11, 16, 32, 38]
     ...
     ```

2. **당첨 통계 출력**
   - 각 등수에 맞는 일치 수와 횟수를 출력하며, 총 수익률을 소수점 둘째 자리까지 표시합니다.
   - 예시:
     ```
     당첨 통계
     ---
     3개 일치 (5,000원) - 1개
     4개 일치 (50,000원) - 0개
     5개 일치 (1,500,000원) - 0개
     5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
     6개 일치 (2,000,000,000원) - 0개
     총 수익률은 62.5%입니다.
     ```

3. **에러 메시지 출력**
   - 잘못된 입력에 대한 에러 메시지를 **"[ERROR]"로 시작**하여 출력합니다.
   - 예시: `[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.`

---

## ⚠️ 예외 상황

1. **구입 금액 관련**
   - **구입 금액이 null이거나 공백인 경우**:
      - 메시지: `[ERROR] 입력 값은 비어 있을 수 없습니다.`
   - **구입 금액이 숫자가 아닐 경우**:
      - 메시지: `[ERROR] 구입 금액은 숫자만 포함되어야 하며, 공백이 포함될 수 없습니다.`
   - **구입 금액이 0 이하인 경우**:
      - 메시지: `[ERROR] 구입 금액은 0보다 커야 합니다.`
   - **구입 금액이 1,000원 단위로 나누어 떨어지지 않는 경우**:
      - 메시지: `[ERROR] 구입 금액은 1,000원 단위여야 합니다.`

2. **당첨 번호 관련**
   - **당첨 번호가 null이거나 공백인 경우**:
      - 메시지: `[ERROR] 입력 값은 비어 있을 수 없습니다.`
   - **당첨 번호 입력 형식이 잘못된 경우 (예: 쉼표 또는 숫자 이외의 문자가 포함된 경우)**:
      - 메시지: `[ERROR] 입력 값은 숫자와 쉼표로만 이루어져야 합니다.`
   - **당첨 번호 입력이 연속된 쉼표를 포함하거나 시작/끝에 쉼표가 있는 경우**:
      - 메시지: `[ERROR] 입력 형식이 잘못되었습니다. 예) 1, 2, 3, 4, 5, 6`
   - **당첨 번호가 6개가 아닌 경우**:
      - 메시지: `[ERROR] 로또 번호는 6개여야 합니다.`
   - **당첨 번호가 1~45 범위를 벗어나는 경우**:
      - 메시지: `[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.`
   - **당첨 번호에 중복된 번호가 있는 경우**:
      - 메시지: `[ERROR] 로또 번호는 중복될 수 없습니다.`

3. **보너스 번호 관련**
   - **보너스 번호가 null이거나 공백인 경우**:
      - 메시지: `[ERROR] 입력 값은 비어 있을 수 없습니다.`
   - **보너스 번호가 숫자가 아닐 경우**:
      - 메시지: `[ERROR] 보너스 번호는 숫자만 포함되어야 합니다.`
   - **보너스 번호가 1~45 범위를 벗어나는 경우**:
      - 메시지: `[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.`
   - **보너스 번호가 당첨 번호와 중복되는 경우**:
      - 메시지: `[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.`

---

## 🧪 테스트 코드
- JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.