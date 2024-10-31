# java-lotto-precourse

## 🎱 로또

---

### 기능 요구 사항

간단한 로또 발매기를 구현한다.

- 로또 번호의 숫자 범위는 1~45이다.
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

---

**실행 결과 예시**

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

## 🪐구현할 기능 목록

---

- [x] **구입 금액 입력받기**
    - [x] 구입 금액 입력을 요청하는 문구를 출력한다.
    - [x] 구입 금액을 입력받는다.
        - [x] 빈 문자열 또는 null이 아님을 검증한다.
        - [x] 숫자로 이루어진 값임을 검증한다.
        - [x] 입력 값이 로또 가격의 배수임을 검증한다. (현재는 1,000원)
        - [x] 최대 100,000원까지만 구입할 수 있도록 한다.

- [x] **구입 금액에 맞게 로또를 발행하기**
    - [x] 구입 금액에 맞는 로또 수량을 계산한다.
    - [x] 로또 구입을 완료했다는 문구를 출력한다.
    - [x] 로또 수량만큼 로또 번호를 출력한다.
        - [x] 로또를 구성하는 번호는 1~45 사이의 랜덤 숫자여야 한다.
        - [x] 하나의 로또에서 각 번호는 고유해야 한다.
        - [x] 로또를 구성하는 번호는 오름차순이어야 한다.
        - `ex: [8, 21, 23, 41, 42, 43]`

- [ ] **당첨 번호 입력받기**
    - [x] 당첨 번호 입력을 요청하는 문구를 출력한다.
    - [ ] 당첨 번호를 입력받는다.
        - [ ] 빈 문자열 또는 null이 아님을 검증한다.
        - [ ] 입력한 당첨 번호는 1~45 사이의 숫자인지 검증한다.
        - [ ] 쉼표로 구분되어 있는지 검증한다.
        - [ ] 각각 고유한 숫자가 6개인지 검증한다.

- [ ] **보너스 번호 입력받기**
    - [ ] 보너스 번호 입력을 요청하는 문구를 출력한다.
    - [ ] 보너스 번호를 입력받는다.
        - [ ] 빈 문자열 또는 null이 아님을 검증한다.
        - [ ] 입력한 숫자가 하나의 숫자인지 검증한다.
        - [ ] 입력한 보너스 번호가 1~45 사이의 숫자인지 검증한다.

- [ ] **당첨 통계 출력하기**
    - [ ] 당첨 통계 문구를 출력한다.
    - [ ] 일치하는 로또 번호 개수에 따라서 당첨 통계를 출력한다.