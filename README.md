# 💰 Lotto

## 기능 목록

- [X] 사용자로부터 로또 구입 금액을 입력받는다.
- [X] 구입 금액에 대한 유효성을 검증한다.
    - 양수가 입력되었는가
    - 1,000(로또 구매 금액 단위)으로 나누어 떨어지는가
    - 최대 구매가능 금액(1,000,000)을 초과하는가
- [X] 사용자가 잘못된 구입 금액을 입력한 경우, 에러 메시지를 출력한 뒤 최대 3번까지 재입력 받는다.
- [X] 로또 발행 수량을 출력한다.
- [X] 발행 수량만큼 로또를 발행한다. 이때, 로또는 아래 조건을 만족한다.
    - 로또는 중복되지 않는 6개의 숫자로 이루어진다.
    - 로또 번호의 숫자 범위는 1이상 45이하 이다.
- [ ] 발행한 로또 번호를 출력한다. 이때, 로또 번호는 오름 차순으로 정렬한다.
- [ ] 사용자로부터 당첨 번호를 입력받는다.
- [ ] 당첨 번호에 대한 유효성을 검증한다.
    - 쉼표로 구분되는 6개의 양수가 입력되었는가
    - 모든 양수가 로또 번호 범위(1이상 45이하) 안에 있는가
- [ ] 사용자가 잘못된 당첨 번호를 입력한 경우, 에러 메시지를 출력한 뒤 최대 3번까지 재입력 받는다.
- [ ] 사용자로부터 보너스 번호를 입력받는다.
- [ ] 보너스 번호에 대한 유효성을 검증한다.
    - 양수가 입력되었는가
    - 양수가 로또 번호 범위(1이상 45이하) 안에 있는가
    - 당첨 번호와 겹치지 않는가
- [ ] 사용자가 잘못된 보너스 번호를 입력한 경우, 에러 메시지를 출력한 뒤 최대 3번까지 재입력 받는다.
- [ ] 당첨 통계(당첨 내역, 수익률)를 계산한다.
- [ ] 당첨 내역을 정해진 형식에 따라 출력한다.
    - 형식
    - | 3개 일치 (5,000원) - a개             |
        |---------------------------------|
      | 4개 일치 (50,000원) - b개               |
      | 5개 일치 (1,500,000원) - c개            |
      | 5개 일치, 보너스 볼 일치 (30,000,000원) - d개 |
      | 6개 일치 (2,000,000,000원) - e개        |
- [ ] 수익률을 소수 둘째 자리에서 반올림하여 출력한다.