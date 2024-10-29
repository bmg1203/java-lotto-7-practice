# java-lotto-precourse

## 기능구현 목록
1. 구입금액을 입력받는다.
   - [예외] null 이나 빈값 검사
   - [예외] 정규표현식으로 양수, 1000의 배수 검사
2. 구입금액으로 구입 매수를 구한다.
3. 구입 매수 만큼 로또 번호를 생성한다.
   - 중복되지 않는 6개의 1~45 숫자 List를 생성한다.
   - 로또 객체를 생성한다.
   - 구입 매수 만큼 반복한다.
4. 구입 매수를 출력한다.
5. 생성된 로또 번호를 출력한다.
6. 당첨 번호를 입력받는다.
    - [예외] null 이나 빈값 검사
    - [예외] 정규표현식으로 쉼표 형식검사, 1~45 범위 검사
    - [예외] 중복된 숫자가 있는지 검사
7. 보너스 번호를 입력받는다.
    - [예외] mull 이나 빈값 검사
    - [예외] 정규표현식으로 1~45 범위 검사
    - [예외] 당첨 번호와 중복 검사
8. 당첨 내역을 구한다.
9. 당첨 내역을 출력한다.
10. 수익률을 구한다.
11. 수익률을 출력한다.
