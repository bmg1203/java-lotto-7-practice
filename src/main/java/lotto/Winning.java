package lotto;

import java.math.BigDecimal;
import java.util.Arrays;

public enum Winning {
    NONE(0, "불일치", 0),
    THREE(3, "3개 일치 (5,000원)", 5000),
    FOUR(4, "4개 일치 (50,000원)", 50000),
    FIVE(5, "5개 일치 (1,500,000원)", 1500000),
    FIVE_BONUS(5, "5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000),
    SIX(6, "6개 일치 (2,000,000,000원)", 2000000000);

    private final int value;
    private final String message;
    private final long price;
    private int count;

    Winning(int value, String message, long price) {
        this.value = value;
        this.message = message;
        this.price = price;
    }

    public int getValue() {
        return value;
    }

    public static Winning fromCount(int value) {
        return Arrays.stream(Winning.values())
                .filter(winning -> winning.getValue() == value)
                .findFirst()
                .orElse(NONE);
    }

    public int increaseCount() {
        return ++count;
    }

    public String toStringMessageAndCount() {
        StringBuilder sb = new StringBuilder();
        sb.append(message)
                .append(" - ")
                .append(count)
                .append("개");
        return sb.toString();
    }

    public BigDecimal multiplyCount() {
        return new BigDecimal(count * price);
    }
}
