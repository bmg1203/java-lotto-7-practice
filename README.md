# 프리코스 3주차 미션 - 로또

## 기능 요구 사항

다음의 기능을 고려하여, 간단한 로또 발매기를 구현한다.

> 1. 로또 번호의 숫자 범위는 1~45까지이다.<br>
>
>
> 2. 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.<br>
>
>
> 3. 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.<br>
>
>
> 4. 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.<br>
     >    - 1등: 6개 번호 일치 / 2,000,000,000원<br>
>    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원<br>
>    - 3등: 5개 번호 일치 / 1,500,000원<br>
>    - 4등: 4개 번호 일치 / 50,000원<br>
>    - 5등: 3개 번호 일치 / 5,000원<br>
>
> 5. 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.<br>
>
>
> 6. 로또 1장의 가격은 1,000원이다.<br>
>
>
> 7. 당첨 번호와 보너스 번호를 입력받는다.<br>
>
>
> 8. 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.<br>
>
>
> 9. 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.<br>
     > 이때 Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.
>

### 입력
- 로또 구입 금액을 입력 받는다. 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.
```
14000
```
- 당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.
```
1,2,3,4,5,6
```
- 보너스 번호를 입력 받는다.
```
7
```

### 출력
- 발행한 로또 수량 및 번호를 출력한다. 로또 번호는 오름차순으로 정렬하여 보여준다.
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
- 당첨 내역을 출력한다.
```
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
```
- 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)
```
총 수익률은 62.5%입니다.
```
- 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.
```
[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.
```

### 실행 결과 예시
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

## 구현할 기능 목록

### 입력 기능
- [x] 로또 구입 금액을 입력받는 기능
    - 구입 금액은 1000원 단위로 입력받는다.
- [x] 당첨 번호를 입력받는 기능
    - 번호는 쉼표(,)를 기준으로 구분한다.
- [x] 보너스 번호를 입력받는 기능

### 출력 기능
- [x] 발행한 로또 수량을 출력하는 기능
- [x] 발행한 로또 1장의 번호를 출력하는 기능
    - 로또 번호는 오름차순으로 정렬하여 보여준다.
- [x] 당첨 통계를 출력하는 기능
- [x] 수익률을 출력하는 기능
    - 수익률은 소수점 둘째 자리에서 반올림한다.
- [x] 에러 문구를 출력하는 기능
    - 에러 문구는 [ERROR]로 시작해야 한다.

### 입출력 이외 기능
- [x] 로또 1장을 발행하는 기능
    - 로또 1장은 중복되지 않은 숫자 6개로 구성되어야 한다.
- [x] 발행된 로또 번호를 오름차순으로 정렬하는 기능
- [x] 입력받은 로또 구입 금액을 통해 구매한 로또 수량을 계산하는 기능
- [x] 발행한 로또의 당첨 여부를 판별하는 기능
    - [x] 발행한 로또와 당첨 로또의 일치하는 번호 개수를 알아낼 수 있어야 한다.
    - [x] 발행한 로또에 보너스 번호가 있는지 판별할 수 있어야 한다.
    - [x] 발행한 로또가 당첨 로또인지 판별할 수 있어야 한다.
        - 당첨 로또라면, 몇 등 당첨인지 알 수 있어야 한다.
- [x] 총 수익률을 계산하는 기능
    - [x] 각 등수 당첨 로또들의 수량과 금액을 곱해, 총 수익에 더하는 기능
    - [x] 로또 구입 금액과 총 수익을 이용해서 총 수익률을 구하는 기능
- [x] 잘못된 값을 입력받는 경우, `IllegalArgumentException`을 발생시키는 기능
    - `Exception`같은 포괄적인 예외 말고, 위와 같은 명확한 예외를 발생시켜야 한다.

## 처리할 예외 목록

### 공통
- [x] 공백이 포함된 문자열을 입력한 경우
- [x] 빈 문자열을 입력한 경우

### 로또 구입 금액
- [x] 로또 구입 금액에 숫자 이외의 문자가 포함된 문자열을 입력한 경우
- [x] 로또 구입 금액이 1000원으로 나누어 떨어지지 않는 경우
- [x] 로또 구입 금액이 10만원을 넘어가는 경우
    - 로또는 1인당 1회 10만원까지만 구매할 수 있는 점을 고려하였다.

### 당첨 번호
- [x] 당첨 번호를 입력받을 때, 쉼표도 아니고, 숫자도 아닌 문자가 포함된 경우
- [x] 당첨 번호가 로또 번호의 숫자 범위를 벗어나는 경우
- [x] 중복된 당첨 번호를 입력한 경우
- [x] 당첨 번호가 6개가 아닌 경우
- [x] 쉼표를 연속해서 입력한 경우

### 로또 번호
- [x] 로또 번호가 로또 번호의 숫자 범위를 벗어나는 경우
- [x] 중복된 로또 번호가 생성된 경우
- [x] 로또 번호가 6개가 아닌 경우

### 보너스 번호
- [x] 보너스 번호를 입력받을 때, 숫자가 아닌 문자가 포함된 경우
- [x] 보너스 번호가 로또 번호의 숫자 범위를 벗어나는 경우
- [x] 보너스 번호가 당첨 번호와 중복되는 경우