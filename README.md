# java-lotto-precourse

## 💸 로또 구입 기능
- [X] 사용자에게 구입금액 입력 요청 문구를 출력한다.
- [X] 사용자에게 구입금액을 입력받는다.
    - [X] 빈 문자열인지 검증한다.
    - [X] 숫자인지 검증한다.
    - [X] 1,000으로 나누어 떨어지는지 검증한다.
    - [X] 예외가 발생한 경우 "[ERROR]"로 시작하는 에러 메시지를 출력한다.
        - 그 부분부터 다시 입력받는다.
- [X] 발행할 로또 수량을 계산한다.
- [X] 수량만큼 로또를 발행한다.
    - [X] 1부터 45까지의 중복되지 않는 6개의 숫자를 뽑는다.
    - [X] 발행한 로또 번호는 오름차순으로 정렬해야 한다.
- [X] 발행한 로또 번호를 출력한다.

## 🎱  당첨 번호와 보너스 번호 입력 기능
- [X] 사용자에게 당첨 번호 입력 요청 문구를 출력한다.
- [X] 사용자에게 당첨 번호를 입력받는다.
    - [X] 빈 문자열인지 검증한다.
    - [X] 올바른 구분자가 포함되어있는지 검증한다.
    - [ ] 숫자인지 검증한다.
    - [ ] 6개의 숫자를 입력했는지 검증한다.
    - [ ] 1부터 45까지의 숫자인지 검증한다.
    - [ ] 중복된 숫자가 포함 되어있는지 검증한다.
    - [ ] 예외가 발생한 경우 "[ERROR]"로 시작하는 에러 메시지를 출력한다.
        - 그 부분부터 다시 입력받는다.
- [ ] 사용자에게 보너스 번호 입력 요청 문구를 출력한다.
- [ ] 사용자에게 보너스 번호를 입력받는다.
    - [ ] 빈 문자열인지 검증한다.
    - [ ] 숫자인지 검증한다.
    - [ ] 1부터 45까지의 숫자인지 검증한다.
    - [ ] 당첨 번호에 포함된 숫자인지 검증한다.
    - [ ] 예외가 발생한 경우 "[ERROR]"로 시작하는 에러 메시지를 출력한다.
        - 그 부분부터 다시 입력받는다.

## 🥇 당첨 결과와 수익률 출력 기능
- [ ] 당첨 통계 안내 문구를 출력한다.
- [ ] 발행한 로또 번호와 당첨 번호, 보너스 번호를 비교하여 일치하는 개수를 확인한다.
    - [ ] 당첨 번호와 일치하는 개수가 5개이면 보너스 번호와 일치하는지 확인해야한다.
- [ ] 등수 별 당첨 내역을 출력한다.
- [ ] 당첨 내역을 통해 수익률을 계산한다.
    - [ ] 당첨 내역을 통해 총 당첨 금액을 덧셈으로 계산한다.
    - [ ] 총 당첨 금액을 구입 금액으로 나누고 100을 곱한다.
    - [ ] 소수점 둘째 자리에서 반올림한다.
- [ ] 수익률을 출력한다.
