## 로또 🎱 💰

### 프로젝트 설명
- 1개에 1000원인 로또를 원하는 갯수만큼 구매
- 기본 6개의 번호와 보너스 번호 입력
```
  1등: 6개 번호 일치 / 2,000,000,000원
  2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
  3등: 5개 번호 일치 / 1,500,000원
  4등: 4개 번호 일치 / 50,000원
  5등: 3개 번호 일치 / 5,000원
```
- 구매한 가격 만큼 로또 갯수를 자동으로 번호를 오름차순으로 정렬하여 번호 출력
- 해당 등수의 총 당첨금과 지불한 금액을 통해 수익률 계산

---
### 예시
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
---
### 기능 사항

- [X] 로또 구입
    - [X] 지불액이 양의 정수인지 검증
    - [X] 지불액이 1000으로 나누어 떨어지는지 검증
    - [X] 지불액을 바탕으로 로또 총 갯수 계산

- [X] 당첨 로또 번호 6개 입력
    - [X] 당첨 로또 번호 6개를 `,`로 분할
    - [X] 로또 번호가 6개이기에 `,`의 갯수는 5개인지 검증
    - [X] 분할한 당첨 로또 번호가 총 6개인지 검증
    - [X] 분할한 당첨 로또 번호들이 모두 양의 정수인지 검증
    - [X] 당첨 번호들이 `1`~`46` 사이의 번호인지 검증
    - [X] 6개의 당첨 번호들이 서로 중복인지 검증

- [X] 보너스 번호 입력
    - [X] 번호가 양의 정수인지 검증
    - [X] 번호가 `1`~`46` 사이의 번호인지 검증
    - [X] 당첨 로또 번호 6개와 보너스 번호가 중복인지 검증

- [X] 랜덤 로또 번호 생성
    - [X] 구매 갯수만큼 랜덤 번호를 오름차순으로 정렬하여 출력

- [X] 당첨 계산
    - [X] 입력한 당첨 로또 번호들과 자동으로 생성한 로또 번호들을 비교하여 맞힌 번호 갯수 계산
    - [X] 입력한 보너스 번호와 자동으로 생성한 로또 번호들을 비교하여 보너스 번호 맞힘 유무 계산
    - [X] 각 등수가 몇번 나왔는지 계산

- [X] 당첨금 계산
    - [X] 맞힌 번호 갯수에 따라 금액 계산

- [X] 수익률 계산
    - [X] 지불한 금액과 총 당첨금을 통해 수익률 계산
