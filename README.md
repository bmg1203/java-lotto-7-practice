# java-lotto-precourse

목표
==========================================
- 관련 함수를 묶어 클래스를 만들고, 객체들이 협력하여 하나의 큰 기능을 수행하도록 한다.
- 클래스와 함수에 대한 단위 테스트를 통해 의도한 대로 정확하게 작동하는 영역을 확보한다.
- 2주 차 공통 피드백을 최대한 반영한다.
  - 마크다운 연습을 위해 문제와 똑같이 README를 구성해본다. (색상 넣는거는 제외...)


로또
==================================
과제 진행 요구 사항
-----------------------------------
- 미션은 [로또](https://github.com/woowacourse-precourse/java-lotto-7) 저장소를 포크하고 클론하는 것으로 시작한다.
- **기능을 구현하기 전 <code>README.md</code> 에 구현할 기능 목록을 정리해 추가한다.**
- Git의 커밋 단위는 앞 단계에서 <code>README.md</code>에 정리한 기능 목록 단위로 추가한다.
  - [AngularJS Git Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)을 참고해 커밋 메시지를 작성한다.
- 자세한 과제 진행 방법은 프리코스 진행 가이드 문서를 참고한다

기능 요구 사항
--------------------------------
간단한 로또 발매기를 구현한다.

- 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
  - 1등: 6개 번호 일치 / 2,000,000,000원
  - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
  - 3등: 5개 번호 일치 / 1,500,000원
  - 4등: 4개 번호 일치 / 50,000원
  - 5등: 3개 번호 일치 / 5,000원
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
- 로또 1장의 가격은 1,000원이다.
- 당첨 번호와 보너스 번호를 입력받는다.
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
- 사용자가 잘못된 값을 입력할 경우 <code>IllegalArgumentException</code>을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
  - <code>Exception</code>이 아닌 <code>IllegalArgumentException</code>, <code>IllegalStateException</code> 등과 같은 명확한 유형을 처리한다.
### 입출력 요구 사항
#### 입력
- 로또 구입 금액을 입력 받는다. 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.
````
 14000
````

- 당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.
````
1,2,3,4,5,6
````

- 보너스 번호를 입력 받는다.
````
7
````

#### 출력

- 발행한 로또 수량 및 번호를 출력한다. 로또 번호는 오름차순으로 정렬하여 보여준다.
````
8개를 구매했습니다. 
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[1, 3, 5, 14, 22, 45]
````

- 당첨 내역을 출력한다.
````
3개 일치 (5,000원) - 1개<br>
4개 일치 (50,000원) - 0개<br>
5개 일치 (1,500,000원) - 0개<br>
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개<br>
6개 일치 (2,000,000,000원) - 0개<br>
````

- 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)
````
총 수익률은 62.5%입니다.<br>
````

예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.

````
> [ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.
````

#### 실행 결과 예시
````
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
````

 ---------------------------------

## TODO LIST
  > 목표: 일급 콜렉션, 모듈 단위 테스트, 기능단위 커밋, 객체들의 협력, MVC 패턴 


### 입력, 출력
-[ ] 안내문구를 출력한다.
-[ ] 입력을 받는다.

````
구입금액을 입력해 주세요.
N
                        
당첨 번호를 입력해 주세요.
n,n,n,n,n,n

보너스 번호를 입력해 주세요.
n
````

````
8개를 구매했습니다.
[8, 21, 23, 41, 42, 43] 
[3, 5, 11, 16, 32, 38] 
[7, 11, 16, 35, 36, 44] 
[1, 8, 11, 31, 41, 42] 
[13, 14, 16, 38, 42, 45] 
[7, 11, 30, 40, 42, 43] 
[2, 13, 22, 32, 38, 45] 
[1, 3, 5, 14, 22, 45]
  
당첨 통계
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다.
````

### 로또
- [x] 번호의 유효성을 체크한다.
  > 크기, 값의 범위, 중복 여부
- [ ] 번호를 정렬한다.
- [ ] 우승 로또와 맞는 개수를 전달한다.
- [ ] 보너스볼을 체크한다.
- [ ] 로또 번호를 전달한다.
### 로또등수
- [ ] 로또 등수를 관리한다.
- [ ] 로또 등수 조건을 출력한다.
- [ ] 로또 등수의 값을 리턴한다. 
### 로또그룹
- [ ] 일급 컬렉션으로 구현한다.
- [ ] N개 만큼 로또 생성
- [ ] 로또에서 받은 번호를 N개 출력한다
- [ ] 로또 등수를 이용하여 통계를 출력한다.
- [ ] 로또 등수를 이용하여 수익율을 계산한다.
- [ ] 로또 수익율 출력한다.


### 컨트롤러
- [ ] 각 클래스를 적절히 호출한다.