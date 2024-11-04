package lotto.validator;

import static lotto.Exception.ExceptionErrorMessage.INPUT_BLANK_MESSAGE;
import static lotto.Exception.ExceptionErrorMessage.INPUT_MINUS_NUMBER_MESSAGE;
import static lotto.Exception.ExceptionErrorMessage.INPUT_NOT_DIGIT_MESSAGE;
import static lotto.Exception.ExceptionErrorMessage.INPUT_ZERO_NUMBER_MESSAGE;
import static lotto.constant.ValidationFormat.DIGIT_NUMBER_REGEX;
import static lotto.constant.ValidationFormat.MINUS_NUMBER_REGEX;
import static lotto.constant.ValidationFormat.ZERO;

import java.util.regex.Pattern;

public class InputPurchaseAmountValidator implements InputValidator {
    public void validate(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException(INPUT_BLANK_MESSAGE.toString());
        }
        if (!isPlusNumber(input)) {
            throw new IllegalArgumentException(INPUT_MINUS_NUMBER_MESSAGE.toString());
        }
        if (!isDigit(input)) {
            throw new IllegalArgumentException(INPUT_NOT_DIGIT_MESSAGE.toString());
        }
        if (isZero(input)) {
            throw new IllegalArgumentException(INPUT_ZERO_NUMBER_MESSAGE.toString());
        }
    }

    @Override
    public boolean isBlank(String input) {
        if (input == null || input.trim().isEmpty()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isPlusNumber(String input) {
        if (Pattern.matches(MINUS_NUMBER_REGEX.toString(), input)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isDigit(String input) {
        if (!Pattern.matches(DIGIT_NUMBER_REGEX.toString(), input)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isZero(String input) {
        if (input.equals(ZERO.toString())) {
            return true;
        }
        return false;
    }
}
