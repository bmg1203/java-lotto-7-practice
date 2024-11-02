# java-lotto-precourse
## 기능 요구 사항
간단한 로또 발매기를 구현한다.

* 로또 번호의 숫자 범위는 1~45까지이다.
* 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
* 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
* 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    * 1등: 6개 번호 일치 / 2,000,000,000원
    * 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    * 3등: 5개 번호 일치 / 1,500,000원
    * 4등: 4개 번호 일치 / 50,000원
    * 5등: 3개 번호 일치 / 5,000원
* 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
* 로또 1장의 가격은 1,000원이다.
* 당첨 번호와 보너스 번호를 입력받는다.
* 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
* 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 **그 부분부터 입력을 다시 받는다.**
    * 프로그램이 종료되는 것이 아니라 그 다음부터 계속 입력을 받게 해야한다. 
    * Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

## 1. 로또 구입 금액을 입력 받는다. 
* [x] 1000 이상의 정수를 입력받는다.
* [x] 입력 금액은 1000으로 나누어 떨어져야한다.

## 2. 발행한 로또 수량 및 번호를 출력한다.
* [x] 발행한 로또 수량을 출력한다. 예: `8개를 구매했습니다.`
* [x] 발행한 개수 만큼 로또 번호를 **오름차순으로 정렬하여** 출력한다.
    * 출력 형식 : `[8, 21, 23, 41, 42, 43]` 
* [x] 로또 번호에 중복된 숫자가 있으면 예외를 발생시킨다.

## 3. 당첨 번호를 입력 받는다.
* [x] 쉼표 `,`를 기준으로 구분해서 당첨 번호를 저장한다.
* [x] 쉼표 `,` 이외의 다른 문자는 작성할 수 없다. 공백도 포함할 수 없다.
* [ ] 당첨 번호는 6개이어야 한다.
* [ ] 당첨 번호는 서로 다른 수이어야 한다.
* [ ] 당첨 번호는 1 - 45 사이의 수이다.

## 4. 보너스 번호를 입력 받는다.
* [ ] 보너스 번호는 1 - 45 사이의 수이다.
* [ ] 당첨 번호와 중복되지 않아야 한다.

## 5. 당첨 내역을 출력한다.
* [ ] 당첨 내역을 출력한다.
* [ ] 당첨 내역에 따른 당첨 금액의 총합을 계산한다.

## 6. 수익률을 출력한다.
* [ ] `수익률 = 당첨 금액의 합 / 구매한 금액`로 계산 후, **소수점 둘째 자리에서 반올림**한다.