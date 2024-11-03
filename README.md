# java-lotto-precourse


# 기능 목록


### 입력 구현

- 구입 금액을 입력 받음

- 당첨 번호와 보너스 번호 입력받음

### 출력 구현

- 발행한 로또 수량 및 번호 출력

- 당첨 내역 출력

- 수익률 출력


### 로또 숫자의 정보를 담고 있는 Lotto 클래스 구현

#### 예외처리

- 로또 번호가 7개가 아니면 오류 메시지 출력


### 전반적인 Lotto 시스템을 진행하는 LottoManager 클래스 구현

- 랜덤으로 로또를 발행

- 값을 입력받아 당첨 번호를 저장

- 입력받은 돈에 따라서 로또를 발행

- 저장된 당첨 번호에 따라서 당첨 내역 계산

- 정담된 내역에 따라서 수익률 계산 

#### 예외처리

- 로또 구입 금액이 1,000원 단위로 나누어 떨어지지 않으면 예외 처리

- 로또 번호가 1~45 사이가 아니면 오류 메세지 출력

