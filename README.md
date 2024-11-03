# 학습 목표

> 관련 함수를 묶어 클래스를 만들고, 객체들이 협력하여 하나의 큰 기능을 수행하도록 한다.

> 클래스와 함수에 대한 단위 테스트를 통해 의도한 대로 정확하게 작동하는 영역을 확보한다.

- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다.
- 3항 연산자를 쓰지 않는다.
- <h4>🔥 함수(또는 메서드)가 `한 가지 일`만 하도록 최대한 작게 만들어라.</h4>
    - 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다
    - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
    - else 예약어를 쓰지 않는다.
    - Java Enum을 적용하여 프로그램을 구현한다.
    - 구현한 기능에 대한 단위 테스트를 작성한다.
        - 단, UI(System.out, System.in, Scanner) 로직은 제외한다.

- 처음부터 큰 단위의 테스트를 만들지 않는다
- JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.

---

# 개인 목표

- 함수 8줄 이내 작성. 메서드와 기능 1:1 매치가 되게 노력하자.

---

# java-lotto-precourse 기능 목록서

# 핵심 기능

## 1. 공용

| 도메인                  | 기능          | 세부 기능              | 상태 |
|----------------------|-------------|--------------------|----|
| Common(ThousandWons) | 천원 단위 금액 생성 | 정상적인 천원 단위 금액 생성   | ✅  |
|                      |             | 천원 단위가 아닌 금액 검증    | ✅  |
|                      |             | 음수,0 금액 검증         | ✅  |
|                      |             | 숫자가 아닌 입력값 검증      | ✅  |
|                      | 금액 비교       | 목표 금액보다 크거나 같은지 확인 | ✅  |
|                      |             | 목표 금액보다 작은지 확인     | ✅  |
|                      | 금액 나누기      | 나누어 떨어지는 경우 처리     | ✅  |
|                      |             | 나누어 떨어지지 않는 경우 처리  | ✅  |

## 2. 결제

| 도메인         | 기능                      | 세부 기능              | 상태 |
|-------------|-------------------------|--------------------|----|
| Payment 도메인 | 로또 가격(LottoPrice) 관리    | 기본 가격(1000원)으로 생성  | ✅  |
|             |                         | 구매 가능한 금액 검증       | ✅  |
|             |                         | 천원 단위 금액으로 검증      | ✅  |
|             |                         | 구매 가능 수량 계산        | ✅  |
|             | 로또 수량(LottoQuantity) 관리 | 유효한 수량(1~100) 생성   | ✅  |
|             |                         | 최소/최대 수량(1~100) 검증 | ✅  |
|             |                         | 수량값 조회             | ✅  |
|             | 결제(Payment) 처리          | 결제 정보 초기화          | ✅  |
|             |                         | 결제 가능 여부 검증        | ✅  |
|             |                         | 중복 검증 방지           | ✅  |
|             |                         | 결제 실행              | ✅  |
|             |                         | 중복 실행 방지           | ✅  |
|             |                         | 로또 수량 계산           | ✅  |
|             | 결제 결과(PaymentResult) 관리 | 결제 결과 생성           | ✅  |
|             |                         | 완료된 결제 정보 조회       | ✅  |

## 로또 티켓

| 도메인        | 기능               | 세부 기능          | 상태 |
|------------|------------------|----------------|----|
| Ticket 도메인 | 로또(Lotto) 관리     | 6개의 번호로 로또 생성  | ✅  |
|            |                  | 번호 범위 검증(1~45) | ✅  |
|            |                  | 번호 개수 검증(6개)   | ✅  |
|            |                  | 중복 번호 검증       | ✅  |
|            | 로또 목록(Lottos) 관리 | 유효한 로또 목록 생성   | ✅  |
|            |                  | null 로또 목록 검증  | ✅  |
|            |                  | 빈 로또 목록 검증     | ✅  |
|            |                  | 로또 목록 불변성 보장   | ✅  |
|            | 티켓(Ticket) 관리    | 티켓 발행          | ✅  |
|            |                  | ID와 로또 목록으로 생성 | ✅  |
|            |                  | null ID 검증     | ✅  |
|            |                  | null 로또 목록 검증  | ✅  |
|            | 티켓 정보 조회         | 티켓 ID 조회       | ✅  |
|            |                  | 로또 목록 조회       | ✅  |

