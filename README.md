# java-lotto-precourse

## 미션 3주차 - 로또

**간단한 로또 발매기를 구현한다.**

## 기능 요구사항
1. 로또 번호의 숫자 범위는 1~45까지이다.

2. 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.

3. 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.

4. 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.

5. 1등: 6개 번호 일치 / 2,000,000,000원

6. 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원

7. 3등: 5개 번호 일치 / 1,500,000원

8. 4등: 4개 번호 일치 / 50,000원

9. 5등: 3개 번호 일치 / 5,000원

10. 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.

11. 로또 1장의 가격은 1,000원이다.

12. 당첨 번호와 보너스 번호를 입력받는다.

13. 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.

14. 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.

15. Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.


## 기능 목록 
### 1. 구입금액 입력 문장 출력 기능
첫 줄에 "구입금액을 입력해 주세요."라는 문장을 출력한다.

### 2. 구입 금액 입력 기능
1000원 단위로 사용자의 구입 금액을 입력 받는다.

### 3. 로또 구매 개수 출력 기능
"n개를 구매했습니다."라는 형식으로 문장을 출력한다.

### 4. 구매한 로또 번호 출력 기능
구매한 로또 번호를 대괄호"[]" 안에 콤마","로 구분하여 한 줄에 6개씩 한 세트로 출력한다.

### 5. 당첨번호 입력 문장 출력 기능
"당첨 번호를 입력해 주세요."라는 문장을 출력한다.

### 6. 당첨 번호 입력 기능
콤마","를 기준으로 사용자의 번호를 입력받는다.

### 7. 보너스 번호 입력 문장 출력 기능
"보너스 번호를 입력해 주세요."라는 문장을 출력한다.

### 8. 보너스 번호 입력 기능
1~45 사이의 숫자 하나를 입력 받는다.

### 9. 당첨 통계 문장 출력 기능
"당첨 통계"라는 문장을 출력 후 줄바꿈하여 "---"을 출력한다.

### 10. 일치하는 문자의 개수와 금액 출력 기능
3, 4, 5, 6개의 일치 여부와 보너스 볼 일치 여부, 당첨 금액과 일치하는 개수를 출력한다.

### 11. 총 수익률 출력 기능
총 수익률을 계산하고 "총 수익률은 n%입니다."라는 문장을 출력한다.


## 예외처리
### - 구입 금액 입력 시 금액이 1000원 단위로 나누어 떨어지지 않는 경우
IllegalArgumentException("[ERROR] 금액은 1000원 단위로 입력해주세요.");를 터트리고 금액 입력을 다시 받는다.
### - 구입 금액 입력 시 숫자가 아닌 문자를 입력한 경우
NumberFormatException을 터트린 후 "[ERROR] 금액은 숫자만 입력할 수 있습니다."라는 메시지를 출력하고 금액 입력을 다시 받는다.
### - 구입 금액 입력 시 음수를 입력받을 경우
IllegalArgumentException("[ERROR] 금액은 음수를 입력할 수 없습니다.");를 터트리고 금액 입력을 다시 받는다.
### - 구입 금액 입력 시 0이나 공백을 입력한 경우
IllegalArgumentException("[ERROR] 금액을 입력해주세요.");를 터트리고 금액 입력을 다시 받는다.

### - 당첨 번호 입력 시 입력 숫자가 6개를 넘을 경우
IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");를 터트리고 당첨 번호 입력을 다시 받는다.
### - 당첨 번호 입력 시 숫자가 아닌 문자를 입력한 경우
NumberFormatException을 터트린 후 "[ERROR] 당첨 번호는 숫자만 입력할 수 있습니다." 라는 메시지를 출력하고 당첨 번호 입력을 다시 받는다.
### - 당첨 번호 입력 시 음수를 입력받을 경우
IllegalArgumentException("[ERROR] 당첨 번호는 음수를 입력할 수 없습니다.");를 터트리고 당첨 번호 입력을 다시 받는다.
### - 당첨 번호 입력 시 1~45 숫자의 범위를 지키지 못 할 경우
IllegalArgumentException("[ERROR] 당첨 번호는 1~45 사이의 숫자를 입력해주세요.");를 터트리고 당첨 번호 입력을 다시 받는다.
### - 당첨 번호 입력 시 중복된 숫자를 입력한 경우
IllegalArgumentException("[ERROR] 당첨 번호는 중복되면 안 됩니다.");를 터트리고 당첨 번호 입력을 다시 받는다.
### - 당첨 번호 입력 시 공백을 입력한 겨우
IllegalArgumentException("[ERROR] 당첨 번호를 입력해주세요.");를 터트리고 당첨 번호 입력을 다시 받는다.

### - 보너스 번호 입력 시 숫자가 아닌 문자를 입력한 경우
NumberFormatException을 터트린 후 "[ERROR] 보너스 번호는 숫자만 입력할 수 있습니다." 라는 메시지를 출력하고 보너스 번호 입력을 다시 받는다.
### - 보너스 번호 입력 시 음수를 입력받을 경우
IllegalArgumentException("[ERROR] 보너스 번호는 음수를 입력할 수 없습니다.");를 터트리고 보너스 번호 입력을 다시 받는다.
### - 보너스 번호 입력 시 1~45 숫자의 범위를 지키지 못 할 경우
IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이의 숫자를 입력해주세요.");를 터트리고 보너스 번호 입력을 다시 받는다.
### - 보너스 번호 입력 시 당첨 번호와 중복된 경우
IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되면 안 됩니다.");를 터트리고 보너스 번호 입력을 다시 받는다.
### - 보너스 번호 입력 시 공백을 입력한 경우
IllegalArgumentException("[ERROR] 보너스 번호를 입력해주세요.");를 터트리고 보너스 번호 입력을 다시 받는다.

## 사용 예제

**올바른 입력인 경우**
```
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

```

**잘못된 입력인 경우**
```
구입금액을 입력해 주세요.
8023
금액은 1000원 단위로 입력해주세요.
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
```