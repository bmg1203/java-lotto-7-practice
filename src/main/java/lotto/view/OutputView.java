package lotto.view;

public class OutputView {

    public void printSpace() {
        System.out.println();
    }

    public void printInputTotalCost() {
        System.out.println(PrintMessage.INPUT_TOTAL_COST.getMessage());
    }

    public void printTicketCount(int count) {
        System.out.println(count + PrintMessage.TICKET_COUNT.getMessage());
    }

    public void printInputWinningNumbers() {
        System.out.println(PrintMessage.INPUT_WINNING_NUMBERS.getMessage());
    }

    public void printInputBonusNumber() {
        System.out.println(PrintMessage.INPUT_BONUS_NUMBER.getMessage());
    }

    public void printWinningStatAnnouncement() {
        System.out.println(PrintMessage.WINNING_STAT_ANNOUNCEMENT.getMessage());
    }

    public void printMatchThree(int count) {
        System.out.println(PrintMessage.MATCH_THREE.getMessage() + count);
    }

    public void printMatchFour(int count) {
        System.out.println(PrintMessage.MATCH_FOUR.getMessage() + count);
    }

    public void printMatchFive(int count) {
        System.out.println(PrintMessage.MATCH_FIVE.getMessage() + count);
    }

    public void printMatchFiveAndBonus(int count) {
        System.out.println(PrintMessage.MATCH_FIVE_AND_BONUS.getMessage() + count);
    }

    public void printMatchSix(int count) {
        System.out.println(PrintMessage.MATCH_SIX.getMessage() + count);
    }

    public void printRateOfReturn(double rate) {
        System.out.println(PrintMessage.RATE_OF_RETURN_PART_START.getMessage() + rate
                + PrintMessage.RATE_OF_RETURN_PART_END.getMessage());
    }
}
