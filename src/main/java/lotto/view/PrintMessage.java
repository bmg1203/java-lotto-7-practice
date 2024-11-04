package lotto.view;

public class PrintMessage {
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String RESULT_PRINT_MESSAGE = "당첨 통계\n---";

    public void getPurchaseAmountMessage() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
    }
    public void getWinningNumbersMessage() {
        System.out.println(WINNING_NUMBERS_MESSAGE);
    }
    public void getBonusNumberMessage() {
        System.out.println(BONUS_NUMBER_MESSAGE);
    }
    public void getResultPrintMessage(){
        System.out.println(RESULT_PRINT_MESSAGE);
    }
}
