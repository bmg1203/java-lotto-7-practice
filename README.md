# java-lotto-precourse

### 구현할 기능
1. 구입 금액 -> 1000원 단위로 나누어 떨어지지 않으면 예외 처리
2. 당첨 번호, 보너스 번호 입력받기 -> 3개의 입력에서 예외가 발생하면 그 단계에서 재입력 받기
3. 구입 금액에 따른 로또 발행 -> 1 ~ 45 사이의 난수 6개 생성
4. 각각의 로또에 대해 당첨 결과 구하기
5. 수익률 구하기
6. 수익률 출력

### 기능 요구 사항
1. **로또 번호 범위**: 1~45
2. **로또 발행**: 중복되지 않는 6개의 숫자로 구성된 로또 번호를 발행
3. **당첨 번호 추첨**: 6개의 당첨 번호와 보너스 번호 1개를 중복 없이 추첨
4. **당첨 등급 및 상금**:
    - 1등: 6개 번호 일치 / 20억 원
    - 2등: 5개 번호 + 보너스 번호 일치 / 3천만 원
    - 3등: 5개 번호 일치 / 150만 원
    - 4등: 4개 번호 일치 / 5만 원
    - 5등: 3개 번호 일치 / 5천 원
5. **구입 금액에 따른 로또 발행**: 로또 1장당 1,000원
6. **당첨 번호 입력**: 당첨 번호와 보너스 번호 입력
7. **당첨 결과 및 수익률 출력**: 구매한 로또와 당첨 번호 비교, 당첨 내역 및 수익률 출력
8. **예외 처리**: 잘못된 입력 시 `[ERROR]`로 시작하는 메시지 출력 후 재입력

### 입출력 요구 사항
- **입력**:
    - 구입 금액
    - 당첨 번호 (쉼표로 구분)
    - 보너스 번호
- **출력**:
    - 발행한 로또 수량 및 번호 목록 (오름차순 정렬)
    - 당첨 내역 및 수익률 (수익률은 소수점 둘째 자리 반올림)

### 예외 상황
- 1,000원 단위로 나누어 떨어지지 않는 금액 입력 시 예외 처리
- 로또 번호는 1~45 사이의 숫자만 허용
- 로또 번호는 숫자만 입력해야함.
- 공백을 입력할 수 없음
- 당첨 번호는 6개를 입력해야함.

### 프로그래밍 요구 사항
- **JDK 21 버전 호환**
- **메서드 분리**: indent depth 2까지만 허용, 메서드는 15라인을 넘지 않도록
- **코드 컨벤션**: Java Style Guide 준수
- **Enum 활용**: 등수에 따른 상금 정의
- **테스트**: JUnit 5와 AssertJ 사용
- **Exception Handling**: IllegalArgumentException 등 명확한 예외 처리

### 라이브러리
- **Randoms**: `camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange()` 활용
- **Console**: `camp.nextstep.edu.missionutils.Console.readLine()` 활용

### Lotto 클래스
- **구조**:
    - `List<Integer> numbers` 필드만 사용
    - 로또 번호는 반드시 6개
