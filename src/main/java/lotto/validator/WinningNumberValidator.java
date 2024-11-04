package lotto.validator;

import lotto.constant.CompareInteger;
import lotto.constant.LottoGuide;
import lotto.constant.WinningNumberRule;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumberValidator {

    public static void validateInputComma(String input) throws IllegalArgumentException {
        validateDoubletComma(input);
        validateFirstComma(input);
        validateLastComma(input);
    }

    public static List<Integer> validateInputWinningNumber(List<String> input) throws IllegalArgumentException {
        validateCount(input);
        List<Integer> winningNumber = new ArrayList<>();
        for (String separatedInput : input) {
            Integer inputNumber = getValidatedNumber(separatedInput);
            winningNumber.add(inputNumber);
        }
        validateDuplication(winningNumber);
        return winningNumber;
    }

    public static Integer getValidatedNumber(String input) throws IllegalArgumentException {
        Integer inputNumber = NumberValidator.stringToInteger(input, LottoGuide.ERROR.getMessage() + WinningNumberRule.ONLY_COMMA_INTEGER.getMessage());
        validateNumberScope(inputNumber);
        return inputNumber;
    }

    public static void validateBonusDuplication(List<Integer> mainNumber, Integer bonusNumber) throws IllegalArgumentException {
        if (mainNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(LottoGuide.ERROR.getMessage() + WinningNumberRule.BONUS_DUPLICATION.getMessage());
        }
    }

    private static void validateDoubletComma(String input) throws IllegalArgumentException {
        if (input.contains(WinningNumberRule.SEPARATOR.getMessage() + WinningNumberRule.SEPARATOR.getMessage())) {
            throw new IllegalArgumentException(LottoGuide.ERROR.getMessage() + WinningNumberRule.DOUBLE_COMMA.getMessage());
        }
    }

    private static void validateFirstComma(String input) throws IllegalArgumentException {
        if (input.startsWith(WinningNumberRule.SEPARATOR.getMessage())) {
            throw new IllegalArgumentException(LottoGuide.ERROR.getMessage() + WinningNumberRule.COMMA_FIRST.getMessage());
        }
    }

    private static void validateLastComma(String input) throws IllegalArgumentException {
        if (input.endsWith(WinningNumberRule.SEPARATOR.getMessage())) {
            throw new IllegalArgumentException(LottoGuide.ERROR.getMessage() + WinningNumberRule.COMMA_LAST.getMessage());
        }
    }

    public static void validateDuplication(List<Integer> input) throws IllegalArgumentException {
        Set<Integer> deduplication = new HashSet<>(input);
        if (deduplication.size() != input.size()) {
            throw new IllegalArgumentException(LottoGuide.ERROR.getMessage() + WinningNumberRule.DUPLICATION.getMessage());
        }
    }

    private static void validateCount(List<String> input) throws IllegalArgumentException {
        if (input.size() != CompareInteger.LOTTO_NUMBER_COUNT.getNumber()) {
            throw new IllegalArgumentException(LottoGuide.ERROR.getMessage() + WinningNumberRule.COUNT.getMessage());
        }
    }

    private static void validateNumberScope(Integer number) throws IllegalArgumentException {
        NumberValidator.validateScope(CompareInteger.LOTTO_NUMBER_MINIMUM.getNumber(), CompareInteger.LOTTO_NUMBER_MAXIMUM.getNumber(), number, LottoGuide.ERROR.getMessage() + WinningNumberRule.SCOPE.getMessage());
    }
}
