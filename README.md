<p align="center">
    <img src="src/main/resources/static/woowacourse.png" alt="우아한테크코스" width="565">
</p>

# 프리코스 3주차 미션 - 로또

---

![Generic badge](https://img.shields.io/badge/precourse-week3-green.svg)
![Generic badge](https://img.shields.io/badge/test-3_passed-blue.svg)
![Generic badge](https://img.shields.io/badge/version-1.0.1-brightgreen.svg)

> 우아한테크코스 7기 프리코스 2주차 미션, 자동차 경주를 구현한 저장소입니다.

<br>

<img src="src/main/resources/static/operation.gif" alt="실행 GIF" width="400">

# 목차

- ### [기능 요구 사항](#기능-요구-사항)
- ### [입출력 요구 사항](#입출력-요구-사항)
- ### [실행 결과 예시](#실행-결과-예시)
- ### [동작 흐름](#동작-흐름)
- ### [기능 목록](#기능-목록)
    - #### [입력 처리](#1입력-처리)
    - #### [로직 구현](#2-로직-구현)
    - #### [출력 처리](#3-출력-처리)
    - #### [예외 처리](#4-예외-처리)

---

## 기능 요구 사항

간단한 로또 발매기를 구현한다.

- #### 로또 번호의 숫자 범위는 1~45까지이다.
- #### 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- #### 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- #### 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    - #### 1등: 6개 번호 일치 / 2,000,000,000원
    - #### 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - #### 3등: 5개 번호 일치 / 1,500,000원
    - #### 4등: 4개 번호 일치 / 50,000원
    - #### 5등: 3개 번호 일치 / 5,000원
- #### 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
- #### 로또 1장의 가격은 1,000원이다.
- #### 당첨 번호와 보너스 번호를 입력받는다.
- #### 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
- #### 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    - #### Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

---

## 입출력 요구 사항
### 입력
1. **구입 금액**:
- 사용자가 로또 구입 금액을 입력합니다.
- 구입 금액은 1,000원 단위로 입력해야 하며, 1,000원으로 나누어 떨어지지 않는 경우 예외 처리됩니다.
- 예시: `14000`

2. **당첨 번호**:
- 사용자가 당첨 번호를 입력합니다.
- 번호는 쉼표(,)로 구분하여 입력해야 합니다.
- 예시: `1,2,3,4,5,6`

3. **보너스 번호**:
- 사용자가 보너스 번호를 입력합니다.
- 예시: `7`

### 출력
1. **로또 구매 결과**:
- 발행한 로또 수량과 각 로또 번호를 출력합니다.
- 로또 번호는 오름차순으로 정렬하여 보여줍니다.
- 예시 출력:
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

2. **당첨 내역**:
- 일치하는 번호에 따라 당첨 내역을 출력합니다.
- 예시 출력:
  ```
  3개 일치 (5,000원) - 1개
  4개 일치 (50,000원) - 0개
  5개 일치 (1,500,000원) - 0개
  5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
  6개 일치 (2,000,000,000원) - 0개
  ```

3. **수익률**:
- 수익률은 소수점 둘째 자리에서 반올림하여 출력합니다.
- 예시 출력: `총 수익률은 62.5%입니다.`

### 예외 처리
- 프로그램은 다음과 같은 예외 상황에서 에러 메시지를 출력합니다.
- 에러 메시지는 "[ERROR]"로 시작해야 합니다.
    - 예시: `[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.`

---

## 실행 결과 예시
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
---

## 동작 흐름
- `구입금액을 입력해 주세요.` 츨력
- `1000원 단위로 나누어 떨어지는 금액` 입력
    - `purchaseAmount % 1000 != 0` 일 경우 오류 메시지`[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.`출력
- `(purchaseAmount / 1000)개를 구매했습니다.` 출력
- 중복없이 1~45번 중 6개씩 총 `(purchaseAmount / 1000)`개의 리스트 뽑아서 `오름차순`정렬 후 출력
- `당첨 번호를 입력해 주세요.` 출력
- 쉼표를 구분으로 6개 숫자 입력
    - 쉼표 이외의 구분자 사용시 오류 메시지`[ERROR] 번호는 쉼표(,)로 구분하여 입력해야 합니다.`출력
    - 1~45 범위를 벗어나는 숫자 입력 시 오류 메시지 `[ERROR] 당첨 번호의 숫자 범위는 1~45까지 입니다.`출력
    - 중복된 당첨 번호 입력 시 오류 메시지 `[ERROR] 중복된 숫자가 입력되었습니다.`출력
    - 숫자가 아닌 값을 입력 시 오류 메시지 `[ERROR] 유효하지 않은 입력입니다. 숫자만 입력해 주세요.`출력
- `보너스 번호를 입력해 주세요.`출력
- `보너스 번호` 입력
    - 1~45 범위를 벗어나는 숫자 입력 시 오류 메시지 `[ERROR] 당첨 번호의 숫자 범위는 1~45까지 입니다.`출력
    - 당첨 번호와 중복된 숫자 입력 시 오류 메시지 `[ERROR] 중복된 숫자가 입력되었습니다.`출력
    - 숫자가 아닌 값을 입력 시 오류 메시지 `[ERROR] 유효하지 않은 입력입니다. 숫자만 입력해 주세요.`출력
- `당첨 통계` 출력
- `---` 출력
- ```
  3개 일치 (5,000원) - ?개
  4개 일치 (50,000원) - ?개
  5개 일치 (1,500,000원) - ?개
  5개 일치, 보너스 볼 일치 (30,000,000원) - ?개
  6개 일치 (2,000,000,000원) - ?개
  ```
- `총 수익률은 ??.?%입니다.` 출력

---

## 기능 목록

### 1.입력 처리

- **기능**: 사용자로부터 값을 입력받는다
    - **입력 형식**: String
    - **유효성 검사**: `null` 입력 시 NoSuchElementException 오류 발생
    - **특이 사항**: `camp.nextstep.edu.missionutils.Console의 readLine()`을 활용한다.

### 2. 로직 구현

- **기능**: 구입금액 유효성 검사
    - 1000원으로 나누어 떨어진다면 `구입금액 / 1000`값 변수에 저장
    - 아니라면 예외처리


- **기능**: `구입금액 / 1000`개수만큼 리스트 생성
    - `camp.nextstep.edu.missionutils.Randoms의 pickUniqueNumbersInRange()`를 활용


- **기능**: 당첨 번호 유효성 검사
    - 유효성 검사 통과 시 당첨 번호 따로 저장
    - 통과 실패 시 예외처리


- **기능**: 보너스 번호 유효성 검사
    - 유효성 검사 통과 시 보너스 번호 따로 저장
    - 통과 실패 시 예외처리


- **기능**: 총 수익률 계산
    - (총 수익 - 구입금액)/구입 금액 * 100 = 수익률
    - 수익율이 0보다 작을 경우 `100+수익률` 반환


### 3. 출력 처리

- **기능**: 변수 없이 순수 문자열 출력
    - `구입금액을 입력해 주세요.` 출력
    - `보너스 번호를 입력해 주세요.` 출력


- **기능**: 로또 몇개 구매했는지 출력
    - 구입금액에서 1000을 나눈 값이 개수가 된다.


- **기능**: 구매한 로또 번호들을 한 줄씩 출력
    - 리스트 형태 그대로 한 줄씩 출력
    - 오름차순으로 정렬된 채 출력되어야 한다.


- **기능**: 당첨 통계를 출력한다.


- **기능**: 총 수익률을 출력한다.
-

### 4. 예외 처리

- **기능**: 구입금액이 1000원으로 나누어 떨어지지 않을 때
    - **오류**: `IllegalArgumentException`
    - **오류 메시지**: ``

  