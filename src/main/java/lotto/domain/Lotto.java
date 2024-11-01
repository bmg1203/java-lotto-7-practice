package lotto.domain;

import static lotto.utils.Constants.END_NUM;
import static lotto.utils.Constants.LOTTO_COUNT;
import static lotto.utils.Constants.START_NUM;
import static lotto.utils.ErrorMessage.INVALID_BONUS_NUM;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

public class Lotto {

    private final List<LottoNum> numbers;

    protected Lotto(List<LottoNum> numbers) {
        validate(numbers);
        this.numbers = sorted(numbers);
    }


    public static Lotto generate() {
        List<LottoNum> numbers = Lotto.generateRandomLottoNumbers();
        return new Lotto(numbers);
    }

    public static Lotto create(List<LottoNum> numbers) {
        return new Lotto(numbers);
    }

    private static List<LottoNum> generateRandomLottoNumbers() {
        return convertToLottoNums(generateUniqueRandomNumbers());
    }

    private static List<Integer> generateUniqueRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(START_NUM, END_NUM, LOTTO_COUNT);
    }

    private static List<LottoNum> convertToLottoNums(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNum::new)
                .toList();
    }

    protected int matchCount(Lotto compareLotto) {
        return (int) numbers.stream()
                .filter(compareLotto::hasNumber)
                .count();
    }

    protected boolean hasNumber(LottoNum number) {
        return numbers.contains(number);
    }

    protected void validBonusNum(LottoNum bonusNum) {
        numbers.forEach(num -> {
            if (num.equals(bonusNum)) {
                throw new IllegalArgumentException(INVALID_BONUS_NUM.getMessage());
            }
        });
    }

    private List<LottoNum> sorted(List<LottoNum> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }

    private void validate(List<LottoNum> numbers) {
        if (numbers == null || numbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }

        Set<LottoNum> numSet = new HashSet<>(numbers);
        if (numSet.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 로또 번호는 허용하지 않습니다.");
        }
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
        return Objects.hashCode(numbers);
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ");
        for (LottoNum num : numbers) {
            joiner.add(num.toString());
        }

        return "[" + joiner + "]";
    }
}
