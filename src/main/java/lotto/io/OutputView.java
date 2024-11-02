package lotto.io;

import static lotto.global.constant.Message.BONUS_NUMBER_INPUT_MESSAGE;
import static lotto.global.constant.Message.PURCHASE_INPUT_MESSAGE;
import static lotto.global.constant.Message.WINNING_NUMBER_INPUT_MESSAGE;

import java.util.List;
import java.util.stream.Collectors;
import lotto.Lotto;

public class OutputView {
    public void printLottos(List<Lotto> lottos) {
        String LottosToString = lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
        println(LottosToString);
    }

    public void printPurchaseInputMessage() {
        println(PURCHASE_INPUT_MESSAGE);
    }

    public void printLottoPurchase(String lottoSize) {
        println(lottoSize + "개를 구매했습니다.");
    }

    public void printWinningNumberInputMessage() {
        println(WINNING_NUMBER_INPUT_MESSAGE);
    }

    public void printBonusNumberInputMessage() {
        println(BONUS_NUMBER_INPUT_MESSAGE);
    }

    private void println(String string) {
        System.out.println(string);
    }
}
