package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Result {

    public static int first = 0;
    public static int second = 0;
    public static int third = 0;
    public static int fourth = 0;
    public static int fifth = 0;
    public static int earnings = 0;
    public static double earningsRate = 0;

    public static int matchLotto(List<Integer> lotto, List<Integer> winningNumbers) {
        int matchCount = 0;
        for (int winningNumber : winningNumbers) {
            if (lotto.contains(winningNumber)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public static boolean matchBonus(List<Integer> lotto, int bonus) {
        if (lotto.contains(bonus)) {
            return true;
        }
        return false;
    }

    public static void addRankCount(Rank rank) {
        if (rank == Rank.FIRST) {
            first++;
            return;
        }
        if (rank == Rank.SECOND) {
            second++;
            return;
        }
        if (rank == Rank.THIRD) {
            third++;
            return;
        }
        if (rank == Rank.FOURTH) {
            fourth++;
            return;
        }
        if (rank == Rank.FIFTH) {
            fifth++;
        }
    }

    public static void addEarnings(int prize) {
        earnings += prize;
    }

    public static void calculateEarningsRate(int money) {
        earningsRate = (double) (earnings - money) / money * 100;
        earningsRate = Math.round(earningsRate * 100 / 100.0);
    }

    public static List<Integer> getRankCount() {
        List<Integer> rankCount = new ArrayList<>();
        rankCount.add(first);
        rankCount.add(second);
        rankCount.add(third);
        rankCount.add(fourth);
        rankCount.add(fifth);
        return rankCount;
    }

    public static double getEarningsRate() {
        return earningsRate;
    }
}