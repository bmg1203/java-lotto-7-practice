package lotto.domain;

import java.util.function.Function;
import lotto.constant.Constant;

public enum Prize {
    MATCHES_3(count -> count * Constant.THREE_MATCHES_PRIZE),
    MATCHES_4(count -> count * Constant.FOUR_MATCHES_PRIZE),
    MATCHES_5(count -> count * Constant.FIVE_MATCHES_PRIZE),
    MATCHES_5_BONUS_MATCH(count -> count * Constant.FIVE_MATCHES_BONUS_MATCH_PRIZE),
    MATCHES_6(count -> count * Constant.SIX_MATCHES_PRIZE);

    private Function<Integer, Integer> expression;

    Prize(Function<Integer, Integer> expression) {
        this.expression = expression;
    }

    public int calculate(int count) {
        return expression.apply(count);
    }
}
