# java-lotto-precourse

## 기능 구현 목록
- [x] 구입 금액 입력 받기 및 입력값 검증하기
- [x] 구입 금액 만큼 로또 발행하기
- [x] 발행한 로또 출력하기
- [x] 당첨 번호 입력 받기 및 입력값 검증하기
- [x] 보너스 번호 입력 받기 및 입력값 검증하기
- [x] 입력에 따른 당첨 통계 및 수익률 계산하기
- [x] 당첨 통계 및 수익률 출력하기

### 생각해본 예외 상황
1. 빈값을 입력하는 경우
2. 입력에 맞지않는 문자가 들어온 경우
3. 입력값의 범위가 맞지 않는 경우
4. 입력값의 길이(크기)가 맞지 않는 경우
5. 입력값이 원하는 형식이 아닌 경우
5. 입력값에 중복된 값이 들어있는 경우

### 테스트 코드를 작성하는 이유
```
내가 생각하는 테스트의 가장 큰 장점은 
전체 로직을 구성하지 않아도,
내가 원하는 흐름대로 코드가 흘러가고 있는지를 할 수 있다는 것이다.

백엔드는 입력부터 출력까지가 구성이되어야 해당 로직이 어떤 값을 반환하는지  알 수 있는데,
테스트 코드를 작성하여 바로바로 작은 부분을 담당하는 기능의 흐름을 알 수가 있다.
디버깅이라는 좋은 기능도 많은 도움이 되고 있다.

하지만 내가 코드를 잘 못짜서 그런지,
기존 코드의 변경이 테스트 코드에도 변경을 줘야하는게 좀 귀찮은 면이 있다.
그만큼 내가 아직 클래스 간의 의존성을 잘 나누지 못한다는 것이고,
우테코를 하면서 해당 부분을 많이 느끼고 있다.
```

### 추가된 요구 사항
1. 함수(또는 메서드)의 길이가 ```15라인```을 넘어가지 않도록 구현
   - 함수(또는 메서드)가 ```한 가지 일만 잘 하도록``` 구현
2. ```else 예약어```를 쓰지 않기
   - ```switch/case```도 금지
3. Java ```Enum```을 적용하여 프로그램을 구현
4. 구현한 기능에 대한 ```단위 테스트```를 작성
   - UI(System.out, System.in, Scanner) 로직은 제외
5. 제공된 ```Lotto 클래스```를 사용하여 구현해야 한다.

### 기능 요구 사항
1. 로또 번호 숫자 범위 : 1 ~ 45
2. 1개의 로또 발행 시 ```중복되지 않는 6개의 숫자``` 뽑기
3. 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 ```보너스 번호 1개``` 뽑기
4. 당첨 : 1 ~ 5등까지
   - 1등 : 6개 번호 일치 - 2,000,000,000원
   - 2등 : 5개 번호 + 보너스 번호 일치 - 30,000,000원
   - 3등 : 5개 번호 일치 - 1,500,000원
   - 4등 : 4개 번호 일치 - 50,000원
   - 5등 : 3개 번호 일치 - 5,000원
5. 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행할 것
6. 로또 1장 가격 : 1,000원
7. 당첨 번호 + 보너스 번호 입력받기
8. 사용자가 구매한 로또 번호와 담첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임 종료
9. 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, <br> 
   ```"[ERROR]"```로 시작하는 에러 메시지를 출력 후 ```그 부분부터 입력을 다시 받는다.``` <br>
   Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 ```명확한 유형을 처리```한다.

### 입출력 요구 사항

1. 입력
   1. ```구입 금액``` : 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.
   2. ```당첨 번호``` : 번호는 쉼표(,)를 기준으로 구분한다.
   3. ```보너스 번호```
2. 출력
   1. ```발행한 로또 수량 및 번호 출력``` : 로또 번호는 오름차순으로 정렬
   2. ```당첨 내역 출력```
   3. ```수익률 출력``` : 소수점 둘째 자리에서 반올림
3. 예외 상황
   1. 에러 문구 : ```[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.```

