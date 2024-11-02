package lotto.view;

import lotto.util.LottoWinningPriceList;

public enum OutputView {

    ENTER_PURCHASE_PRICE("구입금액을 입력해 주세요."),
    EXIT_APPLICATION("회 이상 실패로 앱이 종료됩니다."),
    PURCHASED_LOTTO_COUNT("개를 구매했습니다."),
    ENTER_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    ENTER_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("당첨 통계" + "\n" + "---"),


    ;

    private final String message;

    OutputView(String message) {
        this.message = message;
    }

    public static void printMessage(OutputView view) {
        System.out.println(view.message);
    }

    public static void printMessage(String output) {
        System.out.println(output);
    }

    public static void printWinningResult(int match, int[][] result) {
        int basicCount = result[match][0];
        int bonusCount = result[match][1];

        if (match == 5) {
            printMatchFiveResult(match, basicCount, bonusCount);
            printIsBonus(bonusCount);
            return;
        }
        printBasicResult(match, basicCount);
    }

    private static void printMatchFiveResult(int match, int basicCount, int bonusCount) {
        if (bonusCount != 0 && (basicCount != 0)) {
            printBasicResult(match, basicCount-1);
            return;
        }
        printBasicResult(match,basicCount);
    }

    private static void printIsBonus(int bonusCount) {
        System.out.println("5개 일치, 보너스 볼 일치 (" + LottoWinningPriceList.getIncludeBonus + "원) - " + bonusCount + "개");
    }

    private static void printBasicResult(int match, int basicCount) {
        System.out.println("5개 일치 (" + LottoWinningPriceList.get[match] + "원) - " + basicCount + "개");
    }

    public static void newLine() {
        System.out.println();
    }

    public String getMessage() {
        return message;
    }

}
