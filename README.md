# 로또 💸

## 💸 구현 기능 목록

#### 1. 로또 발매기 생성
 ```text
- 로또 번호 생성기 구현
    - 1~45 사이의 숫자 중 중복되지 않는 6개 번호 생성
    - 생성된 번호 오름차순 정렬
```

#### 2. 로또 구매

```text
- 구매 금액 입력 및 검증
    - 1000원 단위 금액 검증
    - 구매 가능한 로또 수량 계산
   
- 구매한 수량만큼 로또 번호 생성
- 생성된 로또 번호 출력
```

#### 3. 당첨 내역 관리

```text
- 당첨 번호 입력 및 검증
    - 6개의 당첨 번호 입력 (쉼표 구분)
    - 보너스 번호 입력
    - 입력값 범위 검증 (1~45)
    - 중복 번호 검증
```

#### 4. 당첨 확인 및 결과 출력

```text
- 당첨 여부 확인 로직
    - 일치하는 번호 개수 계산
    - 보너스 번호 일치 여부 확인
    - 당첨 등수 판단
    
- 당첨 통계 계산
    - 총 수익률 계산
    
- 결과 출력
    - 등수별 당첨 내역 출력
    - 수익률 출력 (소수점 둘째자리 반올림)
```
#### 5. 예외 처리

```text
- 구매 금액 예외 처리
    - 1000원 단위가 아닌 경우
    - 숫자가 아닌 입력의 경우
    
- 당첨 번호 입력 예외 처리
    - 1~45 범위를 벗어난 숫자
    - 중복된 숫자
    - 잘못된 형식(쉼표 구분)
    - 6개 숫자가 아닌 경우
    
- 보너스 번호 입력 예외 처리
    - 1~45 범위를 벗어난 숫자
    - 기존 당첨 번호와 중복
```

<br/>



## 💸 구조




<br/>

## 💸 추가 테스트 케이스 작성
#### 1. Lotto 테스트
- [X] 로또번호_생성_성공_테스트()
- [X] 로또티켓_번호생성_성공_테스트()
- [X] 로또티켓_정렬확인_테스트()
- [X] 로또티켓_당첨확인_테스트()
- [X] 로또발행_수량확인_테스트()
- [X] 당첨통계_계산_테스트()
- [X] 수익률_계산_테스트()

#### 2. 예외 테스트
- [X] 구입_금액이_1000원으로_나누어떨어지지_않으면_예외가_발생한다()
- [X] 구입_금액이_1000원_미만이면_예외가_발생한다()
- [X] 로또_번호의_개수가_6개_이상이면_예외가_발생한다()
- [X] 로또_번호가_6개가_이하면_예외가_발생한다()
- [X] 로또_번호에_중복된_숫자가_있으면_예외가_발생한다()
- [X] 보너스_번호가_당첨_번호와_중복되면_예외가_발생한다()
- [X] 로또_번호가_1부터_45_사이의_숫자가_아니면_예외가_발생한다()

#### 3. 통합 테스트
- [ ] 기능_테스트()
- [ ] 예외상황_처리후_재시도_테스트()


<br/>

## 💸 SRP 원칙

### 
