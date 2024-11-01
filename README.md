# **미션 : 로또**

## **📜기능 목록**
 
### 입력 기능
- [x] 로또 구입 금액을 입력 받는다.
  - [x] 구입 금액을 1,000원 단위로 나눈다.
    - [x] 1,000원으로 나누어 떨어지지 않는 경우 'IllegalArgumentException' 예외 처리한다.
  - [x] 숫자가 아닐 시 'IllegalArgumentException' 예외 처리한다.
  - [x] 1장당 1~45사이 중복되지 않은 6개의 임의의 수를 생성한다.
    - [x] 로또 번호를 오름차순으로 정렬한다.


- [x] 당첨 번호를 입력 받는다.
  - [x] 1~45사이 중복되지 않은 6개의 수를 입력 받는다.
    - [x] 중복된 숫자가 있을 시 'IllegalArgumentException' 예외 처리한다.
  - [x] 당첨 번호와 쉼표(,) 사이의 공백은 제거한다.
  - [x] 번호는 쉼표(,)를 기준으로 구분한다
    - [x] 숫자가 아닐 시 'IllegalArgumentException' 예외 처리한다.
    - [x] 1~45사이가 아닐 시 'IllegalArgumentException' 예외 처리한다.
    - [x] 번호 갯수가 6자리가 아닐 시 'IllegalArgumentException' 예외 처리한다.


- [x] 보너스 번호를 입력 받는다.
  - [x] 숫자가 아닐 시 'IllegalArgumentException' 예외 처리한다.
  - [x] 1~45사이가 아닐 시 'IllegalArgumentException' 예외 처리한다.
  - [x] 당첨 번호와 겹칠 시 'IllegalArgumentException' 예외 처리한다.

### 출력 기능
- [x] 발행한 로또 수량을 출력한다.


- [x] 발행한 로또 번호를 출력한다.(이미 정렬된)


- [ ] 당첨 내역을 출력한다.
  - [ ] 당첨 내역이 0개여도 출력한다.
    - [ ] 3개 일치 -> 5,000원, 4개 일치 -> 5,0000원, 5개 일치 -> 1,500,000원, 
          5개 일치 + 보너스 볼 일치 -> 30,000,000원, 6개 일치 -> 2,000,000,000원이다.


- [ ] 수익률을 출력한다.
  - [ ] 소수점 첫째 자리까지 출력한다.
  - [ ] 당첨이 된 경우 (당첨금 / 로또 구입 금액)*100 으로 계산한다.
    - [ ] 소수점 둘째 자리에서 반올림한다.
  - [ ] 당첨이 된 경우 (0(당첨금) - 로또 구입 금액 / 로또 구입 금액)*100 으로 계산한다.
    - [ ] 소수점 둘째 자리에서 반올림한다.
- [ ] 예외 상황시 에러 문구는 "[ERROR]"로 시작한다.
  

