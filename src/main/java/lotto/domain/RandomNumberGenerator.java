package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumberGenerator {

    private RandomNumberGenerator() {}

    public static List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
