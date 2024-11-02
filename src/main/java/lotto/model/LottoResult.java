package lotto.model;

import java.util.EnumMap;
import java.util.List;
import lotto.enums.LottoWinInfo;

public class LottoResult {
    private final EnumMap<LottoWinInfo, Integer> lottoWinCount = new EnumMap<>(LottoWinInfo.class);

    {
        for (LottoWinInfo lottoWinInfo : LottoWinInfo.values()) {
            lottoWinCount.put(lottoWinInfo, 0);
        }
    }

    public LottoResult(final LottoDraw lottoDraw, final List<Lotto> lottoTickets, final Integer payment) {
        countWinningLottoTickets(lottoDraw.getDrawNumbers(), lottoDraw.getBonusNumber(), lottoTickets);
    }

    private void countWinningLottoTickets(final LottoNumbers drawNumbers, final Integer bonusNumber,
                                          final List<Lotto> lottoTickets) {
        for (Lotto lotto : lottoTickets) {
            LottoWinInfo lottoWinInfo = getLottoWinInfo(drawNumbers, bonusNumber, lotto);
            if (lottoWinInfo != null) {
                lottoWinCount.put(lottoWinInfo, lottoWinCount.get(lottoWinInfo) + 1);
            }
        }
    }

    private LottoWinInfo getLottoWinInfo(final LottoNumbers drawNumbers, final Integer bonusNumber, final Lotto lotto) {
        int numberMatchCount = lotto.getNumberMatchCount(drawNumbers);
        boolean hasBonusNumber = lotto.hasBonusNumber(bonusNumber);
        return LottoWinInfo.getLottoWinInfo(numberMatchCount, hasBonusNumber).orElse(null);
    }

    public EnumMap<LottoWinInfo, Integer> getLottoWinCount() {
        return lottoWinCount;
    }
}
