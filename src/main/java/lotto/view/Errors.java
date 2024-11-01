package lotto.view;

import lotto.util.Constants;

public enum Errors {
    ERROR("[ERROR]"),
    NUMBER_REQUEST(Constants.LOTTO_PRICE.getNumber() + "원 단위의 금액을 입력해주세요."),
    NULL_OR_EMPTY_INPUT("값이 비어있습니다."),
    NOT_A_NATURAL_NUMBER("자연수가 아닙니다."),
    NOT_A_LONG("long 범위를 벗어났습니다."),
    NOT_IN_RANGE("범위를 벗어났습니다 ("
            + Constants.MIN_MONEY.getNumber()
            + "~"
            + Constants.MAX_MONEY.getNumber()
            + ")."),
    REMAINDER_EXISTENT("값이 나누어 떨어지지 않습니다.");

    private final String message;

    Errors(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
