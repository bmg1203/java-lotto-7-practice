# 로또

### 체크포인트

- [x] 로또 숫자 범위 상수화
- [x] 당첨 금액 상수화
- [x] 입력
  - [x] 로또 구입 금액에 따른 로또 발행
  - [x] 로또 1장 가격 상수화
  - [x] 당첨 번호 입력
  - [x] 보너스 번호 입력
- [x] 출력
  - [x] 당첨 내역, 수익률 출력
- [x] 로또 객체
  - [x] 로또 번호를 오름차순으로 저장
- [x] 예외 처리
  - [x] 잘못된 값 입력


<br>


### 풀이 방향

문제의 조건을 위에서 부터 차례대로 만들어가면서 생각나는 대로 만든 후

리팩토링을 통해서 정돈할 생각.

1. 로또 범위, 상금과 같은 상수는 enum 으로 모두 관리

   (enum 에서 _ 사용해도 되었나?)
2. 필요한 객체라 생각되는 것들

    > 로또(객체), 로또번호 생성기, 내가 가지고 있을 로또 용지들, 당첨 결과 계산 할 객체
3. 로또 머신에서 랜덤 볼들을 받아서 `MyLotto` 에 채워 넣음
4. 당첨 결과를 계산하고 그 정보를 저장


### 고민 사항, 생각해볼 점

고민 1

로또를 몇가지 자동 번호를 통해서 만들었을때 그 로또 번호들을 어디에 저장해야 할지? -> 로또 머신에서 번호를 발행하고 모두 저장?

결론

최대한 작은 단위로 나누는게 정답일 것 같아서 `[로또 머신]`, `[나의 로또 현황]`, `[하나의 로또]` 로 나누기로 결정


<br>

고민2

`MyLotto` 클래스 안에 로또 용지의 정보와 당첨번호를 저장한다고 할때, 당첨 결과도 저장해야 하는가?, 너무 객체가 커지지 않나? 

결론

실생활로 생각해봤을때 '나' 가 로또 용지를 가지고 있고 당첨 번호를 확인하고 결과를 내가 예측하기에 결과 연산도 `MyLotto` 안에서 이루어지고 결과도 저장하도록 결정


