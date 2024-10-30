package controller;

import view.InputHandler;
import view.OutputHandler;

public class LottoController {
    private InputHandler inputHandler;
    private OutputHandler outputHandler;
    public LottoController() {
        this.inputHandler = new InputHandler();
        this.outputHandler = new OutputHandler();
    }

    public void run(){
        outputHandler.promptForAmountInput();
        System.out.println(inputHandler.getAmountInput());
        outputHandler.promptForLottoNumber();
        System.out.println(inputHandler.getLottoNumber().toString());
        outputHandler.promptForBonusNumber();
        System.out.println(inputHandler.getBonusNumber());
    }
}
