package lotto.model;

public class InputValidator {
    public void validateInputMoney(String input) {
        validateParseNumber(input);
        validatePositiveNumber(input);
        validateOverLottoPrice(input);
        validateDivideByUnit(input, 1000);
    }

    private void validateParseNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception exception) {
            throw new IllegalArgumentException("정수를 입력해주세요.");
        }
    }

    private void validatePositiveNumber(String input) {
        int parsedInput = Integer.parseInt(input);

        if (parsedInput < 0) {
            throw new IllegalArgumentException("양수 값을 입력해주세요.");
        }
    }

    private void validateOverLottoPrice(String input) {
        int parsedInput = Integer.parseInt(input);

        if (parsedInput < 1000) {
            throw new IllegalArgumentException(1000 + "원 이상의 값을 입력해주세요.");
        }
    }

    private void validateDivideByUnit(String input, int price) {
        int parsedInput = Integer.parseInt(input);

        if (parsedInput % price != 0) {
            throw new IllegalArgumentException(price + "원 단위의 값을 입력해주세요.");
        }
    }
}
