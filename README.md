# java-lotto-precourse


## 기능 요구 사항
간단한 로또 발매기를 구현한다.

## 기능 목록

### 금액 입력받기
로또 1장의 가격은 1,000원이다.
구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.
로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.

### 당첨번호 + 보너스번호 입력받기
로또 번호의 숫자 범위는 1~45까지이다.
1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.

### 로또 번호 생성하기
로또 번호의 숫자 범위는 1~45까지이다.

### 발행한 로또 수량 및 번호를 출력하기
로또 번호는 오름차순으로 정렬하여 보여준다.

### 구매한 로또 개수 출력하기

### 당첨 내역 출력하기
사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역을 출력한다.
당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
1등: 6개 번호 일치 / 2,000,000,000원
2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
3등: 5개 번호 일치 / 1,500,000원
4등: 4개 번호 일치 / 50,000원
5등: 3개 번호 일치 / 5,000원

### 수익률 출력하기
당첨 결과에 따른 수익률을 출력하고 로또 게임을 종료한다.

### 입력 예외 발생시키기 (금액)
사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

### 입력 예외 발생시키기 (로또번호)
사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

### 테스트 및 리팩토링