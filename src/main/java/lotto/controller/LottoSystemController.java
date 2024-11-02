package lotto.controller;

import java.util.Arrays;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.User;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoSystemController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoSystemController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        User user = null;
        while (user == null) {
            try {
                user = new User(Integer.parseInt(inputView.inputAmount()));
                user.moneyToTicket(user.money);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        outputView.outputPurchaseLottoNumber(user.money / 1000, user.lotteryTickets);

        Lotto lotto = null;
        while (lotto == null) {
            try {
                String input = inputView.inputLottoWinningNumber();
                List<Integer> winningNumbers = Arrays.stream(input.split(","))
                        .map(String::trim)         // 앞뒤 공백 제거
                        .map(Integer::parseInt)    // Integer로 변환
                        .toList();
                lotto = new Lotto(winningNumbers);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        boolean isBonusNumberValid = false;
        while (!isBonusNumberValid) {
            try {
                user.specifyBonusNumber(Integer.parseInt(inputView.inputBonusNumber()));
                isBonusNumberValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        lotto.matcheNumber(user.lotteryTickets, user.bonusNumber);

        outputView.outputLottoWinningStatistics();
        outputView.outputLateOfReturn(user.lateOfReturn());
    }
}
