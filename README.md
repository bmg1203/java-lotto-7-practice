# 로또

간단한 로또 발매기를 구현한다.

## 🔥 구현할 기능 목록

---

### 입력
- [ ] 로또 구입 금액 입력
    ```
    구입금액을 입력해 주세요.
    8000
    ```
- [ ] 당첨 번호 입력. 번호는 쉼표(,)를 기준으로 구분
    ```
    당첨 번호를 입력해 주세요.
    1,2,3,4,5,6
    ```
- [ ] 보너스 번호를 입력
    ```
    보너스 번호를 입력해 주세요.
    7
    ```

### 출력
- [ ] 발행한 로또 수량 및 번호 출력. **오름차순 정렬**
    ```
    8개를 구매했습니다.
    [8, 21, 23, 41, 42, 43]
    [3, 5, 11, 16, 32, 38]
    [7, 11, 16, 35, 36, 44]
    [1, 8, 11, 31, 41, 42]
    [13, 14, 16, 38, 42, 45]
    [7, 11, 30, 40, 42, 43]
    [2, 13, 22, 32, 38, 45]
    [1, 3, 5, 14, 22, 45]
    ```

- [ ] 당첨 내역 출력
    ```
    당첨 통계
    ---
    3개 일치 (5,000원) - 1개
    4개 일치 (50,000원) - 0개
    5개 일치 (1,500,000원) - 0개
    5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
    6개 일치 (2,000,000,000원) - 0개
    ```

-[ ] 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)
   ```
   총 수익률은 62.5%입니다.
   ```

---

### 로또
- [ ] 로또 번호가 정상적인 값으로 입력되었는지 검증하는 기능

### 로또 등수
- [ ] 로또 등수를 저장하는 기능
- [ ] 로또 등수를 판단하는 기능

### 구매한 로또
- [ ] 구매한 로또 전체를 저장하는 기능

### 당첨된 로또
- [ ] 당첨된 로또 전체를 저장하는 기능

### 수익
- [ ] 수익률을 계산하는 기능
- [ ] 계산된 수익률을 반환하는 기능

### 보너스 번호
- [ ] 보너스 번호를 저장하는 기능

---
### 🚫 예외 처리
- 모든 에러 문구는 에러 문구는 `[ERROR]`로 시작해야 한다.
- `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리한다.

#### 로또 구입 금액 입력
- [ ] 1,000원 단위가 아닌 경우 예외 처리
  - `IllegalArgumentException`
- [ ] 문자가 입력된 경우 예외 처리
  - `NumberFormatException`

#### 당첨 번호 입력
- [ ] 입력된 숫자가 6개가 아닐 경우 예외 처리
    - `IllegalArgumentException`
- [ ] 입력된 숫자 중 0 혹은 음수가 포함된 경우 예외 처리
    - `IllegalArgumentException`
- [ ] 문자가 입력된 경우 예외 처리
    - `NumberFormatException`
- [ ] 1 ~ 45 사이의 숫자가 아닌 경우 예외 처리
    - 커스텀 `LottoNumberOutOfRangeException`

#### 보너스 번호 입력
- [ ] 입력된 숫자 중 0 혹은 음수가 포함된 경우 예외 처리
  - `IllegalArgumentException`
- [ ] 문자가 입력된 경우 예외 처리
  - `NumberFormatException`
- [ ] 1 ~ 45 사이의 숫자가 아닌 경우 예외 처리
  - 커스텀 `LottoNumberOutOfRangeException`


---
### 라이브러리
```Java
// 예시
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

String value = Console.readLine(IllegalArgumentException);

List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
```