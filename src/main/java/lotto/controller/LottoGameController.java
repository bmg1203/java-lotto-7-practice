package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.LottoRank;
import lotto.Result;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;
import lotto.io.input.GameInput;
import lotto.io.output.GameOutput;

public class LottoGameController {
    private final GameInput gameInput;
    private final GameOutput gameOutput;

    public LottoGameController(GameInput gameInput, GameOutput gameOutput) {
        this.gameInput = gameInput;
        this.gameOutput = gameOutput;
    }

    public void start() {
        // 구입 금액 입력 및 객체 생성
        PurchaseAmount purchaseAmount = new PurchaseAmount(gameInput.getPurchaseAmountInput());
        LottoTicket lottoTicket = generateLottoTickets(purchaseAmount.getTicketCount());

        gameOutput.printPurchasedTickets(lottoTicket);

        // 당첨 번호 및 보너스 번호 입력 후 객체 생성
        WinningNumbers winningNumbers = new WinningNumbers(gameInput.getWinningNumbersInput());
        BonusNumber bonusNumber = new BonusNumber(gameInput.getBonusNumberInput(), winningNumbers.getWinningNumbers());

        Result result = calculateResults(lottoTicket, winningNumbers, bonusNumber);
        double yield = purchaseAmount.calculateYield(result.getTotalPrize());
        gameOutput.printResults(result, yield);
    }

    private LottoTicket generateLottoTickets(int ticketCount) {
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            tickets.add(new Lotto(lottoNumbers));
        }
        return new LottoTicket(tickets);
    }

    private Result calculateResults(LottoTicket lottoTicket, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        Result result = new Result();
        for (Lotto lotto : lottoTicket.getTickets()) {
            int matchCount = lotto.matchCount(winningNumbers.getWinningNumbers());
            boolean matchBonus = lotto.containsBonus(bonusNumber);
            LottoRank rank = LottoRank.findByMatchCountAndBonus(matchCount, matchBonus);
            result.addMatchResult(rank);
        }
        return result;
    }
}
