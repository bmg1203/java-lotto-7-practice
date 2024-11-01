package lotto.model;

import static lotto.model.LottoStore.LOTTO_NUMBER_MAXIMUM;
import static lotto.model.LottoStore.LOTTO_NUMBER_MINIMUM;

import java.util.List;
import java.util.stream.Collectors;
import lotto.Lotto;
import lotto.util.Validator;

public class WinningLotto extends Lotto {
    private int bonusNum;

    private static final int WINNING_NUMBER_COUNT = 6;

    public WinningLotto(List<Integer> nums, int bonusNum) {
        super(nums);
        this.bonusNum = bonusNum;
        //validate();
    }

    private WinningLotto(List<Integer> nums) {
        super(nums);
    }

    public static WinningLotto create(String winningNumber) {
        basicValidateWinningNumber(winningNumber);
        List<String> parsedNumber = parseEachNumber(winningNumber);
        validateWinningNumber(parsedNumber);
        List<Integer> numbers = parsedNumber.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return new WinningLotto(numbers);
    }

    public void addBonusNumber(String bonusNum) {
        int bonusNumber = validateBonusNumber(bonusNum);
        this.bonusNum = bonusNumber;
    }


    private int validateBonusNumber(String bonusNumber) {
        Validator.isEmptyInput(bonusNumber);
        Validator.isDigitString(bonusNumber);
        Validator.isInteger(bonusNumber);

        int bonusNumberInt = Integer.parseInt(bonusNumber);
        Validator.isNumberWithinRange(bonusNumberInt, LOTTO_NUMBER_MINIMUM, LOTTO_NUMBER_MAXIMUM);
        Validator.isNotInList(super.getNumbers(), bonusNumberInt);
        return bonusNumberInt;
    }

    private static List<String> parseEachNumber(String winningNumber) {
        String[] numbers = winningNumber.split(",");
        return List.of(numbers);
    }

    private static void basicValidateWinningNumber(String winningNumber) {
        Validator.isEmptyInput(winningNumber);
    }

    private static void validateWinningNumber(List<String> parsedNumbers) {
        Validator.isEqualListSize(parsedNumbers, WINNING_NUMBER_COUNT);
        parsedNumbers.stream()
                .peek(Validator::isDigitString)
                .peek(Validator::isInteger)
                .forEach(parsedNumber -> {
                });
        Validator.isNotDuplicate(parsedNumbers);
    }
}
