package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.Rank;
import org.junit.jupiter.api.Test;

class LottoDrawMachineTest {

    @Test
    void 로또_리스트와_당첨_번호를_비교한다() {
        // given
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;
        LottoDrawMachine lottoDrawMachine = new LottoDrawMachine(lottos, winningNumbers, bonus);

        // when
        lottoDrawMachine.compareLottoToWinning();
        Map<Rank, Integer> rankResult = lottoDrawMachine.prizeWinningResult();

        // then
        assertThat(rankResult.get(Rank.FIRST)).isEqualTo(1);
    }

    @Test
    void 당첨번호와_일치하지_않으면_NONE으로_분류한다() {
        // given
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        List<Integer> winningNumbers = List.of(11, 12, 13, 14, 15, 16);
        int bonus = 7;
        LottoDrawMachine lottoDrawMachine = new LottoDrawMachine(lottos, winningNumbers, bonus);

        // when
        lottoDrawMachine.compareLottoToWinning();
        Map<Rank, Integer> rankResult = lottoDrawMachine.prizeWinningResult();

        // then
        assertThat(rankResult.getOrDefault(Rank.NONE, 0)).isEqualTo(1);
        assertThat(rankResult.getOrDefault(Rank.FIRST, 0)).isEqualTo(0);
    }

    @Test
    void 발행한_로또가_1장이고_당첨_결과가_1등인_경우_수익률을_구한다() {
        // given
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;
        LottoDrawMachine lottoDrawMachine = new LottoDrawMachine(lottos, winningNumbers, bonus);

        // when
        lottoDrawMachine.compareLottoToWinning();
        Double earningsRate = lottoDrawMachine.calculateEarningsRate();
        Double result = (double) (Rank.FIRST.price() / 1000);

        // then
        assertThat(earningsRate).isEqualTo(result);
    }

    @Test
    void 발행한_로또가_2장이고_당첨_결과가_1등_2등인_경우_수익률을_구한다() {
        // given
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;
        LottoDrawMachine lottoDrawMachine = new LottoDrawMachine(lottos, winningNumbers, bonus);

        // when
        lottoDrawMachine.compareLottoToWinning();
        Double earningsRate = lottoDrawMachine.calculateEarningsRate();
        Double result = (double) ((Rank.FIRST.price() + Rank.SECOND.price()) / 2000);

        // then
        assertThat(earningsRate).isEqualTo(result);
    }


}