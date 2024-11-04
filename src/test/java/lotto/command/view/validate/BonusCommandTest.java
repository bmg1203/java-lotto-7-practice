package lotto.command.view.validate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;
import lotto.common.exception.ExceptionEnum;
import lotto.dto.BonusUserInput;
import lotto.dto.UserInput;
import lotto.dto.WinningLottoUserInput;
import lotto.model.lotto.WinningLotto;
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
class BonusCommandTest {
  private BonusCommand command;

  @BeforeEach
  void setUp() {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
    WinningLottoUserInput userInput = WinningLottoUserInput.from(numbers);
    command = BonusCommand.from(WinningLotto.from(userInput));
  }

  @ParameterizedTest
  @ValueSource(strings = {
      "8",
      "10",
      "45"
  })
  @DisplayName("[success]execute : 유효한 보너스 번호")
  void execute_shouldReturnCorrectUserInput(String input) {
    UserInput result = command.execute(input);
    assertThat(result)
        .isInstanceOf(BonusUserInput.class);

    assertThat(((BonusUserInput) result).getNumber())
        .isEqualTo(Integer.parseInt(input));
  }

  @ParameterizedTest
  @MethodSource("provideInvalidBonusInputs")
  @DisplayName("[fail]execute : 유효하지 않은 보너스 번호")
  void execute_shouldThrowExceptionWhenInvalidInput(String input, ExceptionEnum expectedException) {
    assertThatThrownBy(() -> command.execute(input))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("[ERROR]")
        .hasMessageContaining(expectedException.getMessage());
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
    String inputWithSpace = "1,4,3,4,5,6 ";
    assertThatThrownBy(() -> command.execute(inputWithSpace))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("[ERROR]")
        .hasMessageContaining(ExceptionEnum.CONTAIN_WHITESPACE.getMessage());
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

  private static Stream<Arguments> provideInvalidBonusInputs() {
    return Stream.of(
        Arguments.of("0", ExceptionEnum.INPUT_LESS_THAN_MINIMUM),
        Arguments.of("46", ExceptionEnum.INPUT_GREATER_THAN_MAXIMUM),
        Arguments.of("50", ExceptionEnum.INPUT_GREATER_THAN_MAXIMUM),
        Arguments.of("abc", ExceptionEnum.INVALID_INTEGER_RANGE),
        Arguments.of("-1", ExceptionEnum.INPUT_LESS_THAN_MINIMUM),
        Arguments.of("1", ExceptionEnum.BONUS_NUMBER_NOT_DISTICT),
        Arguments.of("2", ExceptionEnum.BONUS_NUMBER_NOT_DISTICT),
        Arguments.of("3", ExceptionEnum.BONUS_NUMBER_NOT_DISTICT),
        Arguments.of("4", ExceptionEnum.BONUS_NUMBER_NOT_DISTICT)
    );
  }
}