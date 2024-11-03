package lotto.controller;

import lotto.io.Input;
import lotto.io.Output;
import lotto.util.Validator;

public class LottoController {
    private final Output output;
    private final Input input;
    private final Validator validator;

    public LottoController(Output output, Input input, Validator validator) {
        this.output = output;
        this.input = input;
        this.validator = validator;
    }

    public void playLotto() {
        int purchasePrise = handlePurchasePrice();
    }

    private int handlePurchasePrice() {
        output.printPurchasePriceInputPrompt();
        String purchasePrice = input.inputString();

        validatePurchasePriceInput(purchasePrice);

        return Integer.parseInt(purchasePrice);
    }

    private void validatePurchasePriceInput(String input) {
        try {
            validator.validateEmptyInput(input);
            validator.validateNonNumber(input);
            validator.validatePositiveNumber(input);
            validator.validateDivisibleByThousand(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            handlePurchasePrice();
        }
    }
}
