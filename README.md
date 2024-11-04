# java-lotto-precourse

# 🎰 로또 게임
* * *
간단한 **로또 발매기**를 구현한다.

로또 번호의 숫자 범위는 1~45까지이다.
1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
<br> <br>당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.

1등: 6개 번호 일치 / 2,000,000,000
<br>
2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
<br>
3등: 5개 번호 일치 / 1,500,000원
<br>
4등: 4개 번호 일치 / 50,000원
<br>
5등: 3개 번호 일치 / 5,000원
<br> <br>
로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
로또 1장의 가격은 1,000원이다.
당첨 번호와 보너스 번호를 입력받는다.
사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.


사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

# 🎯 이번 주 목표
* * *
* mvc 패턴 하에 패키지 내 클래스가 올바르게 분류돼 있는지 확인하기
* JUnit 등을 활용하여 메소드를 구현할 때마다 작은 기능 단위로 테스트 케이스 확인하기
* 무분별한 인스턴스 생성과 필드 초기화를 지양하고, this를 남발하지 않기
* 의존성 주입과 DI 관련 공부하여 반영하기
* 목적에 맞게 static, final 사용하기
* 2주차 피드백 반영하기

# 🌱 성장 노트
* * *

## 1. 이번 주 목표에 대해서 어느 정도 지켰는가?
- [x] **mvc 패턴 하에 패키지 내 클래스가 올바르게 분류돼 있는지 확인하기**

  저번 미션 때는 validation 패키지 안에 validator, exception을 몰아 넣었었는데 이번에는 exception도 분리하여 역할을 더 명확하게 나타내려 했다 하지만 model 부분에서 더 직관적인 도메인명을 생각하기에 시간이 부족했었다...... 서비스 부분을 구현하며 느낀 것은 나는 자꾸 모델 객체가 생성되지 않으면 해당 모델에 대한 서비스를 사용해도 되는가에 고민한다는 것이다 하지만 해당 패턴에서 서비스라는 것은 객체 생성의 전후와 상관없이 해당 객체에게 주어진 역할과 관련된 로직이라면 사용 가능한 것이니까 마지막 미션 때는 더 유연하게 분리하여 사용할 수 있었으면 좋겠다!


- [ ] **JUnit 등을 활용하여 메소드를 구현할 때마다 작은 기능 단위로 테스트 케이스 확인하기**

  프리코스 출발선에 섰을 때 쫓기듯 구현하지 않기로 나 스스로와 약속했는데 미래를 미리 엿보고 과거의 나에게 부탁했던 걸까? 마지막 미션이 남은 이 시점까지도 쫓기듯 구현하여 여러 테스트 케이스 구현에는 실패하였다 보통은 기능 단위로 커밋을 하고, 해당 기능이 정상적으로 실행되는지를 확인해 가며 구현하는 것 같은데, 개발자 호소인 З개월 차 버릇 9개월까지 간다고...... 그렇다고 내내 놀다 막바지에 이르러서 시작한 건 아니라서 그렇다면 겸업하며 미션을 진행할 만큼의 실력이 아니라는 게 되는데 저번보다는 내가 만든 테스트 케이스 수가 조금 더 늘었다는 걸로 만족하고 다음 미션 때의 목표로 넘기겠습니다 😭


- [x] **무분별한 인스턴스 생성과 필드 초기화를 지양하고, this를 남발하지 않기**

  최대한 코드 리뷰를 통해 받은 피드백을 머릿속에 문신해 놓고 구현하면서도, 그리고 구현을 끝내고 나서도 훑어보려고 노력했는데 생성할 이유가 없는 것들이 꽤 줄었다 노력하는 과정에서도 왜 이것은 필요하고, 이것은 필요 없는지에 대해 생각할 수 있었다


- [x] **의존성 주입과 DI 관련 공부하여 반영하기**

  클래스 간의 결합이 강하면 의존 대상이 변할 때 결합된 다른 클래스까지 같이 수정해 주어야 하는 단점 때문에 의존성 주입이 중요하다는 것은 알겠지만 의존성 주입을 통해 결합도를 낮추는 것은 참말로 어려운 것 같다 이번 미션에서도 클래스 간 결합이 강했던 부분이 있었는데, 일부 데이터 타입을 수정하는 걸로도 다른 클래스에서 전부 바꿔 줘야 하는 경우가 있었기 때문에 최대한 의존성 주입을 반영하고 싶어서 **컨트롤러에서도 필드 생성을 의존성 주입으로 바꿔 보았는데** 또 의존성 주입이 필요한 부분을 찾는 게 제출 시간이 주는 압박 땜에 힘들었다 (레전드 핑계)


