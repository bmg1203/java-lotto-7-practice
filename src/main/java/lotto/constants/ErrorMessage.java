package lotto.constants;

public enum ErrorMessage {

    LOTTO_NUMBER_NOT_IN_RANGE_ERROR("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    PURCHASE_MONEY_ERROR("구입 금액은 1,000원 단위여야 합니다. "),
    PURCHASE_MIN_MONEY_ERROR("구입 금액은 1,000원 이상이여야 합니다. "),
    DUPLICATE_LOTTO_NUMBER_ERROR("로또 번호는 중복되지 않아야 합니다. "),
    LOTTO_COUNT_ERROR("로또 번호는 6개 여야합니다. "),
    WRONG_INPUT_ERROR("잘못된 입력입니다. ");

    private static final String logLevel = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return logLevel + message;
    }
}
