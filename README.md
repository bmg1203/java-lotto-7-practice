# java-lotto-precourse

2024 우아한테크코스 7기 크루 모집, 프리코스 3주차 과제를 위한 프로젝트로써 로또 시스템을 구현한 프로젝트입니다.

## 기능 구현 목록
- [x] 사용자로부터 로또 구매 금액을 입력 받는다.
  - [x] 금액 프롬프트 메시지를 출력한다. 
  - [x] 가격을 입력 받는다.
  - [x] 예외처리 및 문자열을 다듬는다.  
    - [x] 정수가 아닐 시 예외를 발생 시킨다.
    - [x] 1000으로 나누어 떨어지지 않을 시 예외를 발생 시킨다.
    - [x] 2,000,000,000 초과된 값이 입력될 시 예외를 발생 시킨다.
    - [x] 숫자 앞뒤 공백은 제거한다.
- [x] 사용자에게 로또를 발급한다. 
  - [x] 구매 개수를 출력한다. 
  - [x] 구매 개수만큼 로또 정보를 차례로 출력한다. 
    - [x] 하나의 로또에 중복된 정보가 있으면 안된다.
    - [x] 오름차순으로 출력한다. 
- [x] 사용자로부터 당첨 번호를 입력 받는다. 
  - [x] 당첨 번호 프롬프트 메시지를 출력한다. 
  - [x] 당첨 번호를 입력 받는다. 
  - [x] 예외처리 및 문자열을 다듬는다. 
    - [x] 중복된 숫자가 있을 시 예외를 발생 시킨다. 
    - [x] 1 ~ 45 범위 이외의 숫자가 있을 시 예외를 발생 시킨다. 
    - [x] 각 숫자가 정수가 아닐 시 예외를 발생 시킨다.
    - [x] 문자열 맨 앞뒤가 쉼표일 시 예외를 발생 시킨다.
    - [x] 각 숫자 앞뒤로 공백은 제거한다. 
- [x] 사용자로부터 보너스 번호를 입력 받는다. 
  - [x] 보너스 번호 프롬프트 메시지를 출력한다. 
  - [x] 보너스 번호를 입력 받는다. 
  - [x] 예외처리 및 문자열을 다듬는다.
    - [x] 정수가 아닐 시 예외를 발생 시킨다. 
    - [x] 1 ~ 45 범위 이외의 숫자일 시 예외를 발생 시킨다. 
    - [x] 당첨 번호와 중복된 숫자일 시 예외를 발생 시킨다. 
    - [x] 숫자 앞뒤로 공백은 제거한다. 
- [ ] 결과를 계산한다.
  - [ ] 5등을 계산한다. 
  - [ ] 4등을 계산한다.
  - [ ] 3등을 계산한다. 
  - [ ] 2등을 계산한다.
  - [ ] 1등을 계산한다.
- [ ] 결과를 출력한다. 
  - [x] 당첨 통계 프롬프트 메시지를 출력한다. 
  - [x] 당첨 통계 정보를 출력한다. 
  - [x] 총 수익률을 출력한다.

## 체크리스트
- 코드
  1. 하드코딩 하지 않는다. Enum을 활용하자.
  2. 클래스 구현 순서는 상수, 멤버 변수, 생성자, 메서드 순서로
  3. 변수 이름에 자료형은 포함하지 않는다.
  4. 메서드 indent 3, 길이 15줄 이하로 --> 한 가지 일만 수행하도록
  5. 테스트 코드를 쓰는 나만의 의의를 찾아라.
  6. 유닛 테스트 해라.
  7. else 를 쓰지 않는다.
  8. Random, Console을 사용해라.
  9. 코드 포매팅을 적용해라.
- 문서
  1. REAME를 통해 어떤 프로젝트인지, 주요기능이 뭔지 소개하기
  2. REAMDE에 기능 목록 적을 때, 상세한 내용은 x (클래스, 메서드 등 --> 수정될 일이 많기 때문)
