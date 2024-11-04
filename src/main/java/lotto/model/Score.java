package lotto.model;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public enum Score {

    ZERO(0, false, 0),
    THREE(3, false, 5_000),
    FOURTH(4, false, 50_000),
    FIFTH(5, false, 1_500_000),
    FIFTH_WITH_BONUS(5, true, 30_000_000),
    SIX(6, false, 2_000_000_000);

    private final int matchCount;
    private final boolean containsBonus;
    private final int prize;

    Score(int matchCount, boolean containsBonus, int prize) {
        this.matchCount = matchCount;
        this.containsBonus = containsBonus;
        this.prize = prize;
    }

    public static Score calculateScore(Lotto lotto, WinningLotto winningLotto) {
        int matchCount = winningLotto.getMatchCount(lotto);
        boolean isBonusNumberMatches = winningLotto.isBonusNumberMatches(lotto);

        return Arrays.stream(values())
                .filter(score -> score.matchCount == matchCount)
                .filter(score -> !isBonusNumberMatches || score != FIFTH)
                .findFirst()
                .orElse(ZERO);
    }

    public static Map<Score, Integer> aggregate(List<Score> scores) {
        Map<Score, Integer> scoreCounts = new LinkedHashMap<>();

        Arrays.stream(values())
                .forEach(score -> scoreCounts.put(score, countScores(scores, score)));

        return scoreCounts;
    }

    private static int countScores(List<Score> scores, Score score) {
        return (int) scores.stream()
                .filter(score::equals)
                .count();
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean containsBonus() {
        return containsBonus;
    }

    public int getPrize() {
        return prize;
    }
}
