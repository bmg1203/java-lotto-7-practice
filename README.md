# java-lotto-precourse
로또

## 📝 프로젝트 설명
구입 금액만큼 로또가 발행되고 1등부터 5등까지의 당첨 내역과 수익률을 계산한다.
### 주요 기능 및 요구사항 
- 로또 번호 숫자의 범위는 1부터 45까지이다.
- 1개의 로또의 발행 번호는 중복되지 않는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨 기준과 당첨금은 다음과 같다.
  - 1등: 6개 번호 일치 / 2,000,000,000원 
  - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원 
  - 3등: 5개 번호 일치 / 1,500,000원 
  - 4등: 4개 번호 일치 / 50,000원 
  - 5등: 3개 번호 일치 / 5,000원
- 로또 1장의 가격은 1,000원이다.
- 구입 금액에 해당하는 만큼 로또를 발행한다.


  <br>

## 📌 구현할 기능 목록
### 1. 구입 금액 입력
- [ ] 구입 금액 입력 문구를 출력한다.
- [ ] 구입 금액을 입력받는다.

### 2. 입력값(구입 금액) 예외 처리
- [ ] 빈 값이 입력된 경우
- [ ] 숫자가 아닌 값이 입력된 경우
- [ ] 양수가 아닌 숫자가 입력된 경우
- [ ] 1,000 단위가 아닌 숫자가 입력된 경우

### 2. 구입 금액에 해당하는 만큼 로또 발행
- [ ] 구입 금액에 해당하는 로또 수량을 계산한다.
- [ ] 로또 수량을 출력한다.
- [ ] 로또 수량만큼 로또 번호를 뽑는다.
- [ ] 로또 번호를 오름차순으로 정렬한다.
- [ ] 로또 번호를 출력한다.

### 3. 당첨 번호 입력 및 분리 
- [ ] 당첨 번호 입력 문구를 출력한다.
- [ ] 당첨 번호를 입력받는다.
- [ ] 당첨 번호를 쉼표를 기준으로 분리한다.

### 4. 입력값(당첨 번호) 예외 처리
- [ ] 빈 값이 입력된 경우
- [ ] 당첨 번호가 6개가 아닌 경우
- [ ] 각 당첨 번호로 숫자가 아닌 값이 입력된 경우
- [ ] 각 당첨 번호로 양수가 아닌 값이 입력된 경우
- [ ] 각 당첨 번호의 범위가 1~45가 아닌 경우
- [ ] 당첨 번호가 중복된 경우

### 5. 보너스 번호 입력
- [ ] 보너스 번호 입력 문구를 출력한다.
- [ ] 보너스 번호를 입력받는다.

### 6. 입력값(보너스 번호) 예외 처리
- [ ] 빈 값이 입력된 경우
- [ ] 숫자가 아닌 값이 입력된 경우
- [ ] 양수가 아닌 숫자가 입력된 경우
- [ ] 보너스 번호의 범위가 1~45가 아닌 경우

### 7. 당첨 내역 계산
- [ ] 1등 당첨 내역을 계산한다.
- [ ] 2등 당첨 내역을 계산한다.
- [ ] 3등 당첨 내역을 계산한다.
- [ ] 4등 당첨 내역을 계산한다.
- [ ] 5등 당첨 내역을 계산한다.

### 8. 당첨 내역 출력 
- [ ] 당첨 통계 문구를 출력한다.
- [ ] 당첨 내역을 출력한다.

### 9. 당첨 수익률 계산
- [ ] 당첨 수익률을 계산한다.
- [ ] 수익률을 소수점 둘째 자리에서 반올림한다.

### 10. 당첨 수익률 출력
- [ ] 총 수익률을 출력한다.


<br>

## 📂 프로젝트 구조 설계
```plaintext
lotto/
 ├── Application.java                      # 애플리케이션 시작
 ├── controller/                      
 │    └── LottoController.java             # 로또 로직 처리
 ├── service/                            
 │    ├── LottoService.java                # 로또 비즈니스 로직 인터페이스
 │    └── LottoServiceImpl.java            # 로또 비즈니스 로직 구현체
 ├── model/                          
 │    ├── Lotto.java                       # 로또 도메인 클래스
 │    └── Rank.java                        # 당첨 등수와 상금 정의 (enum)
 ├── io/                               
 │    ├── Input.java                       # 사용자 입력값 처리
 │    └── Output.java                      # 결과 출력
 └── util/                              
      ├── Validator.java                   # 입력값 유효성 검사
      ├── Constants.java                   # 상수값 정의 클래스
      └── ErrorMessage.java                # 에러 메시지 정의 (enum)
```

