package lotto.domain;

import lotto.common.LottoRank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int size() {
        return lottos.size();
    }

    public void forEachLotto(Consumer<Lotto> action) {
        lottos.forEach(action);
    }

    public Map<LottoRank, Integer> calculateRank(Lotto winningLotto, int bonusNumber) {
        Map<LottoRank, Integer> result = new HashMap<>();
        for (Lotto lotto : lottos) {
            int matchCount = lotto.countMatchingNumbers(winningLotto.getNumbers());
            boolean matchBonus = lotto.containsBonusNumber(bonusNumber);
            LottoRank rank = LottoRank.valueOf(matchCount, matchBonus);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
        return result;
    }
}