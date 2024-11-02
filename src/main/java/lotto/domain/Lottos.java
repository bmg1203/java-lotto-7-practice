package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static lotto.constants.LottoConstants.*;

public class Lottos {

    private static final int START_INDEX = 0;

    private final List<Lotto> lottoList;

    private Lottos(int count) {
        this.lottoList = new ArrayList<>();
        generateLottos(count);
    }

    public static Lottos from(final int count) {
        return new Lottos(count);
    }

    public List<Lotto> getLottoList() {
        return Collections.unmodifiableList(lottoList);
    }

    private void generateLottos(final int count) {
        IntStream.range(START_INDEX, count)
                .mapToObj(i -> Lotto.from(
                        Randoms.pickUniqueNumbersInRange(
                                MINIMUM_LOTTO_NUMBER,
                                MAXIMUM_LOTTO_NUMBER,
                                LOTTO_SIZE
                        )
                )).forEach(lottoList::add);
    }

}