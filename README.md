# java-lotto-precourse
### 프리코스 3주 차 [오예현]

# 🔆 로또
간단한 로또 발매기를 구현한다.

## ✅ 기능 요구사항
- 로또 번호 : `1` ~ `45`
    > 사용자 로또 번호 : 6개 랜덤 생성     
    당첨 번호 : 6 + 1(보너스 번호) 입력 받음


- 당첨 기준과 금액
    > 1등 : `6개` 일치 > `2,000,000,000원`  
     2등 : `5개` + `1개(보너스 번호)` 일치 > `30,000,000원`  
     3등 : `5개` 일치 > `1,500,000원`  
     4등 : `4개` 일치 > `50,000원`  
     5등 : `3개` 일치 > `5,000원`
 
- 로또 1장의 가격은 `1000원` > 구입 금액에 해당하는 만큼 로또를 발행


- 사용자로부터 `당첨 번호`, `보너스 번호`, `로또 구입 금액` 입력 받는다.


- `당첨 내역`, `수익률` 출력 후 게임 종료


- 사용자가 잘못된 값 입력한 경우 
    >1. `IllegalArgumentException` 발생  
    >2. `[ERROR]`로 시작하는 에러 메시지 출력  
    >3. 해당 부분부터 입력 다시 받음

## ✅ 입출력 요구사항

- 입력
    - `로또 구입 금액` : `1,000원` 단위로 입력 받고, 나눠 떨어지지 않는 금액은 예외 처리
    - `당첨 번호` : `,`를 기준으로 구분
    - `보너스 번호`


- 출력
    - `로또 수량`과 `번호` : 번호는 오름차순 정렬
    - `당첨 내역`
    - `수익률` : 소수점 둘째 자리에서 반올림(소수점 첫째 자리만 보이게)
    - `에러 메시지` : `[ERROR]`로 시작


- 실행 결과

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

## ☑️ 구현할 기능 목록
- `Application` 클래스

- [X] : 로또 시작하는 함수


- `Lotto` 클래스

- [X] : 번호를 생성하는 함수

- [X] : 로또 번호와 당첨 번호를 비교하는 함수

- [X] : 로또 번호와 보너스 번호를 비교하는 함수


- `LottoTicketsGenerator` 클래스

- [X] : 6개의 로또 번호를 랜덤으로 생성하는 함수


- `LottoService` 클래스

- [X] : 당첨 금액을 가져오는 함수

- [X] : 수익률을 가져오는 함수


- `WinningResultsCalculator` 클래스

- [X] : 당첨 결과를 계산하는 함수


- `WinningAmountCalculator` 클래스

- [X] : 당첨 금액을 계산하는 함수


- `EarningRateCalculator` 클래스

- [X] : 수익률 계산하는 함수


- `RankInfo` 클래스

- [X] : 각 등수 별 정보를 객체로 생성하는 함수


- `RankInfoFactory` 클래스

- [X] : RankInfo를 다른 컴포넌트에서 접근하게 쉽도록 하는 함수


- `EarningRateCalculator` 클래스

- [X] : 수익률 계산하는 함수


- `NumbersValidator` 클래스

- [X] : 번호 중복을 확인하는 함수

- [X] : 번호에 공백에 포함되었는지 확인하는 함수

- [X] : 번호가 숫자인지 확인하는 함수

- [X] : 번호가 1 ~ 45 사이인지 확인하는 함수

- [X] : 번호 개수를 확인하는 함수

- [X] : 보너스 번호가 당첨 번호랑 중복되는지 확인하는 함수



- `PurchaseAmountValidator` 클래스

- [X] : 구입 금액에 공백이 포함되었는지 확인하는 함수

- [X] : 구입 금액이 숫자인지 확인하는 함수

- [X] : 구입 금액이 0원 이상인지 확인하는 함수

- [X] : 구입 금액이 1000원 단위인지 확인하는 함수


- `LottoErrorMessages` 클래스

- [X] : 에러 메시지를 담는 enum


- `LottoInputView` 클래스

- [X] : 구입 금액을 입력 받는 함수

- [X] : 당첨 번호를 입력 받는 함수

- [X] : 보너스 번호를 입력 받는 함수


- `LottoOutputView` 클래스

- [X] : 로또 수량을 출력하는 함수

- [X] : 로또 번호를 출력하는 함수

- [X] : 당첨 내역을 출력하는 함수

- [x] : 수익률을 출력하는 함수


- `LottoController` 클래스

- [x] : InputView의 구입 금액 입력 실행

- [x] : OutputView의 로또 수량 출력 실행

- [x] : LottoGenerator에서 Lotto로 로또 수량만큼 생성하고, OutputView의 로또 번호 출력 실행

- [x] : InputView의 당첨 번호 입력 실행

- [x] : InputView의 보너스 번호 입력 실행

- [x] : LottoService에서 받은 당첨 내역과 수익률로 OutputView의 당첨 내역과 수익률 출력

## ☑️ 프료그램 구조

