# [우테코] 프리코스 3주차
<p align="center">
    <img src="src/main/resources/logo.png" alt="우아한테크코스" width="500px">
</p>
<br>

## 구현하면서 고민했던 부분 
- 캡슐화 해서 외부에서 인스턴스의 데이터를 꺼내서 사용하지 않게 만들고 싶었음. 결합도를 낮추고 싶었다.    
- 클래스 인스턴스가 가진 데이터는 본인이 인스턴스 데이터들을 관리할 수 있도록 하고 싶었다.   
- 변수명과 메서드 명에 대해서 고민함. 직관적인 명명을 통해 의도를 파악하기 쉽게 만들고 싶었다.   
- Enum 사용법에 익숙해지고, 출력 데이터와 상수를 enum으로 관리하는 방법 연습
- 테스트 코드를 작성할 때 콘솔에 입출력되는 문자열들을 관리하는 방법에 대해서 고민했다.
- 로또와 당첨 번호들을 검증하는데 시간복잡도에 대해서 고민하고 투 포인터 알고리즘을 이용하여 구현했음

<br />

## 🚀로또

### 기능 요구 사항
간단한 로또 발매기를 구현한다.   
<br />
**🚨우테코 로또 머신**은 기존 로또 방식과 다르게 **선택한 숫자**와 구매한 만큼의 **로또의 랜덤 숫자**와 비교하여 당첨여부를 결정합니다.   
<br />
*예시*
> 2장 구매 시 선택한 숫자 
> `[1, 2, 3, 4, 5, 6]` + 보너스 숫자 : `7`  
> 구매한 로또   
> 랜덤한 값 6개 `[13, 15, 16, 17, 20, 30]`   
> 랜덤한 값 6개 `[ 5, 41, 42, 43, 44, 45]`


- 로또 번호의 숫자 범위는 1~45까지 이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
  - `1등 : 6개 번호 일치 / 2,000,000,000원`
  - `2등 : 5개 번호 + 보너스 번호 일치 / 30,000,000원`
  - `3등 : 5개 번호 일치 / 1,500,000원`
  - `4등 : 4개 번호 일치 / 50,000원`
  - `5등 : 3개 번호 일치 / 5,000원`
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
- 로또 1장의 가격은 1,000원이다.
- 당첨 번호와 보너스 번호를 입력받는다.
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시키고, `[ERROR]`로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
  - `Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리한다.

### 📜 스토리 구상
- 로또 구매자는 우테코 로또 회사에 존재하는 로또 판매기에서 로또를 구매한다.
- 구매자는 자신의 당첨 번호를 저장하고 있다.
- 구매자는 구매한 로또를 저장하고 있다.
- 선택된 로또 *당첨 번호* 또한 하나의 로또이므로 로또 객체로 관리한다.
- 로또 판매기는 로또를 생성함과 동시에 당첨여부를 부여한다.
- 우테코 로또 회사는 당첨 여부에 따른 당첨금에 대한 정보를 구매자에게 제공한다.
- 구매자는 소지한 로또를 가지고 우테코 로또 회사의 기계를 통해 수익률을 계산한다.

### 📝 구현할 기능 목록

**Consumer**    
✅ 구매자는 구매한 로또 객체를 저장하고 있는다.  
✅ 구매자는 선택한 당첨 번호를 저장하고 있는다.   
✅ 구매자는 선택한 보너스 당첨 번호를 저장하고 있는다.   
✅ 구매자는 구매한 로또 번호를 출력할 수 있다.   
✅ 구매자가 구매한 각각의 로또의 번호는 중복되지 않고, 발급된 로또와 구매자가 받은 로또는 동일하지 않으면 false를 반환하고 테스트가 실패한다.   
✅ 구매자가 선택한 로또 당첨번호는 중복되지 않고, 구매자가 받은 번호들과 선택된 번호들이 다를 경우 false를 반환하고 테스트가 실패한다.   
✅ 구매자가 선택한 보너스 번호가, 선택한 당첨번호와 중복될 경우 예외가 발생한다.   
<br />

**LottoMachine**   
✅ 로또 머신은 구매자에게 로또를 판매하며, 생성한 로또 객체를 전달한다    
✅ 로또 머신은 구매자의 로또의 번호를 출력할 수 있어야 한다.   
✅ 당첨 번호를 입력받아 당첨번호를 지닌 로또 객체를 생성하여 구매자에게 전달한다.      
✅ 로또 머신은 구매자로부터 당첨번호를 입력받는다.   
✅ 당첨 번호 객체는 6개의 숫자와 보너스 번호를 저장하고 있는다.     
✅ 로또를 검증하는 전략에 따라 수익률을 계산하는 전략을 가지고 있는다.   
✅ 로또 머신이 제공한 로또와 구매자가 받은 로또 번호가 다르면 예외가 발생한다.
✅ 로또 머신이 당첨 번호를 입력받는 문자가 공백이면 예외를 발생시키며 에러메시지를 반환한다.   
✅ 로또 머신이 당첨 번호를 입력받을 때 숫자가 6개가 아니면 예외를 발생시키며 에러메시지를 반환한다.   
✅ 로또 머신이 구매자에게 보너스 번호를 공백으로 입력받으면 예외를 발생시키며 에러메시지를 반환한다.   
✅ 로또 머신이 구매자에게 보너스 번호를 음수로 입력받으면 예외를 발생시키며 에러메시지를 반환한다.   
✅ 로또 머신이 구매자에게 보너스 번호를 당첨번호와 중복되게 입력받으면 예외를 발생시키며 에러메시지를 반환한다.   

<br />

**Lotto**   
✅ 로또를 구매하기 위한 입력 로직을 구현한다.   
✅ 로또 객체 생성 시 중복 번호 검사 로직을 구현한다.   
✅ 로또 객체 생성 시 오름차순으로 번호를 정렬한다.   
<br />

**WoowahanLottoCompany**   
✅ 우아한 로또 회사는 로또 구매자를 맞이한다.   
✅ 사용자로부터 입력을 받고 에러가 발생 했을 때, 에러가 발생한 부분부터 다시 입력을 받는다.    

<br />


### 입출력 요구 사항

**입력**
- 로또 구입 금액을 입력 받는다. 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.
```
14000
```
- 당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.
```
1,2,3,4,5,6
```
- 보너스 번호를 입력 받는다.
```
7
```

**출력**
- 발행한 로또 수량 및 번호를 출력한다. 로또 번호는 오름차순으로 정렬하여 보여준다.
```
8개를 구매했습니다.
[8, 21, 23, 41, 42, 43] 
[3, 5, 11, 16, 32, 38] 
[7, 11, 16, 35, 36, 44] 
[1, 8, 11, 31, 41, 42] 
[13, 14, 16, 38, 42, 45] 
[7, 11, 30, 40, 42, 43] 
[2, 13, 22, 32, 38, 45] 
[1, 3, 5, 14, 22, 45]
```
- 당첨 내역을 출력한다.
```
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
```
- 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100%, 51.5%, 1,000,000.0%)
```
총 수익률은 62.5%입니다.
```
- 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.
```
[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.
```

**실행 결과 예시**
```
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
```

**랜덤 번호 생성 사용 예시**   
```java
Randoms.pickUniqueNumbersInRange(1, 45, 6);
```
