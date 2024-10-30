package factory;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import lotto.Lotto;

public class LottoFactory {

    private static final int LOTTO_NUM_RANGE_START = 1;
    private static final int LOTTO_NUM_RANGE_END = 45;
    private static final int LOTTO_NUM_COUNT = 6;

    public static Lotto make() {
        List<Integer> nums = generateRandomNums(LOTTO_NUM_RANGE_START, LOTTO_NUM_RANGE_END, LOTTO_NUM_COUNT);
        Collections.sort(nums);
        return new Lotto(nums);
    }

    private static List<Integer> generateRandomNums(int start, int end, int count) {
        return Randoms.pickUniqueNumbersInRange(start, end, count);
    }
}
