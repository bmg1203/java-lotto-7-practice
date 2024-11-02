package lotto.io;

import lotto.domain.LottoPrize;
import lotto.service.LottoResultAnalyzer;

public enum OutputHandler {
    ENTER_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    ENTER_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    ENTER_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private OutputHandler(String message) {
    }

    public static void printPurchasedQuantity(int quantity){
        System.out.println(quantity + "개를 구매했습니다.");
    }

    public static void printCompareResult(LottoResultAnalyzer analyzer){
        System.out.println(
                "당첨 통계\n"
                + "---\n"
                + "3개 일치 (5,000원) - " + analyzer.get(LottoPrize.FIFTH_PLACE)+"개\n"
                + "4개 일치 (50,000원) - " + analyzer.get(LottoPrize.FOURTH_PLACE) + "개\n"
                + "5개 일치 (1,500,000원) - " + analyzer.get(LottoPrize.THIRD_PLACE) + "개\n"
                + "5개 일치, 보너스 볼 일치 (30,000,000원) - " + analyzer.get(LottoPrize.SECOND_PLACE) + "개\n"
                + "6개 일치 (2,000,000,000원) - " + analyzer.get(LottoPrize.FIRST_PLACE) + "개"
        );
    }

    public static void printTotalYield(double yield){
        System.out.println("총 수익률은 " + yield + "입니다.");
    }
}
