package lotto.entity;

import java.util.List;
import lotto.configuration.LottoConfiguration;

public class ProfitReport {
    private final List<Lotto> purchasedLottos;
    private final WinningNumbers winningNumbers;

    public ProfitReport(List<Lotto> purchasedLottos, WinningNumbers winningNumbers) {
        if (purchasedLottos == null || purchasedLottos.isEmpty()) {
            throw new IllegalArgumentException("구매한 로또는 null 또는 비어있을 수 없습니다.");
        }
        if (winningNumbers == null) {
            throw new IllegalArgumentException("당첨 번호는 null일 수 없습니다.");
        }

        this.purchasedLottos = purchasedLottos;
        this.winningNumbers = winningNumbers;
    }

    public int getPaymentAmount() {
        return purchasedLottos.size() * LottoConfiguration.LOTTO_PRICE.getValue();
    }

    public List<Lotto> getPurchasedLottos() {
        return purchasedLottos;
    }

    public WinningNumbers getWinningNumbers() {
        return winningNumbers;
    }
}
