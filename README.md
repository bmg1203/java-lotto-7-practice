# 로또 

## 소개 🚀
이 프로젝트는 로또 번호 생성과 당첨 확인 기능을 통한 로또 시뮬레이션 기능을 제공합니다.
사용자는 원하는 금액을 입력하여 로또를 구매할 수 있으며, 
각 로또는 1부터 45까지의 숫자 중 중복되지 않는 6개의 숫자로 구성됩니다
이후 당첨 번호와 보너스 번호를 입력 받아, 각 로또가 몇 등에 해당하는지를 계산하고 결과를 보여줍니다.
이 후 최종 결과와 수익률을 알려줍니다.

## 디렉토리 구조 📁
```text
├─main
│  └─java
│      └─lotto
│          ├─constant
│          ├─controller
│          │  └─dto
│          ├─exception
│          ├─model
│          │  ├─enums
│          │  └─lottoInfo
│          ├─service
│          ├─ui
│          ├─util
│          └─validator
└─test
    └─java
        └─lotto
            ├─model
            │  ├─enums
            │  └─lottoInfo
            ├─service
            ├─util
            └─validator

```
## 요구 사항
 - 숫자의 범위는 1~45까지다
 - 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다
 - 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
   - 당첨 번호는 ,로 구분한다
 - 1등부터 5등까지 있다
   - 1등: 6개 번호 일치 / 2,000,000,000원
   - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
   - 3등: 5개 번호 일치 / 1,500,000원
   - 4등: 4개 번호 일치 / 50,000원
   - 5등: 3개 번호 일치 / 5,000원
 - 금액을 입력 받으면 1장에 1000원인 로또를 발급받는다
   - 1000으로 나눠지지 않는다면 예외 발생
 - 출력
   - 발행한 로또 수량 및 번호를 오름차순으로 정렬해 보여준다.
   - 당첨 내역을 출력한다
   - 수익률은 소수점 둘째 자리에서 반올림한다.

 - 예외
   - 예외 발생 시 에러 문구를 출력해야 한다.
   - 에러문구는 [Error] 로 시작한다
   - 에러가 발생할 시 발생한 부분부터 다시 진행한다

## 기능 구현 목록 🖥️
### 로또 구매 기능
- 돈을 입력 받는다.
   - 예외
     - 돈이 로또 가격으로 나눠지지 않는다면 예외를 발생한다.
     - 예외가 발생할 시 다시 금액을 입력 받는다.
- 돈을 로또 가격으로 나눈 갯수만큼 로또를 구매한다.

### 로또 번호 선택 기능
 - 1 ~ 45 중에 중복되지 않은 6개를 뽑는다.
### 당첨 번호 저장 기능
- 6개의 번호를 입력받는다
  - 번호는 쉼표로 구분된다
  - 예외
    - 번호가 6개가 아니면 예외 발생한다.
    - 모든 숫자가 1 ~ 45 사이에 있지 않으면 예외를 발생 한다.
    - 중복되는 숫자가 있으면 예외를 발생한다.
    - 예외가 발생할 시 다시 숫자를 입력 받는다
- 보너스 번호를 입력 받는다.
- 예외
  - 숫자가 1 ~ 45 사이에 있지 않으면 예외를 발생한다.
  - 당첨 번호와 같은 번호가 있으면 예외를 발생한다.
  - 예외가 발생할 시 보너스 번호를 다시 입력 받는다

### 당첨 여부 확인 기능
- 로또 하나의 당첨 여부를 확인한다. (1 ~ 5등)
- 로또 결과를 반환한다.

### 수익률 계산 기능
- 로또 결과를 기반으로 수익률을 계산해 출력한다.
 
## 지난 주 피드백 적용 내역
- 일급 클래스를 이용한 설계
- 검증 로직 분리
- 단위 테스트 작성