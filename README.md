# java-lotto-precourse

***1,000원 단위 금액을 입력 받아 로또를 자동 발행해 당첨 여부를 알려준다!***

# 핵심 개념
| 핵심 개념  |
|:------:|
| **로또** |
| **당첨** |

# 기능 목록
## Presentation
- [ ] 구입금액을 입력 받는다
- [ ] 발행한 로또 수량과 번호를 출력한다
- [ ] 당첨 번호를 입력 받는다
- [ ] 보너스 번호를 입력 받는다
- [ ] 당첨 통계를 출력한다

## Service & Domain
- [x] 숫자들을 생성한다
  - 외부 API를 사용해 랜덤 생성
    - 시스템 예외: 시작 범위가 더 큰 경우
    - 시스템 예외: 끝 범위가 `Integer.MAX_VALUE`와 같은 경우
    - 시스템 예외: 범위 값의 개수가 `Integer.MAX_VALUE` 이상인 경우
    - 시스템 예외: 범위 값의 개수가 생성하려는 숫자들의 개수 미만인 경우
    - 시스템 예외: 생성 개수가 0개 미만인 경우
  - 입력 값을 사용해 수동 생성
    - 사용자 예외: 입력 값 중 int 범위를 초과한 경우
- [x] 로또를 생성한다
  - 사용자 예외: 로또 번호가 6개가 아닌 경우
  - 사용자 예외: 로또 번호가 1~45가 아닌 경우
  - 사용자 예외: 로또 번호에 중복이 존재하는 경우
- [x] 발행된 로또를 저장한다
- [x] 당첨 번호와 보너스 번호를 추첨한다
  - 사용자 예외: 당첨 번호가 6개가 아닌 경우 
  - 사용자 예외: 당첨 번호가 1~45가 아닌 경우 
  - 사용자 예외: 당첨 번호에 중복이 존재하는 경우
  - 사용자 예외: 당첨 번호에 보너스 번호가 중복되는 경우
- [x] 당첨을 확인한다
  - 보너스 번호 일치는 당첨 번호 일치와 상관없다
- [x] 등수를 당첨 통계에 저장한다
- [x] 수익률을 계산한다
  - 수익률은 소수점 둘째 자리에서 반올림한다
