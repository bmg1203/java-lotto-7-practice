package lotto.io.output;

public class UserPromptService {
    private static final String INPUT_PURCHASE_AMOUNT_GUIDE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_GUIDE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_GUIDE = "보너스 번호를 입력해 주세요.";
    private static final String OUTPUT_PURCHASE_COUNT_NOTICE = "%d개를 구매했습니다.";
    private static final String OUTPUT_WINNING_STATISTICS_NOTICE = "당첨 통계\n---";
    private static final String OUTPUT_RATE_OF_RETURN = "총 수익률은 %.1f%%입니다.";

    public UserPromptService() {
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showBlankLine() {
        System.out.println();
    }

    public void showInputPurchaseAmountPrompt() {
        System.out.println(INPUT_PURCHASE_AMOUNT_GUIDE);
    }

    public void showOutputPurchaseCountPrompt(int count) {
        System.out.printf((OUTPUT_PURCHASE_COUNT_NOTICE) + "%n", count);
    }

    public void showInputWinningNumberPrompt() {
        System.out.println(INPUT_WINNING_NUMBER_GUIDE);
    }

    public void showInputBonusNumberPrompt() {
        System.out.println(INPUT_BONUS_NUMBER_GUIDE);
    }

    public void showOutputWinningStatisticsPrompt() {
        System.out.println(OUTPUT_WINNING_STATISTICS_NOTICE);
    }

    public void showRateOfReturnPrompt(double rateOfReturn) {
        System.out.printf((OUTPUT_RATE_OF_RETURN) + "%n", rateOfReturn);
    }
}
