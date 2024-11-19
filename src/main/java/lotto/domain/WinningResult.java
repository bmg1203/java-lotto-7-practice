package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.constants.Prize;

public class WinningResult {

    private final Map<Integer, Integer> winningCount;
    private final BigDecimal returnRate;

    public WinningResult(Lotto winningNumber, Bonus bonus, LottoGenerator lottoGenerator, Purchase purchase) {
        this.winningCount = getWinningCount(winningNumber, bonus, lottoGenerator);
        this.returnRate = calculateReturnRate(purchase);
    }

    public Map<Integer, Integer> getWinningCount() {
        return Collections.unmodifiableMap(winningCount);
    }

    public String getReturnRate() {
        return returnRate.toString();
    }

    //당첨 개수 관련 메소드
    private Map<Integer, Integer> getWinningCount(Lotto winningNumber, Bonus bonus, LottoGenerator lottoGenerator){
        Map<Integer, Integer> resultSave = new HashMap<>();

        for (Lotto lotto : lottoGenerator.getLottos()) {
            boolean correctBonus = isBonus(lotto, bonus);
            int correctCount = getCorrectCount(lotto, winningNumber);
            getResult(resultSave, correctCount, correctBonus);
        }

        return resultSave;
    }

    private boolean isBonus(Lotto lotto, Bonus bonus) {
        return lotto.getNumbers().contains(bonus.getBonus());
    }

    private int getCorrectCount(Lotto lotto, Lotto winningNumber) {
        List<Integer> current = new ArrayList<>(List.copyOf(lotto.getNumbers()));
        List<Integer> winning = List.copyOf(winningNumber.getNumbers());

        current.retainAll(winning);
        return current.size();
    }

    private void getResult(Map<Integer, Integer> resultSave, int correctCount, boolean correctBonus) {
        Prize prize = findPrize(correctCount, correctBonus);

        if (prize != null) {
            resultSave.put(prize.getPlace(), resultSave.getOrDefault(prize.getPlace(), 0) + 1);
        }
    }

    private Prize findPrize(int correctCount, boolean correctBonus) {
        if (correctCount == Prize.SECOND.getMatchCount() && !correctBonus) {
            return Prize.THIRD;
        }

        for (Prize prize : Prize.values()) {
            if (prize.getMatchCount() == correctCount) {
                return prize;
            }
        }
        return null;
    }

    //수익률 관련 메소드
    private BigDecimal calculateReturnRate(Purchase purchase) {
        BigDecimal totalWinnings = getWinnings().multiply(BigDecimal.valueOf(100));
        BigDecimal purchaseMoney = new BigDecimal(purchase.getMoney());

        return totalWinnings.divide(purchaseMoney, 1, RoundingMode.HALF_UP);
    }

    private BigDecimal getWinnings() {
        BigDecimal totalWinnings = BigDecimal.ZERO;

        for (int key : winningCount.keySet()) {
            Prize prize = getPrize(key);
            totalWinnings = totalWinnings.add(BigDecimal.valueOf(prize.getReward()));
        }

        return totalWinnings;
    }

    private Prize getPrize(int key) {
        for (Prize prize : Prize.values()) {
            if (prize.getPlace() == key) {
                return prize;
            }
        }
        return null;
    }
}
