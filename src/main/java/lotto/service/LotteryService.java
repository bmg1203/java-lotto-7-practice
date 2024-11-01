package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoBuyer;
import lotto.validation.LotteryValidator;
import lotto.view.OutputView;

public class LotteryService {
    private final OutputView outputView;
    private final LotteryValidator lotteryValidator;

    public LotteryService() {
        this.outputView = new OutputView();
        this.lotteryValidator = new LotteryValidator();
    }

    public void getPurchaseAmount() {
        outputView.printRequirePurchaseAmount();

        final String inputPurchaseAmount = Console.readLine();
        final int purchaseAmount = Integer.parseInt(inputPurchaseAmount);

        lotteryValidator.validatePurchaseAmount(purchaseAmount);

        int lottoPurchaseAmount = purchaseAmount / 1000;
        final LottoBuyer lottoBuyer = new LottoBuyer(lottoPurchaseAmount);
        outputView.printPurchaseAmount(lottoPurchaseAmount);

        issueLottoTickets(lottoPurchaseAmount);
    }

    public void getLottoWinningNumber() {
        String inputLottoWinningNumbers = Console.readLine();

        List<Integer> lottoWinningNumbers = null;

        for (final String winningNumber : inputLottoWinningNumbers.split(",")) {
            lottoWinningNumbers.add(Integer.parseInt(winningNumber));
        }

        Lotto lotto = new Lotto(lottoWinningNumbers);
    }

    public void getLottoBonusNumber() {
        int lottoBonusNumber = Integer.parseInt(Console.readLine());
    }

    public void getLottoWinningStatistics() {
        outputView.printWinningStatistics();
    }

    public void getLotteryYield() {
        System.out.println("총 수익률은 " + "%입니다.");
    }

    private void issueLottoTickets(final int lottoIssueNumber) {
        for (int i = 0; i < lottoIssueNumber; i++) {
            System.out.println(getTicketNumbers());
        }
    }

    private List<Integer> getTicketNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
