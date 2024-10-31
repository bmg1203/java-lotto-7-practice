package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

public class Lottos {
    private static final Long LOTTO_PRICE = 1_000L;
    private final List<Lotto> lottos;

    public static Lottos from(Long count) {
        ArrayList<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> distintNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(distintNumbers));
        }
        return new Lottos(lottos);
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Float calculateReturnRate(WinningBalls winningBalls, BonusBall bonusBall) {
        RankResult rankResult = calculateWinningResults(winningBalls, bonusBall);
        Long winningAmount = rankResult.calculateWinningAmount();
        long totalPrice = getSize() * LOTTO_PRICE;
        return (Float.valueOf(winningAmount) / totalPrice) * 100;
    }

    public RankResult calculateWinningResults(WinningBalls winningBalls, BonusBall bonusBall) {
        EnumMap<Rank, Integer> ranks = initializeRanks();

        for (Lotto lotto : lottos) {
            Rank rank = calculateRankForLotto(lotto, winningBalls, bonusBall);
            ranks.put(rank, ranks.getOrDefault(rank, 0) + 1);
        }
        return new RankResult(ranks);
    }

    private EnumMap<Rank, Integer> initializeRanks() {
        EnumMap<Rank, Integer> ranks = new EnumMap<>(Rank.class);
        Arrays.stream(Rank.values())
                .forEach(rank -> ranks.put(rank, 0));
        return ranks;
    }

    private Rank calculateRankForLotto(Lotto lotto, WinningBalls winningBalls, BonusBall bonusBall) {
        int sameWinningCount = winningBalls.getSameNumberCount(lotto);
        int sameBonusCount = bonusBall.getSameNumberCount(lotto);
        return Rank.valueOf(sameWinningCount, sameBonusCount);
    }

    public int getSize() {
        return this.lottos.size();
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb.append(lotto.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
