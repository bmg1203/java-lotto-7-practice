## 💡 애플리케이션 설명

> ❓ 애플리케이션의 대략적인 설명입니다.
>

- 사용자로부터 돈을 받은 후, 알맞은 수의 로또를 발행하고 당첨내역과 수익률을 출력하는 애플리케이션 입니다.

## 🛤️ 애플리케이션 플로우

> ❓ 애플리케이션의 대략적인 흐름을 정리합니다.
>

1. 사용자에게 돈을 입력받는다.
2. 입력받은 돈에 알맞은 갯수의 로또를 발급한다.
3. 발급된 로또 번호를 오름차순으로 출력한다.
4. 사용자에서 로또 번호 6개와 보너스 번호 1개를 입력받는다.
5. 당첨 내역을 출력한다.
6. 수익률을 출력한다.

## ⚙️ 필수 기능

> ❓ 프로젝트에 필요한 필수 기능 정리을 정리합니다.
>

- 핵심기능 1. 돈을 천원 단위로 나누는 기능
- 핵심기능 2. 로또 티켓에 따라 알맞은 수의 로또를 발급하는 기능
- 핵심기능 3. 주어진 범위 내의 숫자를 랜덤으로 발급하는 기능
- 핵심기능 4. 당첨 내역을 비교, 관리하는 기능
- 핵심기능 5. 수익률을 계산하는 기능

---

- 추가기능 1. 잘못된 값이 입력됐을 경우, 에러 메시지 출력 후 다시 입력받는 기능
- 추가기능 2. 한번에 100장(10만원)의 로또를 발급하지 못하게 하는 기능
- 추가기능 3. 로또 번호를 오름차순으로 정렬하는 기능
- 추가기능 4. 소수점 둘째 자리에서 반올림하는 기능
- 추가기능 5. 숫자의 단위마다 ,(쉼표) 를 붙이는 기능
- 추가기능 6. 숫자 범위를 검증하는 기능

## 👉 입력

> ❓ 입력 예시입니다. 입력은 `camp.nextstep.edu.missionutils.Console.readLine()`을 사용합니다.
>

```bash
구입금액을 입력해 주세요.
8000

...

당첨 번호를 입력해 주세요.
1,2,3,4,5,6

보너스 번호를 입력해 주세요.
7
```

## 👈 출력

> ❓ 출력 예시입니다.
>

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

...

당첨 통계
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다.
```

## ⛔ 예외 목록

> ❓ 프로그램의 예외 상황입니다. 프로그램이 예외일 경우, `IllegalArgumentException` 이 발생하고 `[ERROR]` 로 시작하는 관련 메시지 출력 후 다시 입력받습니다. 사양에 따라 추가되거나
> 삭제될 수 있습니다.
>

- [x]  입력이 공백이거나 없는 경우. (View Level)
- [x]  유저 로또 숫자가 자연수가 아닌 경우(ex 문자열 등)
- [x]  유저 로또 숫자가 6개가 아닌 경우
- [x]  유저 로또 숫자가 1 ~ 45 이외일 경우
- [x]  유저 로또 숫자가 중복됐을 경우
- [x]  유저 보너스 입력이 자연수가 아닌 경우
- [x]  유저 보너스 숫자가 1 ~ 45 이외일 경우
- [x]  유저 보너스 숫자가 유저 로또 숫자와 중복됐을 경우
- [x]  구입 금액이 자연수가 아닌 경우
- [x]  구입 금액이 0원 이하, 10만원 초과인 경우
- [x]  구입 금액이 1000원 단위로 나누어지지 않는 경우

## ⭕  참고사항

> ❓애플리케이션의 참고사항을 정리합니다.
>

- 반올림 알고리즘은 Banker’s rounding이 아닙니다.
- 0원은 입력받을 수 없습니다.
- 최대 입력 액수는 10만원 입니다. 로또 중독이 되지 않도록 주의합시다.

## 📂 폴더 구성

> ❓ 폴더 및 파일 구성입니다.
>

```bash
src
    ├── main
    │   └── java
    │       └── lotto
    │           ├── Application.java
    │           ├── constants
    │           │   ├── Constants.java
    │           │   ├── ErrorMessages.java
    │           │   ├── OutputMessages.java
    │           │   └── Prizes.java
    │           ├── controller
    │           │   └── LottoGameController.java
    │           ├── domain
    │           │   ├── Lotties.java
    │           │   ├── Lotto.java
    │           │   ├── LottoResult.java
    │           │   ├── Ticket.java
    │           │   └── UserLotto.java
    │           ├── dto
    │           │   ├── PublishedLottiesDTO.java
    │           │   ├── ResultMarginDTO.java
    │           │   ├── UserLottoDTO.java
    │           │   ├── UserMoneyDTO.java
    │           │   └── UserSixNumberDTO.java
    │           ├── service
    │           │   ├── LottoBowl.java
    │           │   ├── LottoComparator.java
    │           │   └── MarginCalculator.java
    │           ├── utils
    │           │   ├── NumberValidator.java
    │           │   ├── RandomNumbersGenerator.java
    │           │   ├── StringSplitter.java
    │           │   └── UnitConverter.java
    │           ├── view
    │           │   ├── InputView.java
    │           │   └── OutputView.java
    │           └── vo
    │               └── Money.java
    └── test
        └── java
            └── lotto
                ├── ApplicationTest.java
                ├── MyApplicationTest.java
                ├── domain
                │   ├── LottoResultTest.java
                │   ├── LottoTest.java
                │   ├── TicketTest.java
                │   └── UserLottoTest.java
                ├── services
                │   └── LottoBowlTest.java
                ├── utils
                │   ├── NumberValidatorTest.java
                │   ├── StringSplitterTest.java
                │   └── UnitConverterTest.java
                └── vo
                    └── MoneyTest.java
```