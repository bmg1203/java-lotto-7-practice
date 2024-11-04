package lotto.entity;

import lotto.enums.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {
    private static final String TEST_TITLE_HEADER = "[LottoTest] ";

    @DisplayName(TEST_TITLE_HEADER + "로또 번호의 개수가 6개가 아니면 예외가 발생한다")
    @ParameterizedTest
    @MethodSource
    void 로또_번호의_개수가_6개가_아니면_예외가_발생한다(List<Integer> lottoNumber) {
        assertThatThrownBy(() -> new Lotto(lottoNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.LOTTO_NUMBER_NOT_VALID_COUNT.getMessage());
    }

    @DisplayName(TEST_TITLE_HEADER + "로또 번호에 중복된 숫자가 있으면 예외가 발생한다")
    @ParameterizedTest
    @MethodSource
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다(List<Integer> lottoNumber) {
        assertThatThrownBy(() -> new Lotto(lottoNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.LOTTO_NUMBER_DUPLICATED.getMessage());
    }

    @DisplayName(TEST_TITLE_HEADER + "로또 번호가 1 과 45 사이의 숫자가 아닐 경우 예외가 발생한다")
    @ParameterizedTest
    @MethodSource
    void 로또_번호가_1_과_45_사이의_숫자가_아니면_예외가_발생한다(List<Integer> lottoNumber) {
        assertThatThrownBy(() -> new Lotto(lottoNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
    }

    @DisplayName(TEST_TITLE_HEADER + "정상 동작 테스트")
    @ParameterizedTest
    @MethodSource
    void 정상_동작_테스트(List<Integer> lottoNumber) {
        assertThat(new Lotto(lottoNumber).getNumbers()).isSorted().containsAll(lottoNumber);
    }

    private static Stream<List<Integer>> 로또_번호의_개수가_6개가_아니면_예외가_발생한다() {
        return Stream.of(
                List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
                List.of(1, 2, 3, 4, 5, 6, 7),
                List.of(1, 2, 3, 4, 5),
                List.of(1, 2, 3, 4),
                List.of(1, 2, 3),
                List.of(1, 2),
                List.of(1),
                List.of()
        );
    }

    private static Stream<List<Integer>> 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        return Stream.of(
                List.of(1, 1, 1, 1, 1, 1),
                List.of(1, 1, 1, 1, 1, 6),
                List.of(1, 1, 1, 1, 5, 6),
                List.of(1, 1, 1, 4, 5, 6),
                List.of(1, 1, 3, 4, 5, 6)
        );
    }

    private static Stream<List<Integer>> 로또_번호가_1_과_45_사이의_숫자가_아니면_예외가_발생한다() {
        return Stream.of(
                List.of(58, 1, 2, 3, 4, 5),
                List.of(999999, 99999, 11111, 333333, 5555555, 123214),
                List.of(0, 2, 3, 4, 5, 6),
                List.of(4, 3, 2, 1, 46, 5),
                List.of(-1, -22, -3, -333333, -5555555, -6)
        );
    }

    private static Stream<List<Integer>> 정상_동작_테스트() {
        return Stream.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(4, 5, 6, 7, 8, 9),
                List.of(1, 11, 22, 33, 44, 45),
                List.of(45, 44, 42, 43, 41, 40)
        );
    }
}
