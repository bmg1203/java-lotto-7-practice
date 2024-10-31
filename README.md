# java-lotto-precourse

# 🎱 로또 미션 구현 할 기능 목록

- [x] 입력을 담당하는 객체
    - 구입금액을 입력받는다.
        - null 혹은 비어있는 경우 -> 예외
    - 당첨 번호를 입력받는다.
        - null 혹은 비어있는 경우 -> 예외
    - 보너스 번호를 입력받는다.
        - null 혹은 비어있는 경우 -> 예외

- [x] 출력을 담당하는 객체
    - 구매 개수와 구매된 로또 출력
    - 당첨 통계 출력
    - 총 수익률 출력

- [x] 구입 금액을 가지는 객체
    - 음수나 0인 경우 -> 예외
    - 1000원 단위 금액이 아닌 경우 -> 예외
    - int 값을 벗어나는 경우 -> 예외

- [ ] 입력된 로또 번호 파싱
    - ','를 기준으로 나눈다.
    - 변환했을 때 숫자가 아닌 경우 -> 예외
    - 숫자가 1에서 45 사이의 정수가 아닌 경우 -> 예외
    - 중복된 숫자가 있는 경우 -> 예외
    - 6개의 숫자가 아닌 경우 -> 예외

- [x] 보너스 번호 객체
    - 숫자가 아닌 경우 -> 예외
    - 정수 범위를 넘어가는 경우 -> 예외
    - 1에서 45 사이의 정수가 아닌 경우 -> 예외
    - 이미 입력된 로또 번호에 동일한 번호가 있는 경우 -> 재입력? 예외?

- [ ] 입력된 로또 번호와 보너스 번호를 가지는 당첨 객체
    - 입력된 로또 번호와 보너스 번호를 가진다.
    - 로또 번호를 입력받아 일치하는 로또 개수와 보너스 번호 개수를 반환한다.

- [ ] 일치하는 로또 개수와 보너스 번호 개수 객체

- [x] 구매한 로또들을 가지는 객체
    - 구입 금액을 입력받아 수량에 맞게 로또를 생성하는 역할을 가진다.

- [x] 로또 번호 6개를 관리하는 객체
    - 오름차순으로 정렬된 값을 가진다.
    - 다른 로또와 일치하는 번호 갯수를 반환하는 기능
    - 로또 번호 중 보너스 번호와 일치하는 번호가 있는지 확인하는 기능

- [x] 랜덤한 숫자 생성기
    - 1 에서 45 사이의 정수
    - 중복되지 않은 6개의 숫자 리스트

- [ ] 당첨 기준을 관리하는 객체
    - 일치하는 로또 개수와 보너스 번호 개수를 받아 등수를 반환한다.
    - 등수가 몇개 나왔는지는 어디에 저장하지??

- [ ] 당첨 통계를 가지는 객체
    - 1등, 2등, 3등, 4등, 5등

- [ ] 수익률을 계산하는 객체
    - 전체 등수 정보를 받아 값을 계산해 수익률을 계산한다.
    - 수익률은 소수점 둘째 자리에서 반올림한다.
    - 수익률 = 수익률 / 투자 비용 * 100

- [x] 예외가 발생했을 때 잡아서 요청을 다시 받는 것을 도와주는 객체
