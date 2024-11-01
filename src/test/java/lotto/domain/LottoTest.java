package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.constant.RankPrice;
import lotto.util.RandomUtil;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_내역을_계산한다() {
        List<Integer> winningLottoNumbers = RandomUtil.getLottoNumbers();
        List<Integer> numbers = new ArrayList<>();
        numbers.addAll(winningLottoNumbers);
        numbers.removeLast();
        numbers.add(0);
        Lotto lotto = new Lotto(numbers);
        WinningLotto winningLotto = new WinningLotto(new Lotto(winningLottoNumbers));
        winningLotto.setupBonusNumber(46);
        RankPrice rankPrice = winningLotto.getRank(lotto);
        assertThat(rankPrice.getRank()).isEqualTo(3);
    }

    @Test
    void 수익률을_계산한다() {
        Wallet wallet = new Wallet(5000);
        wallet.buyLottoTickets();
        wallet.addRank(RankPrice.THIRD);
        assertThat(wallet.gain()).isEqualTo((double) 1_500_000 / 5_000 );
    }
}
