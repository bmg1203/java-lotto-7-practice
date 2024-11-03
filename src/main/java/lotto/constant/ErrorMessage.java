package lotto.constant;

public enum ErrorMessage {
    DUPLICATE_WINNING_NUMBERS("로또 번호에 중복이 있습니다."),
    DUPLICATE_WINNING_AND_BONUS_NUMBER("당첨 번호와 보너스 번호는 중복될 수 없습니다."),
    NEGATIVE_OR_ZERO_PURCHASE_AMOUNT("구매 금액은 0보다 커야 합니다."),
    INVALID_PURCHASE_AMOUNT_FOR_PROFIT_CALCULATION("구매 금액이 0보다 커야 합니다."),
    INVALID_WINNING_NUMBER_COUNT("로또 번호는 6개여야 합니다."),
    INVALID_LOTTO_NUMBER_RANGE("로또 번호는 1부터 45 사이여야 합니다."),
    INVALID_PURCHASE_AMOUNT("구매 금액은 1,000원 단위여야 합니다."),
    INVALID_NUMERIC_INPUT("숫자만 입력해야 합니다."),
    INVALID_WINNING_NUMBER_FORMAT("당첨 번호는 쉼표로 구분된 6개의 숫자여야 합니다."),
    INVALID_PURCHASE_AMOUNT_FORMAT("구매 금액은 숫자 형식에 맞아야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
