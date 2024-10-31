package lotto;

public enum ErrorMessage {

    INPUT_MUST_NUMERIC("숫자를 입력해야 합니다"),
    INSERT_MONEY_NOT_DIVIDED_1000("구입 금액은 1000원 단위로 떨어져야 합니다"),
    WIN_NUMBER_SIZE_MUST_6("당첨 번호는 6개를 입력하여야 합니다"),
    LOTTO_NUMBER_BETWEEN_1_AND_45("로또 번호는 1부터 45 사이의 숫자여야 합니다"),
    BONUS_NUMBER_DUPLICATE_WIN_NUMBERS("보너스 번호가 당첨 번호와 중복됩니다");

    private final String message;
    private static final String PREFIX = "[ERROR] ";

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
