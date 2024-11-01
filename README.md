# java-lotto-precourse

## 문제 설명
### 기능 요구 사항
간단한 로또 발매기를 구현한다.

- 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다. 
  - 1등: 6개 번호 일치 / 2,000,000,000원
  - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
  - 3등: 5개 번호 일치 / 1,500,000원
  - 4등: 4개 번호 일치 / 50,000원
  - 5등: 3개 번호 일치 / 5,000원
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
- 로또 1장의 가격은 1,000원이다.
- 당첨 번호와 보너스 번호를 입력받는다.
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
  - Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

### 실행 결과 예시
<blockquote>
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
</blockquote>

## 문제 풀이
### 기능 구현 목록 정리 (커밋단위)
- [ ] (Model) 로또 번호 "SystemLottoNumber" 자료구조를 구현한다. 
  - 범위 1~45
  - 중복되지 않는 6개의 랜덤 숫자
  - 오름차순 정렬
- [ ] (Model) 당첨 번호 "UserLottoNumber" 자료구조를 구현한다.
  - (사용자에게 입력 받음)
  - 중복되지 않는 숫자 6개
  - 보너스 번호 1개
- [ ] (View) 사용자에게 입력을 받는 InputView 클래스와 로직을 구현한다. 
  - 로또 구입 금액 입력 받기
  - 당첨 번호 입력 받기 (각 숫자 쉼표(,)로 구분)
  - 보너스 번호 입력 받기
- [ ] (Service) 입력 받은 값 처리 로직을 구현한다.
  - 구입 금액으로 발행 수만큼 "SystemLottoNumber" 생성 (1000원 단위당 1개)
  - 당첨 번호와 보너스 번호로 "UserLottoNumber" 생성
- [ ] (View) 발행한 로또 수량 및 번호를 출력한다.
- [ ] (Service) 로또 번호와 당첨 번호를 비교하는 메인 로직을 구현한다.
  - 1~5등 일치 번호와 당첨 금액
- [ ] (View) 당첨 내역을 출력한다.
- [ ] (Service) 수익률 계산 및 출력
  - 소수점 둘째 자리에서 반올림한다.
- [ ] (Exception) 예외 처리
  - 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생
  - "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받기

### 프로그래밍 목표 및 유의사항
- 함수가 한가지 일만 하도록 구현하며 관련 함수를 묶어 클래스를 만든다.
- 구현 기능에 대한 단위 테스트를 작성한다.
- 예외 사항을 기능 구현 목록 추가하며 정리한다.
- indent depth를 3이 넘지 않도록 구현한다.
- else 예약어를 쓰지 않는다.
- Java Enum을 적용하여 구현한다.
