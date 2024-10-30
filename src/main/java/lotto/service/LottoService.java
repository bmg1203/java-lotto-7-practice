package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lotto.Lotto;
import lotto.common.Winning;

public class LottoService {
    public List<Lotto> initLotto(int payCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < payCount; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoNumbers.sort(Integer::compareTo);
            lottos.add(new Lotto(lottoNumbers));
        }

        return lottos;
    }

    public Map<Winning, Integer> getWinnings(List<Lotto> lottos, List<Integer> winningNumbers, int bonus) {
        Map<Winning, Integer> countWinnings = new HashMap<>();
        for (Lotto lotto : lottos) {
            Winning winning = lotto.checkWinnings(winningNumbers, bonus);
            countWinnings.put(winning, countWinnings.getOrDefault(winning, 0) + 1);
        }

        return countWinnings;
    }
}
