package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    @DisplayName("로또 당첨 랭크를 성공적으로 반환 한다.")
    @Test
    void matchWithLottoTest() {
        //given
        final Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        final BonusNumber bonusNumber = new BonusNumber(7);
        final Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        final Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 8));

        //when
        final WinningNumbers winningNumbers = new WinningNumbers(winningLotto, bonusNumber);
        final LottoRank lottoRank1 = winningNumbers.matchWithLotto(lotto1);
        final LottoRank lottoRank2 = winningNumbers.matchWithLotto(lotto2);

        //then
        assertAll(
                () -> assertThat(lottoRank1).isEqualTo(LottoRank.RANK_2),
                () -> assertThat(lottoRank2).isEqualTo(LottoRank.RANK_3)
        );
    }
}
