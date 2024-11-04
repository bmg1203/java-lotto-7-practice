# 로또 발매기
### 소개
- 사용자가 1장에 1000원인 로또를 구매하기 위해 1000원 단위로 구입금액을 입력해준다.
- 사용자의 구입금액만큼 로또를 발행한다.
- 사용자가 1 ~ 45 사이의 숫자 중 중복되지 않는 6개의 당첨번호를 입력한다.
- 사용자가 1 ~ 45 사이의 숫자 중 앞서 뽑은 6개의 당첨번호를 제외한 보너스 번호를 입력한다.
- 당첨 내역과 수익률을 보여준다.
---
### 기능 목록
- **사용자에게 입력받기**
  - [X] 구입금액 입력받기 (1000원 단위로 입력)
    - [X] 숫자가 아닐 경우 -> **"[ERROR] 구입금액은 숫자로 입력해야 합니다."**
    - [X] 1000원으로 나누어 떨어지지 않을 경우 -> **"[ERROR] 구입금액은 1000원 단위로 입력해야 합니다."**
  - [X] 당첨 번호 6개 입력받기
    - [X] 콤마와 숫자 이외의 문자가 있을 경우 -> **"[ERROR] 당첨 번호는 숫자와 쉼표로만 입력해야 합니다."**
    - [X] 1부터 45 사이의 숫자가 아닐 경우 -> **"[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다."**
    - [X] 숫자가 중복될 경우 -> **"[ERROR] 당첨 번호는 중복되면 안됩니다."**
  - [X] 보너스 번호 입력받기
    - [X] 숫자가 아닐 경우 -> **"[ERROR] 보너스 번호는 숫자로 입력해야 합니다."**
    - [X] 1부터 45 사이의 숫자가 아닐 경우 -> **"[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."**
    - [X] 당첨 번호와 숫자가 중복될 경우 -> **"[ERROR] 보너스 번호는 당첨 번호와 중복되면 안됩니다."**


- **구입금액에 대한 로또 생성**
  - [X] 구입금액만큼 1 ~ 45 사이의 숫자 중 중복되지 않는 숫자 6개 생성
  - [X] 생성한 로또 사용자에게 출력


- **생성한 로또와 입력 값 비교**
  - [X] 등수(3 ~ 6개 일치할 경우)목록 만들기
  - [X] 발행한 로또와 당첨 번호 및 보너스 번호를 비교하기
  - [X] 일치하는 개수가 3 ~ 6개 일경우 해당 개수에 대한 등수목록에 더하기
  - [ ] 당첨금액 누적하기


- **당첨 통계 출력**
  - [ ] 등수목록 출력하기
  - [ ] 수익률 출력하기