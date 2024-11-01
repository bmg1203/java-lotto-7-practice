# java-lotto-precourse

## 기능 구현 목록

### 구매 금액 입력 및 유효성 검사
- [ ] 구매 금액 입력 받기: 사용자가 입한 구매 금액을 받는다.
- [ ] 유효성 검사:
   - [ ] 구매 금액이 숫자인지 확인
   - [ ] `1,000`원 단위로 떨어지는지 확인
   - [ ] 유효하지 않는 값을 입력할 경우 `IllegalArgumentException`발생 후 "[ERROR]"로 시작하는 에러 메세지를 출력 후 재입력 요구
- [ ] 로또 발행 개수 계산: 구매 금액이 `1,000`원으로 나누어 발행할 로또 수 계산

### 로또 생성
- [x] 로또 생성:
   - [x] `1~45` 범위의 중복되지 않는 숫자 6개를 랜덤 번호 `6개` 생성
   - [x] 번호는 `오름차순`으로 정렬하여 저장
   - [x] 로또 번호 중복 발생시 `IllegalArgumentException` 발생 후 "[ERROR] 로또 번호는 중복될 수 없습니다." 에러 메세지 출력
   - [x] `티켓 수`만큼 로또 생성

### 로또 번호 출력
- [ ] 각 번호를 한 줄씩 출력

### 당첨 번호 및 보너스 번호 입력 받기
- [ ] 당첨 번호 입력 받기:
   - [ ] 쉼표(,)로 구분된 `6개`의 번호를 입력
   - [ ] 각 번호를 정수로 변환후 리스트에 저장
- [ ] 보너스 번호 입력 받기:
   - [ ] 추가로 보너스 번호를 `1개`를 입력받아 정수로 변환하여 저장
- [ ] 유효성 검사:
   - [ ] 각 번호가 `1~45`사이의 범위에 있는지 확인
   - [ ] 당첨 번호 중복 확인
   - [ ] 보너스 번호와 당첨 번호가 중복되는지 확인
   - [ ] 유효하지 않는 값을 입력할 경우 `IllegalArgumentException`발생 후 "[ERROR]"로 시작하는 에러 메세지 출력 후 재입력 요구

### 구매한 로또 번호와 당첨 번호 비교
- [ ] 일치하는 번호 수 계산:
   - [ ] 각 구매한 로또 번호에 당첨 번호와 일치하는 번호의 개수 확인
   - [ ] 로또 번호가 5개 맞췄을 경우 남은 로또 번호 중에 보너스 번호와 비교하여 일치하는 지 확인
- [ ] 등수 확인:
   - [ ] 일치하는 번호 개수와 보너스 번호 일치 여부에 따라 등수 판정
   - [ ] 판정 기준:
      - [ ] 1등: 6개 번호 일치(2,000,000,000원)
      - [ ] 2등: 5개 번호 + 보너스 번호 일치(30,000,000원)
      - [ ] 3등: 5개 번호 일치(1,500,000원)
      - [ ] 4등: 4개 번호 일치(50,000원)
      - [ ] 5등: 3개 번호 일치(5,000원)

### 당첨 통계 및 수익률 계산
- [ ] 당첨 결과 집계:
   - [ ] 각 등수에 해당하는 당첨 횟수를 카운트
   - [ ] 각 등수의 당첨 금액과 횟수를 곱하여 총 당첨금액 계산
- [ ] 수익률 계산:
   - [ ] 총 당첨 금액을 총 구매 금액으로 나누고, 백분율로 변환 후 `소수점 둘째 자리에서 반올림`