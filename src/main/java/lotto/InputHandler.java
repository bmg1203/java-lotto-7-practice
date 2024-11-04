package lotto;

import java.util.function.Supplier;

public class InputHandler {

    private final InputView inputView = new InputView();

    public Cash inputCash() {
        return handleError(inputView::inputPurchasePrice);
    }

    public Lotto inputWinningNumbers() {
        return handleError(inputView::inputNumbers);
    }

    public BonusNumber inputBonusNumber(Lotto lotto) {
        return handleError(() -> inputView.inputNumber(lotto));
    }

    private <T> T handleError(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
