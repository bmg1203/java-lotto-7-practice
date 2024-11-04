package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Application {
    private static final int LOTTO_PRICE = 1000;
    private static final int PERCENT = 100;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String ERROR_MUST_BE_NUMBER = " 구입 금액은 숫자여야 합니다.";
    private static final String ERROR_MUST_BE_LOTTO_RANGE = " 번호는 1과 45사이여야 합니다.";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";


    public static void main(String[] args) {
        int lottoPieces;
        // 예외 처리 때문에 가독성이 너무 안좋다. 리팩토링 할 때 이 부분 고려하기.
        while (true) {
            try {
                System.out.println("구입 금액을 입력해 주세요.");
                String Money = Console.readLine();
                lottoPieces = buyLotto(Money);
                System.out.printf("\n%d개를 구매했습니다.\n", lottoPieces);
                break;
            } catch (NumberFormatException e) {
                System.out.println(ERROR_MESSAGE + ERROR_MUST_BE_NUMBER);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        List<Lotto> lottos = createLotto(lottoPieces);
        lottosView(lottos);

        Lotto winningLotto;
        while (true) {
            try {
                System.out.println("\n당첨 번호를 입력해 주세요.");
                String winningNumber = Console.readLine();
                winningLotto = new Lotto(parseWinningNumber(winningNumber));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        int bonusNumber;
        while (true) {
            try {
                System.out.println("\n보너스 번호를 입력해 주세요.");
                String rawBonusNumber = Console.readLine();
                bonusNumber = parseBonusNumber(rawBonusNumber);
                break;
            } catch (NumberFormatException e){
                System.out.println(ERROR_MESSAGE + ERROR_MUST_BE_NUMBER);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        Map<String, Integer> lottoResult = drawLotto(lottos, winningLotto, bonusNumber);
        viewWinningLotto(lottoResult);

        double profitRate = calProfitRate(lottoResult, lottoPieces);
        System.out.printf(PROFIT_RATE_MESSAGE, profitRate);
    }

    public static int buyLotto(final String input) {
        int payment = Integer.parseInt(input);
        validateBuyLotto(payment);
        return payment / LOTTO_PRICE;
    }

    public static void validateBuyLotto(final int payment) {
        if (payment % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    public static List<Lotto> createLotto(final int pieces) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < pieces; i++) {
            List<Integer> randomLottoNum = createLottoNum();
            lottos.add(new Lotto(randomLottoNum));
        }
        return lottos;
    }

    public static List<Integer> createLottoNum() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public static void lottosView(List<Lotto> lottos) {
        System.out.println("\n" + lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            lotto.lottoView();
        }
    }

    // 예외 처리 필요
    public static List<Integer> parseWinningNumber(String input) {
        String[] splitInput = input.split(",");

        List<Integer> winningNumber = new ArrayList<>();
        for (String number : splitInput) {
            winningNumber.add(Integer.parseInt(number));
        }
        return winningNumber;
    }

    // 예외 처리 필요
    public static int parseBonusNumber(String input) {
        int bonusNumber = Integer.parseInt(input);
        validateParseBonusNumber(bonusNumber);
        return bonusNumber;
    }

    public static void validateParseBonusNumber(int bonusNumber) {
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new IllegalArgumentException(ERROR_MESSAGE + ERROR_MUST_BE_LOTTO_RANGE);
        }
    }

    public static Map<String, Integer> drawLotto(final List<Lotto> lottos, final Lotto winningLotto, final int bonusNumber) {
        Map<String, Integer> resultLotto = initWinCount();

        for (Lotto lotto : lottos) {
            int matchCount = lotto.compareNumber(winningLotto);
            boolean bonusMatch = lotto.compareBonusNumber(bonusNumber);

            LottoRank rank = LottoRank.win(matchCount, bonusMatch);

            String rankName = rank.name();
            if (rankName.equals("BLANK")) {
                continue;
            }
            resultLotto.put(rankName, resultLotto.get(rankName) + 1);
        }
        return resultLotto;
    }

    public static Map<String, Integer> initWinCount() {
        Map<String, Integer> result = new LinkedHashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.BLANK) {
                String key = rank.name();
                result.put(key, 0);
            }
        }
        return result;
    }

    public static void viewWinningLotto(final Map<String, Integer> lottoResult) {
        System.out.println("\n당첨 통계");
        System.out.println("---");

        for (Map.Entry<String, Integer> rank : lottoResult.entrySet()) {
            String lottoRank = generateLottoRank(rank.getKey());
            System.out.printf("%s - %d개\n", lottoRank, rank.getValue());
        }
    }

    // return 구조 개선 필요 (예외 처리)
    public static String generateLottoRank(final String rankName) {
        LottoRank standardRank = findRank(rankName);
        String matchResult = standardRank.getMatch() + "개 일치";
        String prizeResult = " (" + String.format("%,d", standardRank.getPrize()) + "원)";
        if (rankName.equals(standardRank.name()) && rankName.equals("SECOND")) {
            return matchResult + ", 보너스 볼 일치" + prizeResult;
        }
        if (rankName.equals(standardRank.name())) {
            return matchResult + prizeResult;
        }
        return "";
    }

    public static LottoRank findRank(String name) {
        for (LottoRank rank : LottoRank.values()) {
            if (name.equals(rank.name())) {
                return rank;
            }
        }
        return LottoRank.BLANK;
    }

    public static double calProfitRate(final Map<String, Integer> lottoResult, final int lottoPieces) {
        int totalBuyingLotto = lottoPieces * LOTTO_PRICE;
        int totalPrize = 0;

        for (Map.Entry<String, Integer> entry : lottoResult.entrySet()) {
            LottoRank rank = findRank(entry.getKey());
            int count = entry.getValue();
            totalPrize += rank.getPrize() * count;
        }

        return (double) totalPrize / totalBuyingLotto * PERCENT;
    }
}
