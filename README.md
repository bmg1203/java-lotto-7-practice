# 우테코 7기 프리코스 3주차 - 로또

## 프로그램 구조 떠올리기

1. 로또를 구입할 금액을 입력받는다
2. 당첨 번호를 입력받는다
3. 보너스 번호를 입력받는다
4. 발행한 로또 수량 및 번호를 출력한다.
   - 로또 번호는 오름차순으로 정렬하여 보여준다.
5. 당첨 내역을 출력한다.
6. 수익률은 소수점 둘째 자리에서 반올림하여 출력한다.

## 예외 상황 고려하기
- 로또 구입 금액이 양의 정수가 아닌경우 (공백, 문자, 음수 등)
- 로또 구입 금액이 1,000원으로 나누어 떨어지지 않는 경우
- 당첨 번호가 양의 정수가 아닌경우 (공백, 문자, 음수 등)
- 당첨 번호의 개수가 6보다 적거나 많은 경우
- 당첨 번호가 1~45 로또 범위를 벗어난경우
- 보너스 번호가 양의 정수가 아닌경우 (공백, 문자, 음수 등)
- 보너스 번호가 1~45 로또 범위를 벗어난경우


## 기능 목록 구분하기

- [X] 로또 구입 금액 입력받기

- [X] 로또 구입 금액 예외 상황 판단
  - 1,000원으로 나누어 떨어지지 않는 경우
  - 양의 정수가 아닌 경우

- [X] 당첨 번호 입력받기

- [X] 당첨 번호 예외 상황 판단
  - 로또의 개수가 6개보다 적거나 많은 경우
  - 양의 정수가 아닌 경우
  - 1~45 로또 범위를 벗어난 경우

- [X] 보너스 번호 입력받기

- [X]  보너스 번호 예외 상황 판단
  - 1~45 로또 범위를 벗어난 경우
  - 양의 정수가 아닌 경우

- [X] 발행한 로또 수량 및 번호를 출력
  - 로또를 오름차순으로 정렬

- [X] 당첨 내역 출력

- [X] 수익률 출력
  - 수익률을 소수점 둘째 자리에서 반올림