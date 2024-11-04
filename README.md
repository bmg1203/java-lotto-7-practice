# java-lotto-precourse

## 🔧 구현할 기능 목록

### 1️⃣ 로또를 구매하기 위한 금액 입력

#### 1-1. 구매 금액 입력

- [x] 로또를 구매하기 위한 금액을 입력한다.

#### 1-2. 금액 입력값에 대한 검증

- [x] 입력값이 빈 문자열인지 검증한다.
- [x] 입력값이 문자가 아닌지 검증한다.
- [x] 입력값이 1000의 단위로 떨어지지 않는지 검증한다.
- [x] 입력값이 100,000이 넘지 않는지 검증한다.
    - 해당 입력의 제한을 두는 이유는 너무 많은 출력을 방지하기 위해서입니다.
- [x] 입력값은 음수가 아닌지 검증한다.

### 2️⃣ 로또 생성 및 출력

#### 2-1. 로또 생성

- [x] 입력에 맞추어 로또를 생성한다.
- [x] 생성되는 로또는 미리 오름차순으로 정렬하여 저장한다.

#### 2-2. 로또 생성 검증

- [x] 로또는 하나당 6개의 숫자를 가지는지 검증한다.
- [x] 로또 번호는 1-45까지 값을 가지는지 검증한다.

#### 2-3. 로또 출력

- [x] 로또를 출력한다.

### 3️⃣ 당첨 번호 입력 💵

#### 3-1. 당첨 번호 및 보너스 번호 입력

- [x] 당첨 번호 6개 입력한다.

#### 3-2. 당첨 번호에 대한 검증

- [x] 입력값이 빈 문자열인지 검증한다.
- [x] 당첨 번호는 중복되지 않는지 검증한다.
- [x] 당첨 번호가 1-45 사이에 있는지 검증한다.
- [x] 당첨 번호 문자열을 구분자인 ","로 나누었을 때 6개의 숫자를 가지는지 검증한다.
- [x] 구분자로 나눈 후, 숫자로 변경을 한다. 이때, 변경되지 않는 지 검증한다.

#### 3-3. 보너스 번호 입력

- [x] 보너스 번호 1개 입력한다.

#### 3-4. 보너스 번호 검증

- [x] 입력값이 빈 문자열인지 검증한다.
- [x] 입력값이 문자가 아닌지 검증한다.
- [x] 보너스 번호는 기존에 있던 당첨 번호와 중복되지 않는지 검증한다.
- [x] 보너스 번호가 1-45 사이에 있는지 검증한다.

### 4️⃣ 당첨 계산 🏆

#### 4-1. 등수 계산

- [x] 당첨 번호와 보너스 번호, 그리고 구매한 로또를 비교하여 등수를 정한다.
- [x] 등수의 갯수와 등수에 맞는 총 금액을 계산한다.

#### 4-2. 등수 출력

- [x] 등수와 그 갯수에 맞게 출력한다.
    - 3개 일치 (5,000원) - 1개
    - 4개 일치 (50,000원) - 0개
    - 5개 일치 (1,500,000원) - 0개
    - 5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
    - 6개 일치 (2,000,000,000원) - 0개

### 5️⃣ 수익률 계산

#### 5-1. 수익률 계산

- [x] 기존에 있던 돈에 비해 수익이 얼마나 올랐는지 퍼센트로 계산한다.
- [x] 수익률은 소수점 두번째 자리에서 반올림한다.
- [x] 수익률은 마이너스가 될 수 없다.

#### 5-2. 수익률 출력

- [x] 수익률을 출력한다.

## 패키지 구조

```
.
└── lotto
├── Application.java
├── common
│ └── exception
│ ├── ErrorMessage.java
│ └── LottoException.java
├── controller
│ └── LottoController.java
├── domain
│ ├── lotto
│ │ ├── Investment.java
│ │ ├── Lotto.java
│ │ ├── LottoBundle.java
│ │ ├── LottoGenerator.java
│ │ └── LottoNumber.java
│ └── winning
│ ├── BonusNumber.java
│ ├── LottoResult.java
│ ├── Rank.java
│ └── WinningNumbers.java
├── utility
│ ├── Splitter
│ │ └── CustomSplitter.java
│ ├── converter
│ │ └── Converter.java
│ ├── generator
│ │ ├── RandomIntegerListGenerator.java
│ │ └── RandomNumberListGenerator.java
│ └── sorting
│ ├── AscendingSorter.java
│ └── Sorter.java
└── view
├── input
│ ├── ConsoleInputView.java
│ └── InputView.java
└── output
├── ConsoleOutputView.java
└── OutputView.java
```
