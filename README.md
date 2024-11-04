️3️⃣ 프리코스 3주차 미션 - 로또

간단한 로또 발매기를 구현한다.

로또 번호의 숫자 범위는 1~45까지이다.
1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
1등: 6개 번호 일치 / 2,000,000,000원
2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
3등: 5개 번호 일치 / 1,500,000원
4등: 4개 번호 일치 / 50,000원
5등: 3개 번호 일치 / 5,000원
로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
로또 1장의 가격은 1,000원이다.
당첨 번호와 보너스 번호를 입력받는다.
사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.


## 구현할 기능 목록
기능 목록
1. 입력 
   - [x] 구입 금액 입력
   - [x] 입력한 구입 금액이 1000원 단위의 양수인지 검증한다.
   - [x] 당첨 번호 입력
   - [x] 사용자로부터 당첨 번호 6개를 입력받는다.
   - [x] 입력한 번호가 1부터 45 사이의 숫자로 구성되어 있는지, 중복이 없는지 검증한다. 
   - [x] 보너스 번호 입력
   - [x] 사용자로부터 보너스 번호를 입력받는다.
   - [x] 입력한 번호가 1부터 45 사이의 숫자이며, 당첨 번호와 중복되지 않는지 검증한다. 
   - 
2. 로또 발행 기능
   - [x] 로또 티켓 생성
   - [x] 구입 금액에 따라 필요한 로또 티켓 수를 계산하고 로또 번호를 랜덤으로 생성한다.
   - [x] 각 티켓은 중복되지 않는 6개의 번호로 구성된다.
   - [x] 로또 번호의 범위는 1부터 45까지이다.
   - 
3. 당첨 결과 계산 기능
   - [x] 당첨 등수 계산
   - [x] 사용자가 구입한 각 로또 티켓과 당첨 번호를 비교하여 당첨 등수를 계산한다.
   - [x] 각 로또 티켓의 당첨 여부는 일치하는 번호의 개수와 보너스 번호 일치 여부에 따라 결정된다.
   - [x] 당첨 통계 관리
   - [x] 당첨 결과를 바탕으로 등수별 당첨 횟수를 집계한다.
   
4. 수익률 계산 기능
   - [x] 총 수익 계산
   - [x] 당첨된 로또 티켓의 등수에 따라 상금을 계산한다.
   - [x] 상금을 모두 합산하여 총 수익을 계산한다.
   - [x] 수익률 계산
   - [x] 총 수익을 구입 금액으로 나누어 수익률을 계산한다.
   - [x] 수익률은 소수점 둘째 자리에서 반올림하여 표시한다.
   
5. 출력 기능
   - [x] 로또 티켓 출력
   - [x] 발행된 로또 티켓의 개수와 각 티켓의 번호를 오름차순으로 출력한다.
   - [x] 당첨 통계 출력
   - [x] 당첨 통계를 등수별로 출력한다.
   - [x] 각 등수별로 일치하는 번호의 개수와 상금, 해당 등수의 당첨 횟수를 표시한다.
   - [x] 수익률 출력
   - [x] 계산된 총 수익률을 % 단위로 출력한다.
   
6. 예외 처리 기능
   - [x] 입력 예외 처리
   - [x] 구입 금액, 당첨 번호, 보너스 번호가 유효하지 않은 경우 적절한 예외 메시지를 출력하고 재입력을 요청한다.
   - [x]IllegalArgumentException 처리
   - [x] 예외 발생 시 [ERROR]로 시작하는 에러 메시지를 출력하고 해당 부분부터 다시 입력받도록 한다.
   
7. Prize Enum 관리 기능
   - [x] 당첨 등수 및 상금 관리
   - [x] Prize Enum을 사용하여 당첨 등수, 일치하는 번호 개수, 보너스 번호 여부, 상금 금액 등을 관리한다.
   - [x] 당첨 등수 검색 기능
   - [x] matchCount와 bonusMatch 여부에 따라 해당하는 Prize Enum 값을 반환하는 기능을 구현한다.
