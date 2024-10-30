# java-lotto-precourse

[1. 과제](#과제)  
[2. 구현해야 하는 기능 목록](#구현해야-하는-기능-목록)  
[3. 예외 상황](#예외-상황)

## 과제

로또 발매와 당첨 내역 및 수익률 출력

### 주요 기능

- 1000원짜리 로또 구매 (1000원에 로또 번호 6개)
- 1부터 45까지의 6개 랜덤 숫자를 구매한 로또 개수만큼 발행
- 1부터 45까지의 당첨 번호 여섯 개와 보너스 번호 입력
- 발행했던 로또가 3개/ 4개/ 5개/ 5개 + 보너스/ 6개 각각 일치하는 경우 계산
- 수익률 계산, 소수점 둘째 자리에서 반올림
- 결과 출력

### 실행 결과 예시

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

## 구현 기능 목록

- [x] 사용자가 잘못된 값 입력 시 IllegalArgumentException 발생
    - [x] "\[ERROR]" 로 시작하는 메시지 출력
    - [x] 재입력
- [x] 로또 구입 금액 입력
    - [x] 1,000원 단위 검증
- [x] 구매한 로또 수량 출력
- [x] 구매한 로또 수량만큼 6개의 로또 번호 발행
    - [x] 오름차순으로 정렬된 값 출력
- [x] 당첨 번호 6자리 입력
    - [x] 쉼표를 기준으로 구분
    - [x] 1~45 사이의 숫자 검증
    - [x] 중복 검사
- [x] 보너스 번호 입력
    - [x] 1~45 사이의 숫자 검증
    - [x] 당첨 번호 중복 검증
- [x] 3개/ 4개/ 5개/ 5개 + 보너스/ 6개 일치 결과 계산
    - [x] 당첨 금액 계산
    - [x] 수익률 계산 (소수점 둘째 자리에서 반올림)
- [x] 당첨 내역 출력
- [x] 수익률 출력
- [ ] 예외 처리
- [ ] 리팩토링

## 예외 상황

### 로또 구입 금액

| 예외 상황                | 예시             |
|----------------------|----------------|
| 미입력  또는 공백 포함        | null or blank  |
| int형으로 변환 불가         | "a" or " 1000" |
| 양수X                  | "-1000" or "0" |
| 로또 구입 금액 % 1000 != 0 | 200 or 1024    |

### 당첨 번호

| 예외 상황                 | 예시                                                 |
|-----------------------|----------------------------------------------------|
| 미입력 또는 공백             | null or "" or " "                                  |
| int형으로 변환 불가한 문자가 포함됨 | "1,2.3,4,5,6" or "1a,2,3,4a5,6" or "1, 2,3,4 ,5,6" |
| 1 미만 or 45 초과 숫자      | "1,2,3,44,9,100" or "0,1,2,-10,5,9"                |
| 6개 미만 또는 초과           | "1,2,3" or "1,2,3,4,5,6,7"                         |
| 당첨 번호 중복              | "1,2,2,3,4,5"                                      |

### 보너스 번호

| 예외 상황           | 예시                             |
|-----------------|--------------------------------|
| 미입력 또는 공백       | null or "" or " "              |
| int형으로 변환 불가    | "a" or " 10"                   |
| 1미만 or 45 초과 숫자 | "0" or "-1" or "46"            |
| 당첨 번호와 중복       | 당첨 번호: 1,2,3,4,5,6 / 보너스 번호: 2 | 