## 3. 당첨

| 도메인       | 기능                     | 세부 기능                     | 상태 |
|-----------|------------------------|---------------------------|----|
| Prize 도메인 | 당첨 번호(PrizeNumber) 관리  | Lotto 객체로 당첨 번호 설정        | ⬜️ |
|           |                        | BonusNumber 객체로 보너스 번호 설정 | ⬜️ |
|           |                        | 당첨 번호와 보너스 번호 조회          | ⬜️ |
|           | 보너스 번호(BonusNumber) 관리 | 보너스 번호 생성                 | ⬜️ |
|           |                        | 보너스 번호 범위 검증(1~45)        | ⬜️ |
|           |                        | 당첨 번호와의 중복 검증             | ⬜️ |

---

## 4. 통계

| 도메인            | 기능       | 세부 기능                | 상태 |
|----------------|----------|----------------------|----|
| Statistics 도메인 | 당첨 결과 계산 | 구매한 로또와 당첨번호 비교      | ⬜️ |
|                |          | 일치하는 번호 개수 확인        | ⬜️ |
|                |          | 보너스 번호 일치 여부 확인      | ⬜️ |
|                | 당첨 등수 관리 | 1등(6개 일치) 확인         | ⬜️ |
|                |          | 2등(5개+보너스) 확인        | ⬜️ |
|                |          | 3등(5개) 확인            | ⬜️ |
|                |          | 4등(4개) 확인            | ⬜️ |
|                |          | 5등(3개) 확인            | ⬜️ |
|                | 당첨금 계산   | 등수별 당첨금액 계산          | ⬜️ |
|                |          | 총 당첨금액 계산            | ⬜️ |
|                | 수익률 계산   | 수익률 계산(소수점 둘째자리 반올림) | ⬜️ |
|                | 통계 정보 관리 | 당첨 통계 생성             | ⬜️ |
|                |          | 당첨 통계 조회             | ⬜️ |
|                |          | 등수별 당첨 내역 포맷팅        | ⬜️ |

---

# View

## 1. 티켓 입출력

| 영역          | 기능       | 세부 기능                  | 상태 |
|-------------|----------|------------------------|----|
| Ticket View | 구매 금액 입력 | 콘솔에 구매 금액 입력 안내 메시지 출력 | ✅  |
|             |          | 금액 문자열 입력 받기           | ✅  |
|             |          | ThousandWons 객체로 변환    | ✅  |
|             | 구매 결과 출력 | 구매한 로또 수량 메시지 포맷팅      | ✅  |
|             |          | 구매 수량 출력               | ✅  |
|             |          | 로또 번호 목록 포맷팅           | ✅  |
|             |          | 각 로또 번호 출력             | ✅  |
|             | 출력 포맷 관리 | 구매 메시지 형식 지정           | ✅  |
|             |          | 로또 번호 형식 지정            | ✅  |
|             | 출력 처리    | 메시지 라인 추가              | ✅  |
|             |          | 최종 출력 실행               | ✅  |

# 2. 당첨 입출력

| 영역         | 기능        | 세부 기능                   | 상태 |
|------------|-----------|-------------------------|----|
| Prize View | 당첨 번호 입력  | 콘솔에 당첨 번호 입력 안내 메시지 출력  | ⬜  |
|            |           | 쉼표로 구분된 당첨 번호 입력 받기     | ⬜  |
|            |           | 입력값 공백 제거               | ⬜  |
|            |           | 숫자 리스트로 변환              | ⬜  |
|            | 보너스 번호 입력 | 콘솔에 보너스 번호 입력 안내 메시지 출력 | ⬜  |
|            |           | 보너스 번호 입력 받기            | ⬜  |
|            |           | 입력값 공백 제거               | ⬜  |
|            |           | 숫자로 변환                  | ⬜  |
|            | 입력값 전달    | 당첨 번호와 보너스 번호를 DTO로 변환  | ⬜  |

