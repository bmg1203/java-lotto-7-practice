package lotto.global;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static lotto.exception.ErrorCode.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

    private String validWinningNumbers;
    private String validBonusNumber;
    private String invalidPurchaseAmount;
    private List<String> invalidInputs;
    private List<Consumer<String>> validators;
    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = Validator.getInstance();

        validWinningNumbers = "1,2,3,4,5,6";
        validBonusNumber = "7";
        invalidPurchaseAmount = "1200";

        validators = Arrays.asList(
                validator::validatePurchaseAmount
        );

        invalidInputs = Arrays.asList("", null);
    }

    @Nested
    @DisplayName("구입 금액 테스트")
    class ValidatePurchaseAmountTests {

        @Test
        @DisplayName("1,000원 단위가 아닌 경우 예외 발생")
        void 구입_금액_1000원_단위가_아니면_예외가_발생한다() {
            // when & then
            assertThatThrownBy(() -> validator.validatePurchaseAmount(invalidPurchaseAmount))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(INVALID_PURCHASE_AMOUNT.getMessage());
        }

        @Test
        @DisplayName("공백 또는 null인 경우 예외 발생")
        void 구입_금액_미입력_되면_예외가_발생한다() {
            // when & then
            invalidInputs.forEach(input ->
                    assertThatThrownBy(() -> validator.validatePurchaseAmount(input))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(EMPTY_INPUT.getMessage())
            );
        }

        @Test
        @DisplayName("정상적인 금액 입력 시 예외 발생하지 않음")
        void 구입_금액_정상_입력_테스트() {
            // given
            String validPurchaseAmount = "8000"; // 예를 들어, 8000원이 정상 입력

            // when & then
            assertThatCode(() -> validator.validatePurchaseAmount(validPurchaseAmount))
                    .doesNotThrowAnyException(); // 예외가 발생하지 않음을 확인
        }

        @Test
        @DisplayName("0원 입력 시 예외 발생")
        void 구입_금액_0원_입력_테스트() {
            // when & then
            assertThatThrownBy(() -> validator.validatePurchaseAmount("0"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(NOT_POSITIVE_INPUT.getMessage());
        }
    }

    @Nested
    @DisplayName("당첨 번호 테스트")
    class ValidateWinningNumbersTests {

        @Test
        @DisplayName("1-45 사이의 숫자가 아닌 경우 예외 발생")
        void 당첨_번호_범위가_아니면_예외가_발생한다() {
            // given
            String invalidWinningNumbers = "1,2,3,4,5,46";

            // when & then
            assertThatThrownBy(() -> validator.validateWinningNumbers(invalidWinningNumbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(INVALID_NUMBER_RANGE.getMessage());
        }

        @Test
        @DisplayName("6개가 아닌 경우 예외 발생")
        void 당첨_번호_6개가_아니면_예외가_발생한다() {
            // given
            String invalidWinningNumbers = "1,2,3,4,5";

            // when & then
            assertThatThrownBy(() -> validator.validateWinningNumbers(invalidWinningNumbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(INVALID_WINNING_NUMBERS_INPUT.getMessage());
        }

        @Test
        @DisplayName("빈입력인 경우 예외 발생")
        void 당첨_번호_빈입력이면_예외가_발생한다() {
            // when & then
            invalidInputs.forEach(input ->
                    assertThatThrownBy(() -> validator.validateWinningNumbers(input))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(EMPTY_INPUT.getMessage())
            );
        }

        @Test
        @DisplayName("정상적인 당첨 번호 입력 시 예외 발생하지 않음")
        void 당첨_번호_정상_입력_테스트() {
            // given
            String validWinningNumbers = "1,2,3,4,5,6"; // 예를 들어, 1~6의 정상 입력

            // when & then
            assertThatCode(() -> validator.validateWinningNumbers(validWinningNumbers))
                    .doesNotThrowAnyException(); // 예외가 발생하지 않음을 확인
        }
    }

    @Nested
    @DisplayName("보너스 번호 테스트")
    class ValidateBonusNumberTests {

        @Test
        @DisplayName("1-45 사이의 숫자가 아닌 경우 예외 발생")
        void 보너스_번호_범위가_아니면_예외가_발생한다() {
            // given
            String invalidBonusNumber = "46";

            // when & then
            assertThatThrownBy(() -> validator.validateBonusNumber(validWinningNumbers, invalidBonusNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(INVALID_NUMBER_RANGE.getMessage());
        }

        @Test
        @DisplayName("당첨 번호와 보너스 번호가 중복된 경우 예외 발생")
        void 보너스_번호_중복되면_예외가_발생한다() {
            // given
            String duplicateBonusNumber = "1";

            // when & then
            assertThatThrownBy(() -> validator.validateBonusNumber(validWinningNumbers, duplicateBonusNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(DUPLICATE_BONUS_NUMBER.getMessage());
        }

        @Test
        @DisplayName("빈 입력인 경우 예외 발생")
        void 보너스_번호_빈입력이면_예외가_발생한다() {
            // when & then
            invalidInputs.forEach(input ->
                    assertThatThrownBy(() -> validator.validateBonusNumber(validWinningNumbers, input))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(EMPTY_INPUT.getMessage())
            );
        }

        @Test
        @DisplayName("정상적인 보너스 번호 입력 시 예외 발생하지 않음")
        void 보너스_번호_정상_입력_테스트() {
            // given
            String validBonusNumber = "7"; // 예를 들어, 유효한 보너스 번호

            // when & then
            assertThatCode(() -> validator.validateBonusNumber(validWinningNumbers, validBonusNumber))
                    .doesNotThrowAnyException(); // 예외가 발생하지 않음을 확인
        }
    }

}
