# java-lotto-precourse
- - - 
## 👷기능 요구사항 👷
### Utils
- [x] `Validator`
  - [x] `priceValidator` : 입력 받은 로또 구입 금액을 검증한다.
  - [x] `winningNumValidator` : 입력 받은 당첨 번호를 검증한다.  
  - [x] `lottoNumValidator` : 번호 검증 (1 ~ 45) 
- [ ] `Parser`
  - [ ] `inputParser` : 쉼표를 구분자로 하여 당첨 번호를 분리한다.
- [ ] `Converter`
  - [ ] `priceToLottoCount` : 로또 구입 금액을 구매 개수로 변환한다.
### Domain
- [ ] `Winning` : `enum`
  - [ ] 당첨 개수와 당첨 금액을 관리하는 `enum`
- [ ] `Lotto`
  - [ ] `countMatchingNumbers` : 매칭 숫자 + 보너스 넘버를 비교하여 당첨 형태를 return 한다.
- [ ] `Lottos`
  - [ ] 
- [ ] `WinningLotto` : 당첨 로또 클래스
  - [ ] `Winning` 를 인스턴스 변수로 가진다. 
- [ ] `WinningLottos` : `WinningLotto` 객체들을 List 형태로 저장한다.
###### getter 는 생략
### View
- [ ] `InputView`
  - [ ] `getPrice` : 구매 가격을 입력 받는다.
  - [ ] `getLottoNum` : 로또 번호를 입력 받는다.
  - [ ] `getBonusNum` : 보너스 번호를 입력 받는다.
- [ ] `OutputView`
  - [ ] `printLottos` : 구매한 로또 번호를 출력한다.
  - [ ] `printResult` : 결과를 양식에 맞게 출력한다.
### Controller
- [ ] `LottoController`
  - [ ] `run` : 로또 당첨 시작
- - - 
### 추가된 코드 컨벤션 지키기
- [ ] else 예약어 사용 금지한다.
### 공통 피드백에서 평소 잘 지키지 않는 것
- [ ] 변수명에 자료명 사용 금지한다.
- [ ] 값을 하드코딩 하지 않는다.

#### 문서 작성 참고 링크
<https://gist.github.com/ihoneymon/652be052a0727ad59601>
