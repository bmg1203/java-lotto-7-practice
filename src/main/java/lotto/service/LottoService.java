package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.enums.Constants;

public class LottoService {

    public List<Integer> getLottoNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < Constants.LOTTO_NUMBER_SIZE.getValue()) {
            int number = Randoms.pickNumberInRange(Constants.LOTTO_LOWER_BOUND.getValue(),
                    Constants.LOTTO_UPPER_BOUND.getValue());
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }
        return numbers;
    }
}
