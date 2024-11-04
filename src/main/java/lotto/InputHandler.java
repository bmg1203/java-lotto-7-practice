package lotto;

import java.util.function.Supplier;

public class InputHandler {
    private final Input input;

    public InputHandler(Input input) {
        this.input = input;
    }

    public LottoPurchase handleLottoPurchase() {
        return handle(input::promptLottoPurchase);
    }

    public Lotto handleWinNumbers() {
        return handle(input::promptWinningNumbers);
    }

    public WinningNumbers handleBonusNumber(Lotto lotto) {
        return handle(() -> input.promptBonusNumber(lotto));
    }

    private <T> T handle(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
