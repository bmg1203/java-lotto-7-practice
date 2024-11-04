package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.lottoNumbers = numbers;
    }

    public List<Integer> getLottoNumbers (){
        sort(lottoNumbers);
        return lottoNumbers;
    }

    public Boolean contains(Integer number) {
        return lottoNumbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        validateLottoCountSize(numbers);
        validateDuplication(numbers);
    }

    private void validateLottoCountSize(List<Integer> numbers) {
        if (isLottoCountSize(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplication(List<Integer> numbers){
        if (isDuplication(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복된 숫자가 없어야 합니다.");
        }
    }

    private boolean isLottoCountSize (List<Integer> numbers) {
        return numbers.size() != LottoPublisher.LOTTO_COUNT_SIZE;
    }

    private boolean isDuplication (List<Integer> numbers) {
        return new HashSet<>(numbers).size() != numbers.size();
    }

    @Override
    public String toString() {
        sort(lottoNumbers);
        return lottoNumbers.toString();
    }

    private void sort(List<Integer> numbers) {
        numbers.sort(Integer::compareTo);
    }
}
