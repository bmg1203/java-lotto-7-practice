package lotto.domain;

public enum LottoPrize {
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    SECOND(5, 1500000),
    THIRD(5, 30000000),
    FIRST(6, 2000000000);

    private final int match;
    private final long prize;
    private int count;

    LottoPrize(int match, long prize) {
        this.match = match;
        this.prize = prize;
    }

    public long getPrizeByRank(int matchCount) {
        for (LottoPrize value : values()) {
            if (value.getMatch() == matchCount) {
                value.incrementCount();
                return value.prize;
            }
        }
        return 0;
    }

    public void getWinningStatistics(int match) {

    }

    public void incrementCount() {
        this.count++;
    }

    public int getMatch() {
        return match;
    }

    public long getPrize() {
        return prize;
    }

    public int getCount() {
        return count;
    }
}
    