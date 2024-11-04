package lotto.error;

public enum ErrorMessage {
    NOTNUMBERBUYAMOUNT("[ERROR] 구매금액이 정수가 아닙니다."),
    NOTPER1000BUYAMOUNT("[ERROR] 구매금액이 1000원 단위가 아닙니다."),
    NOTDELIMITERWINNUMBERS("[ERROR] 입력된 당첨번호의 구분자가 ,가 아닙니다."),
    NOTNUMBERWINNUMBERS("[ERROR] 당첨번호가 숫자가 아닙니다"),
    NOTNUMBERBONUSNUMBER("[ERROR] 보너스 번호가 정수가 아닙니다."),
    OUTOFRANGEBONUSNUMBER("[ERROR] 보너스숫자가 1~45 범위안에 존재하는 숫자가 아닙니다."),
    OVERLAPLOTTONUMBER("[ERROR] 발행된 로또번호가 중복입니다."),
    LOTTONUMBERCOUNTNOTSIX("[ERROR] 발행된 로또번호가 6개가 아닙니다."),
    OVERLAPBONUSNUMBER("[ERROR] 보너스 숫자가 당첨번호와 중복입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
