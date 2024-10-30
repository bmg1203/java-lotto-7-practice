# java-lotto-precourse

## ✅ 구현할 기능 목록

- [x] **로또 구입 금액을 입력 받는다.**
  - [x] 입력은 1,000원 단위이며, 그렇지 않은 경우 예외 처리한다.
    - [x] 예외 1) 숫자만 입력하지 않은 경우 (공백 입력 포함)
    - [X] 예외 2) 입력한 숫자가 1,000으로 나누어 떨어지지 않는 경우
    - [x] 예외 3) 구매 수량을 100장으로 제한하여 100,000 이상의 숫자를 입력한 경우
    - [x] 예외 4) 0 이하의 값을 입력한 경우
  ```text
  8000 
  ```

- [x] **1 ~ 45 사이 Random 값 6개를 추출하여 구매한 로또 수 만큼의 로또를 발행한다.**
    - [x] camp.nextstep.edu.missionutils.Randoms의 pickUniqueNumbersInRange()를 사용한다.
    - [x] 발행된 각 로또 번호는 오름차순으로 정렬한다.

  
- [x] 발행된 로또 번호를 출력한다.
  - [x] 발행된 로또를 나열하기 전에 몇개의 로또를 구매했는지 출력한다.
  ```text
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

- [ ] **당첨 번호를 입력 받는다.**
  - [ ] 각 번호는 쉼표(,)를 기준으로 구분한다.
  - [ ] 서로 다른 6개의 수를 입력한다. 그렇지 않은 경우 예외 처리한다.
    - [ ] 예외 1) 숫자만 입력하지 않은 경우
    - [ ] 예외 2) 입력한 숫자가 1 ~ 45 사이의 숫자가 아닌 경우
    - [ ] 예외 3) 입력한 숫자가 6개 미만 혹은 초과한 경우
    - [ ] 예외 4) 빈 값인 경우
    - [ ] 예외 5) 쉼표로 구분하지 않은 경우
    - [ ] 예외 6) 중복된 숫자를 입력한 경우
    ```text
    1,2,3,4,5,6
    ```

- [ ] **보너스 번호를 입력 받는다.**
  - [ ] 한 개의 숫자를 입력한다. 그렇지 않은 경우 예외 처리한다.
    - [ ] 예외 1) 숫자만 입력하지 않은 경우
    - [ ] 예외 2) 입력한 숫자가 1 ~ 45 사이의 숫자가 아닌 경우
    - [ ] 예외 3) 빈 값인 경우
    ```text
    7
    ```

- [ ] **당첨 통계를 출력한다.**
  - [ ] 사용자가 구매한 로또 번호와 당첨 번호를 비교한다.
  - [ ] 비교 결과 일치하는 번호의 개수를 기준으로 1등부터 5등까지의 당첨 내역을 계산한다.
  ```text
  3개 일치 (5,000원) - 1개
  4개 일치 (50,000원) - 0개
  5개 일치 (1,500,000원) - 0개
  5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
  6개 일치 (2,000,000,000원) - 0개
  ```

- [ ] **총 수익률을 출력한다.**
  - [ ] 사용자가 구매한 로또 금액과 당첨 금액 비율을 기반으로 계산한다.
  - [ ] 소수점 둘째 자리에서 반올림한다.
  ```text
  총 수익률은 62.5%입니다. 
  ```

- [ ] **예외 상황 시 출려되는 에러 문구는 접두사로 "[ERROR]"를 사용한다.**
  - [ ] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, 에러 메시지 출력 후 그 부분부터 입력을 다시 받는다.
  - [ ] Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.
    ```text
    [ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.
    ```


## ✅ 전체 실행 결과 예시

```text
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

## ✅ 프로그래밍 요구 사항 점검

- [ ] JDK 21 버전에서 실행 가능해야 한다.
- [ ] 프로그램 실행의 시작점은 Application의 main()이다.
- [ ] build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- [ ] 프로그램 종료 시 System.exit()를 호출하지 않는다.
- [ ] 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- [ ] Java Style Guide를 원칙 자바 코드 컨벤션을 지키면서 프로그래밍한다.


- [ ] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- [ ] 3항 연산자를 쓰지 않는다.
- [ ] 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- [ ] 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- [ ] JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.


- [ ] else 예약어를 쓰지 않는다. switch/case도 허용하지 않는다.
- [ ] Java Enum을 적용하여 프로그램을 구현한다.
- [ ] 구현한 기능에 대한 단위 테스트를 작성한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
