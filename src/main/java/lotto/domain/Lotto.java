package lotto.domain;

import static java.util.stream.Collectors.toList;
import static lotto.domain.LottoConstants.IS_DUPLICATE_NUMBER;
import static lotto.domain.LottoConstants.IS_NOT_LOTTO_SIZE;
import static lotto.domain.LottoConstants.LOTTO_SIZE;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLotto(numbers);
        this.numbers = makeSortLotto(numbers);
    }

    public Lotto(Integer... lottoNumbers) {
        this(Arrays.stream(lottoNumbers).collect(toList()));
    }

    // TODO: 추가 기능 구현
    private void validateLotto(List<Integer> numbers) {
        validateLottoSetSize(numbers);
        valdiateDuplicate(numbers);
    }

    private void valdiateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(IS_DUPLICATE_NUMBER);
        }
    }

    private void validateLottoSetSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(IS_NOT_LOTTO_SIZE);
        }
    }

    private List<Integer> makeSortLotto(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);
        return lottoNumbers;
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
