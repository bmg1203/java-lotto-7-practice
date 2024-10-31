package lotto.config;

public enum ErrorMessage {
    INPUT_MONEY_ERROR("숫자만 입력 가능합니다."),
    INPUT_MONEY_DIVIDE_ERROR("로또 구입 금액은 1000원 단위여야 합니다."),

    INPUT_WIN_NUMBER_ERROR("숫자만 입력 가능합니다."),
    INPUT_WIN_NUMBER_DUPLICATE_ERROR("당첨 번호는 중복되지 않는 6자리 입니다."),
    INPUT_WIN_NUMBER_RANGE_ERROR("1 ~ 45 사이의 숫자만 입력 가능합니다."),

    INPUT_BONUS_NUMBER_RANGE_ERROR("1 ~ 45 사이의 숫자만 입력 가능합니다."),
    INPUT_BONUS_NUMBER_ERROR("숫자만 입력 가능합니다."),
    INPUT_BONUS_DUPLICATE_WIN_NUMBER_ERROR("보너스 번호는 당첨 번호와 중복되지 않아야 합니다."),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] ".concat(message);
    }
}
