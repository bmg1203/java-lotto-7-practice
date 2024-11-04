package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.purchase();
        lottoController.setWinningNumbers();
        lottoController.printStat();
        Console.close();
    }
}
