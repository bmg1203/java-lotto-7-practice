package lotto.viewHandler.validator;

import lotto.viewHandler.Validator;
import lotto.viewHandler.exception.NotLottoNumberRange;

import static lotto.viewHandler.exception.Util.LOTTO_END_NUMBER;
import static lotto.viewHandler.exception.Util.LOTTO_START_NUMBER;
import static lotto.viewHandler.exception.Util.NOT_LOTTO_NUMBER_RANGE;

public class LottoNumberRangeValidator implements Validator<Void, Integer> {
    @Override
    public Void validate(Integer input) {
        if(input < LOTTO_START_NUMBER || input > LOTTO_END_NUMBER) {
            throw new NotLottoNumberRange(NOT_LOTTO_NUMBER_RANGE);
        }
        return null;
    }
}
