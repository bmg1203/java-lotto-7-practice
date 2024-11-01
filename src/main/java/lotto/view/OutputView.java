package lotto.view;

public class OutputView {
    public static void printInsertMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printError(String message) {
        System.out.println(message);
    }

    public static void printLottoTicketMessage(int ticket) {
        System.out.println("\n" + ticket + "개를 구매했습니다.");
    }
}
