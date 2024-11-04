package lotto.model.enums;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum Rank {
    FIFTH("3개 일치", 3, false),
    FOURTH("4개 일치", 4, false),
    THIRD("5개 일치", 5, false),
    SECOND("5개 일치, 보너스 볼 일치", 5, true),
    FIRST("6개 일치", 6, false),
    NONE("꽝", 0, false)
    ;

    private final String message;
    private final Integer match;
    private final boolean requiresBonus;

    Rank(String message, int match, boolean requiresBonus) {
        this.message = message;
        this.match = match;
        this.requiresBonus = requiresBonus;
    }

    public String getMessage() {
        return message;
    }

    public boolean isNotNone() {
        return this != NONE;
    }

    public static Map<Rank, Long> groupByRank(List<Rank> ranks) {
        return ranks.stream()
                .filter(Rank::isNotNone)
                .collect(Collectors.groupingBy(rank -> rank,
                        () -> new EnumMap<>(Rank.class),
                        Collectors.counting()));
    }

    public static Rank checkRank(long match, boolean bonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.isMatch((int) match, bonus))
                .findFirst()
                .orElse(NONE);
    }

    public boolean isMatch(int matchCount, boolean bonus) {
        return this.match == matchCount && (!requiresBonus || bonus == requiresBonus);
    }
}
