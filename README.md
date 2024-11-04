# java-lotto-precourse

우선 간단하게 코딩을 하기 전 어떤 기능들을 구현해야 할지 적어보겠다.

우선 입력층부터 차례대로 구현해보면

1. 금액을 입력받는 메소드를 만든다.
2. 이 때 천원 단위로 떨어지는지 확인하는 메소드도 필요하다. 만약 천원 단위로 떨어지지 않으면 예외 처리를 한다.
3. 숫자인지 확인하는 메소드도 만든다.
4. 음수나 0이 아닌지 확인하는 메소드도 만든다.
5. 금액만큼의 로또 번호를 만들어야 한다. 그러니 로또 번호 생성기를 만든다. 이는 1부터 45까지의 숫자 중 6개를 출력해주는 메소드이다.
6. 이 로또 생성기를 이용해서 여러개의 로또 번호를 만든 다음에 저장한다.
7. 당첨번호와 추가 번호를 저장하는 클래스를 만든다.
8. 당첨 번호를 입력받는 메소드를 만든다.
9. 추가 번호를 입력 받아서 저장하는 메소드를 만든다.
10. 로또 번호와 당첨 번호, 추가 번호까지 있으니 등수를 계산해야 한다. 당첨내역을 계산하는 메소드를 만든다.
11. 당첨 내역에 따른 수익률을 계산하는 메소드를 만든다.
12. 출력층에서 로또 수량과 번호를 출력해주는 메소드를 만들고
13. 당첨 내역도 출력해주는 메소드를 만들고
14. 수익률을 출력해주는 메소드를 만든다.

우선 이를 기준으로 코딩한 다음 수정해야 될 부분이 있으면 수정하고 마지막으로 더 이상 리드미를 수정하지 않아도 되면 리드미를 수정하도록 하겠다.

