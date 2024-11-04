# java-lotto-precourse

# 프리코스 목표 설정

- **객체지향적인 설계를 생각해보자**
- **테스트 주도 개발(TDD)를 익혀보자**
- **리펙터링 습관화를 하자**

# 기능 목록

1. 구입 금액 입력
    - 아래 조건에 부합하지 않는다면, `IllegalArgumentException` 에러
        - 반드시 숫자만 입력 되어야 한다.
        - 최소 숫자가 4자리여야 한다.
        - 첫번째 글자는 1~9만 입력되어야 한다.
        - 두번째 글자부터는 0~9만 입력되어야 한다.
        - 1000으로 나누어 떨어져야 한다.
2. 당첨 번호 입력
    - 아래 조건에 부합하지 않는다면, `IllegalArgumentException` 에러
        - 반드시 숫자만 입력되어야 한다.
        - 1~45의 숫자만 입력되어야 한다.
        - 중복된 숫자를 입력할 수 없다.
3. 보너스 번호 입력
    - 아래 조건에 부합하지 않는다면, `IllegalArgumentException` 에러
        - 반드시 숫자만 입력되어야 한다.
        - 1~45의 숫자만 입력되어야 한다.
4. Lotto 자동 발급
    - 구입 금액 / 1000 개수 만큼 복권 생성
    - 각 복권 오름 차순 정렬
5. Lotto 당첨 여부
    - 발급 받은 복권 번호와 당첨 번호 비교
        - 복권 번호와 동일한 복권 개수가 5라면?
            - 보너스 번호 유무 판단
                - 보너스 번호가 있다면, 2등
                - 보너스 번호가 없다면, 3등
6. Lotto 당첨금 수익률
    - (당첨금 / 구입 금액) * 100 로직
    - 소수점 둘째자리에서 반올림 로직