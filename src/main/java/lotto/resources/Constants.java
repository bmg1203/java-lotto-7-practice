package lotto.resources;

import java.util.regex.Pattern;

public class Constants {
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    public static final int LOTTO_TOTAL_NUMBERS = 6;
    public static final int THOUSAND_UNIT = 1000;
    public static final int ZERO = 0;
    public static final int MATCH_THREE = 3;
    public static final int MATCH_FOUR = 4;
    public static final int MATCH_FIVE = 5;
    public static final int MATCH_SIX = 6;
    public static final boolean MATCH_BONUS = true;
    public static final boolean FAIL_MATCH_BONUS = false;
    public static final String COMMA = ",";
    public static final Pattern NUMBER_AND_COMMA_REGEX = Pattern.compile("[0-9,]+");
    public static final Pattern CONTINUOUS_COMMA_REGEX = Pattern.compile(",{2,}");
    public static final Pattern ONLY_NUMBER_REGEX = Pattern.compile("[0-9]+");
}
