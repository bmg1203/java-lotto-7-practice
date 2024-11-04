package lotto.unit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constants.ErrorMessages;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinningNumbersTest {

    @ParameterizedTest
    @CsvSource({
            "1,2,3,4,5",
            "1,2,3,4,5,6,7",
            "1,2,3,4"
    })
    @DisplayName("입력된 당첨 번호의 개수가 6개가 아닌 경우 예외가 발생한다.")
    void winningNumbersCount(String input) {
        assertThatThrownBy(() -> new WinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INVALID_WINNING_NUMBER_COUNT);
    }

    @Test
    @DisplayName("당첨 번호에 중복된 값이 있는 경우 예외가 발생한다.")
    void winningNumbersContainDuplicates() {
        String input = "1,2,3,4,5,5";
        assertThatThrownBy(() -> new WinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.DUPLICATE_WINNING_NUMBER);
    }

    @Test
    @DisplayName("당첨 번호가 정상적으로 생성된다.")
    void createWinningNumbersSuccessfully() {
        String input = "1,2,3,4,5,6";
        WinningNumbers winningNumbers = new WinningNumbers(input);
        assertThat(winningNumbers.getNumbers()).containsExactlyInAnyOrder(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("당첨 번호 입력에 잘못된 구분자가 포함된 경우 예외가 발생한다.")
    void winningNumbersInvalidDelimiter() {
        String input = "1;2;3;4;5;6"; // 세미콜론 사용
        assertThatThrownBy(() -> new WinningNumbers(input))
                .isInstanceOf(NumberFormatException.class);
    }

    @Test
    @DisplayName("당첨 번호 입력에 공백이 포함된 경우 올바르게 처리된다.")
    void winningNumbersWithSpaces() {
        String input = " 1 , 2 , 3 , 4 , 5 , 6 ";
        WinningNumbers winningNumbers = new WinningNumbers(input);
        assertThat(winningNumbers.getNumbers()).containsExactlyInAnyOrder(1, 2, 3, 4, 5, 6);
    }

    @ParameterizedTest
    @CsvSource({
            "0,2,3,4,5,6",
            "46,2,3,4,5,6",
            "-1,2,3,4,5,6"
    })
    @DisplayName("당첨 번호에 범위를 벗어나는 숫자가 포함된 경우 예외가 발생한다.")
    void winningNumbersOutOfRange(String input) {
        assertThatThrownBy(() -> new WinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INVALID_LOTTO_NUMBER_RANGE);
    }
}
