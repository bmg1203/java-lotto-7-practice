package lotto.message;

public enum ExceptionMessage {
    INVALID_BLANK_INPUT("null 또는 빈 값은 입력할 수 없습니다."),
    INVALID_TYPE_INPUT("%s은(는) %s여야 합니다."),
    INVALID_RANGE_INPUT("%s은(는) %d부터 %d 사이의 숫자여야 합니다."),
    INVALID_NUMBER_INPUT("%s는 %d로 나누어 떨어져야 합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = "[ERROR] " + message;
    }

    public String getMessage() {
        return message;
    }
}
