# 🎯 로또

----

###기능 구현 목록

### ✅ 입력 기능
- [ ] 구입 금액을 입력받는다.
    - [ ] **[예외]** 공백인 경우 예외처리를 한다.
    - [ ] **[예외]** 양의 정수가 아닌 경우 예외처리를 한다.
- [ ] 당첨 번호를 입력한다.
    - [ ] **[예외]** 공백인 경우 예외처리를 한다.
    - [ ] **[예외]** 구분자 `,` 로 구분할 수 없는 경우 예외처리를 한다.
    - [ ] **[예외]** 양의 정수가 아닌 영어,한국어,특수문자인 경우 예외처리를 한다.
- [ ] 보너스 번호를 입력한다.
    - [ ] **[예외]** 공백인 경우 예외처리를 한다.
    - [ ] **[예외]** 양의 정수가 아닌 경우 예외처리를 한다.

### ✅ 출력 기능
- [ ] 구입한 로또 개수를 출력한다.
- [ ] 구입한 로또 번호를 출력한다.
    - [ ] 오름차순으로 정렬하여 보여준다.
- [ ] 당첨 통계를 출력한다.
- [ ] 총 수익률을 출력한다.
    - [ ] 소수점 둘째 자리에서 반올림 한다.
    - [ ] 총 수익률은 백분율로 계산한다.

### ✅ 로또 기능
- [x] 로또번호를 생성한다. 
    - [x] **[예외]** 로또 번호가 1~45가 아닐 경우 예외처리를 한다.
- [ ] 로또를 생성한다.
    - [x] **[예외]** 로또 번호가 6개가 아닐 경우 예외처리를 한다.
    - [ ] **[예외]** 중복되는 로또 번호가 있을 경우 예외처리를 한다.
- [ ] 당첨 번호와 비교해 당첨 정보를 계산한다.

### ✅ 로또 티켓 기능
- [ ] 로또 티켓에 있는 번호들의 당첨 정보를 조회한다.

### ✅ 로또 발급 기능
- [ ] 구입 금액에 맞춰 로또를 발행한다.
    - [ ] **[예외]** 한개의 로또 금액 `1000` 원 단위가 아니라면 예외처리를 한다.

### ✅ 당첨 로또 기능
- [ ] 당첨 로또 정보를 생성한다. (당첨 번호, 보너스 번호)
    - [ ] **[예외]** 당첨 번호가 `6`개가 아닐 경우 예외처리를 한다.
    - [ ] **[예외]** 번호가 `1~45` 가 아닐 경우 예외처리를 한다.
    - [ ] **[예외]** 중복되는 번호가 있을 경우 예외처리를 한다.

### ✅ 로또 결과 기능
- [ ] 수익률을 계산한다.
