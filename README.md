
# 구현 기능 목록

## Domain
- Lotto
- Ticket: 구입한 로또들과 당첨 번호, 보너스 번호가 포함된 객체
  - 당첨 번호와 보너스 번호가 중복 검증
  - 로또 구입 금액이 1,000원 단위로 나누어떨어지는지 검증
- Prize

## Service
#### LottoService
- ~~1 ~ 45의 무작위 숫자 6개를 뽑아 로또를 생성~~ 
#### TicketService
- ~~구입 금액만큼 로또를 발급~~
- 당첨 내역을 구하는 기능
- 당첨 금액과 구입 금액으로 총 수익률을 계산

## Controller
1. 구입 금액을 입력 받는다.
2. 티켓을 발급하고 티켓 정보를 출력한다.
3. 당첨 번호를 입력 받는다.
4. 보너스 번호를 입력 받는다.
6. 당첨 통계를 출력한다.

## IO
### Input
- 구입 금액 입력
- 당첨 번호 입력
- 보너스 번호 입력

### Output
- 티켓 정보 출력
- 당첨 통계 출력
  - 당첨 내역
  - 총 수익률
