package lottoManager;

import java.util.LinkedHashMap;
import java.util.Map;

import rank.LottoRank;

public class LottoWinningResult {

    private static Map<LottoRank, Integer> lottoResult;


    public LottoWinningResult() {
        lottoResult = new LinkedHashMap<>();
        lottoResult.put(LottoRank.FIFTH, 0);
        lottoResult.put(LottoRank.FOURTH, 0);
        lottoResult.put(LottoRank.THIRD, 0);
        lottoResult.put(LottoRank.SECOND, 0);
        lottoResult.put(LottoRank.FIRST, 0);
    }


    public void makeLottoResult(LottoRank lottoRank ) {
        if (lottoRank != LottoRank.FAIL) {
            lottoResult.put(lottoRank, lottoResult.get(lottoRank) + 1);
        }

    }


    public Map<LottoRank, Integer> getLottoResult() {
        return new LinkedHashMap<>(lottoResult);
    }




}
