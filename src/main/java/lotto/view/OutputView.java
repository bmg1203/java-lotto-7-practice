package lotto.view;

import lotto.enums.OutputMessage;

public class OutputView {
    public void printMessage(OutputMessage message) {
        System.out.println(OutputMessage.INPUT_PURCHASE_AMOUNT.getMessage());
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printLottoCountMessage(String lottoCountMessage) {
        System.out.println(lottoCountMessage);
    }

}
