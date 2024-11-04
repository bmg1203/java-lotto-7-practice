# 로또 발매기 프로젝트

* **우아한테크코스 프리코스 과제:** 자바로 로또 발매기 구현하기

## 목차

1. [프로젝트 개요](#프로젝트-개요)
2. [주요 기능](#주요-기능)
3. [기능 목록](#기능-목록)
4. [프로그래밍 요구 사항](#프로그래밍-요구-사항)
5. [예외 처리](#예외-처리)

# 프로젝트 개요

* 이 프로젝트는 Java 언어를 사용하여 간단한 로또 발매기를 구현하는 것을 목표로 합니다.
* 프로젝트는 로또 번호 생성, 당첨 여부 판단, 수익률 계산 등의 기능을 포함하며, 우아한테크코스 프리코스의 과제 요구 사항에 따라 개발됩니다.

# 주요 기능
***로또 번호 생성***
* 1부터 45 사이의 중복되지 않는 6개의 숫자를 자동으로 생성합니다.

***당첨 번호 입력 및 판단***
* 사용자가 입력한 당첨 번호와 구매한 로또 번호를 비교하여 당첨 여부를 판단합니다.

***수익률 계산***
* 사용자가 구매한 로또의 당첨 결과를 기반으로 수익률을 계산하여 출력합니다.

***에러 처리***
* 잘못된 입력에 대해 예외를 발생시키고, "[ERROR]"로 시작하는 메시지를 출력합니다.

# 기능 목록
***로또 번호 생성***
* 기능 설명: 로또 발매기 시스템은 1부터 45 사이의 중복되지 않는 6개의 숫자를 자동으로 생성합니다.
* 사용 시점: 사용자가 금액을 입력하여 로또를 구매할 때, 해당 금액에 맞춰 필요한 수량의 로또 번호를 생성합니다.

***구매한 로또의 수량 및 번호 출력***
* 기능 설명: 사용자가 입력한 금액에 따라 구매 가능한 로또 수량을 계산하고, 각 로또의 번호를 화면에 출력합니다. 
* 사용 시점: 사용자가 구매 금액을 입력하여 로또 번호가 생성된 후, 모든 구매 번호를 확인할 때 사용합니다.

***당첨 번호와 보너스 번호 입력 및 검증***
* 기능 설명: 사용자가 당첨 번호 6개와 보너스 번호 1개를 입력하고, 입력된 값이 올바른 형식과 범위에 맞는지 검증합니다.
* 사용 시점: 로또 구매 후, 당첨 번호가 공개된 이후에 사용자가 당첨 번호를 직접 입력하여 확인할 때 사용합니다.

***구매한 로또의 당첨 금액 확인과 수익률 계산***
* 기능 설명: 당첨 번호와 비교하여 구매한 각 로또의 당첨 등수를 확인하고, 이에 따른 총 당첨 금액과 수익률을 계산합니다.
* 사용 시점: 당첨 번호 입력 후, 각 로또 번호와 당첨 번호를 비교하여 당첨 결과를 계산할 때 사용합니다.

***당첨 내역 출력***
* 당첨 여부를 판단하여 결과를 출력합니다.
  * 당첨 등급 및 상금은 다음과 같습니다:
    * 1등: 6개 번호 일치 - 2,000,000,000원
    * 2등: 5개 번호 + 보너스 번호 일치 - 30,000,000원
    * 3등: 5개 번호 일치 - 1,500,000원
    * 4등: 4개 번호 일치 - 50,000원
    * 5등: 3개 번호 일치 - 5,000원

***수익률 계산***
* 기능 설명: 사용자가 입력한 구매 금액 대비 당첨 금액의 비율로 수익률을 계산하여 출력합니다.
* 사용 시점: 모든 로또의 당첨 결과가 집계된 후, 최종 결과와 함께 수익률을 계산할 때 사용합니다.

# 프로그래밍 요구 사항
* 인덴트 깊이 제한: 최대 2까지 허용
* 함수 길이 제한: **15라인 이하**
* 제어문 제한: **else 및 switch/case** 금지
* 테스트 도구: JUnit5와 AssertJ 사용
* 코딩 컨벤션: Java Style Guide에 따름

# 예외 처리
* 유효하지 않은 입력에 대한 예외 처리: 예외 상황 발생 시 [ERROR]로 시작하는 메시지를 출력하고 입력을 다시 받습니다.
* IllegalArgumentException 등의 명확한 예외 유형 사용
   1. [ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.
   2. [ERROR] 투입한 금액은 1,000원 단위여야 합니다.
   3. [ERROR] 로또 번호의 갯수는 6개의 숫자여야 합니다.
   4. [ERROR] 로또 번호는 중복되지 않는 숫자여야 합니다.
   5. [ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 하며, 당첨 번호와 중복 될 수 없습니다.
   6. [ERROR] 금액은 숫자 형식으로 입력해야 합니다.
