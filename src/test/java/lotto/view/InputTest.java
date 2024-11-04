package lotto.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputTest {

  private Input input;
  private String readLine;



  public InputStream setReadLine(String readLine) {
    return new ByteArrayInputStream(readLine.getBytes());
  }


  /**
   * 애플리케이션을 실행하면 사용자가 로또 구매 금액을 입력하여 값을 읽고 로또 발행 수량까지 요청한다 FAILED
   *     java.util.NoSuchElementException at InputTest.java:34
   */
  @DisplayName("애플리케이션을 실행하면 사용자가 로또 구매 금액을 입력하여 값을 읽고 로또 발행 수량까지 요청한다")
  @Test
  void runApplicationTest() {
    //given
    String given = "8000";
    System.setIn(setReadLine(given));
    Input input = new Input(given);

    //when
    // find why : 함수를 하나식 쪼갰더니 전체 테스트 실행에서 NoSuchElementException
    int actualAmount = input.readAmount();
    int expectAmount = 8000;

    int actualRequest = input.getLottoCounts(actualAmount);
    int expectRequest = 8;
    //then
    assertEquals(expectAmount, actualAmount);
    assertEquals(expectRequest, actualRequest);
  }

  @DisplayName("당첨 번호를 입력받는다")
  @Test
  void readWinningTest() {
    // given
    String winningNumbers = "1,2,3,4,5,6";
    System.setIn(setReadLine(winningNumbers));

    // when

    // then
  }

  /**
   * InputTest > 보너스 번호를 입력받는다 FAILED
   *     java.util.NoSuchElementException at InputTest.java:64
   */
  @DisplayName("보너스 번호를 입력받는다")
  @Test
  void readBonusNumberTest() {
    // given
    String given = "7";
    Input input = new Input(given);
    System.setIn(setReadLine(given));

    // when
    int expect = Integer.parseInt(given);
    int actual = input.readBonus();

    // then
    assertEquals(expect, actual);

  }



//  @DisplayName("입력된 금액에 따른 로또를 정확히 발행한다")
//  @Test
//  void getLottosCount() {
//
//    // given
//    System.setIn(setReadLine("14000"));
//    int amount = input.readAmount();
//    int actual = input.getLottoCounts(amount);
//
//    // when
//    int expect = 14;
//
//    // then
//    assertEquals(expect, actual);
//  }

  //    구매 가능 범위를 초과한 경우 (최대 10만원) : NumberFormatException
  @DisplayName("구매 가능 범위를 초과한 경우 (최대 10만원) : NumberFormatException")
  @Test
  void IllegalArgumentExceptionTest_2_되도_않는_영어이름_테스트_4() {

    String invalid = "100001";
    assertThatThrownBy(() -> new Input(invalid))
        .isInstanceOf(NumberFormatException.class);
  }
}