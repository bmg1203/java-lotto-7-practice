package lotto.model;

import static lotto.util.constants.LottoConstants.LOTTO_TICKET_PRICE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.LongStream;

public class LottoMachine {

    public List<Lotto> issueLotto(Long totalCost) {
        long lottoCount = totalCost/LOTTO_TICKET_PRICE;

        return LongStream.rangeClosed(1, lottoCount)
                .mapToObj(buyCount -> Randoms.pickUniqueNumbersInRange(1,45,6))
                .map(this::issueLotto)
                .toList();
    }

    private Lotto issueLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }
}
