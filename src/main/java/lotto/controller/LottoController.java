package lotto.controller;

import java.util.List;
import lotto.service.LottoService;
import lotto.validation.NumberValidation;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void start() {
        List<List<Integer>> lottos = processTicketPurchase();
        generateWinningNumbersAndDisplayResult(lottos);
        calculateAndPrintProfit();
    }

    private void generateWinningNumbersAndDisplayResult(List<List<Integer>> lottos) {
        List<Integer> winningNumbers = inputWinningNumbers();
        int bonusNumber = inputBonusNumber(winningNumbers);

        lottoService.calculateWinningStatistics(winningNumbers, lottos, bonusNumber);
        OutputView.printResult(lottoService.getLottoResult());
    }

    private List<List<Integer>> processTicketPurchase() {
        int ticketQuantity = purchaseTicketQuantity();
        List<List<Integer>> lottos = lottoPurchaseResult(ticketQuantity);
        return lottos;
    }

    private void calculateAndPrintProfit() {
        String profit = lottoService.getProfit();
        OutputView.printProfit(profit);
    }

    private List<List<Integer>> lottoPurchaseResult(int ticketQuantity) {
        OutputView.printTicketQuantity(ticketQuantity);
        List<List<Integer>> lottos = lottoService.generateLottoNumber(ticketQuantity);
        OutputView.printLottos(lottos);
        return lottos;
    }

    private int purchaseTicketQuantity() {
        InputView.printPurchaseMessage();
        return promptForValidTicketQuantity();
    }

    private List<Integer> inputWinningNumbers() {
        InputView.printWinningNumberMessage();
        return promptForValidWinningNumbers();
    }

    private int inputBonusNumber(List<Integer> winningNumbers) {
        InputView.printBonusNumberMessage();
        return promptForValidBonusNumber(winningNumbers);
    }

    private int promptForValidBonusNumber(List<Integer> winningNumbers) {
        int bonusNumber;
        while (true) {
            try {
                bonusNumber = InputView.bonusNumberInput();
                NumberValidation.validateBonusNumber(winningNumbers, bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
        return bonusNumber;
    }

    private List<Integer> promptForValidWinningNumbers() {
        List<Integer> winningNumbers;
        while (true) {
            try {
                winningNumbers = InputView.winningNumberInput();
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
        return winningNumbers;
    }

    private int promptForValidTicketQuantity() {
        int ticketQuantity = 0;
        while (true) {
            try {
                int purchaseAmount = InputView.purchasePriceInput();
                ticketQuantity = lottoService.calculateTicketQuantity(purchaseAmount);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
        return ticketQuantity;
    }


}
