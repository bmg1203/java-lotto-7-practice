# java-lotto-precourse

## 예외 발생 상황 정의
### 1. 로또 구입 금액 입력 관련
- 입력받은 구입 금액이 1000원 미만이거나, **10만원을 초과하는 경우**
  - 입력받은 구입 금액이 int 범위를 초과해 Integer.parseInt() 호출 시 오버 플로우 발생하는 상황에 대한 처리 추가적으로 필요
- 입력받은 구입 금액이 1000원으로 나누어 떨어지지 않는 경우
- 입력이 숫자 형태가 아니거나, 입력에 숫자 외의 문자가 포함되어 있는 경우

### 2. 당첨 번호 입력 관련
- 입력받은 당첨 번호가 6개가 아닌 경우
- 입력받은 당첨 번호 중 숫자 형태가 아니거나, 숫자 외의 문자가 포함되어 있는 것이 존재하는 경우
- 입력받은 당첨 번호 중 1 이상 45 이하의 정수 범위에 해당하지 않는 것이 존재하는 경우
  - 당첨 번호가 int 범위를 초과해 Integer.parseInt() 호출 시 오버 플로우 발생하는 상황에 대한 처리 추가적으로 필요
- 입력받은 당첨 번호 중 중복된 수가 존재하는 경우

### 3. 보너스 번호 입력 관련
- 입력받은 보너스 번호가 숫자 형태가 아니거나, 숫자 외의 문자가 포함되어 있는 경우
- 입력받은 보너스 번호가 1 이상 45 이하의 정수 범위에 해당하지 않는 경우
  - 보너스 번호가 int 범위를 초과해 Integer.parseInt() 호출 시 오버 플로우 발생하는 상황에 대한 처리 추가적으로 필요
- 입력받은 보너스 번호가 당첨 번호 중 하나와 중복되는 경우

## 기능 목록
### Purchase

- [ ]  public void process()
    - [ ]  buyLottos() 호출해 로또 구매
    - [ ]  setWinningNumbers() 호출해 당첨 번호와 보너스 번호 설정
    - [ ]  showResult() 호출해 당첨 결과 확인
- [ ]  private void buyLottos()
    - [ ]  LottoNumberController.issueLottos() 호출해 구매 액수만큼의 로또 발행
    - [ ]  boughtNumbers의 setter 호출해 발행한 로또 번호 정보 set
- [ ]  private void setWinningNumbers()

### Lotto
- [x] **private void sortNumbers()** \: 로또 번호를 오름차순으로 정렬하는 기능

- [ ]  몇 등 당첨인지 확인하는 기능

### LottoNumberController
- [x] **public List\<Lotto> issueLottos(int amount)** \: 주어진 수량만큼 로또를 발행하는 기능
    - [x] for (int i = 0; i < amount; i++)
        - [x] `getRandomLottoNumbers()` 호출해 로또 번호 6개 추출
        - [x] Lotto 객체 생성 → 리스트에 추가
    - [x] Lotto 객체가 저장된 리스트 반환


- [ ]  public Lotto getWinningNumbers()
    - [ ]  InputView.getWinningNumbers() 호출해 당첨 번호 입력받기
    - [ ]  입력받은 당첨 번호로 Lotto 객체 생성
    - [ ]  Lotto 객체 반환
- [ ]  public int getBonusNumber()
    - [ ]  InputView.getBonusNumbers() 호출해 보너스 번호 입력받기
    - [ ]  보너스 번호 반환

- [x] **private List\<Integer> getRandomLottoNumbers()** \: 로또 번호 6개를 추첨하는 기능
    - [x] `camp.nextstep.edu.missionutils.Randoms`의 `pickUniqueNumbersInRange(1, 45, 6)` 호출한 결과 반환

### ResultController
- [ ]  당첨 통계 산정하는 기능
- [ ]  수익률 연산하는 기능

### BuyingAmountValidator
- [x] **public int validateBuyingAmount(String input)**
\: 구입 금액 입력 검증 기능 
  - [x] `validateLength()`를 호출해 입력의 길이 검증 (입력 값이 int 범위를 초과해 `Integer.parseInt()` 호출 시 오버 플로우가 발생하는 경우를 막기 위함)
    - [x] 길이가 6보다 큰 경우 10만원 이내일 수 없으므로 예외 발생
  - [x] `validateFormat()`을 호출해 입력이 숫자 형태인지 여부 검증
  - [x] `validateRange()`를 호출해 입력이 1000원 이상, 10만원 이하인지 검증
    - [x] 입력이 1000원 이상 10만원 이하라면 이를 int 타입으로 파싱해 반환
    - [x] 입력이 범위 밖이라면 예외 발생
  - [x] `validateDivisionIntoThousand()`를 호출해 입력이 1000으로 나누어 떨어지는지 검증
    - [x] 나누어 떨어지지 않는다면 예외 발생

### WinningNumberValidator

### enum WinningPrize
int standard

int amount

### InputView
- [x]  **public int getBuyingAmount()** \: 구입 금액을 입력받는 기능
    - [x] `구입금액을 입력해 주세요.` 출력
    - [x] `camp.nextstep.edu.missionutils.Console`의 `readLine()` 을 활용해 사용자로부터 구입 금액 입력받기
    - [x] `BuyingAmountValidator.validateBuyingAmount()`를 호출하여 입력 값 검증
      - [x] 검증 결과 유효하지 않은 입력인 경우 재귀 호출하여 금액을 다시 입력받기
      - [x] 유효한 입력인 경우 해당 입력을 int 타입으로 파싱한 결과를 리턴
- [ ]  당첨 번호를 입력받는 기능
    - [ ]  `당첨 번호를 입력해 주세요.` 출력
    - [ ]  `camp.nextstep.edu.missionutils.Console`의 `readLine()` 을 활용해 사용자로부터 당첨 번호 입력받기
- [ ]  보너스 번호를 입력받는 기능

### OutputView
- [ ] **public void printBoughtLottoNumbers(List<List\<Integer>> lottos)** \: 구매한 로또 번호를 출력하는 기능
    - [x] `N개를 구매했습니다.` 출력
    - [x] 생성된 로또 번호 출력


- [ ]  당첨 통계를 출력하는 기능