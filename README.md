# 우아한테크코스 프리코스 3주차: 로또


## 기능 설명

간단한 로또 발매기를 구현합니다.

1. 로또 구입
    1. 로또 구입 금액을 1,000원 단위로 입력받아, 금액만큼의 로또번호를 자동발행합니다.
    2. 로또는 1장당 1,000원입니다.
    3. 1장의 로또마다, 1~45 범위 내에서 중복되지 않는 6개의 숫자를 생성합니다.
2. 당첨 번호 발행
    1. 당첨 번호는 중복되지 않는 숫자 6개와 보너스 번호 1개를 입력받습니다.
    2. 당첨은 1등부터 5등까지 있습니다:
        - 1등: 6개 번호 일치 / 2,000,000,000원
        - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
        - 3등: 5개 번호 일치 / 1,500,000원
        - 4등: 4개 번호 일치 / 50,000원
        - 5등: 3개 번호 일치 / 5,000원
3. 당첨 내역
    1. 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역과 수익률을 출력합니다.
4. 잘못된 값의 경우
    1. 잘못된 값을 입력받았을 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받습니다.

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

<br>

예외 상황 예시:
```
[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.
```

