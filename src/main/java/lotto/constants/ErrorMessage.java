package lotto.constants;

public enum ErrorMessage {
    EMPTY_AMOUNT("로또 금액이 입력되지 않았습니다. 다시 입력해주세요."),
    NON_NUMERIC("숫자가 아닙니다. 다시 입력해주세요."),
    UNDER_MIN_AMOUNTS("로또는 1000원이상 구매가능합니다. 1000원 이상의 금액을 입력해주세요."),
    OVER_MAX_AMOUNTS("로또는 최대 10만원까지 구매가능합니다. 10만원 이하의 금액을 입력해주세요."),
    IS_NOT_DIVISIBLE_BY_THOUSAND_WON("1000원 단위로 구매가능합니다. 다시 입력해주세요."),

    EMPTY_LOTTO_WINNING_NUMBERS("당첨 로또가 입력되지 않았습니다. 다시 입력해주세요."),
    HAS_CONSECUTIVE_COMMA("숫자 + , 의 형태로 입력해 주세요."),
    ONLY_DIGITS_AND_COMMAS_ALLOWED("숫자 쉼표 이외의 값이 들어가 있습니다. 다시 입력해주세요."),
    WINNING_NUMBER_IS_ONLY_INTEGER_ALLOWED("당첨 로또 번호는 오직 정수 범위이내여야 합니다."),
    INVALID_LOTTO_NUMBER_COUNT("로또 번호는 6개여야 합니다."),
    INPUT_LOTTO_NUMBER_OUT_OF_RANGE("당첨번호는 1부터 45사이의 번호여야 합니다."),
    DUPLICATE_NUMBER_MESSAGE("중복된 숫자가 있습니다. 다시 입력해주세요."),

    EMPTY_LOTTO_BONUS_NUMBERS("보너스 숫자가 입력되지 않았습니다. 다시 입력해주세요."),
    ONLY_DIGITS_ALLOWED("보너스 숫자는 오직 숫자만 입력할 수 있습니다. 다시 입력해주세요."),
    ONLY_INTEGER_ALLOWED("보너스 번호는 정수값만 입력할 수 있습니다."),
    INPUT_BONUS_NUMBER_OUT_OF_RANGE("보너스 번호는 1부터 45까지의 숫자만 입력가능합니다."),
    CANT_DUPLICATED_BONUS_NUMBER_WITH_WINNING_NUMBER("당첨 번호와 보너스 번호는 중복될 수 없습니다."),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return "[ERROR]" + message;
    }
}
