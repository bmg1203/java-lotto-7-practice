package lotto.exception;

public enum ErrorMessage {

    ERROR_SIGNATURE("[ERROR] "),
    INVALID_INPUT("빈 값을 입력할 수 없습니다. 다시 입력해 주세요."),
    ONLY_NUMERIC("정수만 입력할 수 있습니다."),
    NOT_CONTAIN_BLANK("공백을 입력할 수 없습니다. 공백을 제외하고 다시 입력해 주세요."),
    NOT_DIVIDE_PURCHASE_AMOUNT("구입 금액은 1000원 단위로 입력해야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return ERROR_SIGNATURE.message + this.message;
    }
}
