package domain.lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import domain.consumer.Consumer;
import domain.rank.MatchCount;
import io.Input;
import io.InputMessage;
import io.Output;
import io.OutputMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import strategy.LottoMatchCounter;
import strategy.LottoMatchCounterImpl;

public class LottoMachin {

    private final LottoMatchCounter counter = new LottoMatchCounterImpl();

    public void sellTo(Consumer consumer) {
        int quantity = consumer.getQuantityPurchaseLottoBy(Input.getMoneyForPurchaseLotto());
        List<Lotto> generatedLotto = generateLottoBy(quantity);
        consumer.receiveLottoTicket(generatedLotto);
    }

    private List<Lotto> generateLottoBy(int lottoQuantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoQuantity; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(
                    LottoCondition.START_INCLUSIVE.getConditionNumber(),
                    LottoCondition.END_INCLUSIVE.getConditionNumber(),
                    LottoCondition.COUNT.getConditionNumber()))
            );
        }
        lottos.forEach(Lotto::sortLottoNumbers);
        return lottos;
    }

    public void printLottoInfo(Consumer consumer) {
        StringBuilder LottoInfo = new StringBuilder();
        LottoInfo
                .append(InputMessage.NEW_LINE.getInputMessage())
                .append(consumer.getPurchasedLottos().size())
                .append(InputMessage.PURCHASE_LOTTO_COUNT.getInputMessage());
        Output.println(LottoInfo.toString());
        consumer.getPurchasedLottos().forEach(Output::println);
    }

    public void inputWinningNumbersTo(Consumer consumer) {
        Output.println(OutputMessage.ENTER_WINNER_NUMBERS.getOutputMessage());
        Lotto selectWinnerLotto = Input.inputWinningNumbers(Console.readLine());
        selectWinnerLotto.sortLottoNumbers();
        consumer.selectWinnerNumbers(selectWinnerLotto);
    }

    public void inputBonusNumbersTo(Consumer consumer) {
        Output.println(OutputMessage.ENTER_BONUS_NUMBER.getOutputMessage());
        int selectedBonusNumber = Input.inputBonusNumber(Console.readLine());
        consumer.selectBonusNumber(selectedBonusNumber);
    }

    public void printLottoWinningResult(Consumer consumer) {
        Output.println(OutputMessage.WINNING_STATISTICS.getOutputMessage());
        // TODO : 리턴 결과를 받는다. ( HashMap 도 괜찮을것 같음)
        Map< MatchCount, Integer> checkedLottoResult = consumer.getCheckLottoResultBy(this);
        // TODO : 리턴 받은 자료구조를 출력 형식에 맞게 출력한다.
        System.out.println(checkedLottoResult);
    }
    public int getMatchedLottoCount(Lotto purchasedLotto,
                                    Lotto winningNumbers,
                                    int bonusNumber) {

        return counter.count(purchasedLotto, winningNumbers, bonusNumber);
    }
    // TODO : 수익률을 계산한다.

    // TODO : 수익률을 출력한다.
}
