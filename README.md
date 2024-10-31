# 💰 로또 게임

## ✨ 기능 구현 목록

- [ ] 구입금액을 입력받는 기능 구현.
    - [ ] 입력받은 금액이 숫자가 아닐시 `IllegalArgumentException` 발생 시키는 기능
    - [ ] 입력 받은 금액이 1000의 배수가 아닐시 `IllegalArgumentException` 발생 시키는 기능
    - [ ] 공백을 입력했을 경우 `IllegalArgumentException` 발생 시키는 기능
    - [ ] 0을 입력 했을 경우 `IllegalArgumentException` 발생 시키는 기능


- [ ] 입력받는 금액에 따라 겹치지 않는 1 ~ 45 사이의 랜덤한 숫자 6개를 생성하는 기능
    - [ ] 랜덤으로 생성된 로또 오름차순으로 정렬하는 기능


- [ ] 위의 결과를 출력하는 기능

- [ ] 당첨번호를 입력 받는 기능
    - [ ] 입력 받은 값을 `,` 단위로 `split` 하여, `List<String>` 으로 변환하는 기능
    - [ ] 입력 받은 값이 숫자가 아닌 값을 포함하고 있을 시 `IllegalArgumentException` 발생 시키는 기능
    - [ ] 입력 받은 값이 1~45 사이의 정수가 아닌 수를 포함하고 있을 시 `IllegalArgumentException` 발생 시키는 기능
    - [ ] 입력 받은 값이 중복된 수를 포함하고 있을 시 `IllegalArgumentException` 발생 시키는 기능


-[ ] 보너스 번호를 입력 받는 기능
    - [ ] 입력 받은 값이 숫자가 아닌 값인 경우 `IllegalArgumentException` 발생 시키는 기능
    - [ ] 입력 받은 값이 1~45 사이의 정수가 아닌 수일 경우 `IllegalArgumentException` 발생 시키는 기능
    - [ ] 입력받은 값의 위의 당첨번호와 겹치는 경우 `IllegalArgumentException` 발생 시키는 기능


- [ ] 당첨 번호와 로또번호를 비교하는 기능

- [ ] 입금 금액과 당첨금액을 토대로 수익률을 계산하는 기능
    - [ ] 위의 결과를 출력하는 기능

- [ ] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    - [ ] Exception 이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.



- [ ] `enum`을 이용한 상수화
    - [ ] 로또에 관련된 정보 상수화
    - [ ] 로또 당첨 등수에 대한 정보 상수화
---


## 🚀 기능 요구 사항

간단한 로또 발매기를 구현한다.


### 입출력 요구 사항
입력

* 로또 구입 금액을 입력 받는다. 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.
```java
14000
```

* 당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.
```java
1,2,3,4,5,6
```

* 보너스 번호를 입력 받는다.
```java
7
```

* 발행한 로또 수량 및 번호를 출력한다. 로또 번호는 오름차순으로 정렬하여 보여준다.
```java
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

* 당첨 내역을 출력한다.

```java
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
```

* 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)

```java
총 수익률은 62.5%입니다.
```

* 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.
```java
[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.
```
실행 결과 예시

```java
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



