package lotto;

import lotto.constant.LottoConfig;
import lotto.constant.LottoConfig.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPrizeTest {

    private Lotto lotto;
    private Bonus bonus;
    private LottoPrize lottoPrize;
    private List<Lotto> tickets = new ArrayList<>();

    @BeforeEach
    void setUp(){
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        bonus = new Bonus(7);
        lottoPrize = new LottoPrize(lotto, bonus);

        tickets.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        tickets.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        tickets.add(new Lotto(List.of(1, 2, 3, 4, 5, 8)));
        tickets.add(new Lotto(List.of(1, 2, 3, 4, 8, 9)));
        tickets.add(new Lotto(List.of(1, 2, 3, 7, 8, 9)));
        tickets.add(new Lotto(List.of(1, 2, 7, 8, 9, 10)));
        tickets.add(new Lotto(List.of(1, 7, 8, 9, 10,11)));
        tickets.add(new Lotto(List.of(8, 9, 10, 11, 12, 13)));
    }

    @Test
    void rankLotto() {
        Lottos lottos = new Lottos(tickets);
        Map<Rank, Integer> rankCount = lottoPrize.determineLottoPrizes(lottos);

        assertThat(rankCount).containsEntry(Rank.FIRST, 1);
        assertThat(rankCount).containsEntry(Rank.SECOND, 1);
        assertThat(rankCount).containsEntry(Rank.THIRD, 1);
        assertThat(rankCount).containsEntry(Rank.FOURTH, 1);
        assertThat(rankCount).containsEntry(Rank.FIFTH, 1);
        assertThat(rankCount).containsEntry(Rank.NOTHING, 3);
    }

    @Test
    void 수익률을_계산한다() {
        Lottos lottos = new Lottos(tickets);
        Map<Rank, Integer> rankCount = lottoPrize.determineLottoPrizes(lottos);
        Purchase purchase = new Purchase(10000);

        Double rateOfReturn = lottoPrize.calculateRateOfReturn(rankCount, purchase);
        assertThat(rateOfReturn).isEqualTo(20_315_550.0);
    }
}