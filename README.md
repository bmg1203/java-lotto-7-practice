# 로또

## 프로젝트 목표
간단한 로또 발매기를 구현한다.

## 구현 요구 사항
- 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
  - 1등: 6개 번호 일치 / 2,000,000,000원
  - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
  - 3등: 5개 번호 일치 / 1,500,000원
  - 4등: 4개 번호 일치 / 50,000원
  - 5등: 3개 번호 일치 / 5,000원
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
- 로또 1장의 가격은 1,000원이다.
- 당첨 번호와 보너스 번호를 입력받는다.
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
  - Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.
    
## 주요 기능
1. **로또 발행**: 구매금액을 입력 받아 금액에 비례하여 로또 발행
2. **로또 추첨**: 당첨 번호 6개와 보너스 번호 1개를 입력 받아 당첨 로또 추첨
3. **당첨 결과 출력**: 로또 당첨 여부를 확인하고 당첨 통계를 출력

## 로또 발행 기능
- 구매금액을 입력받는 기능
- 입력받은 문자열을 정수로 변환하는 기능
- 구매금액에서 로또 구매 개수를 추출하는 기능
- 랜덤 숫자 6개로 로또 객체를 만드는 기능
- 생성된 로또 객체를 출력하는 기능

## 로또 추첨 기능
- 당첨 번호를 입력받는 기능
- 입력된 문자열에서 번호를 추출하는 기능
- 당첨 번호 6개를 하나의 로또 객체로 만드는 기능
- 보너스 번호를 입력받는 기능
- 보너스 번호의 유효값 검증 기능
  - 1부터 45 사이의 값인지
  - 1개만 입력되었는지
  - 당첨 번호와 중복되지 않는지

## 당첨 결과 출력 기능
- 각 등수 별 당첨 횟수를 반환하는 기능
- 당첨 통계 출력 기능
- 총 수익률 계산 기능

## Lotto 클래스
- 로또 객체 생성 기능
- 로또 번호의 개수 검증 기능(6개)
- 로또 번호의 중복 여부 검증 기능
- 로또 번호의 범위 검증 기능(1~45)
- 로또 번호 출력 기능
- 로또 번호 접근 기능
- 두 개의 로또 객체 간의 일치하는 번호 개수 반환 기능
- 정수 리스트와 로또 객체 사이의 일치하는 번호 개수 반환 기능

