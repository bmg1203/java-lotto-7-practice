package message;

import java.math.BigDecimal;

public enum Message {

    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    AMOUNT_PURCHASED("개를 구매했습니다."),
    INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("당첨 통계"),
    WAITING("---"),
    TOTAL_PROFIT_RATE("총 수익률은 %s%%입니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String format(double rate) {
        BigDecimal roundedRate = new BigDecimal(rate).setScale(1, BigDecimal.ROUND_HALF_UP);
        return String.format(this.message, roundedRate.toPlainString());
    }
}
