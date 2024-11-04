package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.model.db.Lotto;

public class LottoRankCounter {

    private static final Map<Integer, Integer> MATCH_CNT_TO_RANK = new HashMap<>();
    private static final int NONE_RANK = -1;
    private static final int TOTAL_RANK_SIZE = 5;
    private static final int UNINITIALIZED_RANK_CNT = 0;
    public static final int FIRST_RANK = 1;

    private final Map<Integer, Integer> rankCnt;

    static {
        MATCH_CNT_TO_RANK.put(6, 1);
        MATCH_CNT_TO_RANK.put(5, 3);
        MATCH_CNT_TO_RANK.put(4, 4);
        MATCH_CNT_TO_RANK.put(3, 5);
    }

    public LottoRankCounter(List<Lotto> buyerLotties, Lotto winningLotto, int bonus) {
        this.rankCnt = new HashMap<>();
        buyerLotties.stream()
                .map(lotto -> parseRank(lotto, winningLotto, bonus))
                .filter(rank -> rank != NONE_RANK)
                .forEach(this::count);
    }

    private int parseRank(Lotto buyerLotto, Lotto winningLotto, int bonus) {
        int rank = parseMatchCntToRank(buyerLotto, winningLotto);
        if (isSecondLottoRank(buyerLotto, bonus, rank)) {
            return 2;
        }
        return rank;
    }

    private int parseMatchCntToRank(Lotto buyerLotto, Lotto winningLotto) {
        return MATCH_CNT_TO_RANK.getOrDefault(buyerLotto.getMatchCnt(winningLotto), NONE_RANK);
    }

    private void count(int rank) {
        rankCnt.put(rank, rankCnt.getOrDefault(rank, UNINITIALIZED_RANK_CNT) + 1);
    }

    private boolean isSecondLottoRank(Lotto lotto, int bonus, int rank) {
        return rank == 3 && lotto.contains(bonus);
    }

    public int getCnt(int rank) {
        return rankCnt.getOrDefault(rank, UNINITIALIZED_RANK_CNT);
    }

    public int getFirstRank() {
        return FIRST_RANK;
    }

    public int size() {
        return TOTAL_RANK_SIZE;
    }
}
