package global.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import global.exception.ErrorCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import store.repository.StoreRepositoryImpl;
import store.service.StoreService;

class ValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"1.123", "1.0", "1.000"})
    @DisplayName("구매 금액의 유효성 검사시, 소수를 입력하면 예외가 발생한다")
    void t001(String purchaseAmount) {
        assertThatThrownBy(() -> Validator.validatePurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INPUT_CANNOT_BE_DECIMAL.getMsg());
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-1000", "0"})
    @DisplayName("구매 금액의 유효성 검사시, 0 이하의 값을 입력하면 예외가 발생한다")
    void t002(String purchaseAmount) {
        assertThatThrownBy(() -> Validator.validatePurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INPUT_MUST_BE_POSITIVE.getMsg());
    }

    @ParameterizedTest
    @ValueSource(strings = {"\n", " ", ""})
    @DisplayName("구매 금액의 유효성 검사시, 공백을 입력하면 예외가 발생한다")
    void t003(String purchaseAmount) {
        assertThatThrownBy(() -> Validator.validatePurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INPUT_CANNOT_INCLUDE_BLANK.getMsg());
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "a", "zero"})
    @DisplayName("구매 금액의 유효성 검사시, 숫자가 아닌 값을 입력하면 예외가 발생한다")
    void t004(String purchaseAmount) {
        assertThatThrownBy(() -> Validator.validatePurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INPUT_SHOULD_BE_PARSING.getMsg());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1001", "1", "10001"})
    @DisplayName("구매 금액의 유효성 검사시, 1000원 단위가 아닌 값을 입력하면 예외가 발생한다")
    void t005(String purchaseAmount) {
        assertThatThrownBy(() -> Validator.validatePurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.PURCHASE_AMOUNT_UNIT_MISMATCH.getMsg());
    }

    @ParameterizedTest
    @ValueSource(strings = {"+1000", "+10000", "+200000"})
    @DisplayName("구매 금액의 유효성 검사시, '+'가 붙은 값을 입력하면 예외가 발생한다")
    void t006(String purchaseAmount) {
        assertThatThrownBy(() -> Validator.validatePurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INPUT_CANNOT_INCLUDE_PLUS_SIGN.getMsg());
    }

    @ParameterizedTest
    @ValueSource(strings = {" 1000 ", "10000 ", " 200000"})
    @DisplayName("구매 금액의 유효성 검사시, 앞 뒤로 공백이 포함된 숫자를 입력하면 예외가 발생한다")
    void t007(String purchaseAmount) {
        assertThatThrownBy(() -> Validator.validatePurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INPUT_CANNOT_INCLUDE_BLANK.getMsg());
    }

    @ParameterizedTest
    @ValueSource(strings = {"01000", "010000", "0500000"})
    @DisplayName("구매 금액의 유효성 검사시, 앞에 0이 붙은 값은 입력될 수 없다.")
    void t008(String purchaseAmount) {
        assertThatThrownBy(() -> Validator.validatePurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INPUT_CANNOT_START_WITH_ZERO.getMsg());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "1,2,3,4,5,6,7", "1,2,3,4,5"})
    @DisplayName("입력한 당첨 번호의 갯수가 6개여야 한다")
    void t009(String weeklyNumbers) {
        assertThatThrownBy(() -> Validator.validateWeeklyNumbers(weeklyNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.WEEKLY_NUMBERS_COUNT_MISMATCH.getMsg());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,", ",2,3,4,5,6", "1,2,3,4,5, 6"})
    @DisplayName("입력한 당첨 번호에 공백이나 무입력이 포함될 수 없다")
    void t010(String weeklyNumbers) {
        assertThatThrownBy(() -> Validator.validateWeeklyNumbers(weeklyNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INPUT_CANNOT_INCLUDE_BLANK.getMsg());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1.1,2,3,4,5,6", "1,2,3,4,5,6.0", "1,2,3,4.12,5,6"})
    @DisplayName("입력한 당첨 번호에 소수가 포함될 수 없다")
    void t011(String weeklyNumbers) {
        assertThatThrownBy(() -> Validator.validateWeeklyNumbers(weeklyNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INPUT_CANNOT_BE_DECIMAL.getMsg());
    }

    @ParameterizedTest
    @ValueSource(strings = {"0,1,2,3,4,5", "-1,2,3,4,5,6", "1,2,3,4,5,-60000"})
    @DisplayName("입력한 당첨 번호가 0보다 작거나 같을 수 없다")
    void t012(String weeklyNumbers) {
        assertThatThrownBy(() -> Validator.validateWeeklyNumbers(weeklyNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INPUT_MUST_BE_POSITIVE.getMsg());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,+6", "+1,2,3,4,5,+6"})
    @DisplayName("입력한 당첨 번호의 숫자에 '+' 기호가 있을 수 없다")
    void t013(String weeklyNumbers) {
        assertThatThrownBy(() -> Validator.validateWeeklyNumbers(weeklyNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INPUT_CANNOT_INCLUDE_PLUS_SIGN.getMsg());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,a", "one,2,3,4,5,6"})
    @DisplayName("입력한 당첨 번호에 숫자 이외의 것이 입력될 수 없다")
    void t014(String weeklyNumbers) {
        assertThatThrownBy(() -> Validator.validateWeeklyNumbers(weeklyNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INPUT_SHOULD_BE_PARSING.getMsg());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,5", "1,1,1,1,1,1"})
    @DisplayName("입력한 당첨 번호는 서로 중복되지 않아야 한다")
    void t015(String weeklyNumbers) {
        assertThatThrownBy(() -> Validator.validateWeeklyNumbers(weeklyNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.LOTTO_NUMBER_CANNOT_BE_DUPLICATE.getMsg());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,46", "1,2,3,400,500,600"})
    @DisplayName("입력한 당첨 번호는 1 이상 45 이하여야 한다.")
    void t016(String weeklyNumbers) {
        assertThatThrownBy(() -> Validator.validateWeeklyNumbers(weeklyNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.LOTTO_NUMBER_RANGE_MISMATCH.getMsg());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,06", "01,2,3,4,5,6"})
    @DisplayName("입력한 당첨 번호의 앞에 0이 붙을수 없다")
    void t017(String weeklyNumbers) {
        assertThatThrownBy(() -> Validator.validateWeeklyNumbers(weeklyNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INPUT_CANNOT_START_WITH_ZERO.getMsg());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("입력한 보너스 번호는 공백 혹은 무입력 상태를 허용하지 않는다")
    void t018(String bonusNumber) {
        List<Integer> weeklyNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> Validator.validateBonusNumber(bonusNumber, weeklyNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INPUT_CANNOT_INCLUDE_BLANK.getMsg());
    }

    @ParameterizedTest
    @ValueSource(strings = {"010", "045"})
    @DisplayName("입력한 보너스 번호는 0으로 시작할 수 없다")
    void t019(String bonusNumber) {
        List<Integer> weeklyNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> Validator.validateBonusNumber(bonusNumber, weeklyNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INPUT_CANNOT_START_WITH_ZERO.getMsg());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1.1", "1.0", "1.45"})
    @DisplayName("입력한 보너스 번호는 소수일 수 없다")
    void t020(String bonusNumber) {
        List<Integer> weeklyNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> Validator.validateBonusNumber(bonusNumber, weeklyNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INPUT_CANNOT_BE_DECIMAL.getMsg());
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-45", "0"})
    @DisplayName("입력한 보너스 번호는 0보다 작거나 같은 수가 될 수 없다")
    void t021(String bonusNumber) {
        List<Integer> weeklyNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> Validator.validateBonusNumber(bonusNumber, weeklyNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INPUT_MUST_BE_POSITIVE.getMsg());
    }

    @ParameterizedTest
    @ValueSource(strings = {"+1", "+45"})
    @DisplayName("입력한 보너스 번호에는 +기호가 포함될 수 없다")
    void t022(String bonusNumber) {
        List<Integer> weeklyNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> Validator.validateBonusNumber(bonusNumber, weeklyNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INPUT_CANNOT_INCLUDE_PLUS_SIGN.getMsg());
    }

    @ParameterizedTest
    @ValueSource(strings = {" 1", " 45", "1 ", "45 ", " 1 ", " 45 "})
    @DisplayName("입력한 보너스 번호에는 앞 뒤 공백을 허용하지 않는다.")
    void t023(String bonusNumber) {
        List<Integer> weeklyNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> Validator.validateBonusNumber(bonusNumber, weeklyNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INPUT_CANNOT_INCLUDE_BLANK.getMsg());
    }

    @ParameterizedTest
    @ValueSource(strings = {"100", "46"})
    @DisplayName("입력한 보너스 번호는 1과 45 사이의 숫자여야 한다")
    void t024(String bonusNumber) {
        List<Integer> weeklyNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> Validator.validateBonusNumber(bonusNumber, weeklyNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.LOTTO_NUMBER_RANGE_MISMATCH.getMsg());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6"})
    @DisplayName("입력한 보너스 번호는 사전에 설정된 당첨 번호와 중복될 수 없다")
    void t025(String bonusNumber) {
        String inputWeeklyNumbers = "1,2,3,4,5,6";
        StoreService storeService = new StoreService(new StoreRepositoryImpl());
        storeService.tryUpdateWeeklyNumbers(inputWeeklyNumbers);
        List<Integer> weeklyNumbers = storeService.getStoredWeeklyNumbers();

        assertThatThrownBy(() -> Validator.validateBonusNumber(bonusNumber, weeklyNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.BONUS_NUMBER_CANNOT_BE_DUPLICATE.getMsg());
    }
}