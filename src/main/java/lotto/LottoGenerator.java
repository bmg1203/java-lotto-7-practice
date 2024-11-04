package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    public List<List<Integer>> generateLottoNumbers(int lottoQuantity) {
        List<List<Integer>> allUserLottoNumbers = new ArrayList<>();

        for (int lottoIndex = 0; lottoIndex < lottoQuantity; lottoIndex++) {
            List<Integer> userLottoNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBER_COUNT);
            Collections.sort(userLottoNumbers);
            allUserLottoNumbers.add(userLottoNumbers);
        }
        return allUserLottoNumbers;
    }
}
