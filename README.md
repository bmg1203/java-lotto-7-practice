# java-lotto-precourse

# 🎰 Lotto

간단한 로또 발매기 구현

## 기능 구현

### ⌨️ 입력

- [ ]  로또 구입 금액 입력
    - [x]  구입 금액은 1000원 단위로 입력 받는다
    - [x]  1000원 단위로 나뉘지 않는다면 예외처리
    - [x]  1000원 이하의 값이 입력되면 예외처리
    - [x]  정수가 아닌 값이 입력되면 예외처리
    - [x]  음수가 입력되면 예외처리
    - [x]  int의 범위를 넘어선 값이 들어오면 예외처리
- [ ]  당첨 번호 입력
    - [x]  6개의 당첨 번호를 입력 받는다
    - [x]  번호는 ,(쉼표)로 구분한다
    - [x]  번호가 중복되면 예외처리
    - [x]  번호가 1~45의 범위를 넘어서면 예외처리
    - [x]  번호의 개수가 6개가 아니라면 예외처리
    - [ ]  잘못된 구분자가 입력 되었다면 예외처리
    - [ ]  정수가 아닌 값이 입력 되었다면 예외처리
- [ ]  보너스 번호 입력
    - [x]  1개의 보너스 번호를 입력 받는다
    - [x]  번호가 1~45의 범위를 넘어서면 예외처리
    - [x]  정수가 아닌 값이 입력 되었다면 예외처리
    - [x]  앞서 입력된 당첨 번호와 중복된다면 예외처리

### 🔄 로직

- [x]  로또 생성
    - [x]  입력된 구입 금액에 해당하는 만큼 로또를 발행한다 (1장의 가격은 1000원)
- [x]  당첨번호와 입력 번호를 비교하여 당첨 여부 결정
    - [x]  3개 이상의 번호가 일치한다면 당첨
    - [x]  3개 미안의 번호가 일치한다면 탈락
- [x]  일치 번호 개수에 따른 당첨 등수 결정
    - [x]  1등: 6개 번호 일치
    - [x]  2등: 5개 번호 + 보너스 번호 일치
    - [x]  3등: 5개 번호 일치
    - [x]  4등: 4개 번호 일치
    - [x]  5등: 3개 번호 일치
- [x]  등수에 따른 당첨 금액 결정
    - [x]  1등: 2,000,000,000원
    - [x]  2등: 30,000,000원
    - [x]  3등: 1,500,000원
    - [x]  4등: 50,000원
    - [x]  5등: 5,000원
- [x]  총 당첨금을 계산한다
- [x]  구입 금액과 총 당첨금을 비교하여 수익률을 계산한다 (수익률은 소수점 둘째 자리에서 반올림)

### 💻 출력

- [x]  발행한 로또 수량 출력
- [x]  발행한 로또 번호를 오름차순으로 정렬하여 출력
- [x]  당첨 내역을 출력
- [x]  수익률을 출력

### ➕ 기타

- [ ]  에외처리가 되었다면 에러 메시지 출력 후 그 부분부터 입력을 다시 받는다

---