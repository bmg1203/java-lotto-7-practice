# java-lotto-precourse

## 기능 목록 정리
- 로또 구입 금액 입력
- 구입 금액 입력 유효성 검사
- 당첨 번호 입력
- 당첨 번호 입력 유효성 검사
- 문자열을 List<Integer>로 변환 
- 보너스 번호 입력
- 보너스 번호 입력 유효성 검사
- 로또 번호 배열(6자리) 생성
- List<Integer>를 오름차순으로 정렬
- 발행한 로또 수량 출력
- 수량만큼 발행한 로또 번호(6자리 + 보너스자리) 출력
- 당첨 내역 출력
- 수익률 출력

## 예외 사항
- Console 클래스 안에 close 메서드 구현되어 있는 내용을 확인. 따라서 리소스 절약을 위해 CloseInput 기능을 추가 구현
- 기존 Data를 Collection으로 하나 하나 관리하는 방식이 아닌 DTO로 통합 관리하는 방식으로 변경
  - 그에 따라 WinningResultDTO, UserInputDTO를 구현
- Switch Case문을 쓰지 않고 더 깔끔히 결과를 관리하기 위해 Enum으로 MatchResult를 구현