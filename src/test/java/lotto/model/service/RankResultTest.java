package lotto.model.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import lotto.model.domain.BonusBall;
import lotto.model.domain.Lotto;
import lotto.model.domain.Rank;
import lotto.model.domain.WinningBalls;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankResultTest {

    @DisplayName("출력을 올바르게 한다")
    @Test
    void test_1() {
        EnumMap<Rank, Integer> ranks = new EnumMap<>(Rank.class);
        Arrays.stream(Rank.values())
                .forEach(rank -> ranks.put(rank, 0));
        ranks.put(Rank.FIFTH, 1);

        assertThat(new RankResult(ranks).toString()).contains(
                "3개 일치 (5,000원) - 1개",
                "4개 일치 (50,000원) - 0개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 0개"
        );
    }

    @DisplayName("이천원 로또를 사고 당첨금 오천원의 수익률을 반환한다")
    @Test
    void test_2() {
        Lotto userLotto1 = new Lotto(List.of(8, 9, 10, 11, 12, 13));
        Lotto userLotto2 = new Lotto(List.of(1, 2, 3, 43, 44, 45));
        Lottos lottos = new Lottos(List.of(userLotto2, userLotto1));
        WinningBalls winningBalls = new WinningBalls(List.of(1, 2, 3, 4, 5, 6));
        BonusBall bonusBall = BonusBall.of(7, winningBalls);
        RankResult rankResult = lottos.calculateWinningResults(winningBalls, bonusBall);
        Long totalPrice = lottos.getTotalPrice();

        Float returnRate = rankResult.calculateReturnRate(totalPrice);

        assertEquals(250F, returnRate);
    }
}
