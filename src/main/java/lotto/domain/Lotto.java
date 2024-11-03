package lotto.domain;

import java.util.List;
import lotto.exception.LottoException;

public record Lotto(List<LottoNumber> numbers) {

    private final static int LOTTO_SIZE = 6;

    public Lotto {
        validate(numbers);
    }

    private void validate(List<LottoNumber> numbers) {
        validateLottoSize(numbers);
        validateDuplicate(numbers);
    }

    private void validateLottoSize(final List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new LottoException("로또 번호는 " + LOTTO_SIZE + "개여야 합니다.");
        }
    }

    private void validateDuplicate(final List<LottoNumber> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_SIZE) {
            throw new LottoException("로또 번호는 중복될 수 없습니다.");
        }
    }
}
