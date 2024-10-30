package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class JackpotLottoTest {

    @Test
    void 당첨_로또_번호와_보너스_번호가_같으면_예외가_발생한다() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoBonusNumber bonusNumber = new LottoBonusNumber(1);

        //when
        assertThatThrownBy(() -> new JackpotLotto(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("발매_로또_및_일치_개수")
    void 당첨_로또_번호와_발매한_로또를_비교해서_일치하는_개수_반환(Lotto issueLotto, long expectedMatchCount) {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoBonusNumber bonusNumber = new LottoBonusNumber(7);
        JackpotLotto jackpotLotto = new JackpotLotto(lotto, bonusNumber);

        //when
        long matchCount = jackpotLotto.getMatchCount(issueLotto);

        //then
        assertThat(matchCount).isEqualTo(expectedMatchCount);
    }

    @Test
    void 발매한_로또에_보너스_번호가_존재하는지_여부_반환() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoBonusNumber bonusNumber = new LottoBonusNumber(7);
        JackpotLotto jackpotLotto = new JackpotLotto(lotto, bonusNumber);

        Lotto issueLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        //when
        boolean isMatchBonusNumber = jackpotLotto.isMatchBonusNumber(issueLotto);

        //then
        assertThat(isMatchBonusNumber).isTrue();
    }

    @ParameterizedTest
    @MethodSource("발매_로또_및_순위_반환")
    void 당첨_로또_순위_반환(Lotto issueLotto, LottoRank expectedLottoRank) {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoBonusNumber bonusNumber = new LottoBonusNumber(7);
        JackpotLotto jackpotLotto = new JackpotLotto(lotto, bonusNumber);

        //when
        LottoRank rank = jackpotLotto.findRank(issueLotto);

        //then
        assertThat(rank).isEqualTo(expectedLottoRank);
    }

    static Stream<Arguments> 발매_로또_및_일치_개수() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 6),
                Arguments.of(new Lotto(List.of(11, 2, 3, 4, 5, 6)), 5),
                Arguments.of(new Lotto(List.of(11, 12, 3, 4, 5, 6)), 4),
                Arguments.of(new Lotto(List.of(11, 12, 13, 4, 5, 6)), 3),
                Arguments.of(new Lotto(List.of(11, 12, 13, 14, 5, 6)), 2),
                Arguments.of(new Lotto(List.of(11, 12, 13, 14, 15, 6)), 1),
                Arguments.of(new Lotto(List.of(11, 12, 13, 14, 15, 16)), 0)
        );
    }

    static Stream<Arguments> 발매_로또_및_순위_반환() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), LottoRank.FIRST),
                Arguments.of(new Lotto(List.of(7, 2, 3, 4, 5, 6)), LottoRank.SECOND), // 보너스 번호 : 7
                Arguments.of(new Lotto(List.of(11, 2, 3, 4, 5, 6)), LottoRank.THIRD),
                Arguments.of(new Lotto(List.of(11, 12, 3, 4, 5, 6)), LottoRank.FOURTH),
                Arguments.of(new Lotto(List.of(11, 12, 13, 4, 5, 6)), LottoRank.FIFTH),
                Arguments.of(new Lotto(List.of(11, 12, 13, 14, 5, 6)), LottoRank.NO_RANK),
                Arguments.of(new Lotto(List.of(11, 12, 13, 14, 15, 6)), LottoRank.NO_RANK),
                Arguments.of(new Lotto(List.of(11, 12, 13, 14, 15, 16)), LottoRank.NO_RANK)
        );
    }
}
