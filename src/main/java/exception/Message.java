package exception;

public class Message {
    private final static String DEFAULT = "[ERROR] ";
    public final static String INVALID_MONEY = DEFAULT + "입력 금액은 %d원 단위로 입력 가능합니다. 사용자의 입력값: ".formatted(lotto.Lotto.Price.PRICE);
    public final static String INVALID_CHOICE = DEFAULT + "로또 번호는 6개여야 합니다. 사용자의 입력값: ";
    public final static String DUPLICATE_NUMBER = DEFAULT + "당첨 번호에는 중복값이 없어야 합니다. 중복값: ";
    public final static String INVALID_RANGE = DEFAULT + "번호는 1과 45 사이의 수여야 합니다. 반례: ";

    public String string;

    public Message(String string) {
        this.string = string;
    }

    public String getMessage(String forward) {
        return forward + this.string;
    }
}
