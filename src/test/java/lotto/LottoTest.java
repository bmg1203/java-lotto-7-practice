package lotto;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("invalidInputSource")
    void 로또_번호에_1미만_45초과_숫자가_있으면_예외가_발생한다(List<Integer> candidate) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new Lotto(candidate))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("[ERROR]로또 번호의 숫자는 1~45까지만 허용됩니다.")
        );
    }

    private static Stream<Arguments> invalidInputSource() {
        return Stream.of(
                Arguments.of(List.of(-1, 1, 2, 3, 4, 5)),
                Arguments.of(List.of(0, 1, 2, 3, 4, 5)),
                Arguments.of(List.of(46, 1, 2, 3, 4, 5))
        );
    }
}
