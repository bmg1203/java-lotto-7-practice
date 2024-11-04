package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.utils.ValidatorFactory;
import lotto.validation.Validator;

public class WinningNumbers {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int NUMBER_COUNT = 6;

    private final List<Integer> numbers;

    public WinningNumbers(String input) {
        List<Integer> parsedNumbers = parseAndValidateInput(input);
        this.numbers = List.copyOf(parsedNumbers);
    }

    private List<Integer> parseAndValidateInput(String input) {
        Validator<String> stringValidator = ValidatorFactory.createStringValidator();
        stringValidator.validate(input);

        List<Integer> parsedNumbers = parseNumbers(input);
        performDetailedValidation(parsedNumbers);
        return parsedNumbers;
    }

    private List<Integer> parseNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void performDetailedValidation(List<Integer> numbers) {
        validateUniqueNumbers(numbers);
        validateNumberCount(numbers);
        validateRange(numbers);
    }

    private void validateUniqueNumbers(List<Integer> numbers) {
        Validator<List<Integer>> uniqueNumberValidator = ValidatorFactory.createUniqueNumberValidator();
        uniqueNumberValidator.validate(numbers);
    }

    private void validateNumberCount(List<Integer> numbers) {
        Validator<List<Integer>> countValidator = ValidatorFactory.createNumberCountValidator(NUMBER_COUNT);
        countValidator.validate(numbers);
    }

    private void validateRange(List<Integer> numbers) {
        Validator<Integer> rangeValidator = ValidatorFactory.createNumberRangeValidator(MIN_NUMBER, MAX_NUMBER);
        numbers.forEach(rangeValidator::validate);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
