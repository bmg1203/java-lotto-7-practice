package lotto.domain;

import lotto.exception.lotto.LottoNumberDuplicateException;
import lotto.exception.lotto.LottoNumberRangeException;
import lotto.exception.lotto.LottoNumberSizeException;
import lotto.util.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("당첨 번호 검증")
class WinningLottoTest {
    @Test
    @DisplayName("1~45 사이의 중복되지 않는 6개의 숫자일 때")
    void validateWinningLotto() {
        assertThat(WinningLotto.from(List.of(1, 2, 3, 4, 5, 45))).isInstanceOf(WinningLotto.class);
    }

    @ParameterizedTest(name = "{index} : {3}")
    @MethodSource("generateExceptionData")
    @DisplayName("예외 검증")
    void invalidWinningLotto(List<Integer> inputWinningLotto, Class expectedExceptionClass,
                             String errerMessage, String message) {
        assertThatThrownBy(() -> {
            WinningLotto.from(inputWinningLotto);
        }).isInstanceOf(expectedExceptionClass)
                .hasMessage(errerMessage);
    }

    static Stream<Arguments> generateExceptionData() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 46), LottoNumberRangeException.class,
                        ErrorMessage.LOTTO_NUMBER_RANGE, "1~45 사이가 아닐 때"),
                Arguments.of(List.of(0, 2, 3, 4, 5, 45), LottoNumberRangeException.class,
                        ErrorMessage.LOTTO_NUMBER_RANGE, "1~45 사이가 아닐 때"),
                Arguments.of(List.of(1, 2, 3, 4, 5), LottoNumberSizeException.class,
                        ErrorMessage.LOTTO_NUMBER_SIZE, "6개의 숫자가 아닐 때"),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7), LottoNumberSizeException.class,
                        ErrorMessage.LOTTO_NUMBER_SIZE, "6개의 숫자가 아닐 때"),
                Arguments.of(List.of(1, 2, 3, 4, 5, 5), LottoNumberDuplicateException.class,
                        ErrorMessage.LOTTO_NUMBER_DUPLICATE, "숫자가 중복될 때")
        );
    }

    @Test
    @DisplayName("구매한 로또와 당첨 번호의 일치 개수를 계산하는지")
    void calculateMatchedCountLottoWithWinningLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        WinningLotto winningLotto = WinningLotto.from(List.of(1, 2, 3, 4, 5, 7));

        assertThat(winningLotto.getMatchedNumberCount(lotto)).isEqualTo(5);
    }
}