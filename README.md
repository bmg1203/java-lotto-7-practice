# java-lotto-precourse

## 기능 요구 사항
- [x] 로또의 숫자 범위는 1~45이다.
  - [x] 범위를 벗어나면 예외가 발생한다.
  - [x] 숫자가 아닌 값이 입력되면 예외가 발생한다.
- [x] 로또 한장의 가격은 1000원이다.
  - [x] 금액이 음수이면 예외가 발생한다.
  - [x] 금액이 1000원 단위가 아니면 예외가 발생한다.
- [x] 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- [x] 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- [x] 구입한 수만큼 로또를 발행한다.
- [x] 사용자의 로또 번호와 당첨 번호를 비교한다.
- [x] 당첨 결과를 구한다.
  - 6개의 숫자 일치(1등)
  - 5개의 숫자 일치, 보너스 번호 일치(2등)
  - 5개의 숫자 일치(3등)
  - 4개의 숫자 일치(4등)
  - 3개의 숫자 일치(5등)
- [x] 당첨 번호 입력을 받는다.(번호는 쉼표(,)를 기준으로 구분)
- [x] 보너스 번호 입력을 받는다.
- [x] 로또 구입 금액을 입력 받는다.
- [x] 수익률을 계산한다.(소수점 둘째 자리에서 반올림)
- [x] 발행한 로또의 수와 번호를 출력한다.(로또 번호는 오름차순)
- [ ] 당첨 내역을 출력한다.
- [ ] 오류가 발생하면 그 부분부터 다시 입력을 받는다.

## 추가된 프로그래밍 요구 사항
- [ ] 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- [ ] else 예약어를 쓰지 않는다.
- [ ] Java Enum을 적용하여 프로그램을 구현한다.
- [ ] 구현한 기능에 대한 단위 테스트를 작성한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
- [ ] 제공된 Lotto 클래스를 사용하여 구현해야 한다.
- [ ] Lotto에 numbers 이외의 필드(인스턴스 변수)를 추가할 수 없다.
- [ ] numbers의 접근 제어자인 private은 변경할 수 없다.
- [ ] Lotto의 패키지를 변경할 수 있다.
