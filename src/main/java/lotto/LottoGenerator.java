package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public final class LottoGenerator {

    private LottoGenerator() {
    }

    public static Lotto generate() {
        return new Lotto(
                Randoms.pickUniqueNumbersInRange(1, 45, 6)
        );
    }
}
