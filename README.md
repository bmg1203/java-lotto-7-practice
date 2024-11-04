# java-lotto-precourse

# 학습 목표
1. 클래스와 함수에 대한 단위 테스트를 진행한다.
2. 작은 단위의 테스트부터 진행한다.
3. 구현 순서를 지킨다. 상수 - 멤버 변수 - 생성자 - 메서드 순으로 구현한다.
4. 메서드는 하나의 기능만을 수행한다.
5. 변수명과 클래스명을 직관적이게 작성한다.
6. 내부 필드의 필요성에 대해 한 번 더 생각한다.
7. 유효성 검사의 책임을 생각한다.
8. git flow를 활용한다.

- - -
# 과제 진행 방식
1. 로또 저장소를 포크하고 클론한다.
2. `mirim` branch를 생성한다.
3. 기능 명세 목록을 `README.md`에 작성한다.
4. 1차 구현 후, 클래스와 메서드의 기능을 분배한다.
5. 작은 단위의 테스트를 진행한다.
6. 예외 처리와 큰 단위의 테스트를 진행한다.
7. 저장소에 pull을 하고, 지원 홈페이지로 제출한다.

- - -

# 기능 명세서

- 입력
    - [x] `camp.nextstep.edu.missionutils.Console`의 `readLine()` 활용   
  
    - [ ] 발행
      - [x] 1000 단위로 입력되어야 한다
      - [x] 예외
        - [x] `입력 % 1000 != 0`
        - [ ] 다시 입력 받게 돌아간다.   
      
    - [x] 기본 당첨 번호 - 정답
      - [x] 1 ~ 45의 숫자에서 중복 없이 6개 입력되어야 한다.
      - [x] `,`만 구분자로 사용한다.
      - [x] 오름차순 정렬
      - [x] 예외
        - [x] 1 ~ 45 이외의 숫자 입력
        - [x] 1 ~ 45의 숫자에서 중복 입력
        - [x] `,`가 아닌 다른 구분자 사용
        - [x] 다른 문자 입력
        - [x] 공백 입력
        - [x] 입력 앞뒤로 `,` 입력
        - [x] `,`의 반복 실수 - `,,1, 2, 3, 4, 5, 6`, `1,,2,3, 4, 5, 6` 과 같은 경우   
    
    - [x] 보너스 당첨 번호 - 정답
      - [x] 1 ~ 45의 숫자에서 1개
      - [x] 기본 당첨 번호와 겹치지 않아야 함
      - [x] 예외
        - [x] 기본 조건
        - [x] 공백 입력
        - [x] 숫자 아닌 문자 입력

- [x] 출력
  - [x] 구매 개수
  - [x] 구매자의 로또 번호 -> 발행 기능
  - [x] 당첨 통계
    - [x] 항목 5개: 3개, 4개, 5개, 5개+보너스볼, 6개 일치 
    - [x] 수익률
      - [x] 소수 둘째자리에서 반올림
      - [x] 백분율로 표기
  
**기능**

- [x] 구매자 로또 번호 발행
    - [x] 오름차순 정렬
    - [x] 1 ~ 45의 숫자에서 중복 없이 6개 출력
      - [x] `camp.nextstep.edu.missionutils.Randoms`의 `pickUniqueNumbersInRange()`를 활용한다.
      - [x] `Randoms.pickUniqueNumbersInRange(1, 45, 6)`

- [ ] 유효성 검사
  - [ ] 유효하지 않을 경우, 해당 기점의 입력부터 다시 받는다.
  - [x] 입력 1: 구매자의 지불 금액이 1000의 단위인가?
  - [x] 입력 2: 유효한 기본 당첨 번호인가?
    - [x] 1 - 45
    - [x] 중복 없음
    - [x] 구분자 `,` 유효하게 사용?
    - [x] 문자가 입력되지는 않았는가?
  - [x] 입력 3: 유효한 보너스 당첨 번호인가?
    - [x] 기본 당첨 번호와 중복 없음, 1- 45 사이
    - [x] 문자가 입력되지는 않았는가?

- [ ] 당첨 확인 비교
  - [x] 기본 당첨 번호 6개와 구매 번호 6개 비교
  - [x] 보너스 당첨 번호 1개와 구매 번호 6개 비교
    - [ ] 기본 당첨 번호 5개 일치, 1개 불일치 시 추가 검사로 실행한다.
  - [x] 일치 개수 저장

