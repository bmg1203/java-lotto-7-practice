# java-lotto-precourse

# 프리코스 3주차 과제 : 💰 로또

> 우아한테크코스 7기 3주차 미션, 로또를 구현한 저장소입니다.
> 사용자로부터 당첨 번호 6개의 로또 번호와 보너스 번호 1개를 받아 구매한 로또로 인해 생성된 무작위 숫자가 얼마나 일치하는지 에
> 따라 몇등에 당첨 됐는지 알려 주는 현실의 로또를 구현했습니다.

# 목차

- [시작하기](#시작하기)
- [기능 목록](#기능-목록)
    - [로또 시뮬레이션 시작](#로또-시뮬레이션-시작)
    - [로또 번호 뽑기](#로또-번호-뽑기)
    - [당첨자 발표](#당첨자-발표)

## 시작하기

레포지토리를 Clone 하고 IDE에서 애플리케이션을 실행합니다.

```
git clone -b as --single-branch https://github.com/ruudska6/java-lotto-7
```

## 기능 목록

---

## 로또 시뮬레이션 시작

- [ ] **사용자에게 로또 구입 금액 입력을 지시하는 메세지 출력**
    - `구입금액을 입력해 주세요.` 가 콘솔에 출력됨.
- [ ] **로또 구입 금액을 입력 받는다.**
    - 예외: 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.
- [ ] **입력 받은 값으로 1000원 단위로 로또의 갯수를 센다.**
    - 예시 : 5000원이라면 5개
- [ ] **사용자에게 당첨 번호 입력을 지시하는 메세지 출력**
    - `당첨 번호를 입력해 주세요.`가 콘솔에 출력됨.
- [ ] **당첨 번호를 입력 받는다.**
    - 번호는 쉼표(,)를 기준으로 구분한다.
- [ ] **보너스 번호를 입력 받는다.**
    - `보너스 번호를 입력해 주세요.`

## 로또 번호 뽑기

- [ ] 로또 1개당 중복되지 않는 무작위 숫자 로또 번호 6개를 뽑는다.
- [ ] 로또 1개당 위와도 중복되지 않는 무작위 숫자 보너스 번호 1개를 뽑는다.

- [ ] 순위와 당첨 기준 설정과 금액 설정
  > 순위 1~5등까지만   
  1등: 6개 번호 일치 => 2,000,000,000원  
  2등: 5개 번호 + 보너스 번호 일치 => 30,000,000원  
  3등: 5개 번호 일치 => 1,500,000원  
  4등: 4개 번호 일치 => 50,000원  
  5등: 3개 번호 일치 => 5,000원

## 당첨자 발표

- [ ] **뽑은 숫자가 몇개나 일치하는 지 확인 한다.**
    - 만약 5개만 일치한다면 보너스 번호도 일치하는지 확인한다.

- [ ] **당첨 금액을 계산한다.**
- [ ] **당첨 금액에 따른 수익률을 계산한다.**
- [ ] 당첨 금액과 수익률을 보여주는 통계를 출력한다.
    - 예시:
      > 3개 일치 (5,000원) - 1개  
      4개 일치 (50,000원) - 0개  
      5개 일치 (1,500,000원) - 0개  
      5개 일치, 보너스 볼 일치 (30,000,000원) - 0개  
      6개 일치 (2,000,000,000원) - 0개  
      총 수익률은 62.5%입니다.  