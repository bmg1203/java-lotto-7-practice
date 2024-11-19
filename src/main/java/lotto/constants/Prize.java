package lotto.constants;

public enum Prize {

    FIRST(1, 6, 2000000000),
    SECOND(2, 5, 30000000),
    THIRD(3, 5, 500000),
    FOURTH(4,4,  50000),
    FIFTH(5, 3, 5000);

    private final int place;
    private final int matchCount;
    private final int reward;

    Prize(int place, int matchCount, int reward) {
        this.place = place;
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public int getPlace() {
        return place;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }
}
