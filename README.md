# java-lotto-precourse

간단한 로또 발매기를 구현합니다.

- 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다.
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
- 로또 1장의 가격은 1,000원이다.
- 당첨 번호와 보너스 번호를 입력받는다.
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.

> 당첨 기준과 금액은 아래와 같다.
> 
> - 1등: 6개 번호 일치 / 2,000,000,000원
> - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
> - 3등: 5개 번호 일치 / 1,500,000원
> - 4등: 4개 번호 일치 / 50,000원
> - 5등: 3개 번호 일치 / 5,000원

## 실행 예시

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

## 기능 목록

- 구입금액 입력
  - [X] `구입금액을 입력해 주세요.` 문구 출력
  - [X] 구입금액 입력
- 구매한 로또 출력
  - [X] `n개를 구매했습니다.` 형태로 문구 출력
  - [X] 구매한 로또 목록 출력
    - [X] 각 로또의 번호는 오름차순으로 출력
- 당첨 번호 입력
  - [ ] `당첨 번호를 입력해 주세요.` 문구 출력
  - [ ] 당첨 번호 입력
    - [ ] 쉼표(,)를 기준으로 구분
- 보너스 번호 입력
  - [ ] `보너스 번호를 입력해 주세요.` 문구 출력
  - [ ] 보너스 번호 입력
- 당첨 통계 출력
  - [ ] `당첨 통계\n---` 문구 출력
  - [ ] `x개 일치 (y원) - z개` 형태로 당첨 통계 문구 출력
  - 보너스 번호가 일치하는 경우
    - [ ] `x개 일치, 보너스 볼 일치 (y원) - z개` 형태로 문구 출력
  - [ ] `총 수익률은 n%입니다.` 형태로 문구 출력
    - [ ] 수익률은 소수점 둘째 자리에서 반올림

## 예외 상황
 
사용자가 잘못된 값을 입력할 경우 예러 메시지를 출력하고 그 부분부터 입력을 다시 받는다.
에러 문구는 `[ERROR]`로 시작한다.

- 구입금액 입력
  - 자연수(1 이상의 모든 정수)가 아닌 경우
    - 숫자가 아닌 문자가 포함된 경우
    - 타입의 표현 범위를 벗어난 경우
    - 음수(-)인 경우
    - 0인 경우
  - `1,000원`으로 나누어 떨어지지 않는 경우
- 당첨 번호 입력
  - 구분자인 쉼표(,)와 자연수 외의 문자가 포함된 경우
  - 쉼표(,)로 입력값을 구분
    - 구분 후 개수가 `6개`가 아닌 경우
    - 구분된 값이 자연수가 아닌 경우
    - 구분된 숫자가 로또 번호의 범위를 벗어난 경우
- 보너스 번호 입력
  - 자연수(1 이상의 모든 정수)가 아닌 경우
    - 숫자가 아닌 문자가 포함된 경우
    - 숫자가 로또 번호의 범위를 벗어난 경우
    - 음수(-)인 경우
    - 0인 경우

## 커밋 메시지 컨벤션

커밋 단위는 앞에서 정리한 구현할 기능 목록 단위로 진행됩니다.  
[AngularJS Git Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)를 참고하여 커밋 컨벤션을
구성하였습니다.

```text
<작업 유형>: <주제>
<공백>
<본문>
```

## 작업 유형

커밋의 유형을 표시합니다.

- **feat**: 새로운 기능 추가
- **fix**: 버그 수정
- **docs**: 문서 관련 변경 사항
- **refactor**: 코드 리팩토링 (버그 수정이나 기능 추가가 아닌 코드 구조 변경)
- **test**: 테스트 추가 또는 수정

## 주제

커밋의 주제를 간단히 작성합니다.

- 명령형으로 작성합니다.
- 문장 끝에 마침표를 사용하지 않습니다.
- 예시 : `fix: 로또 번호 중복 생성 문제 수정`

## 본문 (선택 사항)

- 변경(및 추가) 이유와 변경된 부분의 자세한 내용을 설명합니다.
- 현재 시제 문장 형태로 작성합니다.
- 이전 동작과의 차이점을 작성합니다.

## 커밋 메시지 예시

```text
docs: 구현할 기능 목록 작성
```

```text
feat: 결과 출력 기능 구현
```

```text
fix: 로또 번호 중복 생성 문제 수정
로또를 발급할 때 중복된 번호가 포함될 수 있던 문제를 수정합니다.
이전에는 로또 번호가 번호가 중복될 수 있었지만, 이제 로또 번호는 중복 생성되지 않도록 검증 로직을 추가합니다.
```