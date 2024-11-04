package lotto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoRule;
import lotto.model.Lottos;

public class LottoMatcher {
    public Map<LottoRule, Integer> calculateMatch(Lottos lottos, List<Integer> winNumbers, int bonusNumber) {
        Map<LottoRule, Integer> matchInfo = new HashMap<>();

        for (Lotto lotto : lottos.getLottos()) {
            int matchCount = 0;

            for (Integer winNumber : winNumbers) {
                if (lotto.getNumbers().contains(winNumber)) {
                    matchCount++;
                }
            }

            boolean bonusMatch = (matchCount == 5) && lotto.getNumbers().contains(bonusNumber);
            LottoRule rule = LottoRule.getWinInfo(matchCount, bonusMatch);
            matchInfo.put(rule, matchInfo.getOrDefault(rule, 0) + 1);
        }
        return matchInfo;
    }
}
