package lotto.enums;

public enum ErrorCode {
    INVALID_PURCHASE_AMOUNT("구입 금액은 1,000원 단위로 입력해야 합니다."),
    INVALID_LOTTO_NUMBER_COUNT("로또 번호는 6개여야 합니다."),
    INVALID_NUMBER_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_NUMBER("로또 번호에 중복된 숫자가 있습니다."),
    DUPLICATE_BONUS_NUMBER("보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    PARSING_INTEGER_ERROR("입력한 값이 올바른 숫자가 아닙니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
