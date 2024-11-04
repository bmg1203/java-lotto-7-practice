package lotto.model.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CheckLottoTest {

    private CheckLotto checkLotto;

    @BeforeEach
    void setUp() {
        checkLotto = CheckLotto.create();
    }

    @DisplayName("구매한 로또 번호들 중 3개가 맞으면 3개 카운트가 1씩 올라간다")
    @Test
    void threeMatchedTest() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumbers lottoNumbers = LottoNumbers.
                from(List.of(List.of(1, 2, 3, 7, 8, 9),
                        List.of(7, 8, 9, 10, 11, 14),
                        List.of(15, 16, 17, 18, 22, 45)));

        int bonusNumber = 33;

        // when
        checkLotto.checkLottoNumbers(lottoNumbers, lotto, bonusNumber);

        // then
        assertThat(checkLotto.getThreeMatched())
                .isEqualTo(1);
    }

    @DisplayName("구매한 로또 번호들 중 4개가 맞으면 4개 카운트가 1씩 올라간다")
    @Test
    void fourMatchedTest() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumbers lottoNumbers = LottoNumbers.
                from(List.of(List.of(1, 2, 3, 4, 8, 9),
                        List.of(7, 8, 9, 10, 11, 14),
                        List.of(15, 16, 17, 18, 22, 45)));

        int bonusNumber = 33;

        // when
        checkLotto.checkLottoNumbers(lottoNumbers, lotto, bonusNumber);

        // then
        assertThat(checkLotto.getFourMatched())
                .isEqualTo(1);
    }

    @DisplayName("구매한 로또 번호들 중 5개가 맞으면 5개 카운트가 1씩 올라간다")
    @Test
    void fiveMatchedTest() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumbers lottoNumbers = LottoNumbers.
                from(List.of(List.of(1, 2, 3, 5, 6, 9),
                        List.of(7, 8, 9, 10, 11, 14),
                        List.of(15, 16, 17, 18, 22, 45)));

        int bonusNumber = 33;

        // when
        checkLotto.checkLottoNumbers(lottoNumbers, lotto, bonusNumber);

        // then
        assertThat(checkLotto.getFiveMatched())
                .isEqualTo(1);
    }

    @DisplayName("구매한 로또 번호들 중 5개와 보너스 번호가 맞으면 보너스번호 카운트가 1씩 올라간다")
    @Test
    void bonusMatchedTest() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumbers lottoNumbers = LottoNumbers.
                from(List.of(List.of(1, 2, 3, 4, 5, 33),
                        List.of(7, 8, 9, 10, 11, 14),
                        List.of(15, 16, 17, 18, 22, 45)));

        int bonusNumber = 33;

        // when
        checkLotto.checkLottoNumbers(lottoNumbers, lotto, bonusNumber);

        // then
        assertThat(checkLotto.getBonusMatched())
                .isEqualTo(1);
    }

    @DisplayName("구매한 로또 번호들 중 모두 맞으면 모두 맞음 카운트가 1씩 올라간다")
    @Test
    void allMatchedTest() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumbers lottoNumbers = LottoNumbers.
                from(List.of(List.of(1, 2, 3, 4, 5, 6),
                        List.of(7, 8, 9, 10, 11, 14),
                        List.of(15, 16, 17, 18, 22, 45)));

        int bonusNumber = 33;

        // when
        checkLotto.checkLottoNumbers(lottoNumbers, lotto, bonusNumber);

        // then
        assertThat(checkLotto.getAllMatched())
                .isEqualTo(1);
    }

    @DisplayName("구입 금액과 당첨 금액을 통해 총 수익률을 계산할 수 있다.")
    @Test
    void getEarningRatioTest() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumbers lottoNumbers = LottoNumbers.
                from(List.of(List.of(8, 21, 23, 41, 42, 43),
                        List.of(3, 5, 11, 16, 32, 38),
                        List.of(7, 11, 16, 35, 36, 44),
                        List.of(1, 8, 11, 31, 41, 42),
                        List.of(13, 14, 16, 38, 42, 45),
                        List.of(7, 11, 30, 40, 42, 43),
                        List.of(2, 13, 22, 32, 38, 45),
                        List.of(1, 3, 5, 14, 22, 45)));

        int bonusNumber = 7;

        // when
        checkLotto.checkLottoNumbers(lottoNumbers, lotto, bonusNumber);
        int cost = 8000;

        // then
        assertThat(checkLotto.getEarningRatio(cost))
                .isEqualTo("62.5");
    }

}