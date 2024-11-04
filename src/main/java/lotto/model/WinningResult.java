package lotto.model;

public enum WinningResult {
    NONE(0, 0),
    FIFTH_PLACE(3, 5000),
    FOURTH_PLACE(4, 50000),
    THIRD_PLACE(5, 1500000),
    SECOND_PLACE(5, 30000000),
    FIRST_PLACE(6, 2000000000);

    private final int matchedNumberCount;
    private final int prize;

    WinningResult(int matchedNumberCount, int prize) {
        this.matchedNumberCount = matchedNumberCount;
        this.prize = prize;
    }

    public static WinningResult fromMatchedNumberCount(int matchedNumberCount, boolean hasBonusNumber) {
        if (matchedNumberCount == FIRST_PLACE.matchedNumberCount) {
            return FIRST_PLACE;
        }
        if (matchedNumberCount == SECOND_PLACE.matchedNumberCount && hasBonusNumber) {
            return SECOND_PLACE;
        }
        if (matchedNumberCount == THIRD_PLACE.matchedNumberCount) {
            return THIRD_PLACE;
        }
        if (matchedNumberCount == FOURTH_PLACE.matchedNumberCount) {
            return FOURTH_PLACE;
        }
        if (matchedNumberCount == FIFTH_PLACE.matchedNumberCount) {
            return FIFTH_PLACE;
        }

        return NONE;
    }

    public String formatResult(int count, boolean hasBonus) {
        String bonusPart = "";

        if (hasBonus) {
            bonusPart = ", 보너스 볼 일치";
        }

        return String.format("%d개 일치%s (%,d원) - %d개", matchedNumberCount, bonusPart, prize, count);
    }

    public int getPrize() {
        return prize;
    }
}
