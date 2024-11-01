package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import lotto.converter.IntegersToLottoNumbersConverter;
import lotto.converter.LottoNumbersConverter;
import lotto.converter.StringsToLottoNumbersConverter;
import lotto.util.StringUtil;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final String DELIMITER = ",";

    private final Set<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        this.numbers = toSet(numbers);
        validateSize();
        validDuplicate(numbers);
    }

    public Lotto(LottoNumbersConverter converter) {
        this(converter.convert());
    }

    private static Set<LottoNumber> toSet(List<LottoNumber> numbers) {
        return new HashSet<>(numbers);
    }

    private void validateSize() {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    private void validDuplicate(List<LottoNumber> inputNumbers) {
        if (inputNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복되어서는 안됩니다.");
        }
    }

    public static Lotto fromString(String value) {
        return new Lotto(new StringsToLottoNumbersConverter(StringUtil.converList(value, DELIMITER)));
    }

    public static Lotto fromIntegers(List<Integer> value) {
        return new Lotto(new IntegersToLottoNumbersConverter(value));
    }

    public int matchCount(Lotto lotto) {
        return (int) lotto.numbers.stream().filter(this.numbers::contains).count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
