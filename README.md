# 로또 프로그램

이 프로그램은 로또 게임을 구현한 것으로, 사용자는 로또 번호와 보너스 번호를 입력하고 로또를 구매한 후, 당첨 번호와 비교하여 결과와 수익률을 확인할 수 있습니다.

## 프로그램 흐름도
초기 설계 단계에서 요구사항을 분석하고, 프로그램 흐름도를 작성한 후 코딩을 시작했습니다. 아래는 프로그램 흐름도입니다.

![프로그램 흐름도](https://github.com/leeedongjaee/java-lotto-7/blob/leeedongjaee/로또%20프로그램%20흐름도.jpeg?raw=true)

### 흐름도 설명
1. **구입 금액 입력**:
   - 사용자는 로또를 구매할 금액을 입력합니다. 금액은 1,000원 단위로 입력되어야 하며, 유효하지 않은 경우 오류 메시지를 출력하고 프로그램이 종료됩니다.

2. **로또 구매**:
   - 입력된 금액을 기준으로 구매할 수 있는 로또 수량을 계산하고, 해당 수량만큼 로또 번호를 생성합니다.
   - 구매한 로또 번호들을 출력합니다.

3. **당첨 번호 입력**:
   - 사용자는 당첨 번호 6개를 입력합니다. 번호는 중복되지 않으며, 각 번호는 1부터 45 사이의 유효 범위에 있어야 합니다.
   - 유효하지 않은 입력이 있을 경우 오류 메시지를 출력하고 프로그램이 종료됩니다.

4. **보너스 번호 입력**:
   - 보너스 번호 1개를 입력받습니다. 보너스 번호는 당첨 번호와 중복되지 않고, 1부터 45 사이의 유효 범위 내에 있어야 합니다.
   - 유효하지 않은 경우 오류 메시지를 출력하고 프로그램이 종료됩니다.

5. **결과 계산 및 출력**:
   - 입력된 당첨 번호와 보너스 번호를 기준으로, 구매한 로또 번호와 비교하여 당첨 내역을 계산합니다.
   - 각 등수별 당첨 수량과 수익률을 계산하여 출력합니다.

## 기능 요구사항

### 1. 구입 금액 입력
- **사용자 입력**: 사용자는 로또 구입 금액을 입력해야 합니다.
- **제약 조건**:
  - **1,000원 단위**: 구입 금액은 반드시 1,000원 단위여야 합니다.
  - **유효성 검사**: 입력된 금액이 숫자가 아닌 경우 또는 1,000원 단위가 아닌 경우 오류 메시지를 출력하고 프로그램이 종료됩니다.

### 2. 로또 번호 생성 및 구매
- **로또 번호 생성**: 구입 금액에 따라 생성할 로또 수를 계산하고, 랜덤으로 로또 번호를 생성합니다.
- **랜덤 번호 생성**: 각 로또는 1부터 45 사이의 숫자 중 중복되지 않는 6개의 번호로 구성됩니다.
- **결과 출력**: 생성된 로또 번호들을 출력하여 사용자에게 보여줍니다.

### 3. 당첨 번호 입력
- **사용자 입력**: 당첨 번호 6개를 입력해야 합니다.
- **제약 조건**:
  - **중복 없는 숫자**: 당첨 번호는 중복되지 않고, 각 번호는 1부터 45 사이의 유효 범위에 있어야 합니다.
  - **유효성 검사**: 유효하지 않은 번호가 입력되면 오류 메시지를 출력하고 프로그램이 종료됩니다.

### 4. 보너스 번호 입력
- **사용자 입력**: 보너스 번호 1개를 입력받습니다.
- **제약 조건**:
  - **중복 검사**: 보너스 번호는 당첨 번호와 중복되지 않으며, 1부터 45 사이의 유효 범위 내에 있어야 합니다.
  - **유효성 검사**: 유효하지 않은 번호가 입력되면 오류 메시지를 출력하고 프로그램이 종료됩니다.

### 5. 결과 계산 및 출력
- **등수 계산**: 구매한 로또 번호와 당첨 번호를 비교하여 각 등수별 당첨 내역을 계산합니다.
- **수익률 계산**: 전체 구입 금액과 당첨 금액을 비교하여 수익률을 계산하고, 소수점 둘째 자리까지 출력합니다.
- **결과 출력**: 각 등수별 당첨 수량과 전체 수익률을 사용자에게 출력합니다.

## 클래스 설명

### 1. Application
- 역할: 프로그램의 진입점입니다. `main` 메서드를 포함하고 있으며, 전체 프로그램을 초기화하고 `LottoController`를 실행하여 게임을 시작합니다.

### 2. LottoController
- 역할: 로또 게임의 주요 흐름을 관리합니다.
- 사용자로부터 구입 금액, 당첨 번호, 보너스 번호를 입력받고, 입력값을 검증합니다.
- 로또 번호를 생성하고 결과를 계산하여 최종 수익률을 출력합니다.

### 3. Lotto
- 역할: 로또 번호를 관리하는 클래스입니다.
- 로또 번호의 유효성을 검증하고, 생성된 번호를 저장합니다.

### 4. WinningLotto
- 역할: 당첨 번호와 보너스 번호를 관리하는 클래스입니다.
- 당첨 번호와 보너스 번호의 유효성을 검증하고, 로또 번호와의 비교를 통해 당첨 여부를 결정합니다.

### 5. LottoGenerator
- 역할: 랜덤 로또 번호를 생성하는 클래스입니다.
- 1부터 45 사이의 중복되지 않는 6개의 랜덤 번호를 생성하여 로또를 구성합니다.

### 6. LottoStatistics
- 역할: 당첨 결과와 수익률을 계산하는 클래스입니다.
- 사용자가 구매한 로또와 당첨 로또를 비교하여 각 등수별 당첨 수와 수익률을 계산합니다.

### 7. InputView
- 역할: 사용자로부터 입력을 받는 역할을 합니다.
- 구입 금액, 당첨 번호, 보너스 번호를 입력받아 프로그램에서 사용하도록 합니다.

### 8. OutputView
- 역할: 프로그램의 출력을 관리하는 클래스입니다.
- 구매한 로또 번호, 당첨 결과, 수익률을 포함하여 사용자에게 결과를 출력합니다.

## 사용법
1. 프로그램을 실행합니다.
2. 로또 구입 금액을 입력합니다.
3. 프로그램에서 구입 금액에 따라 로또 번호를 생성하고 출력합니다.
4. 당첨 번호 6개를 입력합니다.
5. 보너스 번호 1개를 입력합니다.
6. 프로그램이 당첨 내역과 수익률을 계산하고 최종 결과를 출력합니다.
