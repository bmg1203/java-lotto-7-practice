# 로또 발매기(Lotto)
`우아한 테크코스`에서 진행하는 `프리코스` 3주차 과제입니다.   
사용자에게 **로또 구매 가격**, **당첨 번호**, **보너스 번호**를 입력 받습니다.
로또는 장당 `1,000`원이며 1부터 45까지의 숫자 중 중복없이 무작위로 6개의 숫자를 가집니다.

구매한 로또들의 `리스트`와 `당첨 여부`, `수익률`을 계산하여 출력하는 것이 목표입니다.      

# 기능 구현 목록

## 1. 사용자 입력 처리

### 로또 구매 가격
* 사용자에게 로또 구매 가격을 입력받는다.
* 입력된 값을 검증한다.   
    * null 값인 경우: `null`
    * 정수형 값이 아닌 경우: `14ee`, `hello`, `6000.123`, `30,000`, `5000.0`
    * 1,000 미만 또는 음수인 경우: `400`, `100`, `-2000`
    * 1,000 단위의 숫자가 아닌 경우: `1234`, `11004`

### 로또 당첨 번호
* 사용자에게 당첨 번호를 입력받아 `,`를 기준으로 분리한다.
* 입력된 값을 검증한다.
    * null 값인 경우: `null`
    * 정수형 값이 아닌 경우: `h,1,3,hi,2,10`, `h,e,l,o,2,44`
    * 구분자가 `,`가 아닌 경우: `23:11:3:39:41:22`, `23'11'3'32'45'44`
    * 1 ~ 45 내에 숫자가 아닌 경우: `100,21,33,55,-23`
    * 중복인 숫자가 존재하는 경우 : `1,1,3,5,1`, `31,45,22,17,31`
    * 숫자가 6개가 아닌 경우 : `1,2,3,4`, `1,17,23,15,29,11`

### 보너스 번호
* 사용자에게 보너스 번호를 입력받는다.
* 입력된 값을 검증한다.
    * null 값인 경우: `null`
    * 정수형 값이 아닌 경우: `h`, `hello`, `2e`, `1e7`, `13.0`
    * 1 ~ 45 내에 숫가가 아닌 경우: `100`, `-23`, `0`
    * 당첨 번호에 보너스 번호가 중복인 번호가 있는 경우: `당첨 번호: 1,17,23,35,44,45 보너스 번호: 35`
* * *

## 2. 로또 생성기

### 로또 생성기
* 구매 가격만큼 로또를 생성한다.
* 로또 생성기를 검증한다.   
    * 구매 가격만큼 로또를 생성하지 못하는 경우: `구매 가격: 3,000 -> 2개의 로또를 생성`  
   

* * *

## 3. 로또 당첨금 지급 서비스

### 로또 당첨 확인 서비스
* 구매한 로또의 당첨/낙첨 여부 확인하고 당첨되었다면 몇 등인지 알려준다.
* 당첨 확인 서비스를 검증한다.
    * 당첨 로또를 낙첨처리하는 경우: `5등 로또를 낙첨처리함`
    * 당첨 로또의 등수를 잘못처리하는 경우: `2등 당첨 로또를 3등으로 처리`

### 로또 당첨금 지급 서비스
* 당첨된 로또의 등수에 맞는 금액을 지급함
* 당첨금 지급 서비스를 검증한다.
    * 당첨 등수에 맞지 않는 금액을 지급함: `5등 로또 -> 50,000을 지급`, `2등 로또 -> 5,000원을 지급`

* * *

## 4. 로또 당첨 내역 및 수익률 계산 서비스

### 당첨 내역 계산
* 구매한 로또의 당첨 내역을 확인한다.
* 당첨 내역이 정확한지 검증한다.
    * 특정 입력 케이스에서 정확히 당첨 내역을 도출하는지 검사

### 수익률 계산
* 수령한 당첨금의 합과 로또 구매 가격에 대한 수익률을 계산한다.
* 수익률이 정확한지 검증한다.
    * 특정 입력 케이스에서 정학히 당첨 내역을 도출하는지 검사

* * *

## 5. 출력 처리

### 구매한 로또 번호 리스트 출력 
* 구매한 로또들의 번호를 구매 가격 개수에 맞게 출력한다.
* 로또 번호가 정확한지 검증한다.

### 당첨 내역 리스트 출력
* 각 등수에 당첨된 로또가 몇 개인지 출력한다.
* 당첨 내역이 정확한지 검증한다.

### 수익률 출력
* 수령한 당첨금의 합과 구매 가격의 수익률을 출력한다.
* 수익률이 정확한지 검증한다.
* * *


