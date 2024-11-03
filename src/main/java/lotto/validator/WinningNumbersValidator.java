package lotto.validator;

import lotto.common.CommonValidator;
import lotto.common.ErrorMessage;
import lotto.common.RegexPattern;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbersValidator {
    private static final String INPUT_SEPERATOR=",";

    public static List<Integer> validateWinningNumbers(String input){
        CommonValidator.validateNullAndBlank(input);
        validateOnyIntegerAndComma(input);

        List<Integer> winningNumbers= Arrays.stream(input.split(INPUT_SEPERATOR))
                        .mapToInt(Integer::parseInt)
                        .boxed()
                        .collect(Collectors.toList());
        return winningNumbers;

    }

    private static void validateOnyIntegerAndComma(String input) {
        if (!RegexPattern.ONLY_INTEGER_AND_COMMA.matches(input)){
            throw new IllegalArgumentException(ErrorMessage.INVALID_CHARACTER);
        }
    }




}
