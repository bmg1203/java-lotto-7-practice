package lotto.domain.winning;

import static lotto.common.exception.ErrorMessage.BONUS_NUMBER_CANNOT_BE_DUPLICATED;

import java.util.List;
import lotto.common.exception.LottoException;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;

public class BonusNumber {

    private final LottoNumber bonusNumber;

    public BonusNumber(LottoNumber bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public boolean hasMatchingBonusNumber(Lotto lotto) {
        return lotto.getLotto().contains(bonusNumber);
    }

    public void validateDuplicate(List<LottoNumber> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new LottoException(BONUS_NUMBER_CANNOT_BE_DUPLICATED);
        }
    }

}
