# java-lotto-precourse - minhyuk2
# 로또
## 개요
해당 프로그램은 사용자에게 금액을 입력받아 그 금액만큼 로또를 구입한 후, 당첨 번호와 보너스 번호를
입력받은 후에 이를 비교하여 사용자에게 당첨된 등수들과 수익률을 출력시켜주는 프로그램입니다.



## 기능 요구 사항
    간단한 로또 발매기를 구현한다.
    
    로또 번호의 숫자 범위는 1~45까지이다.

    1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
    당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
    당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.

    1등: 6개 번호 일치 / 2,000,000,000원
    2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    3등: 5개 번호 일치 / 1,500,000원
    4등: 4개 번호 일치 / 50,000원
    5등: 3개 번호 일치 / 5,000원

    로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
    로또 1장의 가격은 1,000원이다.
    당첨 번호와 보너스 번호를 입력받는다.
    사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.

    사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고,
    "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.


## 입출력 요구 사항
### 입력

로또 구입 금액을 입력 받는다. 구입 금액은<span style="color: orange;">1,000원 단위</span> 로 입력 받으며<span style="color: orange;"> 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.</span>
```14000```


당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.
```1,2,3,4,5,6```

보너스 번호를 입력 받는다.\
```7```

### 출력
발행한 로또 수량 및 번호를 출력한다. 로또 번호는 <span style="color: orange;">오름차순으로</span> 정렬하여 보여준다.

8개를 구매했습니다.

[8, 21, 23, 41, 42, 43]\
[3, 5, 11, 16, 32, 38]\
[7, 11, 16, 35, 36, 44]\
[1, 8, 11, 31, 41, 42]\
[13, 14, 16, 38, 42, 45]\
[7, 11, 30, 40, 42, 43]\
[2, 13, 22, 32, 38, 45]\
[1, 3, 5, 14, 22, 45]

당첨 내역을 출력한다.

3개 일치 (5,000원) - 1개\
4개 일치 (50,000원) - 0개\
5개 일치 (1,500,000원) - 0개\
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\
6개 일치 (2,000,000,000원) - 0개

수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)

총 수익률은 62.5%입니다.

예외 상황 시 에러 문구를 출력해야 한다.\
단, 에러 문구는 <span style="color: orange;">"[ERROR]"</span>로 시작해야 한다.

