package lotto.enums;

public enum ErrorMessage {
    BLANK_INPUT_NOT_ALLOWED("[ERROR] 사용자 입력은 null, 빈문자열, 공백으로만 이루어진 문자열일 수 없습니다."),
    INVALID_INTEGER_INPUT("[ERROR] 숫자는 정수 값만 입력해야 합니다."),
    INVALID_PURCHASE_AMOUNT_UNIT("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다."),
    NEGATIVE_AMOUNT_NOT_ALLOWED("[ERROR] 구입 금액은 1,000원 단위의 양의 정수여야 합니다."),
    DUPLICATE_LOTTO_NUMBER_NOT_ALLOWED("[ERROR] 로또 번호는 모두 다른 번호여야 합니다."),
    INVALID_LOTTO_NUMBER_RANGE("[ERROR] 로또 번호는 1에서 45 사이의 숫자여야 합니다."),
    NEGATIVE_LOTTO_NUMBER_NOT_ALLOWED("[ERROR] 로또 번호는 양의 정수여야 합니다."),
    INVALID_WINNING_NUMBERS_FORMAT("[ERROR] 당첨 번호는 숫자와 콤마로만 구성되어야 합니다."),
    INVALID_BONUS_NUMBER_RANGE("[ERROR] 보너스 번호는 1에서 45 사이의 양의 정수여야 합니다."),
    NEGATIVE_BONUS_NUMBER_NOT_ALLOWED("[ERROR] 보너스 번호는 양의 정수여야 합니다."),
    BONUS_NUMBER_DUPLICATE_WITH_LOTTO("[ERROR] 보너스 번호는 로또 번호와 중복될 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