- [x] 당첨 통계
  - [x] 항목 5개: 3개, 4개, 5개, 5개+보너스볼, 6개 일치
  - [x] 각 항목당 당첨된 개수를 저장

- [x] 수익률 검사
  - [x] 당첨금액 계산 
  - [x] `당첨금액 / 지불 금액 * 100` 의 소수 둘째자리에서 반올림
  - 
- - -

# 패키지 구조
```
lotto
 ┣ common
 ┃ ┣ constant
 ┃ ┃ ┣ LottoConstant.java
 ┃ ┃ ┗ RankConstant.java
 ┃ ┗ model
 ┃ ┃ ┗ Lotto.java
 ┣ config
 ┃ ┗ LottoFactory.java
 ┣ dto
 ┃ ┣ BonusNumberDto.java
 ┃ ┣ LottoTicketsDto.java
 ┃ ┣ NumberOfMatchingDto.java
 ┃ ┣ NumberOfTicketsDto.java
 ┃ ┗ WinningNumberDto.java
 ┣ publishing
 ┃ ┣ controller
 ┃ ┃ ┗ PublishingController.java
 ┃ ┣ model
 ┃ ┃ ┗ Publishing.java
 ┃ ┗ view
 ┃ ┃ ┗ OutputPublishedTicketsView.java
 ┣ purchasing
 ┃ ┣ controller
 ┃ ┃ ┗ PurchasingController.java
 ┃ ┣ model
 ┃ ┃ ┗ Payment.java
 ┃ ┗ view
 ┃ ┃ ┣ PurchasingInputView.java
 ┃ ┃ ┗ PurchasingOutputView.java
 ┣ winning
 ┃ ┣ controller
 ┃ ┃ ┗ WinningController.java
 ┃ ┣ model
 ┃ ┃ ┣ BonusNumber.java
 ┃ ┃ ┣ MatchingBetweenWinningAndTickets.java
 ┃ ┃ ┣ WinningNumbers.java
 ┃ ┃ ┗ WinningStatistics.java
 ┃ ┣ validator
 ┃ ┃ ┗ ValidatorOfWinningNumber.java
 ┃ ┗ view
 ┃ ┃ ┣ InputWinningNumberView.java
 ┃ ┃ ┗ OutputWinningResultView.java
 ┗ Application.java
```
- - -

# 기능 요구 사항
> 간단한 로또 발매기를 구현한다.

- **로또 발행**: 1-45 범위 내 중복되지 않는 6개의 숫자
- **당첨 번호 추첨**: 1-45 범위 내 중복되지 않는 숫자 6개, 보너스 번호 1개
- **당첨 기준**: 
  - 1등: 6개 번호 일치 / 2,000,000,000원   
  - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원   
  - 3등: 5개 번호 일치 / 1,500,000원   
  - 4등: 4개 번호 일치 / 50,000원
  - 5등: 3개 번호 일치 / 5,000원
- **로또 구입 금액 입력**: 장당 1000원으로 구입 금액만큼 로또를 발행
- **당첨 번호, 보너스 번호 입력**
- **출력**: 구매한 로또 번호, 당첨 내역, 수익률
- **게임 종료**
- **예외 메세지**: 
  - 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생
  - "[ERROR]"로 시작하는 에러 메시지를 출력, 그 부분부터 입력을 다시 받는다.
  - `Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리

- - -

## 입출력 요구 사항
### 입력
- 로또 구입 금액을 입력 받는다. 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.
```14000```
- 당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.
```1,2,3,4,5,6```
- 보너스 번호를 입력 받는다.
```7```

### 출력
- 발행한 로또 수량 및 번호를 출력한다. 로또 번호는 오름차순으로 정렬하여 보여준다.
```
8개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[1, 3, 5, 14, 22, 45]
```

- 당첨 내역을 출력한다.
```
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
```

- 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)
```총 수익률은 62.5%입니다.```

- 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.
```[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.```

### 실행 결과 예시
```
구입금액을 입력해 주세요.
8000

8개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[1, 3, 5, 14, 22, 45]

당첨 번호를 입력해 주세요.
1,2,3,4,5,6

보너스 번호를 입력해 주세요.
7

당첨 통계
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다.
```
- - -