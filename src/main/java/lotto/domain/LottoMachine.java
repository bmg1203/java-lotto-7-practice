package lotto.domain;

import static lotto.common.LottoConstants.LOTTO_NUMBER_MAX;
import static lotto.common.LottoConstants.LOTTO_NUMBER_MIN;
import static lotto.common.LottoConstants.LOTTO_NUMBER_MAX_COUNT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;

    private int inputAmount = 0;

    public LottoTickets getLottoTickets() {
        validate(this.inputAmount);
        LottoTickets lottoTickets = new LottoTickets();
        IntStream.range(0, calculateTicketCount()).mapToObj(i -> generateLotto()).forEach(lottoTickets::addLotto);
        return lottoTickets;
    }

    public void insertAmount(Integer inputAmount) {
        validate(inputAmount);
        this.inputAmount = inputAmount;
    }

    private Lotto generateLotto() {
        List<Integer> lottoNumbers = getLottoNumbers();
        return Lotto.create(lottoNumbers);
    }

    private int calculateTicketCount() {
        return inputAmount / LOTTO_PRICE;
    }

    private void validate(Integer inputAmount) {
        if (inputAmount == 0) {
            throw new IllegalStateException("[ERROR] 구입 금액을 넣지 않았습니다. 구입 금액: " + inputAmount);
        }
        if (inputAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    private List<Integer> getLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                LOTTO_NUMBER_MIN,
                LOTTO_NUMBER_MAX,
                LOTTO_NUMBER_MAX_COUNT
        );
    }

    public int getInputAmount() {
        return inputAmount;
    }
}
