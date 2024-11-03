package lotto.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistics {
    public enum Rank {
        THREE(5000, "3개 일치"),
        FOUR(50000, "4개 일치"),
        FIVE(1500000, "5개 일치"),
        BONUS(30000000, "5개 일치, 보너스 볼 일치"),
        SIX(2000000000, "6개 일치");

        private final int WinningMoney;
        private final String Agreement;

        Rank(int PlayCount, String Agreement) {
            this.WinningMoney = PlayCount;
            this.Agreement = Agreement;
        }

        public int GetWinningMoney() {
            return WinningMoney;
        }

        public String GetAgreement() {
            return Agreement;
        }
    }

    public Map<Integer, Integer> CalculateRate(List<Lotto> Lottos, List<Integer> Numbers, int bonus) {
        Map<Integer, Integer> result = Result();

        for (Lotto lotto : Lottos) {
            UpdateResult(result, lotto, Numbers, bonus);
        }
        return result;
    }

    private Map<Integer, Integer> Result() {
        Map<Integer, Integer> result = new HashMap<>();
        for (Rank rank : Rank.values()) {
            result.put(rank.GetWinningMoney(), 0);
        }
        return result;
    }

    private void UpdateResult(Map<Integer, Integer> result, Lotto Lottos, List<Integer> Numbers, int bonus) {
        int PlayCounts = PlayCount(Lottos.getNumbers(), Numbers);
        boolean ContainBonus = Lottos.getNumbers().contains(bonus);
        int WinningMoney = GetWinningMoney(PlayCounts, ContainBonus);
        if(WinningMoney!=0) {
            result.put(WinningMoney, result.get(WinningMoney) + 1);
        }
    }

    private int PlayCount(List<Integer> numbers, List<Integer> Numbers) {
        int PlayCounts = 0;
        for (int number : numbers) {
            if (Numbers.contains(number)) {
                PlayCounts++;
            }
        }
        return PlayCounts;
    }

    private Integer GetWinningMoney(int PlayCounts, boolean ContainBonus) {
        if (PlayCounts == 6) {
            return Rank.SIX.GetWinningMoney();
        }
        if (PlayCounts == 5 && ContainBonus) {
            return Rank.BONUS.GetWinningMoney();
        }
        if (PlayCounts == 5) {
            return Rank.FIVE.GetWinningMoney();
        }
        if (PlayCounts == 4) {
            return Rank.FOUR.GetWinningMoney();
        }
        if (PlayCounts == 3) {
            return Rank.THREE.GetWinningMoney();
        }
        return 0;
    }
}
