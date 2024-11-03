package lotto.view;

import static lotto.common.exception.ExceptionMessages.NONE_NUMERIC_INPUT;
import static lotto.common.exception.ExceptionMessages.NOT_MULTIPLE_OF_UNIT_PRICE;
import static lotto.view.InstructionMessages.INPUT_PURCHASE_AMOUNT;

import lotto.common.exception.EmptyInputException;
import lotto.common.exception.InvalidInputException;

public class PurchaseAmountInput implements Input {
    private InputValidator inputValidator = new InputValidator();

    @Override
    public Integer input() {
        Output.printMessage(INPUT_PURCHASE_AMOUNT.getMessage());
        while (true) {
            try {
                String purchaseAmount = readInput();
                validate(purchaseAmount);
                return Integer.parseInt(purchaseAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void validate(String input) {
        if (inputValidator.isEmptyInput(input)) {
            throw new EmptyInputException();
        }
        if (!inputValidator.isNumeric(input)) {
            throw new InvalidInputException(NONE_NUMERIC_INPUT.getMessages());
        }
        if (!inputValidator.isIntegerRange(input)) {
            throw new InvalidInputException(NONE_NUMERIC_INPUT.getMessages());
        }
        if (!inputValidator.isMultipleOfUnitPrice(input)) {
            throw new InvalidInputException(NOT_MULTIPLE_OF_UNIT_PRICE.getMessages());
        }
    }
}
