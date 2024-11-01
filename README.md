# java-lotto-precourse

## 🛠️ 구현할 기능 목록

### View

- [X] 구입 입력 금액 메시지와 함께 구매 금액을 입력 받는다.
- [ ] 구매 금액을 바탕으로 몇 개 로또를 샀는지 출력한다.
- [ ] 산 로또의 결과를 출력한다. 이때 오름차순으로 출력한다.
- [X] 당첨 번호를 입력 받는 메시지와 함께 당첨 번호를 입력 받는다.
- [X] 보너스 번호를 입력 받는 메시지와 함께 보너스 번호를 입력 받는다.
- [ ] 당첨 통계를 출력한다.
    - 3개 일치, 4개 일치, 5개 일치, 5개 일치(+ 보너스 볼 일치), 6개 일치 개수를 출력한다.
- [ ] 수익률을 출력한다.(수익률은 소수점 둘째 자리에서 반올림한다.)

### SPLIT

- [ ] 입력된 당첨 번호를 , 단위로 잘라 숫자들로 반환한다.

### COUNT

- [ ] 로또를 살 계수로 구입 금액을 바탕으로 몇 개인지 파악한다.

### LOTTO

- [X] 로또는 중복되지 않은 6개의 숫자로 구성되어 있다.
- [X] 각 숫자는 1부터 45 사이의 숫자이다.
    - [ ] 로또 안의 숫자들은 오름차순으로 정렬이 되어있다.

### LOTTOS

- [ ] 산 로또 개수 만큼 LOTTO를 생성한다.
- [ ] camp.nextstep.edu.missionutils.Randoms의 pickUniqueNumbersInRange()를 활용하여 LOTTO 숫자를 뽑는다.

### LOTTOMACHINE

- [ ] 당첨 숫자 6개를 보유하고 있다.
- [ ] 당첨 숫자는 중복되지 않는다.
- [ ] 보너스 숫자를 지니고 있다.
- [ ] 이 숫자들 또한 1부터 45 사이의 숫자이다.

### BONUSNUMBER

- [ ] 보너스 숫자는 1부터 45 사이의 숫자여야한다.
- [ ] 뽑은 로또에 포함되어있는지 확인 가능하다.

### LOTTOCONTROLLER

- [ ] LOTTOS와 LOTTOMACHINE(숫자와 보너스 숫자)을 비교하여 결과를 도출한다.
- [ ] 결과와 함께 수익률을 계산한다.

---

## ❌ 예외 상황

- [X] 예외 상황 시 에러 문구 출력해야한다. 에러 문구는 "[ERROR]"로 시작한다.
- [ ] 사용자가 입력을 잘 못한 경우 IllegalArgumentException을 발생시키고 해당 부분부터 다시 입력 받는다.

### VIEW

- [ ] 구입 급액과 보너스 번호를 입력 받을 때 숫자 아닌 값이 들어오면 예외가 발생한다.

### PARSER

- [ ] , 단위로 파싱한 문자들이 숫자가 아니면 예외가 발생한다.

### COUNT

- [ ] 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외가 발생한다.

### LOTTO

- [ ] 1 부터 45 사이의 숫자가 아니면 예외가 발생한다.
- [X] 중복된 숫자가 있는 경우 예외가 발생한다.
- [X] 숫자가 6개가 아닌 경우 예외가 발생한다.

### LOTTOMACHINE

- [ ] 1 부터 45 사이의 숫자가 아니면 예외가 발생한다.
- [ ] 중복된 숫자가 있는 경우 예외가 발생한다.
- [ ] 숫자가 6개가 아닌 경우 예외가 발생한다.

### BONUSNUMBER

- [ ] 보너스 숫자가 1부터 45 사이의 숫자가 아니면 예외가 발생한다.

---

## ⭐ 프로그래밍 요구 사항

- build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- 프로그램 종료 시 System.exit()를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- 함수의 길이가 15 라인 이상을 넘기지 말아야한다. 즉, 함수 하나는 한가지 일만 한다.
- else 예약어는 사용하지 않는다.
- ENUM을 활용하여 구현한다.
- 단위 테스트를 진행한다. UI 로직은 제외한다.

---

## 💪 3주차 프리코스 목표

- 단위 테스트가 편하도록 설계하기, 제어할 수 없는 값의 영향을 최소화하기
- 각 함수에게 역할은 하나씩만 맡기고 해당 역할이 들어나도록 함수 이름 정하기
- ENUM 타입 활용하기
- 검증은 역할에 맡게 각 도메인에 숨기고 모두 공통으로 사용하는 검증만 밖으로 빼서 관리하기
- 클린 코드 작성하기
- 공부한 Predicate 활용해보기


