# 로또

숫자 6개와 보너스 번호 1개를 당첨번호로 입력받는 로또 발매기입니다.
당신의 일확천금을 여기서 먼저 꿈꾸어보세요!

## 예외사항

* 공통적으로 입력은 빈 문자열을 입력받은 경우 예외 처리한다.
* 구입 금액은 4,611,686,000원으로 제한한다.
* 구입 금액이 1000원 단위가 아닐 경우 예외 처리한다.
* 당첨 번호가 정수가 아닌 경우 예외 처리한다.
* 당첨 번호가 7개 이상 입력된 경우 예외 처리한다.
* 당첨 번호가 1~45 사이의 숫자가 아닌 경우 예외 처리한다.
* 당첨 번호가 중복될 경우 예외 처리한다.
* 보너스 번호가 정수가 아닌 경우 예외 처리한다.
* 보너스 번호가 1~45 사이의 숫자가 아닌 경우 예외 처리한다.
* 보너스 번호가 당첨 번호와 중복될 경우 예외 처리한다.

## 구현할 기능
- [X] 입력
    - [X] 로또 구입 금액 입력
    - [X] 당첨번호 입력
    - [X] 보너스 번호 입력
- [X] 구입 금액 파싱 및 검증
    - [X] 구입 금액이 정수인지 검증
    - [X] 구입 금액이 음수인지 검증
    - [X] 구입 금액이 1,000원 단위인지 검증
    - [X] 구입 금액이 최대치(4,611,686,000원)를 벗어났는지 검증
- [ ] 당첨 번호 파싱 및 검증
    - [ ] 당첨 번호들이 정수가 맞는지 검증
    - [ ] 당첨 번호들이 7개 이상 입력된 지 검증
    - [ ] 당첨 번호들이 1~45 사이의 숫자인지 검증
    - [ ] 당첨 번호들이 중복되었는지 검증
- [ ] 보너스 번호 파싱 및 검증
    - [ ] 보너스 번호가 정수가 맞는지 검증
    - [ ] 보너스 번호가 1~45 사이의 숫자인지 검증
    - [ ] 보너스 번호가 당첨 번호와 중복되는지 검증
- [ ] 로또 발행
    - [ ] 구입한 금액만큼 로또 수량 발행
    - [ ] 각각의 로또 번호 오름차순 정렬
    - [ ] 발행한 로또 수량 및 번호를 출력
- [ ] 당첨 내역 계산
    - [ ] 일치한 개수와 수익률 출력