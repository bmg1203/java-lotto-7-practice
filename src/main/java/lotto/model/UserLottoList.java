package lotto.model;

import static java.util.stream.IntStream.range;
import static lotto.constants.NumberConstants.MONEY_UNIT;
import static lotto.constants.NumberConstants.ZERO;

import java.util.List;
import java.util.stream.Collectors;
import lotto.util.LottoNumberGenerator;

public class UserLottoList {

    private final int count;
    private final List<Lotto> lottoList;

    public UserLottoList(int count) {
        this.count = count;
        this.lottoList = generateNumberOfLotto(count);
    }

    private List<Lotto> generateNumberOfLotto(int number) {
        return range(ZERO, number)
                .mapToObj(i -> generateLotto())
                .collect(Collectors.toList());
    }

    private Lotto generateLotto() {
        return new Lotto(LottoNumberGenerator.getNumbers());
    }

    public List<Lotto> getLottoList() {
        return this.lottoList;
    }

    public List<List<Integer>> getNumberList() {
        return this.lottoList.stream()
                .map(Lotto::getNumbers)
                .toList();
    }

    public int getMoney() {
        return count * MONEY_UNIT;
    }
}
