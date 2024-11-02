# java-lotto-precourse

# 예상 시나리오

1. 로또 구입 금액을 입력한다.
2. (구입 금액 / 1000)만큼 랜덤 숫자의 세트(세트당 6개)를 생성한다.
3. 세트별로 로또 번호를 오름차순으로 정렬하여 출력한다.
4. 당첨 번호를 입력한다.
5. 보너스 번호를 입력한다.
6. 생성한 랜덤 숫자 중에 당첨 번호, 보너스 번호가 있는지 확인하고 그 개수를 저장한다.
7. 당첨 통계를 출력한다.
    1. 3개 일치할 경우
    2. 4개 일치할 경우
    3. 5개 일치할 경우
    4. 5개, 보너스 볼 일치할 경우
    5. 6개 일치할 경우
8. 수익률을 출력한다.

### 예외 처리

1. 구입 금액 입력 시
    1. 0 혹은 음수를 입력한다.
    2. 입력값이 1,000원으로 나누어 떨어지지 않는다.
    3. 숫자가 아닌 문자를 입력한다.
2. 당첨 번호 입력 시
    1. 중복된 숫자를 입력한다.
    2. 숫자를 6개 미만 혹은 초과로 입력한다.
    3. 숫자와 구분자(,)가 아닌 문자를 입력한다.
    4. 1~45 범위 밖의 숫자를 입력한다.
3. 보너스 번호 입력 시
    1. 당첨 번호에서 이미 입력한 숫자를 입력한다.
    2. 숫자를 1개 미만 혹은 초과로 입력한다.
    3. 숫자가 아닌 문자를 입력한다.
    4. 1~45 범위 밖의 숫자를 입력한다.

# 구현 기능 목록

### 구입 금액을 입력 받는 기능

- [x]  “구입금액을 입력해 주세요.” 를 출력한다.
- [x]  int형 정수를 입력 받는다.
- [x]  입력값을 검증한다.
    - [x]  양수인가?
    - [x]  1000으로 나누어 떨어지는가?

### 로또 번호를 생성하는 기능

- [x]  로또 수량(구입 금액 / 1000)을 구한다.
- [x]  로또 수량만큼 반복한다.
    - [x]  6개의 랜덤 숫자를 생성한다.
    - [x]  오름차순으로 정렬하여 저장한다.

### 로또 번호를 출력하는 기능

- [ ]  “[로또 수량]개를 구매했습니다.”를 출력한다.
- [ ]  “[당첨 숫자 6개를 ,로 구분]” 를 로또 수량만큼 출력한다.

### 당첨 번호를 입력 받는 기능

- [x]  “당첨 번호를 입력해 주세요.” 를 출력한다.
- [x]  숫자 6개를 문자열로 입력 받는다.
- [x]  구분자(,)를 기준으로 문자열을 개별로 파싱한다.
- [x]  입력값을 검증한다.
    - [x]  입력받은 번호가 6개보다 적거나 많은가?
    - [x]  숫자 외의 문자가 포함되어 있는가?
    - [x]  1~45 사이의 숫자인가?
    - [x]  중복된 숫자가 있는가?
- [x]  오름차순으로 정렬한다.

### 보너스 번호를 입력 받는 기능

- [x]  “보너스 번호를 입력해 주세요.”를 출력한다.
- [x]  보너스 번호를 입력 받는다.
- [x]  입력값을 검증한다.
    - [x]  숫자 외의 문자가 포함되어 있는가?
    - [x]  1~45 사이의 숫자인가?
    - [x]  당첨 번호에서 이미 입력한 숫자인가?

### 사용자가 구매한 로또 번호와 당첨 번호+보너스 번호를 비교하는 기능

- [ ]  로또 수량만큼 반복한다.
    - [ ]  로또 번호와 당첨 번호를 비교하여 같은 숫자의 개수를 저장한다.
    - [ ]  로또 번호에 보너스 번호가 포함되어 있는지 확인하여 여부를 저장한다.
    - [ ]  1등~5등 당첨 횟수를 확인하고 저장한다.

### 당첨 통계를 출력하는 기능

- [ ]  “당첨 통계\n—-”를 출력한다.
- [ ]  내용을 출력한다.
    - [ ]  당첨 통계를 출력한다.
        - [ ]  5등 : “3개 일치 (5,000원) - [당첨 횟수]개”를 출력한다.
        - [ ]  4등 : “4개 일치 (50,000원) - [당첨 횟수]개”를 출력한다.
        - [ ]  3등 : “5개 일치 (1,500,000원) - [당첨 횟수]개”를 출력한다.
        - [ ]  2등 : “5개 일치, 보너스 볼 일치 (30,000,000원) - [당첨 횟수]개”를 출력한다.
        - [ ]  1등 : “6개 일치 (2,000,000,000원)  - [당첨 횟수]개”를 출력한다.

### 총 수익률을 출력하는 기능

- [ ]  sum(각 당첨 횟수 * 당첨금) / 구입 금액을 소수점 둘째 자리에서 반올림한 값을 수익률로 저장한다.
- [ ]  “총 수익률은 [수익률]%입니다.”를 출력한다.