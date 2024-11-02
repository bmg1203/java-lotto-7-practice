package lotto.model;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class CountByPrizeGrade {

    private final LinkedHashMap<PrizeGrade, Integer> countByPrizeGrade;

    private CountByPrizeGrade(LinkedHashMap<PrizeGrade, Integer> countByPrizeGrade) {
        this.countByPrizeGrade = countByPrizeGrade;
    }

    public static CountByPrizeGrade getOfBoughtAndWinLotto(BoughtLottos lottos, WinLotto winLotto) {
        LinkedHashMap<PrizeGrade, Integer> countByPrizeGrades = new LinkedHashMap<>();
        for (PrizeGrade grade : PrizeGrade.values()) {
            countByPrizeGrades.put(grade, 0);
        }

        for (Lotto lotto : lottos) {
            int matchCount = winLotto.getMatchCount(lotto);
            boolean isBonusMatch = winLotto.getBonusMatch(lotto);
            PrizeGrade grade = PrizeGrade.get(matchCount, isBonusMatch);
            if (grade != null) {
                countByPrizeGrades.put(grade, countByPrizeGrades.getOrDefault(grade, 0) + 1);
            }
        }

        return new CountByPrizeGrade(countByPrizeGrades);
    }

    public Iterable<? extends Map.Entry<PrizeGrade, Integer>> getEntrySet() {
        return Collections.unmodifiableMap(countByPrizeGrade).entrySet();
    }

}
