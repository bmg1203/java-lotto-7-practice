package lotto.util;

public enum ErrorMessages {
    INVALID_AMOUNT_FORMAT("[ERROR] 구입 금액은 숫자여야 합니다."),
    INVALID_AMOUNT_UNIT("[ERROR] 구입 금액은 1,000원 단위여야 합니다."),
    EMPTY_LOTTO_TICKET_LIST ("리스트는 비어있을 수 없습니다.");
    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
