package lotto.message;

public enum InputMessage {
    PRICE_PROMPT("구입금액을 입력해 주세요."),
    WINNING_NUMBER_PROMPT("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_PROMPT("보너스 번호를 입력해 주세요.");

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println(this.message);
    }
}
