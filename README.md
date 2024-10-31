# java-lotto-precourse 
: 로또

# 기능 및 입출력 요구사항
## 입력 1
- [ ] 로또 구입 금액 입력
> 구입금액을 입력해 주세요. <br>
8000 
> <br>
<br>

## 로또 발행 (개수)
- [ ] 구입 금액만큼 로또 발행
- 로또 1장의 가격은 1000원

## 로또 발행 (번호 뽑기)
- [ ] 1개의 로또 발행
- 로또 : 중복되지 않는 6개의 숫자 + 보너스 숫자 1개
- 로또 번호의 숫자 범위는 1~45
- 1에서 45 사이 중복되지 않은 정수 6개 반환 : `Randoms.pickUniqueNumbersInRange(1, 45, 6)`

## 출력 1 : 구매한 로또 개수 출력
- [ ] 구매한 로또 개수 출력

## 출력 2 : 뽑은 로또 번호 출력
- [ ] 한 줄씩 발행한 로또의 번호 출력
- 오름차순으로 정렬하여 출력
> 8개를 구매했습니다. <br> 
[8, 21, 23, 41, 42, 43] <br>
[3, 5, 11, 16, 32, 38] <br>
[7, 11, 16, 35, 36, 44] <br>
[1, 8, 11, 31, 41, 42] <br>
[13, 14, 16, 38, 42, 45] <br>
[7, 11, 30, 40, 42, 43] <br>
[2, 13, 22, 32, 38, 45] <br>
[1, 3, 5, 14, 22, 45] <br>
> <br>

## 입력 2
- [ ] 당첨 번호 입력
- [ ] 보너스 번호 입력
> 당첨 번호를 입력해 주세요. <br>
1,2,3,4,5,6 <br>
<br>
보너스 번호를 입력해 주세요.<br>
7
> <br>
<br>

## 출력 3 : 당첨 통계 반환
- [ ] 1~5등이 각 몇 번씩 당첨되었는지 출력
- 1등 : 6개 번호 일치, 2000000000
- 2등 : 5개 번호 + 보너스 번호 일치, 30000000
- 3등 : 5개 번호 일치, 1500000
- 4등 : 4개 번호 일치, 50000
- 5등 : 3개 번호 일치, 5000
> 당첨 통계 <br>
--- <br>
3개 일치 (5,000원) - 1개<br>
4개 일치 (50,000원) - 0개<br>
5개 일치 (1,500,000원) - 0개<br>
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개<br>
6개 일치 (2,000,000,000원) - 0개

## 출력 4 : 수익률 출력
- [ ] 소수점 둘째 자리에서 반올림한 수익률 출력
> 총 수익률은 62.5%입니다.

<br>

# 예외 처리
- 예외 상황 시, `[ERROR]` 로 시작하는 에러 문구 출력
- [ ] 구입 금액이 1000원 미만인 경우
- [ ] 당첨 번호 중 중복되는 경우가 있을 경우
- [ ] 당첨 번호가 6개가 아닐 경우
- [ ] 당첨 번호의 기준이 쉼표(,)가 아닌 경우
- [ ] 당첨 번호에 숫자 범위를 넘어서는 번호가 있을 경우
- [ ] 당첨 번호가 숫자가 아닐 경우
- [ ] 보너스 번호가 당첨 번호 중 하나와 일치할 경우
- [ ] 보너스 번호에 숫자 범위를 넘어서는 번호가 있을 경우
- [ ] 보너스 번호가 숫자가 아닐 경우

<br>

# 프로그래밍 요구사항
- [ ] indent depth 2까지만 구현
- [ ] 3항 연산자 사용X
- [ ] 함수의 길이가 15라인을 넘지 않도록 구현
- [ ] else 예약어 대신 return 사용
- [ ] Java Enum을 적용하여 프로그램 구현
- [ ] 구현한 기능에 대한 단위 테스트 작성