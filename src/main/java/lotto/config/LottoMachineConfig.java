package lotto.config;

import lotto.controller.LottoMachineController;
import lotto.model.LottoMachine;

public final class LottoMachineConfig {

    public static LottoMachine lottoMachine = getLottoMachine();
    public static LottoMachineController lottoMachineController = getLottoMachineController();

    private LottoMachineConfig() {
    }

    static LottoMachine getLottoMachine() {
        if (lottoMachine == null) {
            lottoMachine = new LottoMachine();
        }
        return lottoMachine;
    }

    static LottoMachineController getLottoMachineController() {
        if (lottoMachineController == null) {
            lottoMachineController = new LottoMachineController(getLottoMachine());
        }
        return lottoMachineController;
    }
}
