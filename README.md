# java-lotto-precourse
## 프로젝트 소개
구입 금액과 당첨 번호를 입력하면 당첨 내역을 출력하는 로또 프로그램 입니다. 
우아한 테크코스 백엔드 7기의 프리코스 3주차 미션 입니다.
## 기능 목록
- 로또 구입

1,000원 단위의 로또 구입 금액을 입력 받는다. 로또 1장 당 1,000원이다.

- 로또 번호 생성

1~45 사이의 중복되지 않은 번호 6개 세트를 구입한 로또 개수만큼 생성한다.

- 로또 번호 출력

구매한 로또 개수와 개수 만큼의 로또 번호를 리스트 형태로 출력한다.

- 당첨 번호 입력

1~45 사이의 중복되지 않은 당첨 번호 6개를 입력한다.

- 보너스 번호 입력

당첨 번호와 중복되지 않은 1~45 사이의 보너스 번호 1개를 입력한다.

- 당첨 통계

생성된 번호와 당첨 번호를 비교해 당첨 내역을 제공한다.

- 수익률 계산

당첨 결과와 구입 금액을 비교해 수익률을 계산한다. 수익률은 소수점 둘째 자리에서 반올림 한 뒤 제공한다.

- 에러 문구 출력

잘못된 값을 입력한 경우 에러 문구를 출력하고 해당 부분부터 입력을 다시 한다.

## 예외 상황
- 로또 구입 금액 입력 예외

입력이 정수형이 아니면 예외 처리 한다.

입력이 0보다 작거나 같으면 예외 처리 한다.

입력이 1,000으로 나눈 나머지가 0이 아니면 예외 처리 한다.

- 당첨 번호 입력 예외

당첨 번호가 정수형이 아니면 예외 처리 한다.

당첨 번호가 6개 미만, 초과인 경우 예외 처리 한다.

당첨 번호가 1~45 사이가 아니면 예외 처리 한다.

당첨 번호가 중복 되면 예외 처리 한다.

- 보너스 번호 입력 예외

보너스 번호가 정수형이 아니면 예외 처리 한다.

보너스 번호가 1~45 사이가 아니면 예외 처리 한다.

보너스 번호가 당첨 번호와 중복되면 예외 처리한다.
