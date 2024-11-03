package lotto.model;

import static lotto.model.Lotto.getLottoPrice;

import java.util.List;

public class LottoBank {

    public LottoResult evaluate(WinningLotto winningLotto, List<Lotto> myLottos, BonusNumber bonusNumber) {
        List<Prize> prizes = myLottos.stream().map(mLotto -> Prize.getPrize(winningLotto, mLotto, bonusNumber))
                .toList();
        return new LottoResult(prizes);
    }

    public double calculateProfitRate(LottoResult lottoResult, int lottoCount) {
        long totalInvestment = (long) lottoCount * getLottoPrice();
        long totalProfit = lottoResult.getResult().stream().mapToLong(prize -> prize.getMoney()).sum();
        double profitRate = ((double) totalProfit / totalInvestment) * 100;
        return Math.round(profitRate * 100) / 100.0;
    }
}
