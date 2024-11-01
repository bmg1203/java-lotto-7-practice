# 🎰 로또 발매기

## 프로젝트 개요
 - 로또 발매기는 사용자가 로또 번호를 구매하고, 당첨 번호와 비교하여 당첨 여부를 확인할 수 있습니다. 로또 구매 금액에 따라 자동으로 번호가 발행되며, 당첨 번호와 비교하여 당첨 등수와 수익률을 계산해 줍니다.
---

# 🚀 기능 구현 목록
- 사용자가 잘못된 값을 입력할 경우`IllegalArgumentException`을 발생시키고 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
- 에러 문구는 "[ERROR]"로 시작해야 한다.

## 입력 기능

- [ ] 로또 구입 금액을 입력 받는다.
  - 예외:
    - 구입 금액이 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다. 
    - 구입 금액이 음수일 경우 예외 처리한다.

- [ ] 당첨 번호를 입력 받는다.
  - 예외:
    - 로또 번호의 숫자 범위는 1~45까지이다. 범위에 벗어난 숫자를 입력할 경우 예외 처리한다. 
    - 입력된 숫자에서 중복이 있을 경우 예외 처리한다.

- [ ] 보너스 번호를 입력 받는다.
  - 예외:
    - 보너스 번호와 당첨 번호가 중복될 경우 예외 처리한다.
    - 로또 번호의 숫자 범위에 벗어난 숫자를 입력할 경우 예외 처리한다.

## 로또 발행 기능

- [ ] 사용자가 입력한 금액에 따라 로또를 발행한다.
  - 로또 번호는 1부터 45 사이의 숫자 중 중복되지 않는 6개의 숫자로 구성된다.

## 로또 결과 계산 기능

- [ ] 구매한 로또 번호와 당첨 번호를 비교하여 등수 및 당첨 금액을 계산한다.
  - 당첨 등수와 금액은 다음과 같다:
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원

## 수익률 계산 기능

- [ ] 총 수익률은 구매 금액 대비 당첨 금액의 비율로 계산한다.
- [ ] 수익률은 소수점 둘째 자리에서 반올림한다.


## 출력 기능

- [ ] 발행한 로또 수량 및 번호를 출력한다. 로또 번호는 오름차순으로 정렬하여 보여준다.
- [ ] 당첨 내역을 출력한다.
- [ ] 수익률은 소수점 둘째 자리에서 반올림한다.

---

# 💻 실행 결과 예시
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