# 🎱 로또 기능 명세서 💸

## 목차 (Table of Contents)

1. [이야기로 이해해보기](#이야기로-이해해보기)
2. [용어 사전 📘](#용어-사전-📘)
3. [승희는 돈을 낼 수 있다](#승희는-돈을-낼-수-있다)
    - [돈은 1000원 단위로 입력돼야 한다](#돈은-1000원-단위로-입력돼야-한다)
    - [잘못 낸 경우에는 바로 다시 낼 기회를 준다](#잘못-낸-경우에는-바로-다시-낼-기회를-준다)
4. [승희는 로또 가게에 가서 로또를 살 수 있다](#승희는-로또-가게에-가서-로또를-살-수-있다)
    - [돈을 낸 만큼 로또 종이를 갖는다](#돈을-낸-만큼-로또-종이를-갖는다)
    - [로또 종이에 쓰여진 로또 번호들은 자동으로 뽑힌다](#로또-종이에-쓰여진-로또-번호들은-자동으로-뽑힌다)
5. [승희는 로또 종이를 봤다](#승희는-로또-종이를-봤다)
    - [랜덤으로 뽑힌 로또 번호들을 확인할 수 있다](#랜덤으로-뽑힌-로또-번호들을-확인할-수-있다)
6. [로또 가게에서 당첨 번호를 입력해준다](#로또-가게에서-당첨-번호를-입력해준다)
7. [로또 가게에서 보너스 번호를 입력해준다](#로또-가게에서-보너스-번호를-입력해준다)
8. [일치하는 숫자에 따라 등수가 정해진다](#일치하는-숫자에-따라-등수가-정해진다)
9. [수익률은 계산된다](#수익률은-계산된다)
10. [승희는 문자로 당첨 통계를 확인할 수 있다](#승희는-문자로-당첨-통계를-확인할-수-있다)

---

## 이야기로 이해해보기

승희는 오늘 좋은 꿈을 꿨다. 🐷 로또 가게에 가서 로또를 사려고 한다. 주머니에는 8500원이 있다.<br>
처음에는 8500원을 냈지만, 거절 당했다. 로또는 무조건 1000원 단위로만 살 수 있다고 하셨다.<br>
8000원을 냈다. 승희는 로또 종이를 봤다. 랜덤으로 생성된 이 숫자들은 6개이고, 범위는 1에서 45 사이이다. 또한 중복은 없다고 가게 주인분께서 그러셨다.<br>
그렇지만, 로또 번호끼리는 겹칠 수 있다고 하셨다. 로또 번호끼리 중복될 확률은 0.0000123% 라고 한다. 겹치게 되면 운명일지도?!
<br>
로또 가게에서 당첨 번호가 입력됐다고 한다. 보너스 번호도 입력됐다고 한다.<br>
이 숫자들도 로또 종이의 숫자들과 마찬가지로 6개이고, 1과 45 사이이며 중복은 없다고 그러셨다. 만약 실수로 잘못 입력하시게 되면 다시 입력해야 한다고 했다.<br>
<br>
두근두근. 당첨 통계 결과가 문자로 왔다! 3개가 일치하는 종이가 하나 있어 5000원을 벌었다.<br>
8개를 사고 5000원을 벌었으니, 수익률이 62.5% 이다! 수익률은 내가 읽기 쉽게 항상 소수점 둘째자리에서 반올림된다고 했다.<br>
문자에는 이렇게 쓰여 있었다.

```
당첨 통계
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다.
```

## 용어 사전 📘

- 구입금액(PaidAmount) : 승희가 낸 돈
- 로또 티켓(LottoTicket) : 받은 로또 종이
- 고객(Customer) : 승희와 같은 고객
- 로또(Lotto) : 번호들을 모은 집합에 대한 명칭
- 당첨 번호 (Winning Number) : 당첨자가 발표되기 전 가게에서 입력하는 개별적인 숫자들의 집합
- 당첨 로또 (Winning Lotto) : 당첨 번호와 보너스 번호가 포함된 숫자들의 집합

## 승희는 돈을 낼 수 있다.

- [x] 돈은 1000원 단위로 입력돼야 한다.
    - [x] 양의 정수가 아닌 경우에는 예외를 던져야 한다.
- [x] 잘못 낸 경우에는 바로 다시 낼 기회를 준다.

## 승희는 로또 가게에 가서 로또를 살 수 있다.

- [x] 돈을 낸 만큼 로또 종이를 갖는다.
    - [x] 로또 종이에 쓰여진 로또 번호들은 자동으로 뽑힌다.
        - [x] 이 번호들은 6개이다.
        - [x] 1과 45 사이이다.
        - [x] 중복은 없다.

## 승희는 로또 종이를 봤다.

- [x] 랜덤으로 뽑힌 로또 번호들을 확인할 수 있다.
    - [x] 랜덤으로 뽑힌 숫자들은 오름차순으로 정렬되어 있다.

## 로또 가게에서 당첨 번호를 입력해준다.

- [x] 0보다 큰 정수 형태여야 한다.
- [x] 범위는 1과 45 사이이다.
- [x] 숫자 간의 중복은 없다.
- [x] 6개이다.
- [x] 잘못 입력한 경우에는 바로 다시 입력할 기회를 준다.

## 로또 가게에서 보너스 번호를 입력해준다.

- [x] 0보다 큰 정수 형태여야 한다.
- [x] 범위는 1과 45 사이이다.
- [x] 당첨 번호와의 중복은 없다.
- [x] 잘못 입력한 경우에는 바로 다시 입력할 기회를 준다.

## 일치하는 숫자에 따라 등수가 정해진다.

- [x] 가게에서는 내 로또 티켓 종이의 번호들과 당첨 번호가 몇개 일치하는지 세어준다.
- [x] 일치하는 번호의 개수에 따라 등수가 정해진다.

## 수익률은 계산된다.

- [x] 수익률을 계산한다.
- 승희는 3,000원을 내고 5,000원을 벌었다.
    - 3개가 일치하면 5,000원을 번다.
    - 4개 일치하면 50,000원을 번다.
    - 5개가 일치하면 1,500,000원을 번다.
    - 5개가 일치 + 보너스 번호가 일치하면 3,000,000원을 번다.
    - 6개가 일치하면 2,000,000,000원을 번다.

## 승희는 문자로 당첨 통계를 확인할 수 있다.

- [x] 각 등수마다의 결과를 확인할 수 있다.
- [x] 소수점 둘째자리에서 반올림된 수익률을 확인할 수 있다.
