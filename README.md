# java-lotto-precourse

## 핵심 기능

**입력 금액에 따라 로또를 구매하고 구매한 로또와 입력한 당첨 번호, 보너스번호를 비교하여 당첨 통계를 제공한다.**

## 기능 구현 목록

### 구입 금액 입력

- [x] ``구입금액을 입력해 주세요.`` 메세지를 출력하고 구입 금액을 입력 받습니다.
    - [x] 구입 금액은 1,000원 단위로 입력 가능합니다.
      - ``[ERROR] 구입 금액은 1,000원 단위로 입력 가능합니다.``
    - [x] 입력 받은 구입 금액이 1,000원보다 작은 경우 예외 처리합니다.
      - ``[ERROR] 구입 가능 최소 금액은 1,000원 입니다.``
    - [x] 입력 받은 구입 금액이 숫자가 아닌 경우 예외 처리합니다.
      - ``[ERROR] 구입 금액은 숫자만 입력 가능합니다.``
    - [x] 입력 받은 구입 금액이 비어 있는 경우 예외 처리합니다.
      - ``[ERROR] 구입 금액이 빈 값입니다.``
    - [x] 잘못 된 값을 입력 받은 경우 IllegalArgumentException를 발생시키고, 에러 메세지 출력 후 구입 금액을 다시 입력 받습니다.


### 로또 구매

- [x] 로또 1장의 가격은 1,000원이며 구입 금액에 해당하는 만큼 로또를 발행합니다.
    - [x] 로또 번호는 랜덤으로 발행합니다.
    - [x] 로또 번호가 1 ~ 45의 범위에 속하지 않는 경우 예외 처리합니다.
      - ``[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.``
    - [x] 로또 번호에 중복된 숫자가 존재하는 경우 예외 처리합니다.
      - ``[ERROR] 로또 번호는 중복되지 않아야 합니다.``
    - [x] 로또 번호의 개수가 6개가 넘어가면 예외 처리합니다.
      - ``[ERROR] 로또 번호 개수는 6개입니다.``

### 구입한 로또 출력

- [x] 구매한 로또 개수를 출력합니다.
- [x] 구매한 로또의 번호를 출력합니다.
- [x] 각 로또 번호 별 구분자는 ","을 사용하며, 로또는 중괄호로 감싸 출력합니다.
- ex)
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

### 당첨 번호 입력

- [ ] ``당첨 번호를 입력해 주세요.`` 메세지를 출력하고 당첨 번호를 입력 받습니다.
    - [ ] 입력 받은 당첨 번호가 빈 값인 경우 예외 처리합니다.
      - ``[ERROR] 당첨 번호가 빈 값입니다.``
    - [ ] 입력 받은 당첨 번호가 숫자가 아닌 경우 예외 처리합니다.
      - ``[ERROR] 당첨 번호는 숫자만 입력 가능합니다.``
    - [ ] 입력 받은 당첨 번호가 1 ~ 45의 범위에 속하지 않는 경우 예외 처리합니다.
      - ``[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.`` 
    - [ ] 입력 받은 당첨 번호에 중복된 숫자가 존재하는 경우 예외 처리합니다.
      - ``[ERROR] 로또 번호는 중복되지 않아야 합니다.`` 
    - [ ] 입력 받은 당첨 번호 개수가 6개가 아닌 경우 예외 처리합니다.
      - ``[ERROR] 로또 번호는 6개여야 합니다.``
    - [ ] 각 숫자 별 구분자는 ","를 입력합니다.
    - [ ] 잘못 된 값을 입력 받은 경우 IllegalArgumentException를 발생시키고, 에러 메세지 출력 후 당첨 번호를 다시 입력 받습니다.

### 보너스 번호 입력

- [ ] ``보너스 번호를 입력해 주세요.`` 메세지를 출력하고 보너스 번호를 입력 받습니다.
    - [ ] 입력 받은 보너스 번호가 빈 값인 경우 예외 처리합니다.
      - ``[ERROR] 보너스 번호가 빈 값입니다.``
    - [ ] 입력 받은 보너스 번호가 숫자가 아닌 경우 예외 처리합니다.
      - ``[ERROR] 보너스 번호는 숫자만 입력 가능합니다.``
    - [ ] 입력 받은 보너스 번호가 1~45의 범위에 속하지 않는 경우 예외 처리합니다.
      - ``[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.``
    - [ ] 입력 받은 보너스 번호가 당첨 번호와 중복되는 경우 예외 처리합니다.
      - ``[ERROR] 보너스 번호는 당첨 번호와 중복 되지 않는 숫자여야 합니다.``
    - [ ] 잘못 된 값을 입력 받은 경우 IllegalArgumentException를 발생시키고, 에러 메세지 출력 후 보너스 번호를 다시 입력 받습니다.

### 로또 추첨

- [ ] 당첨 번호와 보너스 번호를 기준으로 구매한 로또 티켓의 당첨 결과를 확인합니다.
    - 1등: 6개 번호 일치
    - 2등: 5개 번호 + 보너스 번호 일치
    - 3등: 5개 번호 일치
    - 4등: 4개 번호 일치
    - 5등: 3개 번호 일치

### 수익률 계산

- [ ] 당첨 결과에 따른 총 수익률을 계산합니다.
    - 1등: 2,000,000,000원
    - 2등: 30,000,000원
    - 3등: 1,500,000원
    - 4등: 50,000원
    - 5등: 5,000원
- [ ] 수익률은 소수점 둘째 자리에서 반올림합니다. (ex. 100.0%, 51.5%, 1,000,000.0%)

### 통계 출력

- [ ] 당첨 통계를 출력합니다.
- ex
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