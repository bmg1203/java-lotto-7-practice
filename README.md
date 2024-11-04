# 로또

## 프로젝트 소개

로또 프로그램은 사용자로부터 구입 금액을 입력받아 로또를 발행하고, 당첨 번호를 입력받아 당첨 결과와 수익률을 계산하여 출력하는 콘솔 애플리케이션입니다.

## 기능 목록

1. **구입 금액 입력**
  - [x] 사용자로부터 구입 금액을 입력받는다.
  - [x] 구입 금액은 1,000원 단위여야 하며, 그렇지 않으면 예외 처리한다.

2. **로또 발행**
  - [x] 구입 금액에 해당하는 수량의 로또를 자동으로 발행한다.
  - [x] 로또 번호는 1부터 45 사이의 중복되지 않는 6개의 숫자로 구성된다.
  - [x] 발행한 로또 수량 및 번호를 출력한다.

3. **당첨 번호 및 보너스 번호 입력**
  - [ ] 지난 주 당첨 번호 6개를 입력받는다.
    - [ ] 번호는 쉼표(`,`)로 구분한다.
    - [ ] 당첨 번호는 1부터 45 사이의 중복되지 않는 숫자여야 한다.
  - [ ] 보너스 번호 1개를 입력받는다.
    - [ ] 보너스 번호는 1부터 45 사이의 숫자여야 하며, 당첨 번호와 중복될 수 없다.

4. **당첨 결과 계산**
  - [ ] 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역을 계산한다.
  - [ ] 일치하는 번호 개수와 보너스 번호 일치 여부에 따라 등수를 결정한다.
    - [ ] 등수는 1등부터 5등까지 있으며, 각 등수에 해당하는 상금을 관리한다.

5. **결과 출력**
  - [ ] 당첨 통계를 출력한다.
    - [ ] 각 등수별 당첨 횟수를 출력한다.
  - [ ] 총 수익률을 계산하여 출력한다.
    - [ ] 수익률은 소수점 둘째 자리에서 반올림한다.

6. **예외 처리**
  - [ ] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력한 후 입력을 다시 받는다.
    - [ ] 구입 금액이 1,000원 단위가 아닌 경우
    - [ ] 당첨 번호 또는 보너스 번호가 1부터 45 사이의 숫자가 아닌 경우
    - [ ] 당첨 번호 또는 보너스 번호에 중복된 숫자가 있는 경우
    - [ ] 로또 번호의 개수가 6개가 아닌 경우

## 프로그램 실행 예시

```plaintext
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
