package lotto.Model;

import lotto.View.OutputView;

public enum Ranking {

    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - "), // 1등
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "), // 2등
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - "), // 3등
    FOURTH(4, 50_000, "4개 일치 (50,000원) - "), // 4등
    FIFTH(3, 5_000, "3개 일치 (5,000원) - "), // 5등
    MISS(0, 0, "");

    Ranking(int matchingCount, int winningPrize, String message) {
        this.matchingCount = matchingCount;
        this.winningPrize = winningPrize;
        this.message = message;
    }

    private static final int WINNING_MIN_COUNT = 3;
    private static final String ERROR_MESSAGE = "[ERROR]";


    private final int matchingCount;
    private final int winningPrize;
    private final String message;


    public static Ranking valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch < WINNING_MIN_COUNT) {
            return MISS;
        }

        if (SECOND.matchCount(countOfMatch) && matchBonus) {
            return SECOND;
        }

        for (Ranking rank : values()) {
            if (rank.matchCount(countOfMatch) && rank != SECOND) {
                return rank;
            }
        }
        throw new IllegalArgumentException(ERROR_MESSAGE);
    }



    public int getMatchingCount() {
        return matchingCount;
    }

    public int getWinningPrize() {
        return winningPrize;
    }

    private boolean matchCount(int countOfMatch) {
        return this.matchingCount == countOfMatch;
    }

}