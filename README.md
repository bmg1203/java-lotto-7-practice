# java-lotto-precourse
## 📜 프로그램 작동 방식
* 1. **로또 구입 금액을 입력 받는다.**
     - [x] 사용자로 부터 로또 구입 금액 입력 받는다.
     -  _잘못된 값 입력 시 **i** 로 이동_

* 2. **발행한 로또 수량 및 번호를 출력한다.**
     - [ ] 로또 수량을 출력한다.
     - [ ] 로또 번호를 수량만큼 생성한다.
     - [ ] 생성한 로또 번호를 저장한다.
     - [ ] 저장된 로또 번호를 모두 출력한다.

* 3. **당첨 번호를 입력 받는다.**
     - [ ] 사용자로 부터 당첨번호를 입력 받는다.
     -  _잘못된 값 입력 시 **iii** 로 이동_

* 4. **보너스 번호를 입력 받는다.**
     - [ ] 사용자로 부터 보너스 번호를 입력 받는다.
     - _잘못된 값 입력 시 **iv** 로 이동_

* 5. **당첨 통계를 출력한다.**
     - [ ] 당첨 번호와 로또 번호 비교한다.
     - [ ] 일치하는 개수에 따라 n개 일치 부분이 1이 되도록 한다.
     - [ ] n개 일치 부분을 출력한다.
     - [ ] 수익률을 계산한다.
     - [ ] 수익률을 출력한다.
     - [ ] 게임을 종료한다.

<br>

### ⛔ 잘못된 값의 기준:
- ii
  - [ ] 공백인 경우
  - [ ] 숫자가 아닌 경우
  - [ ] 1,000원으로 나누어 떨어지지 않는 경우
- v
  - [ ] 공백인 경우
  - [ ] , 가 없는 경우
  - [ ] , 가 처음과 끝에 있는 경우
  - [ ] split 으로 나눈 배열의 크기가 6이 아닌 경우
  - [ ] 배열의 각 요소가 숫자가 아닌 경우
  - [ ] 배열의 각 요소가 1 이상 45 이하가 아닌 경우
  - [ ] 배열에서 중복된 요소가 있는 경우
- vii
  - [ ] 공백인 경우
  - [ ] 숫자가 아닌 경우
  - [ ] 1 이상 45 이하가 아닌 경우

 
## 💡 유의 사항
- 예외 발생 시 프로그램을 종료하는 것이 아닌 예외 발생 지점 재실행
- 소수점은 둘째 자리에서 반올림하여 첫째 자리까지만 출력 (100.0%, 51.5%)
- 예외 발생 시 [ERROR] 로 시작한 에러 문구 출력
- 예외 처리 시 Exception로 모든 예외를 처리하는 것이 아닌 상황에 맞는 예외 처리


## 🤔 설계 고민
- 사용자가 금액 또는 번호를 입력할 때 " 8000   " 이런 식으로 공백이 있는 입력을 했다면, trim() 사용해서 양 옆 공백을 제거할 것인지, 숫자에 공백이 포함되어 있으니 예외를 발생시킬지 + 중간에 공백이 포함된 경우 ("8 00   0  ")
- 당첨 번호를 입력받을 때 중복된 값을 처리해야 하기 때문에 HashSet ?
- 생성된 로또 저장 공간을 HashSet 과 List<>로 여러 로또 번호 저장
- 당첨 번호 요소가 로또 번호에 속하는지 구하는 방법
