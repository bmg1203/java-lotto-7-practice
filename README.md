# java-lotto-precourse
## 기능 요구 사항
간단한 로또 발매기를 구현한다.

로또 번호의 숫자 범위는 1~45까지이다.
1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.(이거는 문제 오류로 추정됨!)
당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
```
1등: 6개 번호 일치 / 2,000,000,000원
2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
3등: 5개 번호 일치 / 1,500,000원
4등: 4개 번호 일치 / 50,000원
5등: 3개 번호 일치 / 5,000원
```
로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
로또 1장의 가격은 1,000원이다.
당첨 번호와 보너스 번호를 입력받는다.
사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

## 기능 목록
- [X] 구매 금액 입력 받기
  - [X] 구매 금액 입력 예외 처리(empty, NaN)
  - [X] 구매 금액 입력 예외 처리(range, unit)
- [X] 로또 발행
  - [X] 로또 번호 생성
    - [X] 중복되지 않은 6개의 숫자를 뽑기
  - [X] 로또 객체 생성 시 검증(중복 숫자, 숫자 범위, 숫자 개수)
- [X] 구매 금액에 해당하는 만큼 로또 발행하기
- [X] 구매한 로또 수 출력
- [X] 구매한 로또 번호 출력
- [X] 당첨 번호 입력 받기
  - [X] 당첨 번호 메시지 출력
  - [X] 숫자 6개 입력
    - [X] 예외 처리
- [X] 보너스 숫자 1개 입력 받기
  - [X] 보너스 번호 메시지 출력
  - [X] 예외 처리
- [X] 보너스 번호와 당첨 번호 비교
- [X] 구매한 로또의 당첨 금액 확인
  - [X] 구매한 로또와 당첨 번호 비교
  - [X] 당첨 통계(당첨 순위, 개수) 반환
- [X] 당첨 통계 출력
- [X] 수익률 계산
- [X] 수익률 출력
- [X] 에러 메시지 출력

# 책임 분리
- Application
  - 의존성 주입

- LottoController
  - 사용자 입력 받기
  - 서비스를 통한, 비지니스 로직 수행
  - 결과 값 출력

- InputView
  - 구매 금액 입력 받기
  - 당첨 번호, 보너스 숫자 입력 받기
- OutputView
  - 구매한 로또 수 출력
  - 구매한 로또 번호 출력
  - 당첨 통계 출력
  - 수익률 출력
  - 에러 메시지 출력

- Seperator
  - 구분자로 구분한 값 반환
  - 6개 숫자를 구분하여 반환

- Lotto
  - 기입 숫자 반환

- Lotto발행
  - 구매 금액에 해당하는 만큼 로또 발행하기
  - 로또 발행
    - 중복되지 않은 6개의 숫자를 뽑기
    - 정렬해서, 로또에 6개의 숫자를 기입
- Lotto정책
  - 당첨 기준 정의
  - 구매한 로또의 당첨 금액 확인
    - 당첨 통계(맞은 개수, 해당 금액, 개수) 반환
- 수익계산
  - 수익률 계산
    - (당첨 금액 / 구매 금액) 기준

## 입출력 정리
입력
- 구매 금액
- 당첨 번호
- 보너스 숫자
출력
- 구매로또 번호
- 당첨 통계
- 수익률

## 가능한 예외
- 구매 금액
  - NaN
  - Empty
  - Negative
  - 로또 금액으로 나누어 떨어지는 구매 단위
  - Range(로또 1개 금액 ~ 로또 x개 금액)
- 당첨 번호 6개
  - NaN
  - Empty
  - Negative
  - Duplicate
  - Range(로또 숫자 범위)
- 보너스 숫자 1개
  - NaN
  - Empty
  - Negative
  - Duplicate
  - Range(로또 숫자 범위)


MVC + Service 형태 책임
----
- Model : 데이터의 상태를 나타냄
- View : Controller를 통해, 데이터를 받아, 이를 표현
- Controller : 요청의 흐름에 집중
- Service : Model을 통한, 비지니스 로직 담당