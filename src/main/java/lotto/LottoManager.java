package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashMap;
import java.util.List;

public class LottoManager {
    private LinkedHashMap<Integer, List<Integer>> lottoTicket;
    private Lotto lotto;

    public LottoManager(int tryCount) {
        lottoTicket = new LinkedHashMap<>();
        for (int i = 0; i < tryCount; i++) {
            List<Integer> list = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            list.sort(Integer::compareTo);
            lotto = new Lotto(list);
            lottoTicket.put(i, list);
        }
    }

    public LinkedHashMap<Integer, List<Integer>> getLottoTicket() {
        return lottoTicket;
    }
}
