package lotto.domain;

import lotto.constants.ErrorMessage;
import lotto.constants.LottoNumbers;

public class Bonus {

    private final int bonus;

    public Bonus(Lotto lotto, int bonus) {
        validateNumberRange(bonus);
        validateDuplicate(lotto, bonus);
        this.bonus = bonus;
    }

    private void validateNumberRange(int bonus) {
        if (bonus < LottoNumbers.LOTTO_MIN_RANGE.getNumber() ||
                bonus > LottoNumbers.LOTTO_MAX_RANGE.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_NOT_IN_RANGE_ERROR.getMessage());
        }
    }

    private void validateDuplicate(Lotto lotto, int bonus) {
        if (lotto.getNumbers().contains(bonus)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER_ERROR.getMessage());
        }
    }
}
