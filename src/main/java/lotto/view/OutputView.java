package lotto.view;

import java.text.DecimalFormat;
import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.util.Grade;

public class OutputView {

    public static void printPurchasedLottos(final List<Lotto> lottos) {
        final int lottosCount = lottos.size();
        final String delimiter = ", ";
        final String prefix = "[";
        final String suffix = "]";
        System.out.println(lottosCount + "개를 구매했습니다.");
        String result = lottos.stream()
                .map(Lotto::getNumbers)
                .map(number -> number.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(delimiter, prefix, suffix))
                )
                .collect(Collectors.joining("\n"));
        System.out.println(result);
    }

    public static void printResultScore(EnumMap<Grade, Integer> gradeWithCount) {
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Grade grade : Grade.values()) {
            int matchingCount = grade.getMatchingCount();
            String prizeMoney = formatter.format(grade.getPrizeMoney());
            int gradeCount = gradeWithCount.get(grade);
            System.out.println(matchingCount+ "개 일치 ("+prizeMoney+ "원) - " + gradeCount);
        }
    }

    public static void printProfitPercentage(Long profit) {
        System.out.println("총 수익률은 " + Math.round(profit * 100)/10.0 + "%입니다.");
    }

    public static void printRequireWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printRequireBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printRequirePurchasePrice() {
        System.out.println("구입 금액을 입력해 주세요.");
    }
}
