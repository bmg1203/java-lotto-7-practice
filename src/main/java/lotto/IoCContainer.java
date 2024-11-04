package lotto;

import lotto.business.LottoShop;
import lotto.business.Money;
import lotto.business.contract.ContractStrategy;
import lotto.business.contract.WoowaContractStrategy;
import lotto.business.draw.DrawStrategy;
import lotto.business.draw.ManualDrawStrategy;
import lotto.business.issue.IssueStrategy;
import lotto.business.issue.RandomIssueStrategy;
import lotto.io.ConsoleIOManager;
import lotto.io.IOManager;

public class IoCContainer {
    private static final Money lottoPrice = new Money(1_000);
    private static final IOManager ioManager = new ConsoleIOManager();
    private static final ContractStrategy contractStrategy = new WoowaContractStrategy(ioManager, lottoPrice);
    private static final IssueStrategy issueStrategy = new RandomIssueStrategy();
    private static final DrawStrategy drawStrategy = new ManualDrawStrategy(ioManager);
    private static final LottoShop lottoShop = new LottoShop(lottoPrice, contractStrategy, issueStrategy, drawStrategy);

    public static IOManager getIoManager() {
        return ioManager;
    }

    public static LottoShop getLottoShop() {
        return lottoShop;
    }
}
