package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Random {

    public List<Integer> sixNumberIssue() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
