package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumberGenerator {
    public List<Integer> generate() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return sortLottoNumbers(lottoNumbers);
    }

    private List<Integer> sortLottoNumbers(List<Integer> lottoNumbers) {
        return lottoNumbers.stream().sorted().toList();
    }
}
