package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoWinningResultTest {

    @Test
    void 총_획득_상금_반환() {
        //given
        LottoWinningResult lottoWinningResult = new LottoWinningResult();
        lottoWinningResult.increment(WinningPrize.THIRD);
        lottoWinningResult.increment(WinningPrize.FIFTH);
        //when
        int totalPrize = lottoWinningResult.getTotalPrize();
        //then
        Assertions.assertThat(totalPrize).isEqualTo(WinningPrize.THIRD.getPrize()+WinningPrize.FIFTH.getPrize());
    }
}