# 로또

## 프로젝트 요약

로또 발매기 프로그램을 구현하는 프로젝트이다.

프로그램의 실행 순서는 아래와 같다.

사용자가 로또 구입 금액을 입력하면 그 금액에 해당하는 만큼 로또를 발행시킨다.

각 로또는 1 ~ 45까지의 로또 번호 중 중복되지 않게 6개의 숫자를 뽑는다.

또한, 로또 번호는 발행시 사용자가 선택하는 것이 아닌 자동으로 선택된다.

이후 당첨 번호와 보너스 번호를 사용자에게 입력받고,
이 당첨 번호와 보너스 번호를 기준으로 발행된 로또들의 당첨 내역을 정리해 출력한다. 

당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.

- 1등: 6개 번호 일치 / 2,000,000,000원
- 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
- 3등: 5개 번호 일치 / 1,500,000원
- 4등: 4개 번호 일치 / 50,000원
- 5등: 3개 번호 일치 / 5,000원

### 프로그램 실행 결과 예시

```shell
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

## 기능 목록

링크가 달린 기능은 해당 기능에서 발생할 수 있는 예외 목록과 링크되어 있다.

- [X] [1. 사용자 입력 처리](#1-사용자-입력-처리)
  + [1.1. 로또 구입 금액 입력](#11-로또-구입-금액-입력)
    > 로또는 1,000원 단위로 입력받는다.
  + [1.2. 당첨 번호 입력](#12-당첨-번호-입력)
    > 1 ~ 45 사이의 번호 중 6개를 중복되지 않게 입력받는다.<br>
    > 입력받은 번호는 정렬되어 있지 않을 수 있다.
  + [1.3. 보너스 번호 입력](#13-보너스-번호-입력)
    > 당첨 번호와 중복되지 않는 번호 1개를 입력받는다.
- [X] 2. 로또 발행
  > 1 ~ 45 사이의 번호 중 6개를 중복되지 않게 뽑아 로또를 발행한다.
- [X] 3. 당첨 내역 정리
  > 1등부터 5등까지 당첨된 로또 수를 센다.<br>
  > 각 등수의 당첨 기준은 아래와 같다.
  > * 1등 : 당첨 번호와 6개 번호 일치
  > * 2등 : 당첨 번호화 5개 번호 일치 + 보너스 번호 일치
  > * 3등 : 당첨 번호화 5개 번호 일치
  > * 4등 : 당첨 번호화 4개 번호 일치
  > * 5등 : 당첨 번호화 3개 번호 일치
- [X] 4. 수익률 계산
  + 4.1. 총 당첨금 계산
    > 각 등수의 당첨금 기준은 아래와 같다.
    > * 1등 : 2,000,000,000원
    > * 2등 : 30,000,000원
    > * 3등 : 1,500,000원
    > * 4등 : 50,000원
    > * 5등 : 5,000원
  + 4.2. 로또 구입비용과 총 당첨금을 기준으로 수익률 계산
    > 수익률은 소수점 둘째 자리에서 반올림한다.
- [X] 5. 실행 결과 출력
  + 5.1. 발행한 로또 수량 출력
  + 5.2. 발행한 로또 번호 출력
    > 로또 번호는 오름차순으로 정렬하여 보여준다.
  + 5.3. 당첨 내역 출력
  + 5.4. 총 수익률 출력

### 유의 사항

사용자가 잘못된 값을 입력해 오류가 발생할 경우, 오류 메시지를 출력 후 다시 입력받는다.

## 발생 가능 예외 목록

### 1. 사용자 입력 처리

#### 1.1. 로또 구입 금액 입력

- 금액으로 음수 입력
- 1,000원으로 나누어 떨어지지 않는 금액 입력
- 숫자가 아닌 다른 문자 입력

#### 1.2. 당첨 번호 입력

- 1 ~ 45 범위를 벗어난 번호 입력
- 구분자 쉼표(,) 이외의 다른 문자 입력
- 두 개 이상의 중복되는 번호 입력
- 여섯 개보다 많은 번호 입력

#### 1.3. 보너스 번호 입력

- 1 ~ 45 범위를 벗어난 번호 입력
- 숫자가 아닌 다른 문자 입력
- 당첨 번호로 입력받은 수와 중복되는 수 입력