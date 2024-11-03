# java-lotto-precourse


### 진행과정

#### 1. 로또 구입 금액을 입력한다.

- 구입 금액은 1000원 단위로 입력해야한다.
- 숫자가 아닌 값을 입력하면 안된다.

```text
14000
```

#### 2. 입력한 로또 구입 금액을 1000으로 나눈 몫의 수만큼 로또를 발행하고 출력한다.

- (ex: 14000/1000 = 14 => 14개 로또 발행)
- 발행되는 1개의 로또는 총 6개의 숫자로 이루어져있다.
- 6개의 숫자는 서로 중복되면 안된다.
- 로또 번호의 숫자 범위는 1~45이다.
- 로또 번호는 오름차순으로 정렬하여 보여준다.

```text
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[1, 3, 5, 14, 22, 45]
```

#### 3. 당첨번호를 쉼표(,)를 기준으로 구분하여 입력한다.

- 총 6개의 숫자를 쉼표(,)를 기준으로 입력해야한다.
- 로또 번호의 숫자 범위는 1~45이다.
- 각 로또 번호의 숫자들은 서로 중복되면 안된다.
- 구분자가 쉼표(,)가 아니면 안된다.

```text
1,2,3,4,5,6
```

#### 4. 보너스 번호를 입력한다.

- 로또 번호의 숫자 범위는 1~45이다.
- 1개의 숫자만 입력해야한다.

```text
7
```

#### 5. 당첨내역을 출력한다.

- 발행한 로또와 입력한 로또번호 및 보너스 번호를 비교하여 일치한 개수에 따라 당첨 순위를 정한다.

```text
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
```

#### 6. 수익률울 출력한다.
- 수익률은 `로또 당첨 금액 / 로또 구앱 금액 * 100`으로 계산한다.
- 수익률은 소수점 둘째 자리에서 반올림한다.

```text
총 수익률은 62.5%입니다.
```

#### 예외처리
- 예외 상황시 출력되는 에러문구는 "[ERROR]"로 시작해야한다.

```text
[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.
```

### 실행 결과 예시

```text
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



### 기능목록

#### 핵심비즈니스
- [] 발행할 로또 개수를 계산하는 기능
- [] 로또를 발행하는 기능
- [] 랜덤 숫자를 생성하는 기능
- [] 사용자가 구매한 로또 번호화 당첨 번호를 비교하는 기능
- [] 수익률을 계산하는 기능
- [] 로또 프로그램에 필요한 설정 값 모음

#### 검증
- [] 로또 번호 숫자의 범위를 검증하는 기능 ( 구매한 로또 번호, 입력한 당첨 로또 번호 )
- [] 로또 번호 숫자의 중복성을 검증하는 기능 ( 구매 로또 번호, 입력한 당첨 로또 번호 )
- [] 입력한 구입 금액이 1000원 단위인지 검증하는 기능
- [] 입력한 로또 번호의 개수를 검증하는 기능 ( 입력한 당첨 로또 번호, )
- [] 입력한 로또 번호의 구분자 형식을 검증하는 기능  ( 입력한 당첨 번호 )
- [] 입력한 로또 번호가 숫자인지 검증하는 기능 ( 입력한 당첨 번호 )

#### 유틸
- [] 랜덤 숫자를 생성하는 기능

#### 입력
- [] 로또 구입 금액을 입력받는 기능
- [] 당첨번호 6자리를 입력받는 기능
- [] 보너스 번호를 입력받는 기능

#### 츨력
- [x] 로또 구입 금액 입력 요청문을 출력하는 기능
- [] 구입하여 랜덤을 생성된 로또 번호들을 출력하는 기능
- [] 당첨 번호 입력 요청문을 출력하는 기능
- [] 보너스 번호 입력 요청문을 출력하는 기능
- [] 당첨 통계를 출력하는 기능
- [] 수익률을 출력하는 기능
- [] 에러 메시지를 출력하는 기능
  - 에러 문구는 `[ERORR]` 로 시작해야한다.