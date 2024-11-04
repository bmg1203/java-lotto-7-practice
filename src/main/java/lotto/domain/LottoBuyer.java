package lotto.domain;

import static lotto.constant.LotteryConstant.MATCH_FIVE_NUMBERS_AND_BONUS_WINNING_AMOUNT;
import static lotto.constant.LotteryConstant.MATCH_FIVE_NUMBERS_WINNING_AMOUNT;
import static lotto.constant.LotteryConstant.MATCH_FOUR_NUMBERS_WINNING_AMOUNT;
import static lotto.constant.LotteryConstant.MATCH_SIX_NUMBERS_WINNING_AMOUNT;
import static lotto.constant.LotteryConstant.MATCH_THREE_NUMBERS_WINNING_AMOUNT;

import java.util.ArrayList;
import java.util.List;

public class LottoBuyer {
    // 구매 개수
    private int lottoPurchaseAmount;
    // 구매자의 총 수익률
    private double lotteryYield;
    // 구매자가 구입한 로또
    private List<Lotto> lottos;
    // 구매자의 당첨 금액
    private int lottoWinningAmount;

    public LottoBuyer() {
        this.lottoPurchaseAmount = 0;
        this.lotteryYield = 0;
        this.lottos = new ArrayList<>();
        this.lottoWinningAmount = 0;
    }

    public void setLottoPurchaseAmount(final int lottoPurchaseAmount) {
        this.lottoPurchaseAmount = lottoPurchaseAmount;
    }

    public double calculateLotteryYield(final int purchaseAmount, final int totalWinningAmount) {
        this.lotteryYield = ((double) totalWinningAmount / purchaseAmount) * 100;
        return lotteryYield;
    }

    public void addLotto(final Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getLottoPurchaseAmount() {
        return lottoPurchaseAmount;
    }

    public int getLottoWinningAmount() {
        return lottoWinningAmount;
    }

    public void addMoney(final int matchingCount, final boolean isBonus) {
        if (matchingCount == 6) {
            addSixMatchPrize();
            return;
        }
        if (matchingCount == 5) {
            addFiveMatchPrize(isBonus);
            return;
        }
        if (matchingCount == 4) {
            addFourMatchPrize();
            return;
        }
        if (matchingCount == 3) {
            addThreeMatchPrize();
        }
    }

    private void addSixMatchPrize() {
        lottoWinningAmount += MATCH_SIX_NUMBERS_WINNING_AMOUNT;
    }

    private void addFiveMatchPrize(final boolean isBonus) {
        if (isBonus) {
            lottoWinningAmount += MATCH_FIVE_NUMBERS_AND_BONUS_WINNING_AMOUNT;
            return;
        }
        lottoWinningAmount += MATCH_FIVE_NUMBERS_WINNING_AMOUNT;
    }

    private void addFourMatchPrize() {
        lottoWinningAmount += MATCH_FOUR_NUMBERS_WINNING_AMOUNT;
    }

    private void addThreeMatchPrize() {
        lottoWinningAmount += MATCH_THREE_NUMBERS_WINNING_AMOUNT;
    }
}
