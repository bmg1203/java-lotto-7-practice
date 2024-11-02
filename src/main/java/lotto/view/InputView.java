package lotto.view;

import static lotto.constants.InputMessage.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String receiveLottoAmounts() {
        printAmountsMessage();
        return Console.readLine();
    }

    public String receiveWinningNumbers() {
        printNextLine();
        printWinningMessage();
        return Console.readLine();
    }

    public String receiveBonusNumber() {
        printNextLine();
        printBonusNumberMessage();
        return Console.readLine();
    }


    private void printAmountsMessage() {
        System.out.println(GET_LOTTO_AMOUNTS_MESSAGE.getMessage());
    }

    private void printNextLine() {
        System.out.println();
    }

    private void printWinningMessage() {
        System.out.println(GET_WINNING_NUMBERS_MESSAGE.getMessage());
    }

    private void printBonusNumberMessage() {
        System.out.println(GET_BONUS_NUMBER_MESSAGE.getMessage());
    }
}
