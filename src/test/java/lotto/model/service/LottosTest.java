package lotto.model.service;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.model.domain.BonusBall;
import lotto.model.domain.Lotto;
import lotto.model.domain.Rank;
import lotto.model.domain.WinningBalls;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @DisplayName("로또 6개를 산다")
    @Test
    void take6Lottos() {
        Lottos lottos = Lottos.from(6L);
        assertEquals(6, lottos.getSize());
    }

    //테스트를 위해 lotto의 생성자 private -> public
    @DisplayName("로또들의 일치결과를 알려준다.")
    @Test
    void test_2() {
        Lotto userLotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto userLotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 45));
        Lottos lottos = new Lottos(List.of(userLotto2, userLotto1));
        WinningBalls winningBalls = new WinningBalls(List.of(1, 2, 3, 4, 5, 6));
        BonusBall bonusBall = BonusBall.of(7, winningBalls);

        RankResult rankResult = lottos.calculateWinningResults(winningBalls, bonusBall);

        assertEquals(1, rankResult.getMatchCount(Rank.SECOND));
        assertEquals(1, rankResult.getMatchCount(Rank.THIRD));
    }
}
