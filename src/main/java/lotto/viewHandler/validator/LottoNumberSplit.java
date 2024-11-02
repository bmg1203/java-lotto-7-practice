package lotto.viewHandler.validator;

import lotto.viewHandler.Validator;
import lotto.viewHandler.exception.NotLottoNumberSize;

import java.util.List;

import static lotto.viewHandler.exception.MyExceptionUtil.DELIMITER;
import static lotto.viewHandler.exception.MyExceptionUtil.LOTTO_SIZE;
import static lotto.viewHandler.exception.MyExceptionUtil.NOT_WINNING_LOTTO_NUMBER_SIZE;


public class LottoNumberSplit implements Validator<List<String>, String> {
    @Override
    public List<String> validate(String input) {
        List<String> split = List.of(input.split(DELIMITER));
        if(split.size() != LOTTO_SIZE) {
            throw new NotLottoNumberSize(NOT_WINNING_LOTTO_NUMBER_SIZE);
        }
        return split;
    }
}
