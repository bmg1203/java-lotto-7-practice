package lotto.model;

import java.util.List;
import java.util.stream.Collectors;
import lotto.constant.LottoConstants;
import lotto.exception.LottoNumberNotInRangeException;
import lotto.validation.InputValidation;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public static int getNumberIfInRange(final String lottoNumber) throws IllegalArgumentException {
        int lottoNum = InputValidation.parseNumberValidation(lottoNumber);
        Lotto.isLottoNumberOutOfRange(lottoNum);
        return lottoNum;
    }

    private static void isLottoNumberOutOfRange(int number) {
        if (number < 1 || number > 45) {
            throw new LottoNumberNotInRangeException();
        }
    }

    @Override
    public String toString() {
        return LottoConstants.OUTPUT_LOTTO_PREFIX + numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(LottoConstants.OUTPUT_LOTTO_DELIMITER))
                + LottoConstants.OUTPUT_LOTTO_SUFFIX;
    }
}
