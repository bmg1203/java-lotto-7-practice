# 로또

간단한 로또 발매기

---

## 프로젝트 개요

이 프로그램은 사용자가 입력한 금액만큼 로또를 구매하고, 당첨 번호와 보너스 번호를 입력받아 당첨 결과 및 수익률을 계산하여 출력합니다. 로또 구입 금액은 `1,000원` 단위이며, 1등부터 5등까지의 당첨 조건과
상금이 주어집니다.

---

## 기능 목록

#### 1. 입력 기능

- [X] 로또 구입 금액 입력: `1,000` 단위
- [X] 당첨 번호 입력: 중복되지 않는 1~45 범위의 정수 6개
    - [X] 쉼표`,`로 구분
- [X] 보너스 번호 입력: 당첨 번호와 중복되지 않는 1~45 사이의 정수 1개
- [X] 예외 처리: 유효하지 않은 입력 발생 시, 해당 부분부터 재입력받기

##### 유효성 검사

- 구입 금액
    - [X] 정수
    - [X] 양수
    - [X] 로또 가격의 배수
- 로또 번호
    - [X] 정수
    - [X] 6개
    - [X] 숫자 범위 1~45
    - [X] 중복 없음
- 보너스 번호
    - [X] 정수 1개
    - [X] 숫자 범위 1~45
    - [X] 당첨 번호와 중복 안 됨

#### 2. 출력 기능

- [X] 로또 발행 결과 출력
    - 발행된 로또 총 개수와 각 로또 번호 출력
        - 로또 번호는 오름차순 정렬하여 출력
- [X] 당첨 내역 출력
- [X] 수익률 출력
- [X] 에러 메시지 출력: 예외 발생 시, `[ERROR]`로 시작하는 에러 메시지를 출력

#### 3. 로또 발행 기능

- [X] 로또 개수 계산 및 발행
    - [X] 구입한 금액에 따라 로또 개수를 계산하여 발행
      `구입할 개수 = 구입 금액 / 1,000`
    - [X] 1~45 범위의 중복되지 않는 6개의 정수 생성
    - [X] 번호는 오름차순 정렬하여 저장

#### 4. 당첨 확인 및 수익률 계산 기능

- [X] 당첨 번호와의 비교
    - [X] 각 로또 번호를 당첨 번호와 비교하여 일치하는 숫자 개수 확인
    - [X] 보너스 번호 일치 여부 판단
- [X] 당첨 등수 판별
- [X] 총 당첨 금액 계산
- [X] 수익률 계산

#### 5. 종료 기능

- [X] 정상 종료: 결과 출력 후 종료

---

## 기능 요구 사항

- 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
- 로또 1장의 가격은 1,000원이다.
- 당첨 번호와 보너스 번호를 입력받는다.
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    - Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

### 입출력 요구 사항

#### 입력

- 로또 구입 금액을 입력 받는다. 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.
    ```text
    14000
    ```
- 당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.
    ```
    1,2,3,4,5,6
    ```
- 보너스 번호를 입력 받는다.
    ```text
    7
    ```

#### 출력

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
    ```text
    3개 일치 (5,000원) - 1개
    4개 일치 (50,000원) - 0개
    5개 일치 (1,500,000원) - 0개
    5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
    6개 일치 (2,000,000,000원) - 0개
    ```
- 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)
    ```text
    총 수익률은 62.5%입니다.
    ```  
- 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.
    ```text
    [ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.
    ```

#### 실행결과 예시

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