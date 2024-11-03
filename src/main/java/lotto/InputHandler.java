package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public final class InputHandler {

    private InputHandler() {
    }

    public static int inputLottoPurchaseAmount() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            final int purchaseAmount = InputConverter.convertToPurchaseAmount(Console.readLine());
            InputValidator.validatePurchaseAmountIsZero(purchaseAmount);
            InputValidator.validatePurchaseAmountUnit(purchaseAmount);
            return purchaseAmount;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

        return 0;
    }

    public static WinningLotto inputWinningLottoNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                final List<Integer> winningLottoNumbers = InputConverter.convertToWinningLottoNumbers(Console.readLine());
                InputValidator.validateWinningLottoNumbersCount(winningLottoNumbers);
                return new WinningLotto(winningLottoNumbers);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
