package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoBundle;
import lotto.domain.LottoProfit;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.error.LottoError;

public class LottoView {
    private static final String LOTTO_PURCHASE_PRICE_REQUEST_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String GENERATED_LOTTO_COUNT_MESSAGE = "\n%d개를 구매했습니다.";
    private static final String GENERATED_LOTTO_NUMBERS_MESSAGE = "[%s]";
    private static final String GENERATED_LOTTO_NUMBERS_DELIMITER = ", ";
    private static final String LOTTO_WINNING_NUMBERS_REQUEST_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String LOTTO_BONUS_NUMBER_REQUEST_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    private static final String LOTTO_RESULT_MESSAGE = "\n당첨 통계\n---";
    private static final String LOTTO_PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";
    private final LottoInputValidator lottoInputValidator;

    public LottoView(LottoInputValidator lottoInputValidator){
        this.lottoInputValidator = lottoInputValidator;
    }

    public int requestLottoPurchasePrice() {
        System.out.println(LOTTO_PURCHASE_PRICE_REQUEST_MESSAGE);
        String lottoPurchasePrice = input();
        lottoInputValidator.validateLottoPurchasePrice(lottoPurchasePrice);
        return parseInt(lottoPurchasePrice);
    }

    public String requestLottoWinningNumbers() {
        System.out.println(LOTTO_WINNING_NUMBERS_REQUEST_MESSAGE);
        return input();
    }

    public String requestLottoBonusNumber() {
        System.out.println(LOTTO_BONUS_NUMBER_REQUEST_MESSAGE);
        return input();
    }

    public void printLottoBundle(LottoBundle lottoBundle) {
        printLottos(lottoBundle.getLottos());
    }

    public void printLottoResult(LottoResult lottoResult) {
        System.out.println(LOTTO_RESULT_MESSAGE);
        printLottoRankCount(lottoResult.getRankCount());
        printLottoProfitRate(lottoResult.getLottoProfit());
    }

    private String input() {
        return Console.readLine();
    }

    private int parseInt(String number){
        try{
            return Integer.parseInt(number);
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException(LottoError.INVALID_NUMBER.getMessage());
        }
    }

    private void printLottos(List<Lotto> lottos) {
        printLottosCount(lottos.size());

        lottos.stream()
                .map(this::getLottoNumbersMessage)
                .forEach(System.out::println);
    }

    private void printLottosCount(int lottoCount) {
        System.out.println(String.format(GENERATED_LOTTO_COUNT_MESSAGE, lottoCount));
    }

    private String getLottoNumbers(Lotto lotto) {
        return lotto.getNumbers().stream()
                .sorted()
                .map(number -> String.valueOf(number))
                .collect(Collectors.joining(GENERATED_LOTTO_NUMBERS_DELIMITER));
    }

    private String getLottoNumbersMessage(Lotto lotto) {
        return String.format(GENERATED_LOTTO_NUMBERS_MESSAGE, getLottoNumbers(lotto));
    }

    private void printLottoRankCount(Map<LottoRank, Integer> lottoRankCount) {
        Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank != LottoRank.FAIL)
                .map(lottoRank -> String.format(lottoRank.getMessage(), lottoRankCount.get(lottoRank)))
                .forEach(System.out::println);
    }

    private void printLottoProfitRate(LottoProfit lottoProfit){
        System.out.println(String.format(LOTTO_PROFIT_RATE_MESSAGE, lottoProfit.getProfitRate()));
    }
}
