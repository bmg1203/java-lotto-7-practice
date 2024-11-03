package lotto.Service;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.UserLotto;
import lotto.model.UserLottos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoService {
    private final static int THREE_MATCHING_INDEX = 0;
    private final static int FOUR_MATCHING_INDEX = 1;
    private final static int FIVE_MATCHING_INDEX = 2;
    private final static int BONUS_MATCHING_INDEX = 3;
    private final static int SIX_MATCHING_INDEX = 4;

    private UserLottos userLottos;
    private Lotto lotto;
    private BonusNumber bonusNumber;
    private List<Integer> results;


    public void generateUserNumbers(int purchaseAmount) {
        userLottos = new UserLottos(purchaseAmount);
    }

    public void generateLotto(Lotto lotto) {
        this.lotto = lotto;
    }

    public void generateBonusNumber(int number) {
        bonusNumber = new BonusNumber(number, lotto);
    }

    public List<Integer> calculateResult() {
        results = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));

        for (UserLotto userLotto : userLottos.getUserNumbers()) {
            long matchingCount = userLotto.getUserNumber().stream()
                    .filter(lotto.getNumbers()::contains)
                    .count();
            setResults(matchingCount, userLotto);
        }
        return results;
    }

    private void setResults(long matchingCount, UserLotto userLotto) {
        int bonus = this.bonusNumber.getNumber();
        if (matchingCount == 3) {
            results.set(THREE_MATCHING_INDEX, results.get(THREE_MATCHING_INDEX) + 1);
            return;
        }
        if (matchingCount == 4) {
            results.set(FOUR_MATCHING_INDEX, results.get(FOUR_MATCHING_INDEX) + 1);
            return;
        }
        if (matchingCount == 5) {
            if (userLotto.getUserNumber().contains(bonus)) {
                results.set(BONUS_MATCHING_INDEX, results.get(BONUS_MATCHING_INDEX) + 1);
                return;
            }
            results.set(FIVE_MATCHING_INDEX, results.get(FIVE_MATCHING_INDEX) + 1);
            return;
        }
        if (matchingCount == 6) {
            results.set(SIX_MATCHING_INDEX, results.get(SIX_MATCHING_INDEX) + 1);
        }
    }

    public double calculateRate() {
        return roundOff((getProfit() / (double) getInvestmentCost()) * 100);
    }

    private double roundOff(double number) {
        return Math.round(number * 10) / 10.0;
    }

    private long getInvestmentCost() {
        return userLottos.getPurchaseAmount();
    }

    private long getProfit() {
        return 5000L * results.get(THREE_MATCHING_INDEX) + 50000L * results.get(FOUR_MATCHING_INDEX) + 1500000L * results.get(FIVE_MATCHING_INDEX) + 30000000L * results.get(BONUS_MATCHING_INDEX) + 2000000000L * results.get(SIX_MATCHING_INDEX);
    }

    public UserLottos getUserNumbers() {
        return userLottos;
    }
}