- [x] **목적에 맞게 static, final 사용하기**

  이것도 의존성 주입과 동일하게 머리로는 알겠는데 손가락으로 풀어 내려니까 반응이 안 된다 나는 스태틱이랑 파이널과 두사랑을 하고 있는 것인가 일단 final은 한번 선언하면 이후에는 변경하지 못한다는 뜻으로 제어하는 건데 대부분의 필드에 final을 넣어 주는 게 맞는 것 같다가도 아닌 것 같아서 이후 변경하지 못한다는 조건을 특히나 드러내야 하는 부분 위주로 넣었었다 static은 인스턴스 생성 없이도 공통적으로 참조할 수 있는 거라고 요약했는데 인스턴스라는 녀석은 나한테 가깝고도 먼 존재라서...... 사실 객체지향이라는 것에서 인스턴스가 특히나 중요한 개념일 텐데 조금 더 깊게 공부해 봐야 할 것 같았다


- [x] **2주차 피드백 반영하기**


## 2. 반복해서 MVC 패턴으로 구현했는데, 그에 대한 이유는?
사실 제일 큰 이유는 저번 미션 때 구현했던 게 마음에 들지 않아서 복습할 겸 새로운 미션을 같은 패턴으로 구현해 보고 싶었던 것이고 그것을 제외하고는 미션에 대해 읽어 보았을 때 사용자의 입력에 따라 모델에게 데이터를 전달하고, 그 데이터를 로직을 통해 다른 모델로 바꾸어 출력하면 일관성 있게 구현할 수 있을 것 같아서



# 🧩 패키지 구조
* * *
```
src
└── main
    └── java
        └── lotto
            ├── controller
            ├── constant
            ├── exception
            ├── model
            ├── service
            ├── utils
            ├── validation
            ├── view
            └── Application.class

└── test
    └── java
        └── lotto
```


# 💡 구현할 기능 목록
* * *

## 입력 (Input View)
 - [x] 로또 구입 금액 입력
 - [x] 당첨 번호 입력 (쉼표 기준)
 - [x] 보너스 번호 입력

## 컨트롤러 (Controller)
 - [x] 입력 검증 (Input Validation)
 - [x] 로또 게임 초기화 (Lotto Initialization)
 - [x] 로또 게임 실행 (Lotto Start)

## 상수 (Constant)
- [x] 로또 게임 상수 (Lotto Constant)

## 모델 (Model)
 - [x] 로또 (Lotto)
 - [x] 로또 모음 (Lotto Bundle)
 - [x] 로또 기계 (Lotto Machine)
 - [x] 로또 결과 이넘 (Lotto Match Result)
 - [x] 로또 결과 (Lotto Result)
 - [x] 수익률 계산기 (Profit Calculator)
 - [x] 로또 당첨 번호 (Winning Numbers)

## 서비스 (Service)
 - [x] 로또 결과 서비스 (Lotto Result Service)
 - [x] 로또 서비스 (Lotto Service)
 - [x] 수익률 계산기 서비스 (Profit Calculator Service)

## 검증 (Validation)
 - [x] 로또 검증 (Lotto Validator)
 - [x] 로또 구입 금액 검증 (Lotto Amount Validator)
 - [x] 로또 번호 검증 (Lotto Number Validator)

## 예외 처리 (Exception)
 - [x] 로또 게임 예외 (Lotto Exception)
 - [x] 수익률 게산기 예외

## 유틸 (Utils)
 - [x] 랜덤 번호 제공 (Lotto Number Generator)

## 출력 (Output View)
 - [x] 발행한 로또 수량 출력
 - [x] 발행한 로또 수량만큼의 로또 번호 오름차순으로 출력
 - [x] 당첨 내역 출력
 - [x] 소수점 둘째 자리에서 반올림한 수익률 출력

