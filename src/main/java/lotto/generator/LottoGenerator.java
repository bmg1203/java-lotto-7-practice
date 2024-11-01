package lotto.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoBundle;
import lotto.domain.LottoPurchasePrice;

public class LottoGenerator {

    private final int lottoPrice;
    private final int lottoNumberMin;
    private final int lottoNumberMax;
    private final int lottoNumberCount;

    public LottoGenerator(int lottoPrice, int lottoNumberMin, int lottoNumberMax, int lottoNumberCount) {
        this.lottoPrice = lottoPrice;
        this.lottoNumberMin = lottoNumberMin;
        this.lottoNumberMax = lottoNumberMax;
        this.lottoNumberCount = lottoNumberCount;
    }

    public LottoBundle generateLottoBundle(LottoPurchasePrice lottoPurchasePrice) {
        return LottoBundle.from(generateLottos(lottoPurchasePrice.getLottoCount()), lottoPrice);
    }

    private List<Lotto> generateLottos(int lottoCount) {
        return IntStream.range(0, lottoCount)
                .mapToObj(i -> new Lotto(generateRandomNumbers()))
                .collect(Collectors.toList());
    }

    private List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(lottoNumberMin, lottoNumberMax, lottoNumberCount);
    }

}
