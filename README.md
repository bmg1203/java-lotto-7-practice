# java-lotto-precourse

---
## 📌 패키지, 클래스 목록
- [x] controller
    - [x] Controller : try-catch문을 통해 로또 번호와 보너스 번호를 받는 메서드가 있습니다. service계층에서 구현한 게임의 로직과 view를 연결합니다.
- [x] model
    - [x] BonusNumber : 보너스 번호를 담당하는 클래스입니다. 1~45 사이의 숫자인지 확인하는 검증하는 메서드가 있습니다.
    - [x] Lotto : 사용자가 입력하는 당첨 번호를 담당하는 클래스입니다. 1~45 사이인지, 6개인지, 중복이 있는지 검증하는 메서드가 있습니다.
    - [x] Money : 사용자가 입력한 구입 금액을 담당하는 클래스입니다. 1000원 단위인지 검증하는 메서드가 있습니다.
    - [x] PurchasedLottoNumbers : 사용자가 입력한 금액만큼 난수를 관리하는 클래스입니다.
    - [x] RandomNumbers : 1~45 사이의 중복되지 않은 숫자 6개를 생성하는 클래스입니다.
- [x] service
    - [x] LottoRankingService : Lotto와 PurchasedLottoNumbers를 비교하여 등수를 산정하는 로직을 담당하는 클래스입니다.
    - [x] LottoBonusDuplicateCheckerService : BonusNumber가 Lotto와 중복되는지 검증하는 로직을 담당하는 클래스입니다.
    - [x] PurchasedLottoNumbersService : 사용자로부터 입력한 금액만큼 난수를 생성하여 PurchasedLottoNumbers 객체에 담는 로직을 담당하는 클래스입니다.
- [x] validation
    - [x] Parser : 사용자에게 입력받은 구입 금액이 문자열이 아니라면 이를 Int형으로 변환하는 로직을 담당하는 클래스입니다.
- [x] view
    - [x] ErrorMessage : Error 발생시 사용자에게 안내 메세지 출력을 담당하는 클래스입니다.
    - [x] InputView : 사용자에게 입력을 요구하는 안내 메세지를 출력하고, 입력을 받는 클래스입니다.
    - [x] OutputView : 사용자에게 결과에 해당하는 메세지를 출력하는 클래스입니다.
---
## 🚴‍♂️ 기능 목록
- [x] 사용자에게 "구입 금액을 입력해 주세요." 출력합니다.
- [x] 사용자로부터 구입 금액을 입력받습니다.
- [x] 잘못된 구입 금액을 입력한 경우, IllegalArgumentException을 발생시킨 후 종료합니다.
    - [x] 구입 금액이 문자열인 경우
    - [x] 구입 금액이 1000원 단위가 아닌 경우
- [x] 구입 금액만큼 난수를 생성합니다.
- [x] 사용자에게 "당첨 번호를 입력해 주세요." 를 출력합니다.
- [x] 잘못된 당첨 번호를 입력한 경우, IllegalArgumentException을 발생시킨 후 종료합니다.
    - [x] 숫자가 중복되는 경우.
    - [x] 숫자가 1~45 범위에 없는 경오
    - [x] 숫자가 6개가 아닌 경우
- [x] 사용자에게 "보너스 번호를 입력해 주세요." 를 출력합니다.
- [x] 잘못된 보너스 번호를 입력한 경우, IllegalArgumentException을 발생시킨 후 종료합니다.
    - [x] 보너스 번호가 1~45 범위에 없는 경우
    - [x] 보너스 번호가 당첨 번호와 중복되는 경우
- [x] 당첨 번호, 보너스 번호와 난수를 비교하여 등수를 산출합니다.
- [x] 산출된 등수를 바탕으로 수익률을 계산하여 출력합니다.
---
## 💣 예외 처리
- [x] 1000원 단위가 아닌 구입 금액을 입력한 경우 - 1 ex) 1001 -> "[ERROR] 1000원 단위의 금액을 입력해 주세요." 를 출력합니다.
- [x] 6개가 아닌 로또 번호를 입력한 경우 -  ex) 1,2,3,4,5 -> "[ERROR] 로또 번호는 6개여야 합니다." 를 출력합니다.
- [x] 로또 번호끼리 중복되는 경우 ex) 1,2,3,4,5,5 -> "[ERROR] 중복된 숫자를 입력하지 마시오." 를 출력합니다.
- [x] 로또 번호가 1~45 범위에 없는 경우 ex) 1,2,3,4,5,47 -> "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다." 를 출력합니다.
- [x] 보너스 번호가 로또 번호와 중복되는 경우 ex) Lotto: 1,2,3,4,5,6 BonusNumber: 6 -> "[ERROR]보너스 번호는 당첨 번호와 중복되어선 안됩니다." 를 출력합니다.
---
## 🚀 사용 예제
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