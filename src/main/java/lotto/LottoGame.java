package lotto;

import java.util.List;
import java.util.Map;
import lotto.system.formater.PrintFormatter;
import lotto.system.formater.winning.LottoWinningAnalyzer;
import lotto.system.formater.winning.WinningStatisticsFormatter;
import lotto.system.lottoGetter.LottoTicketIssuer;
import lotto.system.unit.LottoTicket;
import lotto.system.utils.PrizeType;
import lotto.user.Bonus;
import lotto.user.Lotto;
import lotto.view.InputView;
import lotto.view.OutPutView;

public class LottoGame {

    public static void start() {
        PrintFormatter printFormatter = new PrintFormatter(OutPutView.INSTANCE, new InputView());
        LottoTicketIssuer ticketIssuer = printFormatter.formatPurchaseInfo();
        List<LottoTicket> issuedTickets = ticketIssuer.issueLottoTickets();
        printFormatter.formatLottoTickets(issuedTickets, ticketIssuer.getQuantity());
        Lotto lotto = printFormatter.formatWinningNumbers();
        Bonus bonus = printFormatter.formatBonusNumber();

        LottoWinningAnalyzer LottoWinningAnalyzer = new LottoWinningAnalyzer(lotto.getNumbers(), bonus.getNumber());
        Map<PrizeType, Integer> prizeTypeIntegerMap = LottoWinningAnalyzer.analyzeWinningStatistics(issuedTickets);
        printFormatter.formatResult(
                WinningStatisticsFormatter.formatStatistics(prizeTypeIntegerMap, ticketIssuer.getPurchaseAmount()));
    }
}
