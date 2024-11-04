package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class LottoGenerator {
    public Lotto generateLotto() {
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(lotto);
    }
}
