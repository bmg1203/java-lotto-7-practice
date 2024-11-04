# java-lotto-precourse

# 🛠️ 진행 과정

## ✍🏻 로또 구매 하기

### ✅ 1. 구입 금액 입력
- [x] 로또 구매 할 금액 입력 받기

### ❌ 예외 상황

- [x] 숫자 외 문자 포함 시 에러
- [x] 1,000원 단위가 아니면 에러
- [x] 최소 1,000원 이상 입력

### ✅ 2. 구매 한 로또 번호 출력
- [x] 금액에 맞게 로또 발행 
- [x] 발행 한 로또 번호 출력하기

## 🕹️ 당첨 번호 입력

### ✅ 1. 당첨 번호
- [x] 로또 번호 6개 입력 받기
- [x] 쉼표(,) 기준으로 구분

### ✅ 2. 보너스 번호
- [x] 보너스 번호 1개 입력 받기

### ❌ 공동 예외 상황
- [x] 숫자 외 문자 포함 시 에러
- [x] 1 에서 45 사이 숫자만 받기
- [x] 숫자가 중복되면 에러

## 🎊 총 수익률 계산

### ✅ 1. 당첨 여부 확인
- [x] 로또 번호와 당첨 번호 비교 후 맞은 갯수 계산

### ✅ 2. 당첨 금액 계산
- [x] 해당 등수 count++
- [x] 해당 등수 상금과 당첨 횟수 곱한 후 리턴

### ✅ 3. 총 수익률 계산
- [x] 총 구매 금액 계산
- [x] 총 당첨 금액 계산
- [x] 계산한 값 바탕으로 총 수익률 계산 후 출력
