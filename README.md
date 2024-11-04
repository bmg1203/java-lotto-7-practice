# 로또 🎰

-----

## 🛠️ 기능 요구 사항

#### 1. 로또 번호의 숫자 범위는 1~45까지이다.
#### 2. 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
#### 3. 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
#### 4. 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
```
1등: 6개 번호 일치 / 2,000,000,000원
2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
3등: 5개 번호 일치 / 1,500,000원
4등: 4개 번호 일치 / 50,000원
5등: 3개 번호 일치 / 5,000원
```
#### 5. 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
#### 6. 로또 1장의 가격은 1,000원이다.
#### 7. 당첨 번호와 보너스 번호를 입력받는다.
#### 8. 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
#### 9. 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시키고, `[ERROR]`로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
```
  Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.
```
----- 

## 🧮 Model
&emsp;▪️ `StringParser`에서 로또 금액을 입력받아 구매한 로또의 개수를 `LottoController`로 전달한다.

&emsp; 🚫 다음 경우에 `IllegalArgumentException`
```
1. 입력 받은 금액이 정수가 아닐 때
2. 입력 받은 금액이 양수가 아닐 때
3. 입력 받은 금액이 1,000원 단위가 아닐 때
```
&emsp;▪️ `StringParser`에서 입력받은 당첨 번호와 보너스 번호를 `LottoController`로 전달한다.

&emsp; 🚫 다음 경우에 `IllegalArgumentException`
```
1. 입력 받은 값이 정수가 아닐 때
2. 입력 받은 값이 양수가 아닐 때
3. 입력 받은 값이 1~45 범위를 벗어날 때
4. 중복되는 값을 입력했을 때
```
&emsp;▪️ `Lotto`를 통해 1~45인 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.

## 🖥️ View
&emsp;▪️ `InputView`클래스를 통해 사용자에게 금액과 번호를 입력 받은 후, `LottoController`로 전달한다.

&emsp;▪️ `OutputView`클래스를 통해 구매한 로또 번호와 당첨 내역 및 수익률을 출력한다.

## 🕹️ Controller
&emsp;▪️ `InputView`에서 입력을 받아 `StringParser`로 전달한다.

&emsp;▪️ `LottoService` 에서 전달받은 당첨 여부 및 수익률을 `OutputView`로 전달한다.

## 🧱 Constant
&emsp;▪️`ErrorMessage`에서 출력할 에러메시지들을 관리한다.
