# java-lotto-precourse
## 프로그램 설명
입력한 금액에 따라 로또 개수를 산출하고, 개수에 맞춰 로또 번호를 생성해주는 프로그램

## 기능 요구 사항

### 1. 입력 처리

- **기능**: 사용자로부터 **로또 구입 금액**을 입력받는다.1,000원 단위로 입력 받을 수 있다.
    - **입력 형식**:
  ```
  14000
  ```
- **기능**: 사용자로부터 **당첨 번호**를 입력받는다. 쉼표(,)를 기준으로 구분한다.
    - **입력 형식**:
  ```
  1,2,3,4,5,6
  ```
- **기능**: 사용자로부터 **보너스 번호**를 입력받는다.
  - **입력 형식**:
  ```
  1,2,3,4,5,6
  ```  

### 2. 주요 로직 구현
- **기능**: **로또 구입 금액**/1000개의 로또를 생성한다.
    - **조건**: 개수 각각 발행  
    중복되지 않는 6개의 숫자를 뽑아 저장한다.
- **기능**: 로또 당첨 여부를 확인해 저장한다.
    ```
    1등: 6개 번호 일치 / 2,000,000,000원
    2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    3등: 5개 번호 일치 / 1,500,000원
    4등: 4개 번호 일치 / 50,000원
    5등: 3개 번호 일치 / 5,000원
    ```
- **기능**: 수익률을 계산해 저장한다.  
  총 당첨 금액/로또 구입 금액 에 대해 소숫점 둘째 자리에서 반올림한다.

### 3. 예외 처리

- **기능**: 잘못된 입력 처리
    - **처리방식**: `IllegalArgumentException`발생 후 해당 입력을 다시 받는다.

### 5. 테스트

- **정상 케이스**: ("8000", "1,2,3,4,5,6", "7") => 
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
- 예외
    - 로또 구입 금액 입력시:
        - 숫자가 아닌 값=>`IllegalArgumentException`
        - 공백,`null`=>`IllegalArgumentException`
        - 1000으로 나누어지지 않는 값=>`IllegalArgumentException`
    - 당첨 번호 입력시:
        - ,를 제외하고 숫자가 입력되지 않은 경우   =>`IllegalArgumentException`
        - 공백,`null`=>`IllegalArgumentException`
        - 번호 개수가 6개가 아닌경우=>`IllegalArgumentException`
        - ','만 입력된 경우=>`IllegalArgumentException`
        - 각 숫자가 1~45 범위를 벗어나는 경우=>`IllegalArgumentException`
    - 보너스 번호 입력시:
        - 숫자가 아닌 값
        - 당첨 번호와 중복된 값
        - `1~45` 범위를 벗어나는 값