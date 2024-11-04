# java-lotto-precourse

## 기능 요구 사항

### 랜덤 번호 발매
+ Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickUniqueNumbersInRange()를 활용한다.

### 당첨금 지급

+ 당첨 번호와 로또 발행 번호 대조
+ 당첨 번호와 같을 시 당첨금 지급

### 입력

+ 로또 구입 금액 입력(1000단위로 입력)
+ 당첨 번호 입력 (쉼표를 기준으로 구분)
+ 보너스 번호 입력

### 출력

+ 발행한 로또 수량과 번호 출력(로또 번호는 오름차순으로 정렬)
+ 당첨 내역 출력
+ 수익률 소수점 둘째 자리에서 반올림

### 예외 처리

+ 로또 구입 금액이 1000단위가 아닐 시
+ 로또 당첨 번호 중복 숫자 입력 시
+ 당첨 번호 입력 숫자가 6개 초과거나, 6개가 아닐 시
+ 당첨 번호 입력 숫자 범위가 1~45가 아닐 시
