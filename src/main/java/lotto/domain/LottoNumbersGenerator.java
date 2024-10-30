package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.List;

public class LottoNumbersGenerator {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int PICK_COUNT = 6;

    public static List<Integer> generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, PICK_COUNT);
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }
}
