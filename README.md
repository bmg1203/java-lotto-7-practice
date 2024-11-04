# java-lotto-precourse

이 앱은 로또 티켓 구매 및 당첨 결과를 시뮬레이션하며, 사용자 입력을 통해 로또를 발행하고 당첨 결과와 수익률을 계산합니다.
사용자의 입력이 올바르지 않을 경우 IllegalArgumentException 오류와 함께 [ERROR]로 시작하는 오류 메세지를 출력하며 그 부분부터 입력을 다시 받는다.

## 기능 목록

### 1. 구매 금액 검증
- **구매 금액 검증**: 사용자는 1,000원 단위의 금액을 입력해야 하며, 1,000으로 나누어 떨어지지 않는 경우 `IllegalArgumentException`과 함께 오류 메시지를 출력합니다.

### 2. 로또 티켓 생성
- **구매 금액에 따라 로또 티켓 생성**: 입력된 구매 금액에 따라 티켓을 생성하며, 티켓당 가격은 1,000원입니다.
- **티켓 번호 생성**: 각 티켓에는 1~45 사이의 중복되지 않는 6개의 숫자가 포함됩니다.
- **티켓 번호 정렬**: 생성된 각 티켓의 번호를 오름차순으로 정렬하여 보여줍니다.

### 3. 당첨 번호 및 보너스 번호 입력
- 사용자에게 6개의 당첨 번호(쉼표로 구분)와 1개의 보너스 번호를 입력받습니다.
- 입력 값이 1~45 범위 내에 있으며 중복되지 않도록 검증합니다.

### 4. 당첨 결과 계산 및 출력
- 각 티켓을 당첨 번호 및 보너스 번호와 비교합니다.
- 당첨 기준에 따라 아래와 같은 등수 및 상금을 계산하여 출력합니다:
    - **1등**: 6개 번호 일치 (2,000,000,000원)
    - **2등**: 5개 번호 + 보너스 번호 일치 (30,000,000원)
    - **3등**: 5개 번호 일치 (1,500,000원)
    - **4등**: 4개 번호 일치 (50,000원)
    - **5등**: 3개 번호 일치 (5,000원)

### 5. 수익률 계산 및 출력
- 당첨 내역을 바탕으로 총 당첨 금액을 계산합니다.
- 수익률을 소수점 첫째 자리에서 반올림하여 백분율로 출력합니다.

### 6. 오류 핸들링 및 재입력
- 사용자가 올바르지 않은 값을 입력했을 때 IllegalArgumentException 오류와 함께 오류 메세지를 출력합니다.
- 오류 메세지 출력 후 그 부분부터 다시 입력받습니다.

## 사용 예시

### 입력
```plaintext
구입금액을 입력해 주세요.
8000

당첨 번호를 입력해 주세요.
1,2,3,4,5,6

보너스 번호를 입력해 주세요.
7
```

### 출력
```plaintext
8개를 구매했습니다.
[8, 21, 23, 41, 42, 43] 
[3, 5, 11, 16, 32, 38] 
[7, 11, 16, 35, 36, 44] 
[1, 8, 11, 31, 41, 42] 
[13, 14, 16, 38, 42, 45] 
[7, 11, 30, 40, 42, 43] 
[2, 13, 22, 32, 38, 45] 
[1, 3, 5, 14, 22, 45]

당첨 통계
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다.
```