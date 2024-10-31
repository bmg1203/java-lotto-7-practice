package lotto.controller;

import java.util.Arrays;
import java.util.List;
import lotto.LottoManager;
import lotto.domain.UserLotto;
import lotto.util.LottoValidator;
import lotto.util.MoneyValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoManager lottoManager = new LottoManager();

    public void run(){
        int purchaseAmount = Integer.parseInt(getPurchaseAmountAsString());

        UserLotto userLotto = new UserLotto(lottoManager.generateLotteries(purchaseAmount));

        outputView.printLottoList(userLotto.getLotteries());

        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = Integer.parseInt(getBonusNumberAsString(winningNumbers));

        lottoManager.executeWinningProcess(userLotto,winningNumbers,bonusNumber);
        float totalPrizeRate = lottoManager.calculateTotalPrizeRate(userLotto,purchaseAmount);

        outputView.printLottoWinningResult(userLotto, totalPrizeRate);
    }

    private List<Integer> getWinningNumbers() {
        return Arrays.stream(getWinningNumbersAsString().split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
    }

    private String getPurchaseAmountAsString(){
        try{
            String input = inputView.enterPurchaseAmount();
            MoneyValidator.validate(input);
            return input;
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return getPurchaseAmountAsString();
        }
    }

    private String getWinningNumbersAsString(){
        try{
            String input = inputView.enterWinningNumbers();
            LottoValidator.validateNumbers(input);
            return input;
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return getWinningNumbersAsString();
        }
    }

    private String getBonusNumberAsString(List<Integer> winningNumbers){
        try{
            String input = inputView.enterBonusNumber();
            LottoValidator.validateBonusNumber(input,winningNumbers);
            return input;
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return getBonusNumberAsString(winningNumbers);
        }
    }
}
