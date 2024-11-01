# java-lotto-precourse

## 기능 구현
### 1. 입력 / 출력
    문자열 입력, 검증
    문자열 변환
    로또 번호들 출력
    당첨금 번호 출력
    수익률 출력
### 2. 로또 번호 생성
    로또 번호 생성, 검증
### 3. 로또 맞은 개수, 금액 계산
    각각의 로또 맞은 개수 확인
        로또 당첨금액 반환
### 4. 수익률 계산
    수익률 계산
    총 당첨금 / 구매금액 * 100% (소수점 둘째에서 반올림)

## 요구사항
간단한 로또 발매기를 구현한다
### 1. 입력 확인
    금액이 1000원단위로 나누어지는지 확인
    문자열이 입력되었는지 확인
### 1. 로또 번호의 확인
    6개 + 보너스 1개
    범위 : 1 ~ 45  
    중복되지 않는다  
### 2. 금액 계산
    로또 한장당 1000원
    등수별 당첨금 계산
    수익률 계산

## 입출력 예시
### 1. 입력 예시
    금액 입력
    14000
    로또 번호 입력
    1,2,3,4,5,6
    보너스 번호 입력
    3
### 2. 출력 예시
    3개를 구매했습니다
    [1,2,3,4,5,6]
    [11,12,13,14,15,16]
    [21,22,23,24,25,26]
    3개 일치 (5,000원) - 0개
    4개 일치 (50,000원) - 0개
    5개 일치 (1,500,000원) - 0개
    5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
    6개 일치 (2,000,000,000원) - 1개
    총 수익률은62.5%입니다