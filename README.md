# java-lotto-precourse


## 기능 구현 목록 📝

### ✨ 업데이트 내용

### ✅ 진행과정

#### 1. 로또 구입 금액을 입력 받는다.
- 구입 금액은 1,000원 단위만 가능
- 구입 금액의 최대는 Integer.MAX_VALUE로 제한

#### 2. 당첨 번호를 입력 받는다.
- 번호는 `,`(쉼표) 기준으로 구분
- 당첨 번호를 중복 불가
- 당첨 번호는 1 부터 45사이 자연수만 가능

#### 3. 보너스 번호를 입력 받는다.
- 보너스 번호는 당첨번호와 중복 불가
- 보너스 번호는 1 부터 45사이 자연수만 가능

#### 4. 발행한 로또 수량 번호를 출력한다.
- 로또 번호는 `오름차순`으로 정렬

#### 5. 당첨 내역을 출력한다.
- 당첨 내역은 5등 부터 1등까지 차례대로 출력
- 등수마다 당첨된 갯수 포함

#### 6. 수익률을 출력한다.
- 수익률은 소수점 둘째 자리에서 반올림  (ex. 100.0%, 51.5%, 1,000,000.0%)

#### 7. 예외 상황 시 에러 문구를 출력해야 한다.
- 에러 문구는 `[ERROR]`로 시작

### ✅ 실행 결과 예시
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

### ✅ 클래스 및 기능

#### 1. domain
##### Lotto

- [] 로또 번호의 정보를 갖고 있음
- [] 특정 숫자가 로또 번호에 있는지 판단

###### 예외 처리
- [] 번호가 중복된 경우
- [] 번호가 1~45를 벗어난 경우

##### Money

- [] 구입 금액의 정보를 갖고 있음
- [] 1,000으로 나눈 몫을 반환 (로또 티켓 수)

###### 예외 처리
- [] 자연수가 아닌 경우
- [] Integer.MAX_VALUE를 초과한 경우
- [] 1,000 단위가 아닌 경우

##### LottoGenerator
- [] 로또를 발행

##### LottoStore
- [] 로또를 구입금액 만큼 발행

##### WinningNumbers

- [] 당첨 번호와 보너스 번호의 정보를 갖고 있음
- [] 당첨 번호에 특정 숫자가 있는지 판단

##### BonusNumber
- [] 보너스 번호의 정보를 갖고 있음
- [] 특정 숫자가 보너스 번호와 일치하는지 판단

##### WinningResult
- [] 로또 당첨 결과를 반환

#### 2. util

##### LottoListValidator
- [] 리스트 사이즈 검증
- [] 리스트 중복 검증

##### LottoNumberValidator
- [] 숫자 범위 검증
- [] 숫자 단위 검증

##### LottoStringValidator
- [] 문자열 형식 검증

##### LottoInputConvertor
- [] 문자열을 숫자 리스트로 변환
- [] 문자열을 숫자로 변환