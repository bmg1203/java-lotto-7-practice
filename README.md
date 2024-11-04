# java-lotto-precourse

---

## 기능 요구 사항

---

간단한 로또 발매기 구현

- 로또 번호 숫자 범위는 1에서 45사이이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있으며 등수에 따른 금액은
    - 1등(6개 번호 일치): 2,000,000,000원
    - 2등(5개 번호 + 보너스 번호 일치): 30,000,000원
    - 3등(5개 번호 일치): 1,500,000원
    - 4등(4개 번호 일치): 50,000원
    - 5등(3개 번호 일치): 5,000원
- 로또 구입 금액을 입력 시 구입 금액에 해당하는 로또를 발행해야 한다
- 로또 1장의 가격은 1,000원이다.
- 당첨 번호와 보너스 번호를 입력 받는다.
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료 한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시키고, [ERROR]로 시작하는 에러 메시지를 출력 후 그 부분부터 다시 입력 받는다.
    - `Exception`이 아닌 `IllegalArgumentException` , `IllegalStateException` 등과 같은 명확한 유형을 처리한다

## 입출력 요구 사항

---

### 입력

---

- 로또 구입 금액 입력

  로또 구입 입력 시 1,000원 단위로 입력을 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리를 한다.

- 당첨 번호 입력

  당첨 번호 입력 시 번호는 쉼표(,)를 기준으로 구분한다.

- 당첨 번호 입력

### 출력

---

- 발행한 로또 수량 및 로또 번호 출력
    - 로도 번호는 오름차순으로 정렬하여 보여줌
- 수익률 출력
    - 소수점 둘째 자리에서 반올림한다.
- 에러 문구 출력
    - 에러 문구는 [ERROR]로 시작해야 한다.

## 프로그래밍 요구 사항

---

- indent(들여쓰기) depth는 2이하까지 허용한다
- 3항 연산자를 사용하지 않는다.
- 함수와 메서드의 길이가 15라인을 넘어가지 않도록 구현한다
    - 함수와 메서드가 한 가지 일만을 하도록 작게 만든다.
- JUnit5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
- `else` , `switch/case`  예약어를 사용하지 않는다.
- Java Enum을 적용하여 프로그램을 구현한다
- 구현 기능에 대한 단위 테스트를 작성한다
    - UI 로직에 대한 테스트는 제외한다.

### `Lotto` 클래스 요구

---

- 제공된 `Lotto` 클래스를 사용하여 구현해야한다
- `Lotto`에 `numbers` 이외의 필드(인스턴스 변수)를 추가할 수 없다.
- `number`의 접근 제한자인 `private`은 변경할 수 없다.
- `Lotto`의 패키지를 변경할 수 있다.

## 기능목록 리스트

---

- [ ]  입출력 View 클래스
- [x]  금액, 발행한 로또가 존재하는 사용자 User 클래스
    - [x] 숫자가 아닌 다른 값 입력 검증
    - [x] 1,000원 단위 및 1,000원 이하를 확인하는 검증
    - [x] 로또를 발행하는 메서드
- [x] Lotto 클래스
    - [x] 로또 번호 개수 검증
    - [x] 중복되는 번호 검증
    - [x] 범위에 해당하는 번호 검증
- [x] 수상 정보가 저장되어 있는 LottoPrice Enum
    - [x] 변수로 LottoPrice를 찾는 메서드
    - [x] LottoPrice 메시지 출력 메서드
- [ ]  당첨 번호가 저장되어 있는 WinningLotto 클래스
    - [ ] 당첨 번호 숫자 개수 검증
    - [ ] 중복되는 번호 검증
    - [ ] 범위에 해당하는 번호 검증
- [ ] 로또 기능을 관리하는 LottoManager 클래스
    - [ ] 잘못된 값을 입력하면 에러 호출 후 반복해서 입력 받는 메서드들
    - [ ] 결과 및 수익률을 출력 해주는 메서드
- [ ] 로또 기능을 실행하는 LottoService 클래스
    - [ ] User의 로또 번호가 각각 몇등인지 계산하는 메서드
    - [ ] 총 수익률이 몇인지 계산하는 메서드
- [ ] 문자열 나누기, 정수를 변환하는 LottoUtil 클래스
    - [ ] 문자를 정수로 변환하는 메서드
    - [ ] 문자열을 나누는 메서드
    - [ ] 나눈 문자열을 정수 배열로 변환하는 메서드
- [ ] 도메인에 대한 테스트
    - [x] LottoTest
    - [ ] UserTest
    - [ ] WinningLottoTest