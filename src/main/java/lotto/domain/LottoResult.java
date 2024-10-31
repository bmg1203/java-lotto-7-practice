package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

//  - 로또 결과에서 발행된 로또들과 당첨 번호를 비교한다
// 로또 결과 비교하기
// 수익률 계산하기
public class LottoResult {
    private Map<LottoRank, Integer> lottoResult = new EnumMap<>(LottoRank.class);
    private float profitRate;

    public LottoResult() {
        lottoResultInitialize();
    }

    private void lottoResultInitialize() {
        for(LottoRank lottoRank : LottoRank.values()) {
            lottoResult.put(lottoRank, 0);
        }
    }

    public void calculateLottoResult(List<Lotto> purchasedLottos, Numbers winNumbers, Number bonusNumber) {
        for (Lotto lotto : purchasedLottos) {
            int lottoScore = lotto.countMatchNumbers(winNumbers);
            boolean hasBonusNumber = lotto.checkHasBonusNumber(bonusNumber);
            LottoRank rank = LottoRank.evaluate(lottoScore, hasBonusNumber);

            if (rank != null) {
                Integer i = lottoResult.get(rank);
                lottoResult.put(rank, ++i);
            }
        }
    }

    public void calculateProfitRate(Price price) {
        int profit = lottoResult.entrySet()
            .stream()
            .filter(e -> e.getValue() != 0)
            .mapToInt(e -> e.getKey().getPrize() * e.getValue())
            .sum();

        profitRate = ((float) profit / price.value()) * 100;
    }

    public Map<LottoRank, Integer> getLottoResult() {
        return lottoResult;
    }

    public float getProfitRate() {
        return profitRate;
    }
}
