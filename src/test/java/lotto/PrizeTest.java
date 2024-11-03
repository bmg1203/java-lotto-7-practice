package lotto;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class PrizeTest {

    private final KoreaPrizeChecker koreaPrizeChecker = new KoreaPrizeChecker();

    @DisplayName("6개 일치")
    @Test
    void 당첨_번호와_로또_번호가_6개_일치하는_경우() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        WinningStatus result = koreaPrizeChecker.checkPrize(lotto, winningLotto);

        assertThat(result).isEqualTo(WinningStatus.first);

    }

    @DisplayName("5개 일치, 보너스 볼 일치")
    @Test
    void 당첨_번호와_로또_번호가_5개_보너스번호1개_일치하는_경우() {

    }

    @DisplayName("5개 일치")
    @Test
    void 당첨_번호와_로또_번호가_5개_일치하는_경우() {

    }

    @DisplayName("4개 일치")
    @Test
    void 당첨_번호와_로또_번호가_4개_일치하는_경우() {

    }

    @DisplayName("3개 일치")
    @Test
    void 당첨_번호와_로또_번호가_3개_일치하는_경우() {

    }
}
