package lotto.model;

import static lotto.model.constant.Lotto.GENERATE_COUNT;
import static lotto.model.constant.Lotto.MAX_NUMBER;
import static lotto.model.constant.Lotto.MIN_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.util.Sorter;

public class RandomNumber {
    public List<Integer> generate() {
        return Sorter.ascendingOrder(Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, GENERATE_COUNT));
    }
}
