---

# 로또 프로그램

## 📌 프로젝트 소개

로또 프로그램은 사용자가 입력한 금액에 따라 여러 장의 로또를 발행하고, 추첨을 통해 당첨 여부와 수익률을 계산해주는 간단한 게임입니다. 사용자는 구입 금액, 당첨 번호, 그리고 보너스 번호를 입력하며, 프로그램은 구매한 로또와 비교해 당첨 내역과 수익률을 출력합니다.

---

## 🎲 구현할 기능 목록

### 1. **로또 구입 금액 입력**
- [x] 로또 구입 금액 입력 문구를 출력한다.
- [x] 1,000원 단위로 입력받으며, 올바르지 않은 입력 시 예외 처리한다.

### 2. **로또 번호 발행**
- [x] 구입 금액에 따라 로또 장수를 계산하고, 각 로또에 중복되지 않는 6개의 번호를 랜덤으로 생성한다.
- [x] 생성된 로또 번호는 오름차순으로 정렬하여 출력한다.

### 3. **당첨 번호 입력 및 예외 처리**
- [x] 당첨 번호 입력 문구를 출력하고, 쉼표로 구분된 6개의 숫자를 입력받는다.
- [x] 각 번호는 1부터 45 사이여야 하며, 중복된 번호가 있을 경우 예외 처리한다.

### 4. **보너스 번호 입력 및 예외 처리**
- [x] 보너스 번호 입력 문구를 출력하고, 숫자를 입력받는다.
- [x] 보너스 번호는 1부터 45 사이여야 하며, 당첨 번호와 중복될 수 없다.

### 5. **당첨 결과 확인**
- [x] 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 각 로또의 일치 개수를 확인한다.
- [x] 보너스 번호를 포함한 2등 조건을 처리하고, 각 당첨 등수별 개수를 출력한다.

### 6. **수익률 계산 및 출력**
- [x] 각 당첨 등수에 따라 정해진 상금을 기준으로 수익률을 계산한다.
- [x] 총 수익률을 소수점 둘째 자리에서 반올림하여 출력한다.

### 7. **예외 처리**
- [x] 입력값이 범위를 벗어나거나 형식에 맞지 않을 경우 `IllegalArgumentException`을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 재입력을 받는다.

---

## 📥 입출력 요구 사항

### 입력
1. **로또 구입 금액**
    - 1,000원 단위로 입력해야 하며, 예시: `14000`
2. **당첨 번호** (쉼표로 구분된 6개의 숫자)
    - 예시: `1,2,3,4,5,6`
3. **보너스 번호**
    - 예시: `7`

### 출력
1. **발행된 로또 번호**
    - 구입 금액에 따라 발행한 로또 수량과 번호를 출력하며, 번호는 오름차순 정렬하여 보여준다.
    - 예시:
      ```
      8개를 구매했습니다.
      [8, 21, 23, 41, 42, 43]
      [3, 5, 11, 16, 32, 38]
      ...
      ```
2. **당첨 통계**
    - 각 등수별 당첨 개수를 출력한다.
    - 예시:
      ```
      3개 일치 (5,000원) - 1개
      4개 일치 (50,000원) - 0개
      ...
      ```

3. **수익률**
    - 총 수익률을 소수점 둘째 자리에서 반올림하여 출력한다.
    - 예시:
      ```
      총 수익률은 62.5%입니다.
      ```

4. **에러 메시지**
    - 예외 발생 시 "[ERROR]"로 시작하는 에러 메시지를 출력한다.
    - 예시:
      ```
      [ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.
      ```

