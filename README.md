# java-lotto-precourse
## 구현 기능 목록
- [x] 구입 금액을 입력해 주세요. 출력
- [x] 구입 금액 입력 받기
    - [x] 입력 받은 것이 빈 문자열 아니다.
    - [x] 유효한 숫자인지 검증(예외 메시지 출력 후 다시 입력)
    - [x] 1000원 단위로 입력 받았는지 검증(예외 메시지 출력 후 다시 입력)
- [ ] %d개를 구매했습니다. 출력
- [ ] 입력 받은 금액 만큼 로또 번호 생성하기
    - [ ] 발행할 로또 수량 계산하기
    - [ ] 6개의 숫자를 랜덤으로 생성하기
        - [ ] 1 ~ 45의 범위의 중복되지 않는 숫자
    - [ ] 발행한 로또를 저장할 구조 생성하기
    - [ ] 생성한 로또를 출력하기

- [ ] 당첨 번호를 입력해 주세요. 출력
- [ ] 당첨 번호 입력 받기
    - [ ] 빈 문자열 아니다.
    - [ ] 번호 개수 6개인지
    - [ ] 1 ~ 45의 범위의 중복되지 않는 숫자
- [ ] 보너스 번호를 입력해 주세요. 출력
- [ ] 보너스 번호 입력 받기
    - [ ] 빈 문자열 아니다.
    - [ ] 입력 받은 것이 번호 1개인지
    - [ ] 1 ~ 45의 범위의 숫자인지
    - [ ] 당첨 번호와 중복이 아닌지

- [ ] 발행된 로또를 통해 당첨 금액을 확인 후 수익률 계산
    - [ ] 당첨 기준에 맞게 당첨번호와 비교
    - [ ] 등수에 맞게 당첨 금액을 더해 총 당첨 금액 계산
    - [ ] 당첨금액 / 구입금액 * 100 을 통해 수익률 계산
        - [ ] 소수점 둘째 자리에서 반올림

- [ ] 당첨 내역, 수익률 출력
    - [ ] 당첨 통계 \n --- 출력
    - [ ] 당첨 내역을 출력한다.
    - [ ] 수익률을 출력한다.