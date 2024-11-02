package lotto.validator;

public class WinningNumberInputValidator {

    public static final String POSITIVE_NUMBER_REGEX = "\\d+";
    public static final String COMMA = ",";

    public static void validateWinningNumberInput(String input) {
        CommonInputValidator.validateCommonInput(input);
        validateIsPositiveNumberList(input);
    }

    private static void validateIsPositiveNumberList(String input) {
        String[] splitInput = input.split(COMMA);
        for (String s : splitInput) {
            if (isNotPositiveNumber(s)) {
                throw new IllegalArgumentException("[ERROR] 로또 당첨 번호는 양의 숫자로만 입력해야 합니다.");
            }
        }
    }

    private static boolean isNotPositiveNumber(String s) {
        return !s.matches(POSITIVE_NUMBER_REGEX);
    }
}
