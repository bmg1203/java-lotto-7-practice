package lotto.view;


import lotto.constants.message.InputMessage;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private static InputView inputView;

    private InputView() {
    }

    public static InputView getInstance() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    public String getInputPrice() {
        System.out.println(InputMessage.PRICE.getInstance());
        return readLine();
    }

    public String getWinningNumber() {
        System.out.println(InputMessage.WINNING_NUMBER.getInstance());
        return readLine();
    }


    public String getBonusNumber() {
        System.out.println(InputMessage.BONUS_NUMBER.getInstance());
        return readLine();
    }

}
