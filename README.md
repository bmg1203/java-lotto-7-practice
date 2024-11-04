# java-lotto-precourse

## 프로젝트 소개
    본 프로그램은 6개의 숫자로 이루어진 로또로 구매할 금액을 입력하면 금액에 맞는 갯수의 로또를 
    랜덤하게 받게 되고 입력한 당첨번호와 보너스 번호를 비교하여 당첨 통계를 내주는 프로그램입니다. 


## 구현 기능 목록
- [X] 구입 금액 입력 요구 문구 출력
- [X] 구입 금액 입력 받기
- [X] 구입 금액에 따른 로또 구매 개수 출력
- [X] 로또 번호 범위 설정
- [X] 구입한 로또 번호 출력
- [X] 당첨 번호 입력 요구 문구 출력
- [x] 당첨 번호 입력 받기
- [x] 보너스 입력 요구 문구 출력
- [X] 보너스 번호 입력 받기
- [X] 당첨 통계 계산 하기
    - [X] 당첨 여부 비교 기능
    - [X] 수익률 계산 기능
- [X] 당첨 통계 출력하기
- [X] 수익률 출력하기

## 예외처리
- [X] 구입 금액 숫자 입력 예외 처리
- [X] 구입 금액 1000 단위 예외 처리
- [X] 구입 금액 최대 금액 설정
- [X] 입력 받은 당첨 번호 숫자 예외 처리
- [X] 보너스 숫자 예외 처리
- [X] 입력 받은 당첨 번호 및 보너스 번호 중복 예외처리

## 파일 구조
    ├── main
    │     └── java  
    │           └── lotto
    │                 ├── Application.java
    │                 ├── constant
    │                 │       ├── Constant.java
    │                 │       ├── ErrorMessage.java
    │                 │       └── Message.java
    │                 ├── controller
    │                 │       └── LottoController.java
    │                 ├── domain
    │                 │       ├── Bonus.java
    │                 │       ├── Lotto.java
    │                 │       ├── PurchaseAmount.java
    │                 │       ├── RandomNumbers.java
    │                 │       ├── Rank.java
    │                 │       ├── WinningLotto.java
    │                 │       └── WinningNumber.java
    │                 ├── model
    │                 │       ├── LottoCollection.java
    │                 │       └── WonLotto.java
    │                 ├── service
    │                 │       └── LottoService.java
    │                 └── view
    │                       ├── InputView.java
    │                       └── OutputView.java
    └── test
          └── java
                └── lotto
                      ├── ApplicationTest.java
                      ├── domain
                      │     ├── BonusTest.java
                      │     ├── LottoTest.java
                      │     ├── PurchaseAmountTest.java
                      │     ├── RandomNumbersTest.java
                      │     ├── RankTest.java
                      │     └── WinningLottoTest.java
                      ├── model
                      │     └── LottoCollectionTest.java
                      └── service
                            └── LottoServiceTest.java
