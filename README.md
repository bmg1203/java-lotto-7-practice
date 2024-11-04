# java-lotto-precourse

## 📁 패키지 목록

```markdown
├── main/
│ ├── java/
│ │ ├── lotto/
│ │ │ ├── view/
│ │ │ │ ├── Input/
│ │ │ │ ├── InputView.java
│ │ │ │ └── InputProcessor.java
│ │ │ │ ├── Output/
│ │ │ │ └── OutputView.java
│ │ │ ├── domain/
│ │ │ │ ├── number/
│ │ │ │ ├── BonusNumber.java
│ │ │ │ ├── WinningNumbers.java
│ │ │ │ └── WinningLottoNumbers.java
│ │ │ │ ├── result/
│ │ │ │ ├── LottoResult.java
│ │ │ │ └── WinningStatistics.java
│ │ │ ├── Lotto.java
│ │ │ ├── LottoRank.java
│ │ │ └── PurchaseAmount.java
│ │ │ ├── service/
│ │ │ └── LottoService.java
│ │ │ ├── constants/
│ │ │ └── ErrorMessage.java
│ │ │ ├── generator/
│ │ │ ├── LottoNumberGenerator.java
│ │ │ └── RandomLottoGenerator.java
│ │ │ ├── controller/
│ │ │ └── LottoController.java
│ │ └── Application.java

```

## 🚀 기능 구현 목록

- [x] 구입 금액 입력
    - [x] 구입 금액 검증
    - [x] 구입 금액에 따른 로또 발급
    - [x] 발행된 로또 번호 출력


- [x] 당첨 번호 6개 입력
    - [x] 당첨 번호 검증
- [x] 보너스 번호 입력
    - [x] 보너스 번호 검증


- [x] 발행된 로또 번호와 당첨 번호 비교
- [x] 당첨 등수별 내역 집계
- [x] 수익률 계산


- [x] 입력값 형식 검증
    - [x] 입력값 숫자 검증
    - [x] 입력값 금액 0 또는 음수 검증
    - [x] 구매단위 검증
    - [x] 값 범위 검증

- [x] 로또 생성 검증
    - [x] 로또 번호 범위 검증
    - [x] 중복 번호 검증
    - [x] 금액에 맞는 로또 생성
    - [x] 로또 오름차순 생성

## 🎯 프로그래밍 요구사항

### 프로그래밍 제약사항

- JDK 21 사용
- Application의 main()에서 시작
- System.exit() 사용 금지
- build.gradle 파일 변경 금지
- 외부 라이브러리 사용 금지
- 파일/패키지 이름 변경 및 이동 제한

### 코드 작성 규칙

- indent depth 최대 2까지 허용
- 3항 연산자 사용 금지
- else 예약어 사용 금지 (switch/case 포함)
- 함수는 한 가지 기능만 수행
- 함수 길이 15라인 이내
- Java Enum 사용
- Java 코드 컨벤션 준수

### 사용할 라이브러리

1. 필수 라이브러리

- camp.nextstep.edu.missionutils.Randoms
- camp.nextstep.edu.missionutils.Console


2. 테스트 라이브러리

- JUnit 5
- AssertJ

## 📋 실행 결과 예시

```markdown
구입금액을 입력해 주세요.
4000
4개를 구매했습니다.
[7, 9, 22, 27, 35, 45]
[4, 13, 15, 24, 29, 32]
[3, 10, 23, 27, 29, 38]
[2, 4, 6, 9, 19, 29]
당첨 번호를 입력해 주세요.
2,3,6,9,29,38
보너스 번호를 입력해 주세요.
19

당첨 통계
---
6개 일치 (2,000,000,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
5개 일치 (1,500,000원) - 0개
4개 일치 (50,000원) - 1개
3개 일치 (5,000원) - 1개
총 수익률은 1375.0%입니다.
```