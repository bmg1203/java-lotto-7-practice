package lotto.io.output;

public enum OutputMessage {
    ENTER_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PURCHASED_COUNT("%d개를 구매했습니다.\n"),
    ENTER_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    ENTER_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS_HEADER("당첨 통계\n---"),
    MATCH_COUNT("%d개 일치 (%d원) - %d개"),
    MATCH_COUNT_WITH_BONUS("%d개 일치, 보너스 볼 일치 (%d원) - %d개\n"),
    TOTAL_RETURN_RATE("총 수익률은 %,.2lf%%입니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
