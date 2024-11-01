# java-lotto-precourse

# 📍 프로젝트 개요

구매한 로또에 대해 당첨과 수익률을 보여주는 프로그램.

# ✅ 구현 기능 목록

### 1. Model 구현

- [x]  Validator 클래스 생성
   - [x]  구입 금액에 대한 유효성 검사
   - [x]  입력한 숫자가 1~45인지 검증
- [x]  Extractor 클래스 생성
   - [x]  구분자를 기준으로 분리하여 숫자 배열로 반환.
- [ ]  Lotto 클래스 기능 추가
   - [ ]  입력한 번호와 일치하는 개수 리턴
- [ ]  Lottos 클래스 생성
   - [ ]  구매한 로또 수에 따라 Lotto 객체 생성.
   - [ ]  각 로또에서 입력값에 대한 숫자 일치 개수 저장.

### 2. View 구현

- [ ]  InputView 클래스
   - [ ]  로또 구입 금액을 입력 받는다.
   - [ ]  당첨 번호를 입력 받는다.
   - [ ]  보너스 번호를 입력 받는다.
- [ ]  OutputView 클래스
   - [ ]  발행한 Lotto 수량 및 번호 출력.
   - [ ]  당첨 통계
   - [ ]  수익률 출력.

### **3. Global 설정**

- [x]  에러 메시지 클래스 생성

### 4. Controller 구현

- [ ]  ApplicationController 클래스 생성
   - [ ]  애플리케이션 실행 기능
- [ ]  LottoController 구현
   - [ ]  구매 금액에 따른 수량 리턴.
   - [ ]  수익률 계산.