package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import lotto.Lotto;

public class LottoMaker {

    public Lotto makeLotto() {
        List<Integer> numbers = Randoms
                .pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }
}
