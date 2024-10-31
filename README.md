# java-lotto-precourse
우아한테크코스 7기 프리코스 3주차 미션 **로또**
- 진행 기간: 24.10.29(화) 15:00 ~ 24.11.4(월) 23:59
  - 제출 가능 시간: 24.11.3(일) 15:00 ~ 24.11.4(월) 23:59

## 문제 파악하기
- 핵심 기능: 숫자를 비교하는 기능과 수익률을 계산하는 기능

## 구현할 기능 목록
- [x] 구매 금액
  - [x] 1000원 단위가 아니면 `IllegalArgumentException`
  - [x] 살 수 있는 장수 계산 기능
- [x] 로또
  - [x] 로또 번호 자동 생성 기능
  - [x] 번호는 1이상 45이하만 가능
    - [x] 해당하지 않으면 `IllegalArgumentException`
  - [x] 번호는 중복 안됨
    - [x] 해당하지 않으면 `IllegalArgumentException`
  - [x] 자기 자신의 정보를 출력하는 기능
  - [x] 특정 숫자가 들어있는지 파악하는 기능 
  - [x] 다른 로또와 같은 숫자가 몇 개인지 비교하는 기능
  - [ ] 자기 자신의 정보를 출력하는 기능 - `[1, 2, 3, 4, 5, 6]`같은 형식
- [x] 당첨 번호
  - [x] `Lotto`에서 처리되는 당첨 번호
    - [x] 중복 번호 불가
    - [x] 1이상 45이하만 가능
  - [x] 보너스 번호가 기존 번호에 없어야 한다.
    - [x] 있다면 `IllegalArgumentException`
    - [x] 보너스 번호 범위는 1이상 45이하만 가능하다.
- [ ] 랭킹 정보(등수 정보)
  - [ ] 당첨 로또와 일반 로또를 비교해서 어떤 랭킹인지 알려주기
    - [ ] 랭킹에 포함되지 않으면 `IllegalStateException` 을 던진다.
  - [ ] 자기 자신의 정보를 출력하는 기능 - `3개 일치 (5,000원)` 혹은 `5개 일치, 보너스 볼 일치 (30,000,000원)` 형태
- [ ] 매칭 결과
  - [ ] 매칭된 수를 업데이트 하는 기능
  - [ ] 수익을 계산하는 기능
  - [ ] 매칭 결과를 출력하는 기능 - `랭킹정보 - 1개`같은 형식
- [ ]
- [x] 예외 메시지 형식 관리
  - [x] `[ERROR]`로 시작한다.
