# java-lotto-precourse

## 기본 기능 구현 목록

### 수정 일시 : 2024. 10. 31

#### 1. 구입 금액 입력

- [X] Console.readLine()을 통한 구입 금액 입력 **(Done)**

#### 2. 로또 구매 개수 계산

- [X] 구매 개수 = 구입 금액 / 1,000원 **(Done)**

#### 3. 구매 개수 출력

- [X] 계산한 구매 개수를 출력 **(Done)**

#### 4. 구매 개수만큼 로또 발행

- [X] Randoms.pickUniqueNumbersInRange(1, 45, 6) 활용하여 List numbers 생성 **(Done)**
- [X] numbers 오름차순 정렬 **(Done)**
- [X] numbers을 활용하여 Lotto 생성 **(Done)**
- [X] 구매 개수만큼 위 과정 반복 **(Done)**

#### 5. 생성된 로또들 출력

#### 6. 당첨 번호 입력

- [X] Console.readLine()을 통한 당첨 번호 입력

#### 7. 보너스 번호 입력

- [X] Console.readLine()을 통한 보너스 번호 입력
- [X] Console.close() 호출

#### 8. 당첨 로또(당첨 번호 + 보너스 번호) 생성

<br>

#### 9. 당첨 등수, 금액 정의

- [X] Enum을 통한 당첨 등수, 금액 정의

#### 10. 당첨 로또와 구입한 로또 비교

- [X] 로또 번호 일치 개수 확인
- [X] 보너스 번호 일치 여부 확인
- [X] 등수별 매칭 수 기록

#### 11. 수익률 계산

- [X] 구입 금액과 총 수익으로 수익률 계산
- [X] 소수점 둘 째자리까지 표현

#### 12. 당첨 통게 및 수익률 출력