# 로또

## 기능 목록

### view package
- output class
    + [0] 로또 구매 개수를 출력하는 기능 - printPurchaseAmount
    + [0] 구매한 로또 번호를 출력하는 기능 - printLottoNumbers
    + [0] 당첨 통계를 출력하는 기능 - printWinningStatistics
    + [0] 수익률을 출력하는 기능 - printProfitRate
    + [0] 개행 문자 출력 기능 - printNewLine

- input class
    + [0] 구입 금액을 입력받는 기능 - getPurchaseAmount
    + [0] 당첨 번호를 입력받는 기능 - getWinningNumbers
    + [0] 보너스 번호를 입력받는 기능 - getBonusNumber

### model package
- LottoTransform class
    + [] 입력된 로또 반복 횟수 만큼 로또 생성 
    + [] 랜덤한 숫자를 생성하는 기능 


- LottoValidation class
    + [] 로또 중 당첨된 등수를 반환하는 기능 
    + [] 수익률을 계산하는 기능 

### service package
- LottoMaker class : model 기능을 통해 로또 로직 구현, 자료구조 저장 위치
    + [] 생성 로또, 당첨 번호 저장 공간
    + [] 생성한 로또 번호 반환 
    + [] 당첨 등수 반환 
    + [] 수익률 반환 

### controller package
- LottoManager class
    + [] 로또 진행 기능 - 

### utils package
- WinningLotto class
    + [0] 당첨금 관련 Enum 클래스 구현 
        + [0] 등수에 맞는 당첨금, 당첨 통계 출력 포멧 상수화
        + [0] Enum 원소 반환 기능 구현

### exception package
- Lotto class : 입력된 로또 번호에 대한 검증 진행
    + [0]  입력한 로또 번호가 6개가 맞는지 검증 - validate


## 구현 규칙
- 메서드 길이는 15라인 이내로 구성한다.
- indent(들여쓰기) depth를 2단계로 제한한다.
- 3항 연산자 사용 금지
- else 사용하지 않는다
- Enum을 적용한다.
- 하드 코딩 값을 상수화 한다
- 상수, 변수, 생성자, 메서드 순서로 구현한다.
- 변수명에 자료형은 제거한다
- 기능 단위테스트를 구현한다.
- 하나의 메서드는 하나의 일을 한다
