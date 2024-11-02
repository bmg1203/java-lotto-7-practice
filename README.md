# java-lotto-precourse

## 📌기능 구현 목록

### 📝 입력

- [ ] 로또 구입 금액 입력받기 (1,000원 단위로 입력)
    - [X] 예외) 빈 값을 입력받는 경우
    - [ ] 예외) 문자를 포함하는 경우
    - [ ] 예외) 1,000으로 나누어떨어지지 않는 경우

- [ ] 당첨 번호 입력 (쉼표 기준으로 번호 구분)
    - [ ] 예외) 빈 값을 입력받는 경우

- [ ] 보너스 번호 입력
    - [ ] 예외) 빈 값을 입력받는 경우
    - [ ] 예외) 문자를 포함하는 경우
    - [ ] 예외) 숫자 범위가 1 ~ 45가 아닌 경우
    - [ ] 예외) 기존 당첨 번호와 중복된 경우

### 📝 로또 발행

- [ ] 1부터 45까지 랜덤으로 중복되지 않는 정수 6개 반환 -> 로또 구입한 개수만큼 반복
- [ ] 당첨 번호 로또 형태로 저장
    - [ ] 예외) 쉼표로 자른 후 문자가 포함된 경우 (음수, 소수도 포함)
    - [ ] 예외) 쉼표로 자른 후 공백이 포함된 경우
    - [ ] 예외) 숫자 범위가 1 ~ 45가 아닌 경우
    - [ ] 예외) 자른 숫자의 개수가 6개가 아닌 경우
    - [ ] 예외) 자른 숫자 중 중복이 있는 경우
- [ ] 발행된 로또 각각에 대해 일치하는 개수 구하기
- [ ] 1등부터 5등까지 각각 당첨된 개수 저장
- [ ] 총 당첨금 계산하기
- [ ] 총 수익률 계산하기

### 📝 출력

- [ ] 발행한 로또 수량 및 번호 출력 (오름차순 정렬)
- [ ] 당첨 내역 출력
- [ ] 수익률 출력 (소수점 둘째자리에서 반올림)
    - [ ] 예외) 출력 형식이 안 맞는 경우

