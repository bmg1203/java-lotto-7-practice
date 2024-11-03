package lotto.view;

public enum OutputMessage {
    INPUT_MONEY("구매금액을 입력해 주세요."),
    PURCHASED_AMOUNT("%d개를 구매했습니다."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요"),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("당첨 통계\n" +
            "---\n" +
            "3개 일치 (5,000원) - %d개\n" +
            "4개 일치 (50,000원) - %d개\n" +
            "5개 일치 (1,500,000원) - %d개\n" +
            "5개 일치, 보너스 불 일치 (30,000,000원) - %d개\n" +
            "6개 일치 (2,000,000,000원) - %d개\n"),
    RATE_OF_RETURN("총 수익률은 %.1f%%입니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getFormattedMessage(Object... args) {
        return String.format(message, args);
    }
}