# 3. 통계 입출력

| 영역              | 기능       | 세부 기능                              | 상태 |
|-----------------|----------|------------------------------------|----|
| Statistics View | 당첨 통계 출력 | 당첨 통계 시작 구분선 출력 ("---")            | ⬜️ |
|                 |          | 당첨 통계 제목 출력                        | ⬜️ |
|                 | 당첨 내역 출력 | 3개 일치 (5,000원) - n개                | ⬜️ |
|                 |          | 4개 일치 (50,000원) - n개               | ⬜️ |
|                 |          | 5개 일치 (1,500,000원) - n개            | ⬜️ |
|                 |          | 5개 일치, 보너스 볼 일치 (30,000,000원) - n개 | ⬜️ |
|                 |          | 6개 일치 (2,000,000,000원) - n개        | ⬜️ |
|                 | 수익률 출력   | 총 수익률 계산 결과 포맷팅                    | ⬜️ |
|                 |          | 수익률 메시지 출력 (소수점 둘째자리까지)            | ⬜️ |
|                 | 출력 포맷 관리 | 당첨 내역별 메시지 형식 지정                   | ⬜️ |
|                 |          | 수익률 형식 지정                          | ⬜️ |
|                 | 출력 처리    | 메시지 라인 추가                          | ⬜️ |
|                 |          | 최종 출력 실행                           | ⬜️ |

---

# 유틸 기능

| 영역              | 기능        | 세부 기능                 | 상태 |
|-----------------|-----------|-----------------------|----|
| StringConverter | 문자열 trim  | 문자열 앞뒤 공백 제거          | ⬜  |
|                 |           | null 값 검증             | ⬜  |
|                 |           | 빈 문자열 검증              | ⬜  |
|                 |           | 공백 문자열 검증             | ⬜  |
|                 | 문자열 split | 쉼표로 문자열 분리            | ⬜  |
|                 |           | null 값 검증             | ⬜  |
|                 |           | 빈 문자열 검증              | ⬜  |
|                 |           | 공백 문자열 검증             | ⬜  |
|                 | 정수 리스트 변환 | 숫자 문자열 배열을 정수 리스트로 변환 | ⬜  |
|                 |           | 숫자가 아닌 문자열 검증         | ⬜  |
|                 |           | 빈 문자열 포함 검증           | ⬜  |

# 로또 발매기(LottoTicketMachine)

- 컨트롤러간의 흐름 제어를 한다.

## 📌 컨트롤러

### WinnerNumberController (당첨 번호 컨트롤러)

- InputView - 당첨 번호를 입력해 주세요.
- InputView - 보너스 번호를 입력해 주세요.
- CreateWinnerNumberUsecase - 당첨 번호를 생성하라.
- GetWinnerNumberUsecase - 당첨 번호를 조회하라.

```java
InputView-당첨 번호를 입력해 주세요.
        InputView-보너스 번호를 입력해 주세요.

        Long winNumId=CreateWinnerNumberUsecase.execute(
        List<Integer> winnerNumber,
        int bonus);

        WinnerNumber winnerNumber=GetWinnerNumberUsecase().execute(Long winNumId);
```

### WinnerStatisticsController (당첨 통계 컨트롤러)

- InputView - 당첨 통계
- InputView - ---
- CreateWinnerStatisticsUsecase - 당첨 통계를 생성하라
- GetWinnerStatisticsUsecase - 당첨 통계를 조회하라
- OutputView - {당첨 통계 결과}

