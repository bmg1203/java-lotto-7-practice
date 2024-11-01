package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.List;

public class LottoGenerator {

    public static Lotto generateLottoNumbers() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
