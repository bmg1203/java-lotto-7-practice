# java-lotto-precourse
# 로또
## 0. 공통 사항
+ 사용자가 잘못된 값을 입력할 경우 에러 표시 이후 재입력
## 1. 로또 구입 금액 입력
- [x] 로또 구입 금액 입력
- [x] 입력값 검증
    - [x] 공백 검사
    - [x] Integer 변환 가능 여부 확인
    - [x] 양수 확인
    - [x] 1000원 단위 확인 (나누어 떨어짐)
## 2. 로또 번호 생성 및 출력
- [x] 구입 금액에 따른 로또 수량 계산
- [x] 중복되지 않는 로또 번호 6개 생성
- [x] 생성된 로또 번호 출력
## 3. 당첨 번호 입력
- [x] 당첨 번호 입력
- [x] 입력값 검증
    - [x] 공백 검사
    - [x] 구분자로 번호 분리
    - [x] Integer 변환 가능 여부 확인
    - [x] 당첨 번호 저장
      - [x] 6개 입력 확인
      - [x] 번호 범위 (1~45) 확인
      - [x] 당첨 번호 중복 확인
## 4. 보너스 번호 입력
- [ ] 보너스 번호 입력
- [ ] 입력값 검증
    - [ ] 공백 검사
    - [ ] Integer 변환 가능 여부 확인
    - [ ] 당첨 번호와 중복 확인
    - [ ] 번호 범위 (1~45) 확인
## 5. 당첨 결과 처리
- [ ] 로또 당첨 정보 계산
- [ ] 수익률 계산
## 6. 결과 출력
- [ ] 당첨 통계 출력
- [ ] 수익률 출력