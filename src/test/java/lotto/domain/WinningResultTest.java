package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.constants.Prize;
import lotto.mock.MockLottoGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WinningResultTest {

    Purchase purchase = new Purchase(4000);
    MockLottoGenerator mockLottoGenerator;

    @BeforeEach
    public void setMockLottoGenerator() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 8, 9)));
        lottos.add(new Lotto(List.of(1, 2, 3, 11, 12, 13)));

        mockLottoGenerator = new MockLottoGenerator(purchase, lottos);
    }

    @Test
    void 작은_수익률_구하기() {
        //given
        Lotto winningNumber = new Lotto(List.of(11, 12, 13, 14, 15, 16));
        Bonus bonus = new Bonus(winningNumber, 20);

        //when
        WinningResult winningResult = new WinningResult(winningNumber, bonus, mockLottoGenerator, purchase);

        //then
        assertThat(winningResult.getWinningCount().get(Prize.FIFTH.getPlace())).isEqualTo(1);
        assertThat(winningResult.getReturnRate()).isEqualTo("125.0");
    }

    @Test
    void 수익률_0_구하기() {
        //given
        Lotto winningNumber = new Lotto(List.of(14, 15, 16, 17, 18, 19));
        Bonus bonus = new Bonus(winningNumber, 20);

        //when
        WinningResult winningResult = new WinningResult(winningNumber, bonus, mockLottoGenerator, purchase);

        //then
        assertThat(winningResult.getReturnRate()).isEqualTo("0.0");
    }

    @Test
    void 큰_수익률_구하기() {
        //given
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Bonus bonus = new Bonus(winningNumber, 7);

        //when
        WinningResult winningResult = new WinningResult(winningNumber, bonus, mockLottoGenerator, purchase);

        //then
        assertThat(winningResult.getWinningCount().get(Prize.FIRST.getPlace())).isEqualTo(1);
        assertThat(winningResult.getWinningCount().get(Prize.SECOND.getPlace())).isEqualTo(1);
        assertThat(winningResult.getWinningCount().get(Prize.FOURTH.getPlace())).isEqualTo(1);
        assertThat(winningResult.getWinningCount().get(Prize.FIFTH.getPlace())).isEqualTo(1);
        assertThat(winningResult.getReturnRate()).isEqualTo("50,751,375.0");
    }

    @Test
    void 소수점_반올림_수익률_구하기() {
        //given
        Purchase curPurchase = new Purchase(3000);
        MockLottoGenerator curMockLottoGenerator = setCurrentLottoGenerator(curPurchase);
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Bonus bonus = new Bonus(winningNumber, 7);

        //when
        WinningResult winningResult = new WinningResult(winningNumber, bonus, curMockLottoGenerator, curPurchase);

        //then
        assertThat(winningResult.getWinningCount().get(Prize.FIFTH.getPlace())).isEqualTo(1);
        assertThat(winningResult.getWinningCount().get(Prize.FOURTH.getPlace())).isEqualTo(1);
        assertThat(winningResult.getReturnRate()).isEqualTo("1,833.3");
    }

    private static MockLottoGenerator setCurrentLottoGenerator(Purchase curPurchase) {
        List<Lotto> curLottos = new ArrayList<>();
        curLottos.add(new Lotto(List.of(11, 12, 13, 14, 15, 16)));
        curLottos.add(new Lotto(List.of(1, 2, 3, 4, 8, 9)));
        curLottos.add(new Lotto(List.of(1, 2, 3, 8, 9, 10)));
        return new MockLottoGenerator(curPurchase, curLottos);
    }
}