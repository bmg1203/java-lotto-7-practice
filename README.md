# java-lotto-precourse

## 프로젝트 소개

- 제목: 로또 게임 프로젝트
- 세부 내용: 사용자로부터 로또 구입 금액과 당첨 번호를 입력받아 당첨 통계를 출력하는 게임

## 기능 명세

- [x] 로또 구입 금액 입력받기
    - [ ] 1,000원 단위로 입력받기
- [x] 해당 금액만큼 로또 발행
    - [x] 1장 가격: 1,000원
    - [x] 로또 번호 범위: 1~45
    - [x] 1개 로또 발행 시, 중복되지 않는 6개의 숫자 뽑기
- [x] 구매 내역 출력하기
    - [x] 오름차순으로 정렬하여 출역한다
- [x] 당첨 번호 입력 받기
    - [x] 쉼표를 기준으로 구분 (ex. 1,2,3,4,5,6)
- [x] 보너스 번호를 입력 받기
- [x] 사용자가 구매한 로또 번호와 당첨 번호 비교
    - 당첨 기준 / 금액
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
- [x] 수익률 계산
- [x] 당첨 통계 출력
    - [x] 당첨 내역 출력
    - [x] 수익률 출력
        - [x] 소수점 둘째 자리에서 반올림해 출력
- [x] 로또 게임 종료

## 예외 처리 방법

- [ ] 사용자가 잘못된 값을 입력할 경우
    - [ ] IllegalArgumentException를 발생시킨다.
        - [ ] Exception이 아닌, IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형 처리를 한다.
    - [ ] '[ERROR]'로 시작하는 에러 메시지를 출력한다.
    - [ ] 해당 부분부터 다시 입력을 받는다.

## 예외 처리가 필요한 상황

- [x] 구입 금액 입력에 숫자가 아닌 문자를 입력했을 경우
- [ ] 로또 구입액이 1,000원 단위로 나눠 떨이지지 않는 경우
- [ ] 당첨 번호를 6개 입력하지 않았을 경우
- [ ] 중복된 당첨번호를 입력한 경우
- [ ] 당첨 번호 입력에 숫자가 아닌 문자를 입력했을 경우
- [ ] 입력한 당첨 번호가 1~45 사이가 아닌 경우
- [ ] 보너스 번호 입력에 숫자가 아닌 문자를 입력했을 경우
- [ ] 입력한 보너스 번호가 1~45 사이가 아닌 경우
- [ ] 입력한 보너스 번호가 당첨 번호와 중복된 경우