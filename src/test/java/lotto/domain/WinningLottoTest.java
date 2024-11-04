package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.Lotto.Lotto;
import lotto.domain.Lotto.LottoFactory;
import lotto.domain.Lotto.LottoNumber;
import lotto.domain.Lotto.WinningLotto;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
    @Test
    void 보너스번호가_당첨번호와_중복되면_예외가_발생한다() {
        // given
        Lotto winningLottoNum = LottoFactory.createManualLotto("1,2,3,4,5,6");
        String bonusNum = "3"; // 중복된 번호

        // when & then
        assertThatThrownBy(() -> new WinningLotto(winningLottoNum,bonusNum))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
