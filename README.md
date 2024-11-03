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
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
- `Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException 등과 같은 명확한 유형을 처리한다.


## 입출력 요구 사항

### 입력

- 로또 구입 금액을 입력 받는다. 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.
````
14000
````
- 당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.
````
1,2,3,4,5,6
````
- 보너스 번호를 입력 받는다.
````
7
````

### 출력

- 발행한 로또 수량 및 번호를 출력한다. 로또 번호는 오름차순으로 정렬하여 보여준다.

````
8개를 구매했습니다.
[8, 21, 23, 41, 42, 43] 
[3, 5, 11, 16, 32, 38] 
[7, 11, 16, 35, 36, 44] 
[1, 8, 11, 31, 41, 42] 
[13, 14, 16, 38, 42, 45] 
[7, 11, 30, 40, 42, 43] 
[2, 13, 22, 32, 38, 45] 
[1, 3, 5, 14, 22, 45]
````

- 당첨 내역을 출력한다.
````
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
````
- 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)
````
총 수익률은 62.5%입니다.
````
- 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.
````
[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.
````

### 실행 결과 예시

````
구입금액을 입력해 주세요.
8000

8개를 구매했습니다.
[8, 21, 23, 41, 42, 43] 
[3, 5, 11, 16, 32, 38] 
[7, 11, 16, 35, 36, 44] 
[1, 8, 11, 31, 41, 42] 
[13, 14, 16, 38, 42, 45] 
[7, 11, 30, 40, 42, 43] 
[2, 13, 22, 32, 38, 45] 
[1, 3, 5, 14, 22, 45]

당첨 번호를 입력해 주세요.
1,2,3,4,5,6

보너스 번호를 입력해 주세요.
7

당첨 통계
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다.
````

## 기능 구현 목록
- getUserInput 
  - 문자열을 입력받는다. 
- isNumeric 
  - 숫자 문자열인지 확인한다.
    - 양수 판별은 숫자인지 확인하며 진행된다.
- isParsableAsInteger
  - Integer형으로 형변환이 가능한지 확인한다.
- isLessThanFirstPrizeAmount
  - 로또 구입 금액이 1등 당첨금보다 적은 액수인지 확인한다.
    - 당첨금보다 많이 로또를 구매할 수 없게 1등 당첨금을 최대 구매 가능 액수로 제한했다.
- isDivisibleBy1000 
  - 1000으로 나누어 떨어지는 숫자인지 확인한다.
- getLottoPurchaseAmount
  - 구매할 로또 수량을 구한다.
- setLottoPurchaseAmount
  - 구매할 로또 수량을 저장한다.
- displayLottoPurchaseAmount
  - 구매한 로또 수량을 출력한다.
- makeLottoNumber
  - 구매 가능한 로또 수량만큼 Lotto 객체를 생성하여 로또번호를 저장한다.
- loopLottos
  - 구매한 로또들을 순회한다.
- getRandomLottoNumber
  - 1에서 45 사이의 중복되지 않은 정수 6개를 반환한다.
- sortAscending
  - Lotto 번호를 오름차순 정렬한다.
- isAscendingNumber
  - Lotto 번호가 오름차순 되었는지 확인한다.
- displayLottoNumbers
  - Lotto 번호를 출력한다.
- getWinningInput
  - 당첨 번호를 입력받는다.
- runValidString
  - 당첨 번호가 올바른 문자열이 아니라면 재입력을 요청한다.
- isValidString
  - 숫자와 쉼표로 이루어진 문자열인지 확인한다.
- isSixNumber
  - 쉼표를 기준으로 잘려진 문자열의 갯수가 6개인지 확인한다.
- addWinningNumber
  - HashSet에 당첨 번호 추가한다.
- getBonusInput
  - 보너스 번호를 입력받는다.
- isLottoNumber
  - 1에서 45 사이의 숫자인지 확인한다.
- containsWinningNumber
  - Lotto에 HashSet과 동일한 값이 있는지 확인한다.
- removeWinningNumber
  - Lotto에서 동일한 값 제거한다.
- containsBonusNumber
  - Lotto에 보너스 번호와 동일한 값이 있는지 확인한다.
- checkBonusNumber
  - 보너스 번호 상태를 변경한다.

## 로직

1. 로또 구입 금액을 입력받는다.
2. 올바른 입력인지 확인한다.
    - 숫자로만 이루어진 문자열이다.
    - 올바른 문자열인 경우
        - 1000으로 나누어 떨어짐
    - 올바른 문자열이 아닌 경우
        - 1000으로 나누어 떨어지지 않음
        - 숫자가 아닌 문자가 포함된 문자열
    - 올바른 문자열이 아니라면, `IllegalArgumentException`을 발생시키고 "[ERROR]"로 시작하는 에러 메시지를 출력 후, 다시 입력받는다.
3. 로또를 구매한다.
4. 발행한 로또 수량 및 번호를 출력한다.
5. 당첨 번호를 입력 받는다.
6. 보너스 번호를 입력 받는다.
7. 당첨 내역을 출력한다.
8. 수익률을 출력한다.
    - 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)
9. 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.

## 순서도

<img width = "450" alt = "image" src="./image/flowchart(total).jpg">

## 파일 구조

````
````