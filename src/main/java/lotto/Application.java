package lotto;

import lotto.controller.LottoMachineController;

public class Application {
    public static void main(String[] args) {
        LottoMachineController lottoMachineController = new LottoMachineController();
        lottoMachineController.start();
    }
}
