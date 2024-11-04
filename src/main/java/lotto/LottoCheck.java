package lotto;

import java.util.List;

public class LottoCheck {   // 로또 당첨 및 등수확인
    public int lottoRankResult (int match, boolean bonus) {
        // 당첨 등수 반환 메서드
        if (match == 6) return 1;
        if (match == 5 && bonus) return 2;
        if (match == 5) return 3;
        if (match == 4) return 4;
        if (match == 3) return 5;
        return -1;
    }

    public int countMatches(List<Integer> userPurchasedLotto, List<Integer> winningNumber) {
        // 당첨 번호와 구매 번호의 일치 개수 확인
        int match = 0;
        for (int number : userPurchasedLotto) {
            if (winningNumber.contains(number)) {
                match++;
            }
        }

        return match;
    }

    public int checkRank(Lotto userPurchasedLotto, List<Integer> winningNumber, int bonus) {
        // 당첨 번호, 구매번호, 보너스 번호 비교해서 당첨 등수 확인
        int match = countMatches(userPurchasedLotto.getNumbers(), winningNumber);
        boolean bonusMatch = userPurchasedLotto.getNumbers().contains(bonus);

        return lottoRankResult(match, bonusMatch);
    }

    public int prizeInfo(int rank) {
        // 등수 상금 메서드
        if (rank == 1) return 2000000000;
        if (rank == 2) return 30000000;
        if (rank == 3) return 1500000;
        if (rank == 4) return 50000;
        if (rank == 5) return 5000;
        return 0;
    }
}
