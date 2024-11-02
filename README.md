# java-lotto-precourse

# 기능 요구 사항

#### 로또

### 기능 ✨
1. 로또 일치 개수 판단
2. 로또 생성
3. 사용자 입력 처리
4. 금액 계산
5. 로또 추첨
6. 로또 당첨 결과 출력

### 프로세스 ⚙️
1. **로또 구입**

시뮬레이터 - 시뮬레이션 - 계산 - 로또 추첨기 - 로또 생성기

2. **로또 추첨**

로또 추첨국 - 시뮬레이터 - 로또 생성기

3. **로또 결과**

로또 확인기 - 로또 결과 출력 - 로또 추첨국 - 시뮬레이터

### 클래스 🌿
**역할
- 로또 연구소 
  : 프로세스를 시작하는 클래스

  - [ ] start

- 시뮬레이터
  : 사용자로부터 로또 구입 정보와 당첨 번호를 입력받는 클래스

  - 필드: 영수증, 로또
  - [ ] 구매 금액 물음
  - [ ] 구매 금액 입력 받기
  - [ ] 당첨 번호 물음
  - [ ] 당첨 번호 입력 받기
  - [ ] 보너스 번호 물음
  - [ ] 보너스 번호 입력 받기

- 시뮬레이션
  : 사용자가 구매한 금액에 맞는 로또를 생성하는 서비스 역할

  - [ ] 구매한 로또 개수 출력
  - [ ] 로또 만들기
  - [ ] 시뮬레이터에게 영수증 및 로또를 반환

- 계산
  : 사용자가 입력한 금액을 로또 구매 개수로 변환하는 클래스

  - [X] 금액을 로또 개수로 반환 (예: 7800원 -> 7개)
  - [X] 로또 금액 예외처리

- 로또 추첨기
  : 랜덤 값을 생성하여 로또 번호 리스트로 반환하는 클래스

  - [X] 랜덤값 리스트로 반환
 
- 로또 추첨국
  : 시뮬레이터가 입력 받은 로또를 기반으로 로또를 생성함

  - 필드 : 추첨한 로또
  - [ ] 로또 생성기로부터 로또 생성 후 필드에 저장

- 로또 생성기
  : 로또를 생성해줌

  - [ ] 로또 생성

- 로또 확인기
  : 사용자가 구매한 로또의 당첨 여부를 확인하는 클래스

  - [ ] 로또가 몇개 일치하는지 반환

- 로또 결과 출력
  : 로또 결과를 알려줌

  - [ ] 결과 출력 
  - [ ] 3개 일치 결과 출력
  - [ ] 4개 일치 결과 출력
  - [ ] 5개 일치 결과 출력
  - [ ] 5개, 보너스 일치 결과 출력
  - [ ] 6개 일치 결과 출력
  - [ ] 총수익률 출력 
---
** DTO
- 영수증
  : 구매한 금액을 담고 있는 데이터 전송 객체 (DTO)

- 로또
  : 로또 번호 6개를 가짐

---

** UTIL
- 로또 관리
  : 로또 객체들을 관리하는 일급 컬렉션 클래스

- 출력 enum
  : 출력 메시지 모음

- 에러 enum
  : 에러 메시지 모음

- app config
  : 의존성 주입해주는 클래스

# 예외 처리

- [ ] **IllegalArgumentException** : 사용자가 잘못된 값을 입력한 경우

