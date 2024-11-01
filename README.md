# java-lotto-precourse

## 개요
간단한 로또 발매기를 구현한다.
>* 로또 구입 액수를 입력받아 금액에 해당하는 로또를 발행한다.
>* 발행한 로또는 1에서 45 사이 숫자 6개와 보너스 숫자로 이루어져 있다.
>* 당첨은 1등부터 5등까지 있다.
>   1. 1등 : 6개 번호 일치 / 2,000,000,000원
>   2. 2등 : 5개 번호 + 보너스 일치 / 30,000,000원
>   3. 3등 : 5개 번호 일치 / 1,500,000원
>   4. 4등 : 4개 번호 일치 / 50,000원
>   5. 5등 : 3개 번호 일치 / 5,000원
>* 당첨 내역과 수익률을 반환한다.
>* 예외가 발생하면 [ERROR]와 함께 이유를 출력한다.

## 기능 구현 목록

### 구입 금액을 입력하는 기능
* [x] "구입금액을 입력해 주세요."를 출력한다.
* [x] 구입 금액을 입력한다
    * [x] 입력한 금액 값이 숫자가 아닌 값이 있는지 확인한다.
    * [x] 입력한 금액 값이 0보다 작은지 확인한다.
    * [x] 입력값이 비어있는지 확인한다.

### 로또를 발행하는 기능
* [x] 입력한 금액에 따라 발행할 로또 수량을 계산한다.
* [x] 로또 갯수에 따라 로또를 발행한다.
  * [x] 6개 숫자를 무작위로 생성한다.
  * [x] 1부터 45 사이의 숫자에서 번호를 고른다.
* [x] 갯수 + "개를 구매했습니다."를 출력한다.
* [x] 발행한 로또 번호를 차례로 출력한다.

### 당첨 번호를 입력하는 기능
* [ ] "당첨 번호를 입력해 주세요."를 출력한다.
* [ ] 당첨 번호를 입력한다
  * [ ] 입력값이 비어있는지 확인한다.
  * [ ] 당첨 번호는 구분자 ','를 기준으로 한 줄로 입력한다.
  * [ ] 구분자와 숫자 이외의 값이 있는 지 확인한다.
  * [ ] 당첨 번호가 1부터 45 사이의 값인지 확인한다.
  * [ ] 당첨 번호 중 중복되는 숫자가 있는지 확인한다.
* [ ] "보너스 번호를 입력해 주세요."를 출력한다.
* [ ] 보너스 번호를 입력한다
  * [ ] 입력값이 비어있는지 확인한다.
  * [ ] 숫자 이외의 값이 있는지 확인한다.
  * [ ] 보너스 번호가 1부터 45 사이의 값인지 확인한다.
  * [ ] 보너스 번호가 당첨 번호과 중복되는지 확인한다.

### 당첨 내역과 수익을 출력하는 기능
* [ ] 로또의 6개 번호와 당첨번호를 비교한다
  * [ ] 로또 당 당첨번호와 일치 갯수를 저장한다
* [ ] 당첨 내역을 토대로 수익률을 계산한다
  * [ ] 수익률은 소점 둘째 자리에서 반올림한다
* [ ] 당첨 내역을 출력한다.
* [ ] 수익률을 출력한다.