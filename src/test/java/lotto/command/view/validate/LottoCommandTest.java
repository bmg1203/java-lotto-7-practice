package lotto.command.view.validate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;
import lotto.common.exception.ExceptionEnum;
import lotto.dto.UserInput;
import lotto.dto.WinningLottoUserInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 11. 3.
 */
class LottoCommandTest {
  private LottoCommand command;

  @BeforeEach
  void setUp(){
    command = new LottoCommand();
  }

  @ParameterizedTest
  @MethodSource("provideValidLottoInputs")
  @DisplayName("[success]execute : 유효한 로또 번호")
  void execute_shouldReturnCorrectUserInput(String input, List<Integer> expectedNumbers) {
    UserInput result = command.execute(input);
    assertThat(result)
        .isInstanceOf(WinningLottoUserInput.class);
    assertThat(((WinningLottoUserInput) result)
        .getNumbers())
        .isEqualTo(expectedNumbers);
  }

  @ParameterizedTest
  @MethodSource("invalidWhiteSpace")
  @DisplayName("[fail]execute : 공백 입력 처리")
  void execute_shouldThrowExceptionWithWhiteSpace(String blankInput,
      ExceptionEnum exceptionEnum) {
    assertThatThrownBy(() -> command.execute(blankInput))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("[ERROR]")
        .hasMessageContaining(exceptionEnum.getMessage());
  }

  @Test
  @DisplayName("[fail]execute : 공백이 포함된 입력 처리")
  void execute_shouldThrowExceptionWithSpace() {
    String inputWithSpace = "1,2,3,4,5,6 ";
    assertThatThrownBy(() -> command.execute(inputWithSpace))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("[ERROR]")
        .hasMessageContaining(ExceptionEnum.CONTAIN_WHITESPACE.getMessage());
  }

  @Test
  @DisplayName("[fail]execute : 최소 번호보다 작은 값 입력")
  void execute_shouldThrowExceptionWhenNumberLessThanMinimum() {
    String inputLessThanMinimum = "0,1,2,3,4,5";
    assertThatThrownBy(() -> command.execute(inputLessThanMinimum))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(ExceptionEnum.INPUT_LESS_THAN_MINIMUM.getMessage());
  }

  @Test
  @DisplayName("[fail]execute : 최대 번호보다 큰 값 입력")
  void execute_shouldThrowExceptionWhenNumberGreaterThanMaximum() {
    String inputGreaterThanMaximum = "1,2,3,4,5,50";
    assertThatThrownBy(() -> command.execute(inputGreaterThanMaximum))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(ExceptionEnum.INPUT_GREATER_THAN_MAXIMUM.getMessage());
  }

  @ParameterizedTest
  @MethodSource("provideInputsWithDuplicates")
  @DisplayName("[fail]execute : 중복된 번호 입력")
  void execute_shouldThrowExceptionWhenNumbersNotDistinct(String input) {
    assertThatThrownBy(() -> command.execute(input))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(ExceptionEnum.LOTTO_NUMBER_NOT_DISTINCT.getMessage());
  }

  @Test
  @DisplayName("[fail]execute : 잘못된 숫자 형식 입력")
  void execute_shouldThrowExceptionWhenInvalidNumberFormat() {
    String invalidInput = "1,two,3,four,five,six";
    assertThatThrownBy(() -> command.execute(invalidInput))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(ExceptionEnum.INVALID_INTEGER_RANGE.getMessage());
  }

  @Test
  void execute() {
  }

  @Test
  void ask() {
  }

  private static Stream<Arguments> provideValidLottoInputs() {
    return Stream.of(
        Arguments.of("1,2,3,4,5,6", List.of(1, 2, 3, 4, 5, 6)),
        Arguments.of("7,8,9,10,11,12", List.of(7, 8, 9, 10, 11, 12)),
        Arguments.of("1,3,5,7,9,11", List.of(1, 3, 5, 7, 9, 11))
    );
  }

  private static Stream<String> provideInputsWithDuplicates() {
    return Stream.of(
        "1,2,3,4,5,5",
        "1,1,2,3,4,5",
        "2,3,4,5,6,6",
        "7,8,9,10,10,11",
        "1,2,2,3,4,5",
        "5,6,7,8,9,9"
    );
  }

  private static Stream<Arguments> invalidWhiteSpace() {
    return Stream.of(
        Arguments.of("", ExceptionEnum.CONTAIN_BLANK),
        Arguments.of(" ", ExceptionEnum.CONTAIN_BLANK),
        Arguments.of("\t", ExceptionEnum.CONTAIN_BLANK),
        Arguments.of("\n", ExceptionEnum.CONTAIN_BLANK),
        Arguments.of("\r", ExceptionEnum.CONTAIN_BLANK),
        Arguments.of("\f", ExceptionEnum.CONTAIN_BLANK));
  }
}