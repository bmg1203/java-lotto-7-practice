package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static List<Lotto> buyAsMoney(int money) {
        List<Lotto> boughtLottos = new ArrayList<>();
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[Error] 구매금액은 1,000원단위로 입력주세요");
        }
        for (int i = 0; i < money / 1000; i++) {
            boughtLottos.add(createLotto());
        }
        return boughtLottos;
    }

    private static Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public int countMatchingNumbers(Lotto winningLotto) {
        int matchingNumberCount = 0;
        for (Integer number : numbers) {
            if (winningLotto.getNumbers().contains(number)) {
                matchingNumberCount++;
            }
        }
        return matchingNumberCount;
    }

    public boolean contains(int bonusNumber) {
        boolean iscontainBonusNumber = numbers.contains(bonusNumber);
        return iscontainBonusNumber;
    }
}
