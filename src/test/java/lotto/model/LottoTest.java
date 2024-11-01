package lotto.model;

import java.util.ArrayList;
import lotto.constants.ErrorMessage;
import lotto.validator.AmountsValidator;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.constants.ErrorMessage.INVALID_LOTTO_NUMBER_COUNT;
import static lotto.constants.ErrorMessage.WINNING_NUMBER_OUT_OF_RANGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.in;

class LottoTest {

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성

    @DisplayName("로또 번호의 개수가 6개보다 적게 들어오면, 예외가 발생한다.")
    @Test
    void Given_LottoNumbersUnderSix_When_ValidateNumberCount_Then_Error() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LOTTO_NUMBER_COUNT.getMessage());
    }

    @DisplayName("로또 번호가 1부터 45사이의 숫자가 아니면, 예외가 발생한다.")
    @Test
    void Given_LottoNumbersAreOutOfRange_When_ValidateNumberRange_Then_Error() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WINNING_NUMBER_OUT_OF_RANGE.getMessage());

    }
}
