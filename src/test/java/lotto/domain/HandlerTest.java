package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Lotto;
import lotto.view.InputTest;
import lotto.view.Input;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HandlerTest {
  private Handler handler;
  private InputTest inputTest;
  private Input input;



  private InputStream setReadLine(String readLine) {
    return new ByteArrayInputStream(readLine.getBytes());
  }

  /**
   * HandlerTest > 사용자 입력 후 로또를 요청 수만큼 발행했는지 확인한다 FAILED
   *     java.util.NoSuchElementException at HandlerTest.java:31
   * @throws Exception
   */
  @DisplayName("사용자 입력 후 로또를 요청 수만큼 발행했는지 확인한다")
  @Test
  public void generateLottoTest() throws Exception{
    // given : 사용자가 구매 금액을 입력하면

    String readLine = "14000";
    this.input = new Input(readLine);
    System.setIn(setReadLine(readLine));

    // 구매액만큼 로또수를 요청하고
    int request = 14;
    int givenRequest = input.getLottoCounts(request);
    this.handler = new Handler(request);
    // when : 요청 수만큼 로또 생성을 반복해서 이중리스트에 추가
    // 로또 자동 생성시 중복되는 문제
    Lotto lotto = new Lotto(handler.generateLotto());  //  java.lang.NumberFormatException at HandlerTest.java:89


    List<List<Integer>> lottoRequest = lotto.responseLottoCounts(request);

    int actualGenerated = lottoRequest.size();

    assertEquals(request, actualGenerated);
  }


  @DisplayName("입력받은 당첨번호를 쉼표, 공백 구분자와 정수를 분리한다")
  @Test
  void generateWinningTest() throws Exception{

    // given : 당첨 번호를 입력하면
    String expect = "1, 2, 3, 4, 5, 6";
    this.input = new Input(expect);
    System.setIn(setReadLine(expect));

    // when : 쉼표와 공백 구분자를 정수와 분리한다
    String actualWinning = input.readWinning();


    // then : 실제 입력된 당첨번호를 조회하여 검증한다
    assertEquals(expect, actualWinning);
  }


  @DisplayName("내부적으로 구매 금액만큼의 로또를 발행하여 당첨 번호와 보너스 번호를 적절히 비교한다")
  @Test
  void compareNumbersTest() {
    // given : 일치성 횟수 계산 결과 예시
    String given = "3개 일치 (5,000원) - 1개\n" +
        "4개 일치 (50,000원) - 0개\n" +
        "5개 일치 (1,500,000원) - 0개\n" +
        "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" +
        "6개 일치 (2,000,000,000원) - 0개";

    // 구매 금액 만큼의 로또 수 조회
    String readAmount = "8000";
    System.setIn(setReadLine(readAmount));
    this.input = new Input(given);

//    new Lo

  }

  /**
   * HandlerTest > 비교한 결과를 토대로 총 수익률 계산한다 FAILED
   *     java.util.NoSuchElementException at HandlerTest.java:31
   */
  @DisplayName("비교한 결과를 토대로 총 수익률 계산한다")
  @Test
  void calculateRevenueTest() {
    // 총 수익률 예시
    double given = 62.5;
    String expect = "총 수익률은 62.5%입니다.";
    String resultExam = "3개 일치 (5,000원) - 1개\n" +
        "4개 일치 (50,000원) - 0개\n" +
        "5개 일치 (1,500,000원) - 0개\n" +
        "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" +
        "6개 일치 (2,000,000,000원) - 0개";

    // 수익률 계산
    double revenue = handler.valueationRevenue(resultExam, input.readAmount());
    // 수익률 계산 결과 조회
    String actual = handler.getResult(revenue);
    // 검증
    assertEquals(expect, actual); // java.util.regex.PatternSyntaxException: Unclosed counted closure near index 6
    // 아 시간 없어서 인공지능한테 물어봤더니 또 틀리네 기계녀석
  }


}