package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("당첨 정보 확인 테스트")
class RankCalculatorTest {
    private RankCalculator rankCalculator;

    @BeforeEach
    void setUp() {
        this.rankCalculator = new RankCalculator();
    }

    @Test
    @DisplayName("구입한 로또와 당첨번호가 몇 개 일치하는지 확인하는 테스트")
    void compareLottos() {
        WinningNumber winningNumber = createWinningNumber(List.of(1, 2, 3, 4, 5, 6), 45);
        List<Lotto> lottos = createTestLottos();
        assertThat(rankCalculator.compareLottos(lottos, winningNumber))
                .containsExactly(Rank.FIRST, Rank.THIRD, Rank.FOURTH, Rank.FIFTH, Rank.MISS);
    }

    private List<Lotto> createTestLottos() {
        return List.of(
                Lotto.createUserLotto(List.of(1, 2, 3, 4, 5, 6)),
                Lotto.createUserLotto(List.of(1, 2, 3, 4, 5, 7)),
                Lotto.createUserLotto(List.of(1, 2, 3, 4, 7, 8)),
                Lotto.createUserLotto(List.of(1, 2, 3, 7, 8, 9)),
                Lotto.createUserLotto(List.of(1, 2, 7, 8, 9, 10))
        );
    }

    private WinningNumber createWinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        return new WinningNumber(Lotto.createWinningLotto(winningNumbers), new BonusNumber(bonusNumber));
    }

    @Test
    @DisplayName("보너스 번호와 로또가 일치하는지 확인하는 테스트")
    void compareBonusNumber() {
        WinningNumber winningNumber = createWinningNumber(List.of(2, 3, 4, 5, 7, 8), 6);
        WinningNumber winningNumber2 = createWinningNumber(List.of(2, 3, 4, 5, 6, 8), 7);

        assertThat(rankCalculator.checkBonusNumber(
                Lotto.createUserLotto(List.of(1, 2, 3, 4, 5, 6)), winningNumber)).isTrue();
        assertThat(rankCalculator.checkBonusNumber(
                Lotto.createUserLotto(List.of(1, 2, 3, 4, 5, 6)), winningNumber2)).isFalse();
    }

    @Test
    @DisplayName("일치하는 개수에 따라 올바른 등수를 나타내는지 확인하는 테스트")
    void confirmLottoRank() {
        assertThat(rankCalculator.determineRank(2, true)).isEqualTo(Rank.MISS);
        assertThat(rankCalculator.determineRank(3, true)).isEqualTo(Rank.FIFTH);
        assertThat(rankCalculator.determineRank(4, true)).isEqualTo(Rank.FOURTH);
        assertThat(rankCalculator.determineRank(5, false)).isEqualTo(Rank.THIRD);
        assertThat(rankCalculator.determineRank(5, true)).isEqualTo(Rank.SECOND);
        assertThat(rankCalculator.determineRank(6, true)).isEqualTo(Rank.FIRST);
    }

    @Test
    @DisplayName("등수 리스트를 받아서 당첨 개수를 제대로 나타내는지 확인하는 테스트")
    void checkRankingCount() {
        Map<Rank, Integer> test1 = rankCalculator.finalRank(List.of(
                Rank.FIFTH, Rank.FIFTH, Rank.FIFTH, Rank.FIFTH, Rank.MISS
        ));
        assertThat(test1)
                .containsEntry(Rank.FIFTH, 4)
                .containsEntry(Rank.MISS, 1);

        Map<Rank, Integer> test2 = rankCalculator.finalRank(List.of(
                Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.FIFTH, Rank.MISS
        ));
        assertThat(test2)
                .containsEntry(Rank.FIFTH, 2)
                .containsEntry(Rank.FOURTH, 1)
                .containsEntry(Rank.THIRD, 1)
                .containsEntry(Rank.MISS, 1);
    }
}