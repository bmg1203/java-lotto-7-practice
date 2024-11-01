# 로또 🪙

## 기능 구현 목록 ⚙️

### ✅ 로또 발행 기능
- [x] 1 ~ 45까지 범위 6개 숫자 추출
    - `Randoms의 pickUniqueNumbersInRange()` 사용
- [x] 금액 만큼 로또 장수 발행 (장당 1,000원)
- [x] 로또 장수 만큼 번호 발행 (중복 방지 추가)

### ✅ 발행 로또 번호 정보 반환 기능
- [x] 로또 번호는 오름차순으로 정렬
- [x] 로또 번호를 `', '` 구분자 기준으로 합치기
- [x] 여러 로또들의 번호 반환 

### ✅ 당첨 확인 기능
- [ ] 당첨 번호 비교 후 당첨액 확인
- [ ] 구입금액과 당첨액으로 수익률 계산

### ✅ 입력
- [x] 로또 구입 금액 입력 요청문 ex) `구입금액을 입력해 주세요.`
- [x] 로또 구입 금액 입력 (1,000원 단위)
- [x] `예외처리` 0원일 경우
- [x] `예외처리` 1,000원 단위가 아닌 경우
---
- [x] 당첨 번호 입력 요청문 ex) `당첨 번호를 입력해 주세요.`
- [x] 당첨 번호 입력 
- [x] 번호는 쉼표 ',' 구분해 리스트 생성
- [ ] `예외처리` 1 ~ 45 숫자 범위가 아닌 경우
- [ ] `예외처리` 번호가 중복되는 경우
- [ ] `예외처리` 번호가 6개가 아닌 경우
---
- [ ] 보너스 번호 입력 요청문 ex) `보너스 번호를 입력해 주세요.`
- [ ] 보너스 번호 입력
- [ ] `예외처리` 1 ~ 45 숫자 범위가 아닌 경우
- [ ] `예외처리` 번호가 1개가 아닌 경우
---
- [x] `공통예외처리` 공백 or 빈 문자일 경우
- [x] `공통예외처리` 숫자가 아닌 문자열인 경우

### ✅ 출력
- [x] 로또 구입 갯수 문구 출력 ex) `N개를 구매했습니다.`

- [x] 구입 랜덤 로또 번호 출력
```
ex)
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[1, 3, 5, 14, 22, 45]
```

- [ ] 당첨 통계 출력
```
ex)
당첨 통계
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
```
- [ ] 당첨 수익률 출력 (소수점 둘째 자리에서 반올림) ex) `총 수익률은 62.5%입니다.`

### ✅ 예외 처리
- [ ] 예외 상황 시 구체적인 에러 메시지 출력 ex) `[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.`
- [ ] `Exception`이 아닌, 명확한 에러 유형으로 처리
- [ ] 에러 메시지 출력 후 발생 지점부터 다시 입력 처리


### ✅ 실행 결과 예시
```
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