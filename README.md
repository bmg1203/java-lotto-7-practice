# java-lotto-precourse

* 출력문 띄우는 기능
* 구입 금액 입력 받는 기능

  * 나누어 떨어지지 않을 때 예외 처리
  * 숫자가 아닌 것이 들어왔을 때 예외 처리
* 로또 당첨 번호를 입력 받는 기능

  * 숫자가 아닌 문자가 들어올 경우
  * 중복 검사
  * 숫자와 쉼표만 들어왔는데 입력이 잘못된 경우
    * ,,가 존재하는 경우
    * 숫자가 6개 이상으로 입력하였을 때
    * 숫자가 1부터 45이하가 아닌 경우
* 보너스 번호를 입력 받는 기능

  * 숫자가 아닌 문자가 들어올 경우
  * 숫자가 1부터 45이하가 아닌 경우
* 몇 개를 구매했는지 띄우는 기능
* 1개의 로또 생성하는 기능(이걸 N번 반복한다)

  1. 1부터 45 사이의 수 6개를 랜덤하게 뽑음
  2. 6개를 sorting
* N 개의 로또를 오름차순으로 띄우는 기능
* 하나의 로또가 몇개를 맞췄는지 계산하는 기능(로또 등수를 반환)

  * 1,2,3,4,5 등은 각각 6,5(+보너스),5,4,3개를 맞췄고, 6,7,8등은 각각 2,1,0개를 맞춤
* 당첨 내역 출력하는 기능
* 수익률 계산하는 기능
* 수익률 출력하는 기능
