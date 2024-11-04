package lotto.domain;

public enum Prize {

    FAIL(-1, false, 0),
    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000);

    private int matchCount;
    private boolean isBonus;
    private int money;

    Prize(int matchCount, boolean isBonus, int money) {
        this.matchCount = matchCount;
        this.isBonus = isBonus;
        this.money = money;
    }

    public static Prize getMatchPrize(int matchCount, boolean bonusFlag) {
        if (matchCount == Prize.SECOND.getMatchCount() && bonusFlag) {
            return Prize.SECOND;
        }

        for (Prize value : Prize.values()) {
            if (value.matchCount == matchCount) {
                return value;
            }
        }

        return Prize.FAIL;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusMatch() {
        return isBonus;
    }

    public int getMoney() {
        return money;
    }
}
