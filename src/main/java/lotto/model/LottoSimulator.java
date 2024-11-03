package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoSimulator {
    private final static int PRICE_OF_SINGLE_LOTTO = 1000;
    private final static int START_NUMBER = 1;
    private final static int END_NUMBER = 45;
    private final static int COUNT_OF_NUMBER = 6;
    private final static int DEFAULT = 0;
    private final int cost;
    private List<Lotto> purchasedLotto;
    private Map<Integer, Integer> prizeResult;

    public LottoSimulator(String cost) {
        this.cost = Integer.parseInt(cost);
        purchasedLotto = new ArrayList<>();
        prizeResult = new HashMap<>();
    }

    public void buyRandomLotto() {
        int count = cost / PRICE_OF_SINGLE_LOTTO;
        purchasedLotto.addAll(
                IntStream.range(0, count)
                        .mapToObj(i -> new Lotto(Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, COUNT_OF_NUMBER)))
                        .collect(Collectors.toList())
        );
    }

    public void countPrize(Draw draw) {
        for (int i = 0; i < purchasedLotto.size(); i++) {
            int count = purchasedLotto.get(i).checkLotto(draw.getWinningNumbers());
            boolean bonus = purchasedLotto.get(i).checkBonus(draw.getBonusNumber());
            Prize prize = findPrize(count, bonus);

            if (prize != null) {
                prizeResult.put(prize.rank, prizeResult.getOrDefault(prize.rank, DEFAULT) + 1);
            }
        }
    }

    private Prize findPrize(int count, boolean bonus) {
        if (count == 6) {
            return Prize.FIRST_PRIZE;
        } else if (count == 5 && bonus) {
            return Prize.SECOND_PRIZE;
        } else if (count == 5) {
            return Prize.THIRD_PRIZE;
        } else if (count == 4) {
            return Prize.FORTH_PRIZE;
        } else if (count == 3) {
            return Prize.FIFTH_PRIZE;
        }
        return null;
    }


    public List<Lotto> getPurchasedLotto() {
        return purchasedLotto;
    }

    public Map<Integer, Integer> getPrizeResult() {
        return prizeResult;
    }
}
