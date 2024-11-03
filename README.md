# 로또 프로그램

## 기능 목록

1. 구입금액을 입력받는다
    - 1000단위로 받고 아닐 경우 illegalArgumentException을 발생시킨다.
    - [ERROR]로 시작하는 에러 메시지를 출력 후 그 부분 부터 다시 입력을 받는다.

2. 로또 하나 가격은 1000원이고 구매한 로또 개수를 출력한다.

3. 발행한 로또 번호를 출력한다.
    - 로또 번호는 1~45사이인 중복 되지 않은 정수 6개이다.

4. 당첨 번호를 입력받는다.
    - 당첨 번호는 1~45사이인 중복 되지 않은 정수 6개이다.
    - 숫자 앞뒤 공백을 처리한다.
    - 입력이 잘못됐을 경우 illegalArgumentException을 발생시킨다.
    - [ERROR]로 시작하는 에러 메시지를 출력 후 그 부분 부터 다시 입력을 받는다.

5. 보너스 번호를 입력받는다.
    - 보너스 번호는 1~45사이인 정수 1개 이고, 당첨 번호와 중복 되면 안된다.
    - 입력이 잘못됐을 경우 illegalArgumentException을 발생시킨다.
    - [ERROR]로 시작하는 에러 메시지를 출력 후 그 부분 부터 다시 입력을 받는다.

6. 로또 번호를 확인하여 당첨 금액을 확인한다.
    - 당첨 기준
        - 1등: 6개 번호 일치 / 2,000,000,000원
        - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
        - 3등: 5개 번호 일치 / 1,500,000원
        - 4등: 4개 번호 일치 / 50,000원
        - 5등: 3개 번호 일치 / 5,000원

7. 당첨 통계를 출력한다.
    - 각 등수 별로 몇개가 당첨 됐는지 출력한다.
    - 총 수익률을 출력한다. 
    - 수익률 = (수익/구입금액)*100 --소수점 둘째 자리에서 반올림한다.


## 예외 목록

- 구입 금액 입력 예외
    - [ ] 1000단위가 아닐경우
    - [ ] 1000 미만 일 경우
    - [ ] 정수가 아닐 경우
- 당첨 번호 입력 예외
    - [ ] 정수가 아닐 경우
  - Lotto 클래스에서 처리 할 것
    - [ ] 번호 개수가 6개가 아닌 경우
    - [ ] 중복된 숫자가 존재 할 경우
    - [ ] 1~45 사이의 숫자가 아닐 경우
- 보너스 번호 입력 예외
    - [ ] 당첨 번호에 중복된 숫자가 존재 할 경우
    - [ ] 1~45 사이의 숫자가 아닐 경우
    - [ ] 정수가 아닐 경우
