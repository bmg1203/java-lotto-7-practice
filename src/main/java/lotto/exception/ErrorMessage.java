package lotto.exception;

public enum ErrorMessage {
    LOTTO_NUMBER_OUT_OF_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다. "),
    LOTTO_SIZE_OUT_OF_RANGE("로또 번호는 6개여야 합니다. ");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
