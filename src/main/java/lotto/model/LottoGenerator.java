package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private static final int STARTINCLUSIVE = 1;
    private static final int ENDINCLUSIVE = 45;
    private static final int COUNT = 6;
    private final int lottoCnt;
    private final List<Lotto> lottos;

    public LottoGenerator(int lottoCnt) {
        this.lottoCnt = lottoCnt;
        this.lottos = new ArrayList<>();
    }

    public List<Lotto> generateLottos() {
        for (int i = 0; i < lottoCnt; i++) {
            lottos.add(new Lotto(generateLottoNumbers()));
        }
        return lottos;
    }

    private List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(STARTINCLUSIVE, ENDINCLUSIVE, COUNT);
    }

    public int getLottoCnt() {
        return lottoCnt;
    }

}
