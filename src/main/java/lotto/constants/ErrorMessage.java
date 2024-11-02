package lotto.constants;

public enum ErrorMessage {
    INPUT_CAN_NOT_BE_BLANK("빈 값은 입력할 수 없습니다.");

    private static final String header = "[ERROR] ";
    private final String errorMessage;

    private ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String get() {
        return header + errorMessage;
    }
}
