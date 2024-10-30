# 🎰로또 게임

---

우아한 테트 코스의 3주차 미션인 **로또 게임** 입니다. 최대한 **객체끼리의 협력**을 통해서 기능을 구현하고자 하였습니다. ✨

<br>

## 🎡 로또 게임 소개

---

간단한 로또 발매기라고 생각하시면 프로그램 이해에 도움되실 것 같습니다.

다만, 일반적인 로또 추첨과 다른 점은 **당첨 번호와 보너스 번호를 사용자에게 입력**받는다는 점과 **발행한 로또 표는 자동 선택**되는 상황이라고 생각하시면 좋을 것 같습니다!

<br>

### 🎫 로또 발매 진행 방식

1. **원하시는 로또 수량만큼 로또 구입 금액을 입력합니다.**

   **(로또 표는 장당 1,000원입니다.)**

    - 이때 구입 금액은 `1,000원 단위`로만 입력 받습니다.

      (숫자의 양쪽 공백은 제거되어 들어옵니다)

    - 아래와 같이 잘못 입력 했을 경우 재입력 부탁드립니다.
        - null일 경우
        - 입력 값에 숫자가 아닌 것이 존재하는 경우
        - 0보다 작을 경우
        - **1000원으로 나누어 떨어지지 않는 경우**

<br>

2. **당첨 번호를 입력합니다.**
    - 로또 번호의 `숫자 범위는 1~45`까지이며, `중복되지 않는 6개의 숫자`를 입력 받습니다.

      (번호는 `쉼표(,)`를 기준으로 구분되며, 숫자의 양쪽 공백은 제거되어 들어옵니다.)

    - 아래와 같이 잘못 입력 했을 경우 재입력 부탁드립니다.
        - null일 경우
        - 입력 값에 숫자가 아닌 것이 존재하는 경우
        - 번호가 **6**개가 아닌 경우
        - 번호가 **1부터 45 사이의 숫자**가 아닌 경우
        - **중복된 숫자가 있을 경우**

<br>

3. **보너스 번호를 입력합니다.**
    - 보너스 번호의 `숫자 범위 또한 1~45`까지이며, `당첨 번호와 중복되지 않는 1개의 숫자`를 입력 받습니다.
    - 아래와 같이 잘못 입력 했을 경우 재입력 부탁드립니다.
        - null일 경우
        - 입력 값에 숫자가 아닌 것이 존재하는 경우
        - 번호가 **1부터 45 사이의 숫자**가 아닌 경우
        - **당첨 번호와 중복되는 경우**

<br>

4. **출력되는 발행한 로또 수량과 로또 번호를 확인해주세요 .**
    - 구입 금액에 해당하는 만큼 로또가 발행됩니다.
    - 발행한 로또는 1부터 45 사이의 중복되지 않는 6개의 숫자의 로또 번호가 자동으로 생성됩니다.
    - 출력 예시는 아래와 같으며, 로또 번호는 오름차순 정렬되어 보여집니다.

        ```c
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

<br>

5. **출력되는 당첨 내역을 확인합니다.**
    - 당첨은 1등부터 5등까지 있으며, 당첨 기준과 금액은 아래와 같습니다.
        - 1등: 6개 번호 일치 / 2,000,000,000원
        - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
        - 3등: 5개 번호 일치 / 1,500,000원
        - 4등: 4개 번호 일치 / 50,000원
        - 5등: 3개 번호 일치 / 5,000원
    - 구매하신 로또 번호와 당첨 번호를 비교하여 나온 당첨 내역의 출력 예시는 아래와 같습니다.

        ```c
        3개 일치 (5,000원) - 1개
        4개 일치 (50,000원) - 0개
        5개 일치 (1,500,000원) - 0개
        5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
        6개 일치 (2,000,000,000원) - 0개
        ```

<br>

6. **출력되는 수익률을 확인합니다.**
    - 구매하신 로또 번호와 당첨 번호를 비교하여 수익률이 측정됩니다.
    - 수익률은 소수점 둘째 자리에서 반올림됩니다.

      (ex. 100.0%, 51.5%, 1,000,000.0%)

    - 아래는 수익률의 출력 예시입니다.

        ```c
        총 수익률은 62.5%입니다.
        ```

<br>

7. **🎡 이후 프로그램은 종료되며, 최종적인 실행 결과는 아래와 같습니다.**

    ```c
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

<br>

# 구현 목록

---

### 사용자 입력 관련

- [ ]  구입 금액
    - [ ]  숫자의 양쪽 공백 제거
    - [ ]  [예외] null일 경우
    - [ ]  [예외] 입력 값에 숫자가 아닌 것이 존재하는 경우
    - [ ]  [예외] 0보다 작을 경우
    - [ ]  [예외] 1000원으로 나누어 떨어지지 않는 경우
- [ ]  당첨 번호 입력 받기
    - [ ]  숫자의 양쪽 공백 제거
    - [ ]  [예외] null일 경우
    - [ ]  [예외] 입력 값에 숫자가 아닌 것이 존재하는 경우
    - [x]  [예외] 번호가 6개가 아닌 경우
    - [x]  [예외] 번호가 1부터 45 사이의 숫자가 아닌 경우
    - [x]  [예외] 중복일 경우
- [ ]  보너스 번호 입력 받기
    - [ ]  [예외] null일 경우
    - [ ]  [예외] 입력 값에 숫자가 아닌 것이 존재하는 경우
    - [ ]  [예외] 번호가 1부터 45 사이의 숫자가 아닌 경우
    - [ ]  [예외] 당첨 번호와 중복되는 경우

### 로또

- [ ]  구입 금액에 해당하는 만큼 로또 발행
    - [ ]  로또 수량 구하기
    - [ ]  로또 수량에 따른 1부터 45 사이의 중복되지 않는 6개의 숫자의 로또 번호 생성
    - [ ]  로또 번호 오름차순 정렬
- [ ]  당첨 통계 계산 (3개부터 6개 일치까지)
    - [ ]  사용자가 구매한 로또 번호와 당첨 번호 비교하여 당첨 결과 계산
    - [ ]  당첨 통계 계산
- [ ]  총 수익률을 소수점 둘째 자리에서 반올림하여 계산



### 사용자에게 출력

- [ ]  발행한 로또 수량 및 번호 출력
- [ ]  당첨 통계 출력
- [ ]  수익률(= 당첨 금액 /구입 금액) 출력