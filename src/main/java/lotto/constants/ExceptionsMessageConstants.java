package lotto.constants;

public final class ExceptionsMessageConstants {
    public static final String ERROR = "[ERROR] ";
    public static final String INPUT_MUST_BE_NUMERIC = "구입 금액은 Integer이거나 Integer 이내 값이어야 합니다.(2,147,483,647)";
    public static final String INPUT_NUMBER_MUST_BE_POSITIVE = "숫자는 0보다 커야 합니다.";
    public static final String MONEY_MUST_BE_A_MULTIPLE_OF_THOUSAND = "구입 금액은 1000의 배수여야 합니다.";
    public static final String INPUT_NUMBER_CANNOT_START_WITH_ZERO = "숫자의 맨 앞은 0으로 시작할 수 없습니다.";
    public static final String INPUT_CONTAINS_WHITE_SPACE = "입력값에 공백이 존재합니다.";
    public static final String INPUT_CANNOT_BE_EMPTY_OR_NULL = "빈 문자열이나 null값이면 안됩니다.";
    public static final String INPUT_CONTAINS_NUMBER_AND_COMMA_ONLY = "입력값은 숫자와 콤마(,)만 포함해야 합니다.";
    public static final String LOTTO_NUMBERS_COUNT_MUST_BE_SIX = "로또 번호는 6개여야 합니다.";
    public static final String INPUT_NUMBERS_MUST_BE_IN_ALLOWED_RANGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String NUMBERS_CANNOT_BE_DUPLICATED = "숫자는 중복될 수 없습니다.";
    public static final String INPUT_BONUS_NUMBER_MUST_BE_IN_ALLOWED_RANGE = "보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String INPUT_BONUS_NUMBER_DUPLICATED = "보너스 번호가 입력된 당첨 번호와 중복됩니다.";



    private ExceptionsMessageConstants() {}
}
