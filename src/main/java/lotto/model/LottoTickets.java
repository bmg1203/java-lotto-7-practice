package lotto.model;

import static lotto.view.OutputView.printEachLotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTickets {
    private final List<Lotto> lottoTickets = new ArrayList<>();

    public LottoTickets(int attemptCount) {
        for (int count = 1; count <= attemptCount; count++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            printEachLotto(numbers);
            lottoTickets.add(new Lotto(numbers));
        }
    }
}
