package lotto;

import constants.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    public List<Lotto> generateLottos(int amount) {
        int count = amount / Constants.LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottos.add(generateRandomLotto());
        }

        return lottos;
    }

    private Lotto generateRandomLotto() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < Constants.LOTTO_MAIN_COUNT) {
            int number = (int) (Math.random() * Constants.LOTTO_MAX_NUMBER) + Constants.LOTTO_MIN_NUMBER;
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }
        Collections.sort(numbers);
        return new Lotto(numbers);
    }
}
