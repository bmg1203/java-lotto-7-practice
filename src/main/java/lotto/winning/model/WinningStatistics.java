package lotto.winning.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.common.constant.RankConstant;
import lotto.dto.NumberOfMatchingDto;
import lotto.dto.NumberOfTicketsDto;

public class WinningStatistics {
    private Map<RankConstant, Integer> ranks;
    private final List<Integer> numberOfMatching;
    private final int payment;
    private double rateOfWinning;

    public WinningStatistics() {
      numberOfMatching = NumberOfMatchingDto.getNumberOfMatching();
      payment = NumberOfTicketsDto.getPayment();
    }

    public Map<RankConstant, Integer> getRanksOfLottoTickets() {
        calculateRanks();
        return ranks;
    }

    public double getRateOfReturn() {
        calculateRateOfReturn();
        return rateOfWinning;
    }


    private void calculateRanks() {
        ranks = new HashMap<>(5);

        for (RankConstant rankConstant : RankConstant.values()) {
            int matching = rankConstant.getMatching();
            int totalMatching = Collections.frequency(numberOfMatching, matching);
            ranks.put(rankConstant, totalMatching);
        }
    }

    private void calculateRateOfReturn() {
        double sum = 0;
        for (RankConstant rankConstant : ranks.keySet()) {
            sum += rankConstant.getAmount() * ranks.get(rankConstant);
        }
        sum *= (100.0 / payment);
        rateOfWinning =  Math.round(sum * 100) / 100.0;
    }
}
