## 🛠️ 기능 구현 목록

### 🕹️ 로또 컨트롤러: LottoController

- 로또를 실행할 수 있다.
- 회차의 당첨 번호를 입력받을 수 있다.
- 회차의 보너스 번호를 입력받을 수 있다.
  - 수익률은 소수점 둘째 자리에서 반올림한다.

### 🎰 로또 머신: LottoMachine

- 로또를 회당 1000원에 구매할 수 있다.
- 당첨 통계를 반환할 수 있다.

### 🎲 로또: Lotto

- 로또 번호 리스트를 가질 수 있다.
    - 로또 번호는 오름차순으로 저장한다.
- 번호를 비교하고 등수를 알 수 있다. 

### ✍️ 로또 히스토리: LottoHistory

- 로또 리스트를 가질 수 있다.
- 회차의 당첨 번호를 가질 수 있다.

### 📊 로또 통계: LottoStatistic

- 당첨 내역 및 수익률을 계산할 수 있다.

### 💰 로또 등수: (Enum) LottoRank

- 등수에 대한 상금을 가질 수 있다.
- 당첨 번호와 보너스 일치 여부에 해당하는 등수를 반환할 수 있다.

### 🏆 당첨 로또: WinningLotto

- 당첨 번호와 보너스 번호를 가질 수 있다.

### ⌨️ 입력: InputView

- 구입할 금액을 입력받을 수 있다.
    - 입력안내 문구: **구입금액을 입력해 주세요.**
- 6개의 당첨 번호를 입력받을 수 있다.
    - 입력안내 문구: **당첨 번호를 입력해 주세요.**
- 1개의 보너스 번호를 입력받을 수 있다.
    - 입력안내 문구: **보너스 번호를 입력해 주세요.**

### 💻 출력: OutputView

- 발행한 로또 수량 및 번호를 출력할 수 있다.
    - 출력 예시

    ```text
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

- 당첨 내역을 출력할 수 있다.
    - 출력 예시

    ```text
    당첨 통계
    ---
    3개 일치 (5,000원) - 1개
    4개 일치 (50,000원) - 0개
    5개 일치 (1,500,000원) - 0개
    5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
    6개 일치 (2,000,000,000원) - 0개
    총 수익률은 62.5%입니다.
    ```

### 👀 검증: InputValidator

- 구입할 금액 입력 시 검증할 수 있다.
    - 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
        - 정수가 아닌 값이 입력된 경우
        - 1,000원으로 나누어 떨어지지 않을 경우
        - 음수가 입력된 경우
        - 0에서 1,000원 사이의 값이 입력된 경우
- 6개의 당첨 번호 입력 시 검증할 수 있다.
    - 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
        - 1에서 45 사이의 숫자가 아닐 경우
        - `,` 로 구분되지 않을 경우
        - 6개가 입력되지 않을 경우
        - 중복되는 숫자가 입력될 경우
- 1개의 보너스 번호 입력 시 검증할 수 있다.
    - 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
        - 1에서 45 사이의 숫자가 아닐 경우
