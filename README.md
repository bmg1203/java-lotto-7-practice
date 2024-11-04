# java-lotto-precourse

### 기능 목록

#### 로또

1. **로또 번호**
    - 6개의 숫자를 가짐.
    - 오름차순으로 정렬됨.

2. **정상 로또 확인**
    - 중복을 허용하지 않음.
    - 6개의 숫자로 이루어져 있어야 함.
    - 범위는 1~45이어야 함.
    - null값 또는 빈값이 입력 되면 안됨.

#### 발행 로또

1. **로또 번호**
    - 6개의 숫자를 가짐.
    - 1개의 보너스 숫자를 가짐.
    - 오름차순으로 정렬됨.

2. **정상 발행 로또 확인**
    - 중복을 허용하지 않음.
    - 보너스 숫자도 중복을 허용하지 않음.
    - 범위는 1~45이어야 함.
    - null 또는 빈 값이 입력될 수 없음.

#### 로또 컨트롤러

1. 로또를 구입함.
2. 구입한 로또를 발행함.
3. 로또의 결과를 확인함.

#### 로또 구입

1. **구입 금액 입력**
    - 1000원 단위로 나누어져야 하며, 아닐 경우 예외 처리함.
    - 최소 구입 금액은 1000원임.
    - 입력 값에 오류가 있을 시 재입력을 받음.

2. **로또 번호 입력**
    - 6개의 로또 번호를 입력받음.
    - 중복은 허용되지 않으며, 예외 처리함.
    - 로또 번호는 쉼표로 구분됨.
    - 1~45 범위의 숫자 값이어야 함.
    - 입력 값에 오류가 있을 시 재입력을 받음.

3. **보너스 번호 입력**
    - 이전 로또 번호와 중복될 수 없음.
    - 1~45 범위의 숫자 값이어야 함.
    - 입력 값에 오류가 있을 시 재입력을 받음.

#### 발행로또 발행

1. 구입한 만큼 로또를 발행함.
2. 발행한 로또의 수량 및 번호를 출력함.

#### 로또 추첨
1. 로또 추첨를 추첨함.

#### 로또 결과 확인

1. 모든 로또의 당첨 내역을 확인함.
2. 당첨 통계를 출력함.
3. 수익률 확인
    - 수익률은 소수점 둘째 자리에서 반올림함.
4. 수익률을 출력함.