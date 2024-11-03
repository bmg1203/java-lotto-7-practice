# java-lotto-precourse

> ### 🍀 로또 발매기 <br>
> 이 프로젝트는 간단한 로또 발매기를 구현한 프로그램입니다. 사용자는 로또를 구입하고, 당첨 번호와 비교하여 당첨 결과 및 수익률을 확인할 수 있습니다.

<br>

## 🛠️ 기능 목록

-----

### 로또 발행
- [X] 사용자에게 로또 구입 금액을 입력받는다.
- [ ] 로또 발행 시 1,000원당 1개의 로또를 발행한다.
- [ ] 각 로또는 1~45 사이의 중복되지 않는 6개의 숫자로 구성된다.
- [ ] 발행한 로또 수량 및 번호를 출력한다. 
  ```
  3개를 구매했습니다.
  [8, 21, 23, 41, 42, 43]
  [3, 5, 11, 16, 32, 38]
  [7, 11, 16, 35, 36, 44]
  ```
  - 로또 번호는 오름차순으로 정렬하여 보여준다.

<br>

### 당첨 번호 추첨
- [ ] 사용자에게 당첨 번호와 보너스 번호를 입력받는다.
  - 당첨 번호는 쉼표(,)를 기준으로 구분한다.
- [X] 로또 당첨 번호를 추첨한다.
  - 중복되지 않는 6개의 숫자를 뽑는다.
  - 당첨 번호에 포함되지 않는 보너스 번호 1개를 뽑는다.

<br>

### 당첨 결과 확인
- [ ] 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 일치하는 개수를 확인한다.
- [ ] 일치하는 개수에 따라 1등부터 5등까지 당첨 여부를 판단한다.
  - 1등: 6개 번호 일치 / 2,000,000,000원
  - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
  - 3등: 5개 번호 일치 / 1,500,000원
  - 4등: 4개 번호 일치 / 50,000원
  - 5등: 3개 번호 일치 / 5,000원
- [ ] 당첨 내역을 출력한다.
  ```
  3개 일치 (5,000원) - 1개
  4개 일치 (50,000원) - 0개
  5개 일치 (1,500,000원) - 0개
  5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
  6개 일치 (2,000,000,000원) - 0개
  ```
- [ ] 총 수익률을 계산하여 출력한다.
  ```
  총 수익률은 62.5%입니다.
  ```
  - 수익률은 소수점 둘째 자리에서 반올림한다.

<br>

### 예외 처리
- 예외 상황 시 `[ERROR]`로 시작하는 에러 문구를 출력 후, 그 부분부터 입력을 다시 받는다.
- `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리한다.


- [ ] 로또 구입 금액이 1,000원으로 나누어 떨어지지 않는 경우

<br>

---------------
#### 실행 결과 예시
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
