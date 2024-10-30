package lotto;

public enum ExceptionMessage {
    PURCHASE_AMOUNT_NOT_NUMERIC_EXCEPTION("구입금액은 숫자로만 이루어져야 합니다."),
    PURCHASE_AMOUNT_NOT_DIVISIBLE_BY_1000_EXCEPTION("구입금액은 1000원으로 나누어 떨어져야 합니다."),

    LOTTO_NUMBER_LENGTH_EXCEPTION("로또 번호는 6개여야 합니다.");

    private String exceptionMessagePrefix = "[ERROR] ";
    private String exceptionMessage;

    ExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessagePrefix + exceptionMessage;
    }

    public String message() {
        return exceptionMessage;
    }
}
