package constant;

public enum InputNotice {
    PURCHASE_AMOUNT("구입금액을 입력해 주세요"),
    WINNER_NUMBER("당첨 번호를 입력해 주세요"),

    BONUS_NUMBER("보너스 번호를 입력해 주세요");

    private final String inputNotice;

    InputNotice(String inputNotice) {
        this.inputNotice = inputNotice;
    }

    public String show() {
        return inputNotice;
    }
}
