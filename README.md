# java-lotto-precourse

# 구현할 기능 목록
- Model
    - [ ] 로또 생성기
        - [x] 6개의 서로 다른 로또 번호를 가지는 로또 생성
        - [ ] 당첨 로또 생성
    - [x] 로또 묶음
        - [x] 구입 금액의 개수만큼 로또 생성
    - [x] 구입금액
        - [x] 구입금액이 1000으로 나누어 떨어지지 않을 시, 예외 처리
        - [x] 구입금액이 0 이하일 시, 예외 처리
    - [x] 로또
        - [x] 로또 번호 리스트의 크기가 6이 아닐 시, 예외 처리
    - [x] 로또 번호
        - [x] 번호의 범위가 [1,  45]가 아닐 시, 예외 처리
    - [x] 구매 로또 결과 출력 생성기
        - [x] 로또 번호를 2차원 문자열 리스트로 변환
    - [ ] 당첨 정보 로또
        - [ ] 로또 추첨
        - [ ] 수익률 계산
- View
    - [ ] 입력
        - [x] 구입금액 입력
        - [ ] 당첨 관련 번호 입력
            - [ ] 숫자가 아닐 시, 예외 처리
    - [ ] 출력
        - [ ] 로또 수량 및 번호 출력
        - [ ] 당첨 내역 및 수익률 출력
- Controller
    - [ ] 로또 (간단한 로또 발매기)
    - [ ] 로또 생성
    - [ ] 로또 추첨
- Test
    - [ ] 로또 생성기 테스트
        - [ ] 생성된 로또의 로또 번호가 6개인지 테스트
        - [ ] 생성된 로또의 로또 번호가 서로 다른지 테스트
    - [ ] 로또 묶음
        - [ ] 구입 금액의 개수만큼 로또를 생성하는지 테스트
    - [x] 구입금액
        - [x] 1000으로 나누어 떨어지면서 구입금액이 1000원을 넘는지 테스트
        - [x] 구입금액이 1000으로 나누어 떨어지지 않을 시, 예외 처리되는지 테스트
        - [x] 구입금액이 0 이하일 시, 예외 처리되는 지 테스트
    - [ ] 로또
        - [ ] 로또 생성 테스트
        - [ ] 로또 번호 리스트의 크기가 6이 아닐 시, 예외 처리되는지 테스트
    - [ ] 로또 번호
        - [ ] 번호의 범위가 [1, 45]일 때, 생성되는지 테스트
        - [ ] 번호의 범위가 [1,  45]가 아닐 시, 예외 처리되는지 테스트
    - [ ] 당첨 정보 로또
        - [ ] 로또 추첨 테스트 (등수마다)
        - [ ] 수익률 계산 테스트

# 기능 동작 순서
1. 구입금액 입력 메세지를 출력한다.
2. 구입금액을 입력받는다.
    - 숫자가 아니라면 예외를 터뜨리고 2로 돌아간다.
3. 구입금액을 검증한다.
    - 1000으로 나누어 떨어지지 않는다면 예외를 터뜨리고 2로 돌아간다.
4. 로또 개수만큼 로또 객체를 생성한다.
5. 발행한 로또 수량 및 번호를 출력한다.
6. 당첨 번호 입력 메세지를 출력한다.
7. 당첨 번호를 입력받는다.
    - ,를 기준으로 분리한다.
    - 번호가 숫자가 아니라면 예외를 터뜨리고 7로 돌아간다.
8. 당첨 번호를 검증한다.
    - 번호가 1 미만 또는 45 초과라면 예외를 터뜨리고 7로 돌아간다.
    - 번호의 개수가 6개가 아니라면 예외를 터뜨리고 7로 돌아간다.
9. 보너스 번호 입력 메세지를 출력한다.
10. 보너스 번호를 입력받는다.
    - 번호가 숫자가 아니라면 예외를 터뜨리고 7로 돌아간다.
11. 보너스 번호를 검증한다.
    - 번호가 1 미만 또는 45 초과라면 예외를 터뜨리고 7로 돌아간다.
12. 당첨 번호를 토대로 로또를 추첨한다.
13. 수익률을 계산한다.
    - 수익률은 소수점 둘째 자리에서 반올림한다.
14. 당첨 통계 메시지를 출력한다.
15. 당첨 내역을 출력한다.
16. 총 수익률을 출력한다.