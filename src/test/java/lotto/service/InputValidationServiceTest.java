package lotto.service;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import java.util.stream.Stream;
import lotto.constant.LottoConfiguration;
import lotto.constant.ValidationFailMessage;
import lotto.generator.RawInputGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class InputValidationServiceTest {

    private InputValidationService inputValidationService;

    @BeforeEach
    void beforeEach() {
        inputValidationService = new InputValidationService();
    }

    @DisplayName("올바른 구매 금액의 입력을 검증")
    @Test
    void 올바른_구매_금액의_입력을_검증() {
        String rawPurchasePrice = String.valueOf(LottoConfiguration.LOTTO_PRICE * 15);
        assertThatCode(() -> inputValidationService.validatePurchasePrice(rawPurchasePrice))
                .doesNotThrowAnyException();
    }

    @DisplayName("잘못된 구매 금액의 입력을 검증")
    @ParameterizedTest(name = "\"{0}\"가 입력된 경우 : {1}")
    @MethodSource
    void 로또_구매_금액에_대한_입력값_검증(String inputPurchasePrice, String expectedExceptionMessage) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> inputValidationService.validatePurchasePrice(inputPurchasePrice))
                .withMessage(expectedExceptionMessage);
    }

    static Stream<Arguments> 로또_구매_금액에_대한_입력값_검증() {
        return Stream.of(
                Arguments.of("  ", ValidationFailMessage.EMPTY_INPUT.getMessage()),
                Arguments.of("만원", ValidationFailMessage.NON_NUMERIC_INPUT.getMessage()),
                Arguments.of("99999999999999", ValidationFailMessage.OUT_OF_PARSE_RANGE.getMessage()),
                Arguments.of("-99999999999999", ValidationFailMessage.OUT_OF_PARSE_RANGE.getMessage())
        );
    }

    @DisplayName("올바른 당첨 번호의 입력을 검증")
    @Test
    void 올바른_당첨_번호의_입력을_검증() {
        List<Integer> givenNumbers = List.of(1, 2, 3, 4, 5, 6);
        String rawWinningNumbers = RawInputGenerator.makeRawWinningNumbers(givenNumbers);
        assertThatCode(() -> inputValidationService.validateWinningNumber(rawWinningNumbers))
                .doesNotThrowAnyException();
    }

    @DisplayName("잘못된 당첨 번호의 입력을 검증")
    @ParameterizedTest(name = "\"{0}\"가 입력된 경우 : {1}")
    @MethodSource
    void 잘못된_당첨_번호의_입력을_검증(String inputPurchasePrice, String expectedExceptionMessage) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> inputValidationService.validateWinningNumber(inputPurchasePrice))
                .withMessage(expectedExceptionMessage);
    }

    static Stream<Arguments> 잘못된_당첨_번호의_입력을_검증() {
        return Stream.of(
                Arguments.of(" ", ValidationFailMessage.EMPTY_INPUT.getMessage()),
                Arguments.of(",1,2,3,4,5", ValidationFailMessage.EMPTY_INPUT.getMessage()),
                Arguments.of("1,2,3,4,5,", ValidationFailMessage.EMPTY_INPUT.getMessage()),
                Arguments.of("일,2,3,4,5,6", ValidationFailMessage.NON_NUMERIC_INPUT.getMessage()),
                Arguments.of("99999999999999,2,3,4,5,6", ValidationFailMessage.OUT_OF_PARSE_RANGE.getMessage()),
                Arguments.of("-99999999999999,2,3,4,5,6", ValidationFailMessage.OUT_OF_PARSE_RANGE.getMessage())
        );
    }

}