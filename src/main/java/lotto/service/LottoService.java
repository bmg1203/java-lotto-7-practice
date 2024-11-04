package lotto.service;

import lotto.domain.PurchaseAmount;
import lotto.dto.PrizeResponse;
import lotto.repository.LottoRepository;

import java.util.List;

public class LottoService {
    private final LottoRepository lottoRepository;

    public LottoService(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    public double calculateProfitRate(PurchaseAmount purchaseAmount, List<PrizeResponse> prizeResponses) {
        int totalProfit = 0;
        for (PrizeResponse prizeResponse : prizeResponses) {
            totalProfit += prizeResponse.prizeMoney() * prizeResponse.winningCount();
        }

        double profitRate = ((double) totalProfit / purchaseAmount.getAmount()) * 100;
        return Math.round(profitRate * 10.0) / 10.0;
    }
}
