# 로또

## 구현할 기능 목록

### Domain

- Number
  - 검증 : 1 이상 45 이하 숫자인지 검증
  - 두 숫자가 동일한지 확인하는 기능
- Numbers
  - 검증 : 총 숫자가 6개인지 검증
  - 검증 : 겹치는 숫자가 있는지 검증
  - 특정 숫자가 안에 있는지 확인
  - 곂치는 숫자가 몇 개 있는지 세기
- Lotto
  - 현재 가지고 있는 번호를 반환
- Lotties
  - 검증 : 로또 금액이 1,000원 단위인지 검증
  - 생성 : 로또 금액을 받아 금액에 따라 로또를 만듦
  - 가지고 있는 번호들을 반환
- WinningNumbers
  - 입력 받은 Lotties에 따라 전체 결과 반환
- WinningRank
  - 번호 당첨 개수 & 보너스 당첨 여부에 따라 적당한 랭크 반환

### View

- InputView
  - 구입금액 입력
    - 입력한 내용이 숫자인지 확인
    ```text
    
    구입금액을 입력해 주세요.
    8000
    ```
  - 당첨 번호 입력
    - 입력한 내용이 ','를 기준으로 숫자로 쓰여있는지 확인
    ```text
    
    당첨 번호를 입력해 주세요.
    1,2,3,4,5,6
    ```
  - 보너스 번호 입력
    - 입력한 내용이 숫자인지 확인
    ```text
    
    보너스 번호를 입력해 주세요.
    7
    ```
  - OutputView
    - 구매한 로또 출력
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
    - 당첨 통계 출력
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
    - 에러 출력 기능
    ```text
    [ERROR] 숫자는 1 이상 45이하 이어야 합니다
    ```

### Application

- 전반적인 실행 로직
- 입력 중 예외 발생 시, 재입력 받는 기능
