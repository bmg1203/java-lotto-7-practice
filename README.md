# java-lotto-precourse

- 기능
    - [ ] 로또 번호의 숫자 범위는 1~45까지
    - [ ] 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자
        - Randoms.pickUniqueNumbersInRange(1, 45, 6) 사용(중복 판별 필요 x)
    - [ ] 당첨은 1등부터 5등까지
        - 1등: 6개 번호 일치 / 2,000,000,000원
        - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
        - 3등: 5개 번호 일치 / 1,500,000원
        - 4등: 4개 번호 일치 / 50,000원
        - 5등: 3개 번호 일치 / 5,000원
    - [ ] 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행(로또 1장의 가격은 1,000원)
        - [ ] 구입 금액은 1000원 단위로 입력
        - [ ] 1000원으로 나누어 떨어지지 않는 경우 예외 처리를 위한 유효성 검사
    - [ ] 당첨 번호와 보너스 번호를 입력
        - [ ] 당첨 번호 유효성 검사
            - [ ] 중복 유효성 검사 
            - [ ] 숫자 판별 유효성 검사
            - [ ] 범위 판별 유효성 검사
        - [ ] 보너스 번호 유효성 검사
            - [ ] 숫자 판별 유효성 검사
            - [ ] 범위 판별 유효성 검사
    - 유효성 검사 메소드 종류
        - [ ] 숫자 여부 
        - [ ] 범위 판별
        - [ ] 중복 판별 
        - [ ] 1000원으로 나누어 떨어지는지 여부

- 입력
    - [ ] 로또 구입 금액을 입력, 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리
    - [ ] 당첨 번호를 입력, 번호는 쉼표(,)를 기준으로 구분
    - [ ] 보너스 번호를 입력

- 출력
    - [ ] 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료
        - [ ] 당첨 내역 출력
        - [ ] 수익률 출력

- 예외
    - [ ] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    - [ ] Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형


