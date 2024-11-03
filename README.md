# java-lotto-precourse

## 구현할 기능 목록 (v1 - 2024.10.29)

### 1. 입출력 기능

- [ ] 입력값 받기
    - [ ] 입력값을 받을 때, 주어진 라이브러리를 이용함
    - [ ] 로또 구입 금액을 입력 받는다. 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리함
    - [ ] 로또 구입 금액은 0원이 될 수 없음
    - [ ] 당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분함
    - [ ] 당첨 번호는 중복이 불가능함
    - [ ] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    - [ ] 당첨 번호를 받은 이후, 보너스 번호를 입력 받는다.
    - [ ] 각각의 당첨번호와 보너스 번호는 1~45 정수 중 하나임

- [ ] 결과 출력 하기
    - [ ] 발행한 로또 수량 및 번호를 출력하며 로또 번호는 오름차순으로 정렬하여 보여줌
    - [ ] 출력 형태에 맞게 당첨 내역을 출력함
    - [ ] 수익률을 출력하고 둘째 자리에서 반올림함
    - [ ] 예외 상황의 에러 문구는 "[ERROR]"로 시작해야 함

### 2. 로또 발행 기능

- [ ] 로또 발행
    - [ ] 1~45 내의 중복되지 않는 6개의 정수 뽑기
    - [ ] 발행한 로또는 중복이 가능함

- [ ] 로또 당첨 번호 발행
  - [ ] 6개의 1~45 내의 중복되지 않은 정수 리스트
  - [ ] 보너스 번호는 당첨 번호와 중복되지 않음
  
### 3. 로또 결과 확인 기능

- [ ] 당첨 확인
    - [ ] 발행한 로또와 당첨 번호를 비교함
    - [ ] 당첨 기준에 따라 금액과 결과를 계산함

- [ ] 당첨 통계
    - [ ] 최종 당첨 금액과 구입 금액을 비교하여 수익률을 계산함
    - [ ] 수익률은 소숫점 둘째자리에서 반올림함

---

## 지난 주 피드백 사항

- 원시값 Wrapping 하기
- 필드는 직접 접근 막기
- 정적 팩토리 메소드는 필요할 때 사용하기
- 일급 컬렉션 알아보기

## 신경써서 진행할 것

- 더 좋은 테스트코드 작성 (Junit, AssertJ 가이드 공부)
- 단위 테스트 세분화 (단 입출력 제외)
- 함수 한개의 하나의 기능 (15줄 이하)
- 일급 컬렉션(LOTTO)의 장점 이해하고 쓰기 
- 모든 문자열과 숫자 값을 코드 내에서 하드코딩하지 않기
- 변수 이름에 자료형은 제외하기