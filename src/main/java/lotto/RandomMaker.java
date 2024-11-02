package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomMaker {
    private static final int MIN_RANDOM_NUMBER = 1;
    private static final int MAX_RANDOM_NUMBER = 45;

    public static List<Integer> getRandomNumber(int count) {
        return Randoms.pickUniqueNumbersInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER, count);
    }
}
