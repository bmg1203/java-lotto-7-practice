# java-lotto-precourse

간단한 로또 발매기를 구현한다.

## 기능 요구사항
로또 번호의 숫자 범위는 1~45까지이다.\
1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.\
당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.\
당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.

1등: 6개 번호 일치 / 2,000,000,000원\
2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원\
3등: 5개 번호 일치 / 1,500,000원\
4등: 4개 번호 일치 / 50,000원\
5등: 3개 번호 일치 / 5,000원

로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.\
로또 1장의 가격은 1,000원이다.\
당첨 번호와 보너스 번호를 입력받는다.\
사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.\
사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, \
"[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.\

### 입력 요구사항
로또 구입 금액을 입력\
구입금액은 천원 단위로 받는다. 1000원으로 나눠 떨어지지 않으면 예외처리\
당첨 번호 입력(6개). 번호는 쉼표 기준으로 구분\
보너스 번호 입력(1개)

구입 금액을 입력해 주세요.\
당첨 번호를 입력해 주세요.\
보너스 번호를 입력해 주세요.

### 출력 요구사항
발행한 로또 수량 및 번호 출력. 로또 번호 오름차순 정렬\
수익률은 소수점 둘째 자리에서 반올림
예외 상황 시 에러 문구 출력. 단, 에러 문구 [ERROR] 로 시작

8개를 구매했습니다.\
[8, 21, 23, 41, 42, 43] \
[3, 5, 11, 16, 32, 38] \
[7, 11, 16, 35, 36, 44] \
[1, 8, 11, 31, 41, 42] \
[13, 14, 16, 38, 42, 45] \
[7, 11, 30, 40, 42, 43] \
[2, 13, 22, 32, 38, 45] \
[1, 3, 5, 14, 22, 45]

당첨 통계

\---\
3개 일치 (5,000원) - 1개\
4개 일치 (50,000원) - 0개\
5개 일치 (1,500,000원) - 0개\
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\
6개 일치 (2,000,000,000원) - 0개\
총 수익률은 62.5%입니다.

---
## 구현해야 할 기능 목록

## 입력 - 프로세스 - 출력
### 입력
1. 사용자로부터 구입금액을 입력받는다. 입력받은 금액을 천원 단위로 나눠 구매할 로또의 개수를 파악한다.
2. 당첨번호를 입력받는다. 쉼표를 구분자로 삼아 1~45사이의 숫자 6개를 입력받는다. 이때 중복되는 숫자가 없어야 한다.
3. 보너스 번호를 입력받는다. 1 ~ 45 사이이며 당첨번호에 없는 숫자를 입력받는다.

### 프로세스
1. 1 ~ 45 사이의 당첨번호 6개를 추첨한다. 이때, 중복되는 숫자는 없다.
2. 1 ~ 45 사이의 보너스 번호 1개를 추첨한다. 이때, 당첨번호에 있는 숫자는 제외한다.
3. 유저가 구매한 로또와 당첨번호를 비교한다. 순서와 상관없이 유저의 로또가 갖는 숫자들과 당첨번호가 동일하면 당첨이다

### 출력
1. 유저가 구매한 로또(들)의 당첨 통계를 출력한다.
2. 유저의 수익률을 출력한다.

### 예외처리

### *구매 금액을 입력받을 떄의 예외*
1. 구매금액이 1000원 미만
2. 구매금액이 1000원으로 떨어지지 않을 때
3. 숫자 외에 다른 문자들이 올 때
4. 입력에 공백이 포함될 때

### *당첨 번호를 입력받을때의 예외*
1. 쉼표로 시작하거나 끝날때
2. 쉼표와 쉼표 사이 공백이 있을때
3. 숫자와 공백이 같은 토큰에 있을때
4. 공백으로 시작할떄
5. 입력끝에 엔터 제외 다른 공백이 있을때
6. 숫자 외에 다른게 있을떄
7. 연속되는 쉼표가 있을 떄
8. 1~45 외의 범위의 숫자가 입력될 때
   
### *보너스 번호를 입력받을 때의 예외*
1. 1~45 외의 범위의 숫자가 입력될 떄
2. 당첨번호중 하나가 입력될 때
3. 숫자 외의 문자가 입력될 때
4. 입력에 공백이 포함될 때
