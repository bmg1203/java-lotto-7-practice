package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomLottoGenerator {
    public static List<Integer> generateSixRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
