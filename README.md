# java-lotto-precourse

### 입력 기능
- [ ] 가격을 입력받는다.  
- [ ] 당첨번호를 입력받는다.
- [ ] 보너스 번호를 입력받는다.

### 출력 기능
- [ ] 등수별 당첨 개수를 출력한다.
- [ ] 구매 개수를 출력한다.
- [ ] 당첨 수익률을 출력한다.
- [ ] 로또 번호를 출력한다.

### 비즈니스 로직
- [x] 로또 개수를 계산한다
- [x] 로또 개수만큼 로또를 생성한다 
- [x] 로또 번호를 오름차순 정렬한다
- [ ] 각 복권별로, 몇개가 일치하는지 계산한다
- [ ] 각 복권별로, 몇등인지 계산한다.
- [ ] 수익률을 계산한다.
- [ ] 수익률을 소수점 둘째자리에서 반올림 한다
- [ ] 예외 상황 시, [ERROR] 를 출력한다. 

### 예외 처리
- [x] 숫자가 아닌 가격.
- [x] 가격이 null 인 경우
- [x] 양수가 아닌 가격.
- [x] 숫자가 아닌 당첨 번호.
- [x] 당첨번호 , 외의 구분자.
- [x] 숫자 외의 보너스 번호.
- [x] 1 ~ 45 사이가 아닌 숫자.
- [x] 숫자 개수가 6개가 아닌 경우.
- [x] 숫자가 중복된 경우.
- [x] 구입금액이 1000원으로 나누어 떨어지지 않는경우