```java
InputView-당첨 통계
        InputView- ---

        Long winnerStatisticsId=CreateWinnerStatisticsUsecase.execute(lottos,winnerNumber);
        WinnerStasticsResult winStatistics=GetWinnerStatisticsUsecase.execute(Long id);

        OutputView-{당첨 통계 결과}
```

---

## 📌 유스케이스

- CreateWinnerNumberUsecase - 당첨 번호를 생성하라.
- GetWinnerNumberUsecase - 당첨 번호를 조회하라.


- CreateWinnerStatisticsUsecase - 당첨 통계를 생성하라
- GetWinnerStatisticsUsecase - 당첨 통계를 조회하라

### CreateWinnerNumberUsecase - 당첨 번호를 생성하라.

- WinnerNumberService - 당첨 번호를 생성하라

```java
Long winNumId=WinnerNumberService.generate(List<Integer> numbers,int bonus);
```

### GetWinnerNumberUsecase - 당첨 번호를 조회하라.

- WinnerNumberService - 당첨 번호를 조회하라

```java
WinnerNumber winnerNumber=WinnerNumber.getById(Long winNumId);
```

### CreateWinnerStatisticsUsecase - 당첨 통계를 생성하라

- WinnerStatisticsService - 당첨 통계를 내라

```java
Long winStatisticsId=WinnerStatistics.compile(LottoTicket lottoTicket,WinnerNumber winNum);
```

### GetWinnerStatisticsUsecase - 당첨 통계를 조회하라

- WinnerStatisticsService - 당첨 통계를 조회하라

```java
WinnerStatistics winStatistics=WinnerStatistics.getById(Long winStatisticsId);
```

---

# 📌 서비스

### WinnerNumberService - 생성하라

- WinnerNumber - 생성하라
- WinnerRepository - 저장하라

```java
Lotto winLotto=Lotto.of(List<Integer> numbers);
        WinnerNumber winNum=WinnerNumber.of(Lotto lotto,int bonus);
        Long savedId=WinnerRepository.save(winNum);
```

### WinnerNumberService - 조회하라

- WinnerNumberRepository - 조회하라

```java
WinnerNumber winNum=WinnerNumberRepository.getById(Long winNumId);
```

### WinnerStatisticsService - 당첨 통계를 생성하라

- WinnerStatistics - 컴파일 하라
- WinnerStatisticsRepository - 저장하라

```java
WinnerStatiscis winStatistics=WinnerStatistics.compile(LottoTicket lottoTicket,WinnerNumber winNum);
        Long savedId=WinnerStatisticsRepository.save(winStatistics);
```

### WinnerStatisticsService - 당첨 통계를 조회하라

- WinnerStatisticsRepository - 조회하라

```java
WinnerStatistics winStatistics=WinnerStatisticsRepository.getById(Long winStatisticsId);
```

---

# 📌 도메인

- WinnerNumber - 생성하라
    - 당첨 번호를 생성한다.
    - 중복되지 않는 숫자 6개와 보너스 번호 1개가 있다.


- WinnerStatistics - 컴파일하라
    - 당첨 등수 정의 (Enum)
        - FIRST(6, 2_000_000_000, "6개 일치")
        - SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치")
        - THIRD(5, 1_500_000, "5개 일치")
        - FOURTH(4, 50_000, "4개 일치")
        - FIFTH(3, 5_000, "3개 일치")
        - NONE(0, 0, "미당첨")

    - 당첨 결과 집계하기
        - 구매한 각 로또와 당첨번호를 비교
        - 일치하는 번호 개수 확인
        - 보너스 번호 일치 여부 확인
        - 당첨 등수별 개수 집계

    - 당첨금 계산하기
        - 등수별 당첨금액 계산
        - 총 당첨금액 계산

    - 수익률 계산하기
        - 구매 금액 대비 당첨금 비율 계산
        - 소수점 둘째자리에서 반올림

    - 통계 조회 결과 제공하기
        - 등수별 당첨 내역 포맷팅
        - 전체 통계 결과를 포맷에 맞게 조합
