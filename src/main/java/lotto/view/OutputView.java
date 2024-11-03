package lotto.view;

import java.util.List;
import lotto.dto.LottoNumberDto;

public class OutputView {
    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_NUMBER_MESSAGE = "\n%d개를 구매했습니다.";
    private static final String WINNING_NUMBER_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";

    private OutputView() {
    }

    public static void printPurchaseAmountInputMessage() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
    }

    public static void printPurchaseLottoNumbers(List<LottoNumberDto> purchasedLottoNumbers) {
        System.out.printf(PURCHASE_NUMBER_MESSAGE + "%n", purchasedLottoNumbers.size());

        purchasedLottoNumbers.forEach(lottoNumberDto ->
                System.out.println(lottoNumberDto.numbers())
        );

    }

    public static void printWinningNumberInputMessage() {
        System.out.println(WINNING_NUMBER_MESSAGE);
    }

    public static void printBonusNumberInputMessage() {
        System.out.println(BONUS_NUMBER_MESSAGE);
    }
}
