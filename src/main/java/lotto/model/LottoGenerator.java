package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoGenerator {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    private static final int FIXED_SIZE = 6;
    private final List<Lotto> lottos;

    private LottoGenerator(long amount) {
        List<Lotto> lottos = generateLottos(amount);
        this.lottos = List.copyOf(lottos);
    }

    public static LottoGenerator generate(long amount) {
        return new LottoGenerator(amount);
    }

    private List<Lotto> generateLottos(long amount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int lottoCount = 0; lottoCount < amount; lottoCount++) {
            Lotto lotto = generateAscedingSortedRandomLotto();
            lottos.add(lotto);
        }

        return lottos;
    }

    private Lotto generateAscedingSortedRandomLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, FIXED_SIZE);
        List<Integer> sortedRandomNumbers = randomNumbers.stream().sorted(Comparator.naturalOrder()).toList();

        return new Lotto(sortedRandomNumbers);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
