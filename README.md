# java-lotto-precourse

## 믿음직하고 간단한 로또 자동 판매기 구현!

* 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행하는 '자동 판매기'를 구현한다.
* 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
* ~~과제 끝나고 실제로 구매해봐야겠다ㅎㅎ~~

***

### 기능 목록

1. **로또 구입 및 금액 체크**

   가격: 로또 1장당 1,000원

2. **로또 번호 생성하기**

    범위: 1부터 45까지의 숫자
    특징: 중복되지 않는 6개의 숫자 생성

3. **당첨 번호 및 보너스 번호 추첨**

    당첨 번호: 중복 없는 6개 숫자
    보너스 번호: 당첨 번호와 중복되지 않는 추가 번호 1개

4. **당첨 결과 계산하기**

   1등: 6개 번호 일치 / ***2,000,000,000원***

   2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원

   3등: 5개 번호 일치 / 1,500,000원
   
   4등: 4개 번호 일치 / 50,000원
   
   5등: 3개 번호 일치 / 5,000원

5. **수익률 계산**
   
   수익률: 당첨금액 합계 / 총 구매 금액 * 100
   출력 형식: 소수점 둘째 자리까지 반올림하여 %로 표시

6. **예외 처리**

   IllegalArgumentException 및 관련 예외 사용

***

### 공부한 메소드 목록

assertRandomUniqueNumbersInRangeTest

: NsTest 라이브러리에서 제공하는 테스트 유틸리티 메서드로, 랜덤 값이 포함된 코드를 테스트할 때 특정한 랜덤 값을 강제로 지정해서 테스트할 수 있게 해 줍니다.

이를 통해 로또 번호처럼 매번 다르게 생성되는 랜덤 값이 고정되도록 설정할 수 있어서, 예상 출력값과 비교하여 테스트할 수 있게 합니다.


***


### 출력 결과

- Generator 테스트 
   - 중복 검사 및 출력 테스트
>몇장?
>
>7
> 
>[[11, 34, 38, 44, 30, 42], [29, 27, 24, 30, 13, 41], [38, 18, 44, 41, 14, 8], [33, 32, 45, 15, 38, 4], [39, 24, 25, 42, 14, 19], [44, 3, 31, 16, 11, 39], [5, 17, 22, 14, 29, 18]]
> 

