# java-lotto-precourse

## 기능 요구 사항
간단한 로또 발매기를 구현한다.

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
  - Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.


## 기능 목록

### 1. 로또 구입 금액 입력
- 사용자에게 구입할 로또 금액을 입력받는다.
- 예외상황 :
  - 빈 칸일시 예외를 출력하고 다시 입력받는다.
- **실행 예시:**
  ```
  구입금액을 입력해 주세요. 8000
  ```

### 2. 구입 금액 유효성 검증
- 구입 금액이 1,000원 단위인지 검증한다.
    - 구입 금액이 1,000원 미만이거나 1,000원 단위로 나누어 떨어지지 않는 경우 예외를 발생시킨다.
    - 예외 발생 시 `[ERROR] 구입 금액은 1,000원 단위여야 합니다.` 메시지를 출력하고 다시 입력을 받는다.

### 3. 로또 발행
- 구입 금액에 해당하는 개수만큼 로또를 발행한다. (로또 1장당 1,000원)
- 각 로또 번호는 다음 기준을 따른다:
    - 1~45 사이의 숫자 중 중복되지 않는 6개의 숫자를 생성한다.
    - `Randoms.pickUniqueNumbersInRange(1, 45, 6)` 메서드를 사용한다.
- 예외 상황:
    - 생성된 숫자가 중복되거나 범위를 벗어날 경우 예외를 발생시킨다.

### 4. 로또 번호 출력
- 구매한 로또 개수와 각 로또의 번호를 오름차순으로 정렬하여 출력한다.
- **예시:**
    ```
    3개를 구매했습니다. 
    [8, 21, 23, 41, 42, 43] 
    [1, 3, 5, 14, 22, 45] 
    [7, 11, 16, 35, 36, 44]
    ```

### 5. 당첨 번호 입력
- 당첨 번호 6개를 콤마(,)로 구분하여 입력받는다.
- 예외 상황:
- 6개의 숫자 이외의 값이 입력되거나 빈칸이 입력될 경우 예외를 발생시킨다.
- 중복된 번호가 포함된 경우 예외를 발생시킨다.
- 숫자가 1~45 범위를 벗어나는 경우 예외를 발생시킨다.
- **실행 예시:**
  ```
  당첨 번호를 입력해 주세요. 
  1,2,3,4,5,6
  ```

### 6. 보너스 번호 입력
- 보너스 번호를 입력받는다.
- 예외 상황:
- 숫자가 아닌 값이 입력된 경우 예외를 발생시킨다.
- 숫자가 1~45 범위를 벗어나는 경우 예외를 발생시킨다.
- 보너스 번호가 당첨 번호와 중복될 경우 예외를 발생시킨다.
- **실행 예시:**
  ```
  보너스 번호를 입력해 주세요. 
  7
  ```

### 7. 당첨 내역 확인
- 각 로또 번호에 대해 당첨 번호와 일치하는 개수를 확인한다.
- 일치하는 개수에 따라 1등부터 5등까지 등수를 판별한다.
- **예시:**
    - 1등: 6개 번호 일치
    - 2등: 5개 번호 + 보너스 번호 일치
    - 3등: 5개 번호 일치
    - 4등: 4개 번호 일치
    - 5등: 3개 번호 일치
- 예외 상황:
- 일치 개수가 6개를 초과하거나 잘못 계산된 경우 예외를 발생시킨다.

### 8. 수익률 계산
- 로또 발행 개수와 당첨 금액을 기반으로 수익률을 계산한다.
- 수익률 계산: `총 수익금 / 구입 금액`
- 결과는 소수점 둘째 자리에서 반올림한다.

### 9. 당첨 결과 및 수익률 출력
- 각 로또 번호별 당첨 결과와 최종 수익률을 출력한다.
- **예시:**
  ```
  당첨 통계
  ---
  3개 일치 (5,000원) - 1개
  4개 일치 (50,000원) - 0개
  5개 일치 (1,500,000원) - 0개
  5개 일치, 보너스 일치 (30,000,000원) - 0개
  6개 일치 (2,000,000,000원) - 0개
  ```
- 최종 수익률 예시:
  ```
  총 수익률은 62.5%입니다.
  ```

### 10. 잘못된 입력 처리
- 입력값이 잘못되었을 경우 `IllegalArgumentException`을 발생시킨다.
- 예외 발생 시 `[ERROR]`로 시작하는 에러 메시지를 출력하고 해당 입력부터 다시 받는다.
- 명확한 예외 유형(`IllegalArgumentException`, `IllegalStateException` 등)으로 처리하여 예외 상황에 맞는 메시지를 제공한다.
