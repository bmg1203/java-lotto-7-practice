# 💰 java-lotto-precourse
#### 간단한 로또 발매기를 구현한다.

## 🔧 구현할 기능 목록
#### 1. 로또 구입 금액 입력받기
- "구입 금액을 입력해 주세요." 안내문 출력
- 1000원 단위로 입력 받기
  - 숫자로만 이루어져 있는지 확인 후, 아닐 경우 에러 메시지
  - 제대로 입력할 때까지 반복
- 1000원으로 나누어 떨어지지 않는 경우 예외 처리
  - ```IllegalArgumentException```을 발생
  - 에러 문구는 [ERROR] 1000원 단위로 입력해 주세요.

#### 2. 금액에 따른 로또 번호 출력
- "n개를 구매했습니다."와 함께 n개의 로또 번호 출력
  - 오름차순 정렬
    - Lotto 클래스에서 오름차순 정렬 확인용 toString 메서드 오버라이드
- Random 값 추출은 ```camp.nextstep.edu.missionutils.Randoms```의 ```pickUniqueNumbersInRange()```를 활용
  - 예시) ```Randoms.pickUniqueNumbersInRange(1, 45, 6);```

#### 3. 당첨 번호 입력 받기
- "당첨 번호를 입력해 주세요." 안내문 출력
- 쉼표(,) 기준으로 구분하기
- 예외 처리
  - 구분된 값이 숫자가 아닌 경우 예외 처리
      - 에러 문구는 [ERROR] 당첨 번호는 숫자만 포함해야 합니다.

#### 4. 보너스 번호 입력 받기
- "보너스 번호를 입력해 주세요." 안내문 출력
- 숫자 입력 받기
- 예외처리
  - 숫자가 아닌 경우 예외 처리
    - 에러 문구는 [ERROR] 숫자를 입력해 주세요.
  - 숫자인데, 1~45 사이의 숫자가 아닌 경우
    - 에러 문구는 [ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.
  - 보너스 번호가 당첨 번호에 있는 숫자인 경우
    - 에러 문구는 [ERROR] 보너스 번호는 당첨 번호에 없는 숫자여야 합니다.

#### 5. 당첨 통계 출력
- 5등부터 1등 순서대로 몇 개가 당첨되었는지 표시

#### 6. 수익률 출력
- 수익률은 소수점 둘째 자리에서 반올림

#### 7. Lotto 클래스 안에서 로또 번호 예외처리
- 기존에는 입력 받을 때마다 예외처리를 해주던 것을 로또 클래스를 이용하여 한 클래스에서 처리
  - 로또 번호 6개 여부
  - 중복 여부
  - 1 ~ 45 사이의 숫자인지 확인

#### 8. 자바 코드 컨벤션을 지키며 프로그래밍
- [Java Style Guide](https://github.com/woowacourse/woowacourse-docs/blob/main/styleguide/java)를 참고하여 수정