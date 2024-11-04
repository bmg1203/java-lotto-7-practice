package lotto.service;

import lotto.domain.model.lotto.Lotto;
import lotto.domain.model.winning.WinningNumbers;
import lotto.domain.model.winning.WinningResult;
import lotto.domain.model.winning.Rank;
import lotto.domain.model.bonus.BonusNumber;
import lotto.domain.model.winning.WinningContext;
import lotto.exception.lotto.LottoErrorMessages;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

public class LottoApplicationServiceImplTest {
    private LottoApplicationServiceImpl lottoService;
    private WinningNumbers winningNumbers;
    private BonusNumber bonusNumber;
    private WinningContext context;

    @BeforeEach
    void setUp() {
        lottoService = new LottoApplicationServiceImpl();
        winningNumbers = new WinningNumbers("8,21,15,33,40,42");
        bonusNumber = new BonusNumber("7", winningNumbers.getNumbers());
        context = new WinningContext(winningNumbers, bonusNumber);
    }

    @Test
    @DisplayName("로또 구입 금액이 공백일 경우 예외가 발생한다.")
    void 로또_구입_금액이_공백일_경우_예외가_발생한다() {
        String invalidAmount = "";

        assertThatNullPointerException()
                .isThrownBy(() -> lottoService.validateAmount(invalidAmount))
                .withMessage(LottoErrorMessages.INVALID_AMOUNT_EMPTY.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1000", "1000j"})
    @DisplayName("로또 구입 금액이 음수이거나 문자인 경우 IllegalArgumentException이 발생한다.")
    void 로또_구입_금액이_음수_또는_문자인_경우_예외가_발생한다(String invalidAmount) {
        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoService.validateAmount(invalidAmount))
                .withMessage(LottoErrorMessages.INVALID_AMOUNT_NON_NUMERIC.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"800", "2500"})
    @DisplayName("로또 구입 금액이 1,000원 단위가 아닌 경우 IllegalArgumentException이 발생한다.")
    void 로또_구입_금액이_1000원_단위가_아닌_경우_예외가_발생한다(String invalidAmount) {
        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoService.validateAmount(invalidAmount))
                .withMessage(LottoErrorMessages.INVALID_AMOUNT_NOT_DIVISIBLE_BY_1000.getMessage());
    }

    @Test
    @DisplayName("로또 구입 금액이 정상 입력된 경우 true를 반환한다.")
    void 로또_구입_금액이_정상_입력된_경우_true를_반환한다() {
        // given
        String validAmount = "3000";

        // when
        boolean result = lottoService.validateAmount(validAmount);

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("로또 번호가 1부터 45 사이의 범위를 벗어나지 않는지 검증한다.")
    void 로또_번호_범위_검증() {
        // given
        int testIterations = 1000;

        // when, then
        for (int i = 0; i < testIterations; i++) {
            Lotto lotto = lottoService.generateLottos(1000).get(0);
            assertThat(lotto.getNumbers()).allMatch(num -> num >= 1 && num <= 45);
        }
    }

    @Test
    @DisplayName("발행한 로또 번호가 오름차순으로 정렬되어 있는지 확인한다.")
    void 로또_번호_오름차순_정렬_확인() {
        // given
        List<Integer> originalNumbers = List.of(40, 8, 15, 33, 21, 42);

        // when
        List<Integer> lottoNumbers = new Lotto(originalNumbers).getNumbers();
        List<Integer> sortedNumbers = new ArrayList<>(originalNumbers);
        Collections.sort(sortedNumbers);

        // then
        assertThat(lottoNumbers).isEqualTo(sortedNumbers);
    }

    @Test
    @DisplayName("수익률 계산이 소수점 둘째 자리에서 정확히 반올림되는지 검증한다.")
    void 수익률_소수점_반올림_검증() {
        // given
        int totalPrize = 1500;
        int amount = 1000;

        // when
        double earningsRate = lottoService.calculateEarningsRate(totalPrize, amount);

        // then
        assertThat(earningsRate).isEqualTo(150.0);
    }

    @Test
    @DisplayName("6개 번호가 모두 일치하면 1등이어야 한다.")
    void 모든_번호_일치_1등() {
        // given
        Lotto lotto = new Lotto(List.of(8, 21, 15, 33, 40, 42));

        // when
        WinningResult result = lottoService.result(List.of(lotto), context);

        // then
        assertThat(result.getRankCounts().get(Rank.FIRST)).isEqualTo(1);
    }

    @Test
    @DisplayName("5개 번호와 보너스 번호가 일치하면 2등이어야 한다.")
    void 다섯_번호_보너스_일치_2등() {
        // given
        Lotto lotto = new Lotto(List.of(8, 21, 15, 33, 40, 7));

        // when
        WinningResult result = lottoService.result(List.of(lotto), context);

        // then
        assertThat(result.getRankCounts().get(Rank.SECOND)).isEqualTo(1);
    }

    @Test
    @DisplayName("5개 번호만 일치하면 3등이어야 한다.")
    void 다섯_번호_일치_3등() {
        // given
        Lotto lotto = new Lotto(List.of(8, 21, 15, 33, 40, 43));

        // when
        WinningResult result = lottoService.result(List.of(lotto), context);

        // then
        assertThat(result.getRankCounts().get(Rank.THIRD)).isEqualTo(1);
    }

    @Test
    @DisplayName("4개 번호가 일치하면 4등이어야 한다.")
    void 네_번호_일치_4등() {
        // given
        Lotto lotto = new Lotto(List.of(8, 21, 15, 33, 44, 45));

        // when
        WinningResult result = lottoService.result(List.of(lotto), context);

        // then
        assertThat(result.getRankCounts().get(Rank.FOURTH)).isEqualTo(1);
    }

    @Test
    @DisplayName("3개 번호가 일치하면 5등이어야 한다.")
    void 세_번호_일치_5등() {
        // given
        Lotto lotto = new Lotto(List.of(8, 21, 15, 34, 44, 45));

        // when
        WinningResult result = lottoService.result(List.of(lotto), context);

        // then
        assertThat(result.getRankCounts().get(Rank.FIFTH)).isEqualTo(1);
    }

    @Test
    @DisplayName("2개 이하의 번호가 일치하면 당첨되지 않는다.")
    void 두_번호_이하_일치_꽝() {
        // given
        Lotto lotto = new Lotto(List.of(8, 21, 16, 34, 44, 45));

        // when
        WinningResult result = lottoService.result(List.of(lotto), context);

        // then
        assertThat(result.getRankCounts().get(Rank.NO_WIN)).isEqualTo(1);
    }
}