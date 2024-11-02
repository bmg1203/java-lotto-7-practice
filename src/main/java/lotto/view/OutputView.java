package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
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

    public void printLottoNumbers(List<Lotto> lottoNumbers) {
        for (Lotto lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber.getNumbers());
        }
    }

}
