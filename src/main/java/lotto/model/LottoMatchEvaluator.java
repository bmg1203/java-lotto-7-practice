package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoMatchEvaluator {
    private List<LottoResult> lottoResults = new ArrayList<LottoResult>();
    private final List<Integer> lottoWinningCounts = new ArrayList<Integer>();

    public LottoMatchEvaluator(List<Integer> lottoNumber, int bonusNumber, LottoPublisher lottoPublisher) {
        matchLottoNumbers(lottoNumber, bonusNumber, lottoPublisher);
    }

    public void matchLottoNumbers(List<Integer> lottoNumber, int bonusNumber, LottoPublisher lottoPublisher) {
        List<List<Integer>> publishedLottos = lottoPublisher.getPublishedLotto();
        List<Integer> publishedBonus = lottoPublisher.getPublishedBonusLotto();
        boolean matchedBonus = false;

        for (int i = 0; i < publishedLottos.size(); i++) {
            int matchingLottoCount = (int) publishedLottos.get(i).stream().filter(lottoNumber::contains).count();

            if (matchingLottoCount < 3) { //매칭 갯수가 3보다 작으면 당첨권 밖이므로
                continue;
            }
            if (bonusNumber == publishedBonus.get(i)) {
                matchedBonus = true;
            }
            lottoResults.add(new LottoResult(matchingLottoCount, matchedBonus));
        }
    }

    public List<Integer> getLottoWinningCounts() {
        LottoRank[] ranks = LottoRank.values();

        for (int i = 0; i < ranks.length ; i++) {
            int rankMatchingcount = ranks[i].getMatchingCount();
            int lottoWinningCount = (int) lottoResults.stream().filter(lotto -> lotto.getMatchingCount() == rankMatchingcount).count();

            if(ranks[i].getMatchingBonus() == true){
                int bonusWinnigCount = (int) lottoResults.stream().filter(lotto -> lotto.isMatchingBonus() && lotto.getMatchingCount() == rankMatchingcount).count();
                lottoWinningCounts.add(bonusWinnigCount);
                continue;
            }

            lottoWinningCounts.add(lottoWinningCount);
        }
        return lottoWinningCounts;
    }
}
