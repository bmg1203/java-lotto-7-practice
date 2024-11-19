package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constants.LottoNumbers;

public class LottoGenerator {

    private final List<Lotto> lottos;

    public LottoGenerator(Purchase purchase) {
        this.lottos = generateLottos(purchase);
    }

    public List<Lotto> getLottos() {
        return List.copyOf(lottos);
    }

    private List<Lotto> generateLottos(Purchase purchase) {
        Set<Lotto> noDuplicateLottos = new HashSet<>();

        while (noDuplicateLottos.size() != purchase.purchaseCount()) {
            Lotto lotto = generateRandomNumbers();
            noDuplicateLottos.add(lotto);
        }

        return List.copyOf(noDuplicateLottos);
    }

    private Lotto generateRandomNumbers() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(LottoNumbers.LOTTO_MIN_RANGE.getNumber(),
                LottoNumbers.LOTTO_MAX_RANGE.getNumber(),
                LottoNumbers.LOTTO_LENGTH.getNumber()));
    }
}
