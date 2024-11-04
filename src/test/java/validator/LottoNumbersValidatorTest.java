package validator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumbersValidatorTest {

    private List<Integer> validLottoNumbers;

    @BeforeEach
    void setUp() {
        validLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("로또 번호의 개수가 6개일 때 예외가 발생하지 않는다.")
    void 로또_번호_개수가_6개여서_예외가_발생하지_않는다() {
        // when, then
        assertThatCode(() -> LottoNumbersValidator.validateLottoNumbers(validLottoNumbers))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("로또 번호의 개수가 6개가 아닐 때 예외가 발생한다.")
    void 로또_번호_개수가_5개여서_예외가_발생한다() {
        // given
        List<Integer> invalidLottoNumbers = List.of(1, 2, 3, 4, 5); // 5개 번호

        // when, then
        assertThatThrownBy(() -> LottoNumbersValidator.validateLottoNumbers(invalidLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호가 1 이상 45 이하일 때 예외가 발생하지 않는다.")
    void 로또_번호가_허용된_범위_내에_있어서_예외가_발생하지_않는다() {
        // when, then
        assertThatCode(() -> LottoNumbersValidator.validateLottoNumbers(validLottoNumbers))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("로또 번호가 1 미만일 때 예외가 발생한다.")
    void 로또_번호가_1_미만이어서_예외가_발생한다() {
        // given
        List<Integer> invalidLottoNumbers = List.of(0, 2, 3, 4, 5, 6); // 0이 포함됨

        // when, then
        assertThatThrownBy(() -> LottoNumbersValidator.validateLottoNumbers(invalidLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호가 45 초과일 때 예외가 발생한다.")
    void 로또_번호가_45를_초과해서_예외가_발생한다() {
        // given
        List<Integer> invalidLottoNumbers = List.of(1, 2, 3, 4, 5, 46); // 46이 포함됨

        // when, then
        assertThatThrownBy(() -> LottoNumbersValidator.validateLottoNumbers(invalidLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호에 중복이 없을 때 예외가 발생하지 않는다.")
    void 로또_번호에_중복이_없어서_예외가_발생하지_않는다() {
        // when, then
        assertThatCode(() -> LottoNumbersValidator.validateLottoNumbers(validLottoNumbers))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("로또 번호에 중복이 있을 때 예외가 발생한다.")
    void 로또_번호에_중복이_있어서_예외가_발생한다() {
        // given
        List<Integer> invalidLottoNumbers = List.of(1, 2, 3, 4, 5, 5); // 5가 중복됨

        // when, then
        assertThatThrownBy(() -> LottoNumbersValidator.validateLottoNumbers(invalidLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
