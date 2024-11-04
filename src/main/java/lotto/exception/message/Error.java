package lotto.exception.message;

public enum Error {

    CAPTION("[ERROR] "),
    NOT_FIX_SIZE(CAPTION.message + "로또 번호는 %d개여야 합니다."),
    DUPLICATED_NUMBER(CAPTION.message + "같은 숫자는 중복될 수 없습니다."),
    NOT_NUMERIC(CAPTION.message + "숫자 이외엔 입력할 수 없습니다."),
    REMAIN_EXISTS(CAPTION.message + "가격은 %,d원 단위로 입력해야 합니다."),
    INVALID_RANGE(CAPTION.message + "숫자는 %d에서 %d까지만 입력할 수 있습니다."),
    BONUS_DUPLICATED(CAPTION.message + "당첨 번호에 입력한 숫자는 보너스 번호로 입력할 수 없습니다."),
    EMPTY_VALUE(CAPTION.message + "공백 혹은 빈 문자열은 입력할 수 없습니다");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String formatMessageOf(int num) {
        return String.format(this.message, num);
    }

    public String formatMessageOf(int minimum, int maximum) {
        return String.format(this.message, minimum, maximum);
    }

    public String getMessage() {
        return message;
    }
}
