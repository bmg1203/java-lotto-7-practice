package controller;


import lotto.Lotto;
import lottoManager.LottoWinningResult;

import service.LottoService;
import view.InputView;
import view.OutputView;
import winningLottoNumber.WinningLottoNumber;

public class Controller {


    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;


    public Controller(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }


    public void play() {
        long buyQuantity = getBuyQuantity();
        outputView.showQuantityView(buyQuantity);
        lottoService.buyLotto(buyQuantity);
        outputView.showMyPurchasedLotto(lottoService.getPurchasedLotto());

        Lotto createdLottoWithWinningNumber = getInputAndCreateLotto();
        createWinningLotto(createdLottoWithWinningNumber);


        LottoWinningResult result = lottoService.getLottoResult();
        outputView.displayFinalResult(result, buyQuantity);
    }


    private long getBuyQuantity() {
        long buyPrice;
        while (true) {
            try {
                buyPrice = inputView.startView();
                return lottoService.calculateBuyQuantity(buyPrice);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    private Lotto getInputAndCreateLotto() {
        String winningNumbersInput;
        while (true) {
            try {
                winningNumbersInput = inputView.inputWinningNumberView();
                return lottoService.createWinningLotto(winningNumbersInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    private WinningLottoNumber createWinningLotto(Lotto lottoWithWinningNumbers) {
        String bonusNumberInput;
        while (true) {
            try {
                bonusNumberInput = inputView.inputBonusNumberView();
                return lottoService.createWinningLottoWithBonus(lottoWithWinningNumbers, bonusNumberInput);  //2
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


}
