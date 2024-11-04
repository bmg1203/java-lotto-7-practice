package lotto.exception;

public enum ExceptionCode {

    INVALID_NUMBER_FORMAT("숫자를 입력해주세요."),
    MAX_TRY_ERROR("최대 입력 가능 횟수를 초과했습니다."),
    NON_SIX_NUMBERS("숫자를 6개 입력해주세요."),
    OUT_OF_RANGE("1~45 사이의 숫자를 입력해주세요."),
    DUPICATED_ERROR("중복된 숫자를 입력할 수 없습니다."),
    NEGATIVE_NUMBER("양수를 입력해주세요."),
    NON_DIVISIBLE_BY_THOUSAND("1000원으로 나누어 떨어지도록 금액을 입력해주세요.");

    private static final String ERROR_PREFIX = "[ERROR] ";

    private final String message;

    ExceptionCode(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message + "\n";
    }
}
