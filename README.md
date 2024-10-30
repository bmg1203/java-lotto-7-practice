# 로또

## 🔎 과제 진행 요구 사항
- 미션은 로또 저장소를 포크하고 클론하는 것으로 시작한다.
- 기능을 구현하기 전 README.md에 구현할 기능 목록을 정리해 추가한다.
- Git의 커밋 단위는 앞 단계에서 README.md에 정리한 기능 목록 단위로 추가한다.
- AngularJS Git Commit Message Conventions을 참고해 커밋 메시지를 작성한다.
- 자세한 과제 진행 방법은 프리코스 진행 가이드 문서를 참고한다.

## ✏️ 기능 요구 사항
간단한 로또 발매기를 구현한다.

```
로또 번호의 숫자 범위는 1~45까지이다.
1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
1등: 6개 번호 일치 / 2,000,000,000원
2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
3등: 5개 번호 일치 / 1,500,000원
4등: 4개 번호 일치 / 50,000원
5등: 3개 번호 일치 / 5,000원
로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
로또 1장의 가격은 1,000원이다.
당첨 번호와 보너스 번호를 입력받는다.
사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.
```

## 🤷🏻‍ 입출력 요구 사항
### 입력
#### 로또 구입 금액을 입력 받는다. 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.
```
14000
```
#### 당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.
```
1,2,3,4,5,6
```
#### 보너스 번호를 입력 받는다.
```
7
```

### 출력
#### 발행한 로또 수량 및 번호를 출력한다. 로또 번호는 오름차순으로 정렬하여 보여준다.
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

#### 당첨 내역을 출력한다.
```
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
```

#### 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)
```
총 수익률은 62.5%입니다.
```

#### 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.
 ```
[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.
```

#### 실행 결과 예시
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

### 🗓️ 기본 요구 조건 + 사용자 정의 요구조건 설정

### 사전 준비 목록
#### 로또 구매
- ✔️ **로또 구매 입력 기능**
  - ✔️ 로또 구매 금액이 1,000원 이상인지 검증하는 기능
  - ✔️ 로또 구매 금액이 100,000만원을 초과하지 않는지 검증하는 기능


- ✔️ **로또 구매 개수 출력 기능**
  - ✔️ 로또 1장의 가격은 1,000원이므로 나머지 값 버림 기능


- ✔️**로또 번호 생성 기능**
  - ✔️ 랜덤 번호 호출 기능
  - ✔️ 로또 번호는 오름차순 정렬 기능 기능
  - ✔️ 중복되는 값이 있는지 검증하는 기능
  - ✔️ 로또 번호가 1 ~ 45 범위 내에 있는지 검증하는 기능
  - ✔️ 로또 번호 개수가 6개인지 검증하는 기능


- ✔️ **로또 구매 번호 출력 기능**
  - ✔️ 로또 번호는 , 공백 이용해 배열 형태로 반환 기능
  - ✔️ 로또 구매 개수 만큼 한줄에 한개씩 출력 기능

### 로또 게임 진행 
#### 로또 당첨번호 발급
- ✔️ **로또 당첨 번호 입력**
  - ✔️ 로또 당첨 번호가 6자리인지 검증하는 기능
  - ✔️ 로또 , 로 지정된 형식을 지키는지 검증하는 기능
  - ✔️ 로또 번호는 숫자인지 검증하는 기능
    - ✔️ 지정된 범위 1 ~ 45에 벗어나는지 검증하는 기능
    - ✔️ 로또 번호가 중복 검증하는 기능
  - ✔️ 로또 번호 숫자로 변경하는 기능

#### 로또 보너스 번호 발급
- ✔️ **로또 보너스 번호 입력**
  - ✔️ 보너스 번호가 1개만 입력됬는지 검증하는 기능
  - ✔️ 보너스 번호가 숫자인지 검증하는 기능
    - ✔️ 보너스 번호가 로또 당첨번호와 중복되는지 검증하는 기능
    - ✔️ 보너스 번호가 1 ~ 45를 벗어나는지 검증하는 기능
  - ✔️ 보너스 번호를 숫자로 변경하는 기능

### 로또 결과 발표
#### 로또 결과 출력
- ✔️ **등수별 당첨 개수 저장**
  - ✔️ 하나의 로또 당 당첨 번호 일치 개수 확인하는 기능
  - ✔️ 보너스 번호와 일치하는 번호 확인 기능
    - ✔️ 로또번호가 5개가 일치하고 보너스 번호가 일치한 경우 2등
  - ✔️ 일치 번호 개수별 순위 판단 기능

#### 로또 수익율 결과 출력
- ✔️ **로또 수익율**
  - ✔️ 구매 금액 대비 얻은 수익율 계산 기능
  - ✔️ 수익율은 소수점 2자리에서 반올림 처리 기능


### 검증 기능 예외 처리 
- ✔️ **검증 기능에서 발상하는 예외처리**
  - ✔️ [ERROR::IllegalArgumentException] 오류 상황 반환 메시지
  - ✔️ 사용자 입력 값이 잘못된 경우 에러 메시지 호출 후 재입력 처리
  - ✔️ 시스템 오류의 경우 에러 메시지 반환 후 종료