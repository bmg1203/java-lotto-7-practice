package domain.lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import domain.consumer.Consumer;
import io.Input;
import io.Output;
import java.util.ArrayList;
import java.util.List;

public class LottoMachin {

    private final int START_INCLUSIVE = 1;
    private final int END_INCLUSIVE = 45;
    private final int COUNT = 6;

    public void sellTo(Consumer consumer) {
        int quantity = consumer.getQuantityPurchaseLottoBy(Input.getMoneyFoPurchaseLotto());
        List<Lotto> generatedLotto = generateLottoBy(quantity);
        consumer.receiveLottoTicket(generatedLotto);
    }

    private List<Lotto> generateLottoBy(int lottoQuantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoQuantity; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, COUNT)));
        }
        return lottos;
    }

    public void printLottoInfo(Consumer consumer) {
        Output.println("\r\n"+consumer.getPurchasedLottos().size() + "개를 구매했습니다.");
        consumer.getPurchasedLottos().forEach(Output::println);
    }

    public void inputWinningNumbers() {
        Input.inputWinningNumbers(Console.readLine());
    }
    /**
     * 머신은 사용자에게 번호를 입력받는다.
     * 머신은 사용자에게 보너스 번호를 입력받는다.
     */

}
