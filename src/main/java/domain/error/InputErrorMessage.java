package domain.error;

public enum InputErrorMessage {
    ONLY_NUMBERS_ALLOWED("입력값은 숫자만 허용됩니다."),
    PURCHASE_LOTTO_CONDITION("로또 구매 금액은 1000원 단위 입니다."),
    WINNING_NUMBER_VALIDATION("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    ;
    private final String inputErrorMessage;
    private final String PREFIX = "[ERROR] ";

    private InputErrorMessage(String inputErrorMessage) {
        this.inputErrorMessage = PREFIX + inputErrorMessage;
    }

    public String getErrorMessage() {
        return inputErrorMessage;
    }
}
