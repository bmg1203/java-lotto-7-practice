# 기능 목록

## ver 1.0

### 0.0 -> 1.0

각 도메인에 대한 Parser가 따로 있었지만 하나의 일반화된 파서로 기능을 변경한다.

각 도메인에 대한 검증로직이 Parser에 있었지만 파서는 문자를 숫자로만 바꾸는 기능을 담당하고 각 도메인을 만들어 검증 로직을 각 도메인의 인스턴스로 이동함.

입력 기능을 하나의 메서드로 통일한다.

### 기능1

로또 구매 금액, 당첨 숫자와 보너스 숫자를 입력 받을 수 있는 인풋 기능을 구현한다.

### 기능2

로또 금액 입력 당첨 숫자와 보너스 숫자에 대한 입력을 도메인에 알맞은 형태로 변환한다.

-변환하기 알맞은 형태가 아니라면 기능1로 돌아간다.

### 기능3

Attempt, BonusLotto, Lotto로 도메인을 만들어 저장 및 검증 기능을 구현한다.

-만일 검증에서 예외가 발생하면 기능1로 돌아간다.

### 기능4

Attempt 도메인을 이용해 1개의 로또를 발행할 때마다 중복되지 않는 6개의 숫자를 뽑는다.

### 기능5

사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 결과를 도출한다.

```
1등: 6개 번호 일치 / 2,000,000,000원
2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
3등: 5개 번호 일치 / 1,500,000원
4등: 4개 번호 일치 / 50,000원
5등: 3개 번호 일치 / 5,000원
```

### 기능6

당첨 결과를 바탕으로 당첨 내역과 수익률을 출력한다.
