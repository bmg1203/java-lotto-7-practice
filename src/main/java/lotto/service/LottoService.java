package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class LottoService {

    // 당첨 통계 설정
    public void setWinningLottoCount(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            int winningNumberCount = lotto.getWinningNumberCount(lottos.getInputLottoNumbers(),
                    lottos.getBonusNumber());
            lottos.countUp(winningNumberCount);
        }
    }

    // 수익률 계산
    public double getRateOfReturn(Lottos lottos, int price) {
        int[] counts = lottos.getWinningLottoCounts();

        long sum = counts[3] * 5000L + counts[4] * 50000L + counts[5] * 1500000L + counts[7] * 30000000L
                + counts[6] * 2000000000L;

        double rateOfReturn = (double) sum / price;

        return Math.round(rateOfReturn * 100 * 100) / 100.0; // 소수점 둘째 자리에서 반올림
    }

    public void addLotto(Lottos lottos, int price) {
        for (int i = 0; i < price / 1000; i++) {
            List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(lotto));
        }
    }

}
