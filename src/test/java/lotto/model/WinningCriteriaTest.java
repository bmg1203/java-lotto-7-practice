package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningCriteriaTest {

    @DisplayName("올바른 입력으로 객체 생성")
    @Test
    void 올바른_입력으로_객체_생성() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(8, lotto.getNumbers());

        WinningCriteria actualCriteria = new WinningCriteria(lotto, bonusNumber);

        assertThat(actualCriteria.getLotto())
                .usingRecursiveComparison()
                .isEqualTo(lotto);
        assertThat(actualCriteria.getBonusNumber())
                .usingRecursiveComparison()
                .isEqualTo(bonusNumber);
    }

    @DisplayName("잘못된 입력으로 객체 생성")
    @ParameterizedTest(name = "{0}, {1}을 입력할 경우 : {2}")
    @MethodSource
    void 잘못된_입력으로_객체_생성(Lotto lotto, BonusNumber bonusNumber, String expectedExceptionMessage) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningCriteria(lotto, bonusNumber))
                .withMessage(expectedExceptionMessage);
    }

    static Stream<Arguments> 잘못된_입력으로_객체_생성() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(8, lotto.getNumbers());
        return Stream.of(
                Arguments.of(lotto, null, WinningCriteria.NULL_BONUS_NUMBER_EXCEPTION_MESSAGE),
                Arguments.of(null, bonusNumber, WinningCriteria.NULL_LOTTO_EXCEPTION_MESSAGE),
                Arguments.of(null, null, WinningCriteria.NULL_LOTTO_EXCEPTION_MESSAGE)
        );
    }
}