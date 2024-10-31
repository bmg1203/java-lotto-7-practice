package lotto.exception;

import static lotto.config.LottoInfo.*;

public enum ErrorMessage {

    ERROR_PREFIX_MESSAGE("[ERROR]"),

    MIN_LOTTO_PRICE_ERROR_MESSAGE(String.format("%s 로또는 %s원 이하로 구매할 수 없습니다.",
            ERROR_PREFIX_MESSAGE,
            LOTTO_TICKET_PRICE)),

    PURCHASE_UNIT_ERROR_MESSAGE(String.format("%s 로또는 %s원 단위로만 구매 가능합니다.",
            ERROR_PREFIX_MESSAGE,
            LOTTO_TICKET_PRICE)),

    LOTTO_NUMBER_OUT_OF_RANGE_ERROR_MESSAGE(String.format("%s 로또 번호는 %s ~ %s만 허용합니다.",
            ERROR_PREFIX_MESSAGE,
            MINIMUM_LOTTO_NUMBER,
            MAXIMUM_LOTTO_NUMBER)),

    INVALID_LOTTO_COUNT_SIZE_ERROR_MESSAGE(String.format("%s 로또 번호는 %s개 입력해야합니다.",
            ERROR_PREFIX_MESSAGE,
            LOTTO_NUMBER_SIZE)),

    DUPLICATE_LOTTO_NUMBER_ERROR_MESSAGE(String.format("%s 로또 번호는 중복을 허용하지 않습니다",
            ERROR_PREFIX_MESSAGE)),

    EMPTY_INPUT_ERROR_MESSAGE(String.format("%s 빈 값은 입력될 수 없습니다.",
            ERROR_PREFIX_MESSAGE)),

    CHARACTER_INPUT_ERROR_MESSAGE(String.format("%s 문자 입력은 허용되지 않습니다",
            ERROR_PREFIX_MESSAGE)),

    NOT_ALLOW_NEGATIVE_NUMBER_ERROR_MESSAGE(String.format("%s 0또는 음수는 허용하지 않습니다.",
            ERROR_PREFIX_MESSAGE)),

    BONUS_NUMBER_ALREADY_INCLUDED_WINNING_NUMBER_ERROR_MESSAGE(String.format("%s 입력하신 보너스 숫자는 당첨 번호에 이미 속해있습니다",
            ERROR_PREFIX_MESSAGE));

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
