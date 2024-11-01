# java-lotto-precourse

### 로또 구입 금액 입력

- [ ] 로또 구입 금액 입력
- [ ] [예외처리] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, 그 부분부터 입력을 다시 받는다.
- [ ] [예외처리] 금액이 1,000원으로 나누어 떨어지지 않을 때

### 로또 생성

- [ ] 로또 구입 금액을 계산해 발행할 로또 생성
- [ ] 1~45까지의 숫자 범위의 로또 번호 생성
- [ ] 로또 발행 시 중복되지 않는 6개의 숫자 생성
- [ ] [예외처리] 로또 번호가 숫자 범위를 넘어갈 때
- [ ] [예외처리] 생성된 로또의 숫자 개수가 6개가 아닐 때
- [ ] [예외처리] 발행된 로또에 중복된 숫자가 존재 할 때

### 당첨 번호와 보너스 번호 입력

- [ ] 중복되지 않은 6개의 당첨 번호 입력
- [ ] 당첨 번호와 중복되지 않은 보너스 번호 입력
- [ ] [예외처리] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, 그 부분부터 입력을 다시 받는다.
- [ ] [예외처리] 당첨번호가 중복되었을 때
- [ ] [예외처리] 보너스 번호가 당첨 번호와 중복되었을 때

### 당첨 여부 계산

- [ ] 발행한 로또의 당첨 여부 계산

### 수익률 계산

- [ ] 당첨 여부를 통해 수익률 계산
- [ ] 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)
- [ ] [예외처리] 수익률 계산 시 Division By Zero

### 출력

- [ ] "구입금액을 입력해 주세요." 구입 금액 메시지 출력
- [ ] "0개를 구매했습니다." 형식으로 구매 메시지 출력
- [ ] "[00, 00, 00, 00, 00, 00]" 형식으로 구매한 로또 번호 출력
- [ ] "당첨 번호를 입력해 주세요." 당첨 번호 입력 메시지 출력
- [ ] "보너스 번호를 입력해 주세요." 보너스 번호 입력 메시지 출력
- [ ] "당첨 통계" 당첨 통계 메시지 출력
- [ ] "0개 일치 (0,000원) - 0개" 형식으로 당첨 통계 출력
- [ ] "총 수익률은 00.0%입니다." 형식으로 수익률 출력

### 기타

- [ ] "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.

---

## 프로그래밍 요구사항

* indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
* 3항 연산자를 쓰지 않는다.
* 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
* else 예약어를 쓰지 않는다
* Java Enum을 적용하여 프로그램을 구현한다.