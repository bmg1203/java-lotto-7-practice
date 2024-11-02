# java-lotto-precourse

## 🎲 프로그램 설명

- 간단한 로또 발매기를 구현한다.
- 사용자가 입력한 **로또 구입 금액**을 기반으로, 로또가 자동으로 구매된다.
- 사용자가 입력한 **로또 당첨 번호**와 **보너스 번호**를 기반으로, 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.

## 💻 프로그램 실행 예시
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
## 📌 클래스 구조

![diagram.png](image/diagram.png)

## 📄 기능 구현 목록

### 입출력
- [x] 로또 구입 금액을 입력받는다.
- [x] 로또 당첨 번호를 입력받는다.
- [x] 보너스 번호를 입력받는다.
- [x] 발행한 로또 수량 및 번호를 출력한다.
- [x] 당첨 내역과 수익률을 출력한다.
- [x] 예외 상황 시 에러 문구를 출력한다.

### 프로그램 실행
- [x] 사용자의 입력이 올바른지 검증한다.
- [x] 예외가 발생한 입력에 대해, 에러 메시지를 출력하고 다시 입력받는다.

### 로또
- [x] 금액만큼 로또를 발행한다.
- [x] 로또 당첨 여부를 확인한다.
- [x] 수익률을 계산한다.

## ❗️ 예외 상황
>사용자의 입력이 예외 상황에 해당하면 `IllegalArgumentException`을 발생시키고, `[ERROR]`로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.

- [x] 입력한 금액이 1000원 단위로 떨어지지 않는 경우
- [x] 입력한 금액이 0 이하인 경우
- [x] 입력한 금액이 정수가 아닌 경우
- [x] 입력한 당첨 번호가 1~45의 범위를 벗어나는 경우
- [x] 입력한 당첨 번호가 ","로 구분할 수 없는 경우
- [x] 각 당첨 번호가 정수가 아닌 경우
- [x] 입력한 보너스 번호가 1~45의 범위를 벗어나는 경우
- [x] 입력한 보너스 번호가 정수가 아닌 경우
- [x] 입력한 보너스 번호가 로또 번호와 겹치는 경우