# Lotto 발매기

## 소개 

---

- 사용자가 입력한 1000원 단위의 금액만큼 자동으로 로또를 발행하고, 사용자가 제공한 당첨 번호와 비교하여 당첨 여부 및 수익률을 확인할 수 있는 프로그램이에요.

**로또 구성**
- 자동 발권 로또는 [1-45] 사이의 고유한 숫자 6자리로 이루어져 있어요
- 당첨 로또는 총 7자리로, 일반 숫자 6자리와 1자리의 보너스 숫자로 이루어져 있어요.
- 당첨은 1등부터 5등까지 구분되며, 각 등수는 다음의 조건과 금액으로 보상하고 있어요.
  - 1등: 6개 번호 일치 / 2,000,000,000원
  - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
  - 3등: 5개 번호 일치 / 1,500,000원
  - 4등: 4개 번호 일치 / 50,000원
  - 5등: 3개 번호 일치 / 5,000원
  
## 주요기능

---

- 자동 발권
  - 입력한 금액만큼 천원 단위로 자동으로 로또를 발행해드리고 있어요.

- 당첨 결과 실시간 확인
  - 당첨 번호와 보너스 번호를 입력하면 당첨 여부를 실시간으로 확인할 수 있어요.  

- 수익률 계산 
  - 사용자가 구매한 로또와 당첨 금액을 바탕으로 수익률 까지도 확인할 수 있어요.

## 구현 기능 목록

---

- 자동 발권
  - 고려사항
    - 숫자는 6자리의 중복되지 않는 숫자로 구성되어야 함
  - 예외 사항
    - 1000원 단위로만 입력 받아야 한다
    - 1000원 이상이여 한다
    - 숫자여야 한다

- 당첨 확인
  - 고려사항
    - 1등,2등이 보너스 번호 사용유무에 차이가 있음에 유의해야함
    - 당첨번호를 입력받고, 다음으로 보너스 번호를 입력 받아야 함
  - 예외 사항
    - ',' 구분자로 당첨번호를 입력받아야 한다
    - 구분자 사이 숫자 형식이여야 한다
    - 숫자가 [1-45] 이여야만 한다.

- 통계(수익률 계산)
  - 공식 : (당첨금액 - 구매금액)[수익] / 구매금액 * 100
  - 고려사항
    - 수익 에서 0이거나, 음수일 경우를 수익률은 자동으로 0이됨에 유의한다 




