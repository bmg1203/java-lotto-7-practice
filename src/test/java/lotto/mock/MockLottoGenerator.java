package lotto.mock;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.Purchase;

public class MockLottoGenerator extends LottoGenerator {

    private final List<Lotto> fixedLottos;


    public MockLottoGenerator(Purchase purchase, List<Lotto> fixedLottos) {
        super(purchase);
        this.fixedLottos = List.copyOf(fixedLottos);
    }

    @Override
    public List<Lotto> getLottos() {
        return fixedLottos;
    }
}
