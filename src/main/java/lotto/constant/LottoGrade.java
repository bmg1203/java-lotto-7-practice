package lotto.constant;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoGrade {
    NONE("0", 0),
    FIFTH("3", 5_000),
    FOURTH("4", 50_000),
    THIRD("5", 1_500_000),
    SECOND("5+", 30_000_000),
    FIRST("6", 2_000_000_000);

    private static final Map<String, String> GRADE = Collections.unmodifiableMap(
            Stream
                    .of(values())
                    .filter(grade -> grade != NONE)
                    .collect(Collectors.toMap(LottoGrade::getCorrect, LottoGrade::name)));

    private final String correct;
    private final int amount;

    LottoGrade(String correct, int amount) {
        this.correct = correct;
        this.amount = amount;
    }

    public static LottoGrade from(String correct) {
        return LottoGrade.valueOf(GRADE.get(correct));
    }

    public String getCorrect() {
        return correct;
    }

    public int getAmount() {
        return amount;
    }
}