[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.

## 실행 결과 예시
    구입금액을 입력해 주세요.
    8000
    
    8개를 구매했습니다.
    [8, 21, 23, 41, 42, 43]
    [3, 5, 11, 16, 32, 38]
    [7, 11, 16, 35, 36, 44]
    [1, 8, 11, 31, 41, 42]
    [13, 14, 16, 38, 42, 45]
    [7, 11, 30, 40, 42, 43]
    [2, 13, 22, 32, 38, 45]
    [1, 3, 5, 14, 22, 45]
    
    당첨 번호를 입력해 주세요.
    1,2,3,4,5,6
    
    보너스 번호를 입력해 주세요.
    7
    
    당첨 통계
    ---
    3개 일치 (5,000원) - 1개
    4개 일치 (50,000원) - 0개
    5개 일치 (1,500,000원) - 0개
    5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
    6개 일치 (2,000,000,000원) - 0개
    총 수익률은 62.5%입니다.

## 필요한 부분들
1. [x] 사용자에게 값을 입력받고 그걸 천원단위로 나눠서 몇 회를 진행할 수 있는지 판단 -> 나눠떨어지지않으면 나머지는 버리기
2. [x] 랜덤으로 뽑은 값들을 겹치지 않게 설정하기
3. [x] 단위테스트 공부하여 설정하기
4. [x] 전체테스트 작성하기
5. [x] 수익률 계산하기
6. [x] 랜덤 번호를 오름차순으로 정렬하기
7. [x] 에러 상황에 에러 문구 출력하기
8. [x] 수익률 소수점 둘째 자리에서 반올림하기
10. [x] ENUM 사용하기
11. [x] 출력시에 금액에 ,로 나누기
12. [x] 프로그래밍 요구 사항 1 적용 확인
13. [x] 프로그래밍 요구 사항 2 적용 확인
14. [x] 프로그래밍 요구 사항 3 적용 확인


## 기능 구현 정리
1. [x] 사용자에게 멘트를 출력하고, 구매금액 입력받는 기능
2. [x] 해당 금액을 1000원 단위로 나누는 기능
3. [x] 구입한 개수만큼 랜덤 숫자를 중복되지 않게 뽑아서 오름차순 정렬하는 기능
4. [x] 당첨번호에 대한 안내를 출력하고 입력받는 기능
5. [x] 보너스 번호에 대한 안내를 출력하고 입력 받는 기능
6. [x] 보너스 번호까지 포함하여, 당첨 번호를 토대로 해당 숫자가 몇 개 존재하는지 파악하는 기능
7. [x] 몇 개 존재하는지 파악하여 저장한 후 통계로 출력하는 기능
8. [x] 수익률 계산하여 소수점 둘째 자리에서 올려준느 기능
9. [x] 단위 테스트 추가하여 확인하기


## 예외처리
### 이번 예외처리는 예외를 처리하고 거기서부터 값을 다시 받아야 한다.

1. [x] 1000원으로 나눠지지 않을 경우 예외처리
2. [x] 잘못된 값들이 입력으로 들어왔을 경우에 대한 예외처리
3. [x] 로또 번호를 중복된 값으로 입력하거나 범위를 벗어나나서 입력하였을 때에 대한 예외처리
4. [x] 45보다 큰 값이 당첨번호로 들어왔을 때에 대한 예외처리
5. [x] 당첨번호가 6개가 아닌 경우에 대한 예외처리
6. [x] 보너스 번호에 대한 예외처리


## 프로그래밍 요구사항
### 프로그래밍 요구 사항 1
    JDK 21 버전에서 실행 가능해야 한다.
    프로그램 실행의 시작점은 Application의 main()이다.
    build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
    프로그램 종료 시 System.exit()를 호출하지 않는다.
    프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
    자바 코드 컨벤션을 지키면서 프로그래밍한다.
    기본적으로 Java Style Guide를 원칙으로 한다.
### 프로그래밍 요구 사항 2
    indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
    3항 연산자를 쓰지 않는다.
    함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
    JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
    테스트 도구 사용법이 익숙하지 않다면 아래 문서를 참고하여 학습한 후 테스트를 구현한다.
    JUnit 5 User Guide
    AssertJ User Guide
    AssertJ Exception Assertions
    Guide to JUnit 5 Parameterized Tests
### 프로그래밍 요구 사항 3
    함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
    함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
    else 예약어를 쓰지 않는다.
    else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
    힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
    Java Enum을 적용하여 프로그램을 구현한다.
    구현한 기능에 대한 단위 테스트를 작성한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
    단위 테스트 작성이 익숙하지 않다면 LottoTest를 참고하여 학습한 후 테스트를 작성한다.
    라이브러리
    camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
    Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickUniqueNumbersInRange()를 활용한다.
    사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
    사용 예시
    1에서 45 사이의 중복되지 않은 정수 6개 반환
    Randoms.pickUniqueNumbersInRange(1, 45, 6);
    Lotto 클래스
    제공된 Lotto 클래스를 사용하여 구현해야 한다.
    Lotto에 numbers 이외의 필드(인스턴스 변수)를 추가할 수 없다.
    numbers의 접근 제어자인 private은 변경할 수 없다.
    Lotto의 패키지를 변경할 수 있다.
    public class Lotto {
    private final List<Integer> numbers;
    
        public Lotto(List<Integer> numbers) {
            validate(numbers);
            this.numbers = numbers;
        }
    
        private void validate(List<Integer> numbers) {
            if (numbers.size() != 6) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
            }
        }
    
        // TODO: 추가 기능 구현
    }