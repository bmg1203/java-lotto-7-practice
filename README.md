# 로또

로또 발매기입니다.

- 당첨은 1등부터 5등까지 있으며, 당첨 기준과 금액은 아래와 같습니다.
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원

- 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 합니다.
- 로또 1장의 가격은 1,000원이며, 반드시 1,000원 단위로만 구매할 수 있습니다.

## 입력

- 구입할 금액을 1,000원 단위로 입력합니다.
- 6개의 당첨 번호를 `콤마(,)로 구분`하여 `중복 없이` 입력합니다.
- 1개의 보너스 번호를 입력합니다.
- 번호는 `1~45` 사이입니다.

| 입력 문구            | 예시 입력         |
|------------------|---------------|
| 구입금액을 입력해 주세요.   | `8000`        |
| 당첨 번호를 입력해 주세요.  | `1,2,3,4,5,6` |
| 보너스 번호를 입력해 주세요. | `7`           |

## 출력
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

- [ ] 입력
    - [ ] 구입할 금액을 입력받아 정수로 변환한다.
    - [ ] 당첨 번호를 입력받아 정수 리스트로 변환한다.
    - [ ] 보너스 번호를 입력받아 정수로 변환한다.

- [ ] 로또 발행
    - [ ] 구입한 개수만큼 로또를 발행한다.
    - [ ] 발행한 로또의 등수를 결정한다.
        - [ ] 일치하는 번호 개수와 보너스 번호 적중 여부에따라 등수를 결정한다.
    - [ ] 수익률을 계산한다.

- [ ] 출력
    - [ ] 발행한 로또의 수량을 출력한다.
    - [ ] 발행한 로또의 번호를 오름차순으로 출력한다.
    - [ ] 발행한 로또의 당첨 내역을 출력한다.
    - [ ] 수익률을 출력한다.

- [ ] 검증 목록
    - [ ] 당첨 및 보너스 번호는 1부터 45사이의 정수이다.
    - [ ] 당첨 및 보너스 번호는 중복되지 않는다.
    - [ ] 로또는 최대 1000장 구매할 수 있다.
    - [ ] 1,000원 단위로만 구매할 수 있다.
