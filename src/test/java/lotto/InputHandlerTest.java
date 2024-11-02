package lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InputHandlerTest {
    @Test
    void 로또_구입금액이_1000단위가_아닐경우_예외_발생() {
        // Given
        int price = 5500;

        // When
        InputHandler inputHandler = new InputHandler();
        // Then
        Assertions.assertThatThrownBy(() -> inputHandler.priceInputValidator(price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입금액은 1000단위만 가능합니다.");
    }

    @Test
    void 로또_당첨번호에_중복된_숫자가_존재할_경우_예외_발생() {
        // Given
        List<Integer> winningNumbers = Arrays.asList(1, 1, 2, 3, 4, 5);
        // When
        InputHandler inputHandler = new InputHandler();
        // Then
        Assertions.assertThatThrownBy(() -> inputHandler.winningNumbersInputValidator(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨번호에 중복된 숫자가 존재합니다.");
    }
}