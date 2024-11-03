package lotto.service;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.enums.ErrorCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ValidatorServiceTest {

    private ValidatorService validatorService;

    @BeforeEach
    void setUp() {
        validatorService = new ValidatorService();
    }

    @Test
    void 구매_금액_검증_유효한_금액() {
        int validAmount = 5000;
        assertThatCode(() -> validatorService.validatePurchaseAmount(validAmount))
                .doesNotThrowAnyException();
    }

    @Test
    void 구매_금액_검증_유효하지_않은_금액() {
        int invalidAmount = 5500;
        assertThatThrownBy(() -> validatorService.validatePurchaseAmount(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INVALID_PURCHASE_AMOUNT.getMessage());
    }

    @Test
    void 쉼표_구분된_문자열_파싱_검증_유효한_입력() {
        String validInput = "1, 2, 3, 4, 5, 6";
        assertThatCode(() -> validatorService.validateParsing(validInput))
                .doesNotThrowAnyException();
    }

    @Test
    void 쉼표_구분된_문자열_파싱_검증_유효하지_않은_입력() {
        String invalidInput = "a, b, c, d, e, f";
        assertThatThrownBy(() -> validatorService.validateParsing(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.PARSING_INTEGER_ERROR.getMessage());
    }

    @Test
    void 로또_숫자_검증_유효한_숫자() {
        List<Integer> validNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatCode(() -> validatorService.validateLottoNumbers(validNumbers))
                .doesNotThrowAnyException();
    }

    @Test
    void 로또_숫자_검증_숫자_개수_오류() {
        List<Integer> invalidCountNumbersLess = List.of(1, 2, 3, 4, 5);
        List<Integer> invalidCountNumbersMore = List.of(1, 2, 3, 4, 5, 6, 7);
        assertThatThrownBy(() -> validatorService.validateLottoNumbers(invalidCountNumbersLess))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INVALID_LOTTO_NUMBER_COUNT.getMessage());

        assertThatThrownBy(() -> validatorService.validateLottoNumbers(invalidCountNumbersMore))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INVALID_LOTTO_NUMBER_COUNT.getMessage());
    }

    @Test
    void 로또_숫자_검증_숫자_범위_오류() {
        List<Integer> outOfRangeNumbers = List.of(0, 2, 3, 4, 5, 46);
        assertThatThrownBy(() -> validatorService.validateLottoNumbers(outOfRangeNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INVALID_NUMBER_RANGE.getMessage());
    }

    @Test
    void 로또_숫자_검증_중복_숫자_오류() {
        List<Integer> duplicateNumbers = List.of(1, 1, 2, 3, 4, 5);
        assertThatThrownBy(() -> validatorService.validateLottoNumbers(duplicateNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.DUPLICATE_NUMBER.getMessage());
    }
}
