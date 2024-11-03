package lotto.model.dummy;

import java.util.HashMap;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.WinningLotto;

public class LottoDummy {
    public final WinningLotto winningLotto;
    public final HashMap<Lotto, LottoRank> lottoResult;

    public LottoDummy() {
        this.winningLotto = generateWinningLotto();
        this.lottoResult = generateLottoResult();
    }

    public List<Lotto> getLottoList() {
        return lottoResult.keySet().stream().toList();
    }

    private WinningLotto generateWinningLotto() {
        return new WinningLotto(
                new Lotto(List.of(7, 9, 13, 26, 29, 43)), 11
        );
    }

    private HashMap<Lotto, LottoRank> generateLottoResult() {
        HashMap<Lotto, LottoRank> lottoResult = new HashMap<>();

        lottoResult.put(new Lotto(List.of(1, 2, 3, 4, 5, 6)), LottoRank.LOSE);
        lottoResult.put(new Lotto(List.of(7, 8, 11, 14, 15, 16)), LottoRank.LOSE);
        lottoResult.put(new Lotto(List.of(7, 9, 11, 14, 15, 16)), LottoRank.LOSE);
        lottoResult.put(new Lotto(List.of(7, 9, 13, 14, 15, 16)), LottoRank.RANK_5);
        lottoResult.put(new Lotto(List.of(7, 9, 13, 26, 27, 28)), LottoRank.RANK_4);
        lottoResult.put(new Lotto(List.of(7, 9, 13, 26, 29, 36)), LottoRank.RANK_3);
        lottoResult.put(new Lotto(List.of(7, 9, 11, 13, 26, 29)), LottoRank.RANK_2);
        lottoResult.put(new Lotto(List.of(7, 9, 11, 26, 29, 43)), LottoRank.RANK_2);
        lottoResult.put(new Lotto(List.of(7, 9, 13, 26, 29, 43)), LottoRank.RANK_1);

        return lottoResult;
    }
}
