package lotto.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.BonusBall;
import lotto.domain.Lotto;
import lotto.domain.PurchasedLottos;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.util.ErrorMessage;
import lotto.util.NumberGenerate;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoMachineTest {

    private final int money = 1000;
    private final NumberGenerate numberGenerate = new LottoGeneratorTest();
    private final LottoMachine lottoMachine = new LottoMachine(numberGenerate);

    @ParameterizedTest
    @ValueSource(ints = {1100, 1200, 2600, 2040, 2003})
    void 돈_천원_단위가_아닌_입력(int money) {
        // given
        // when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> lottoMachine.issueLotto(money));

        // then
        Assertions.assertThat(e.getMessage()).isEqualTo(ErrorMessage.MONEY_IS_NOT_MOD_PRICE.getMsg());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -30, -1000, -1500, -2000})
    void 돈_0_이하_입력(int money) {
        // given
        // when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> lottoMachine.issueLotto(money));

        // then
        Assertions.assertThat(e.getMessage()).isEqualTo(ErrorMessage.NOT_NUMBER.getMsg());
    }


    @Test
    void 랜덤_값_테스트() {
        // given
        List<Integer> expect = numberGenerate.randomGenerateInRange();

        // when
        PurchasedLottos purchasedLottos = lottoMachine.issueLotto(money);
        List<Lotto> lottos = purchasedLottos.getLottos();

        // then
        for (Lotto lotto : lottos) {
            Assertions.assertThat(lotto.numbers()).isEqualTo(expect);
        }
    }

    @ParameterizedTest
    @MethodSource("lottoArgsGenerate")
    void 로또_1개_당첨_테스트(List<Integer> numbers, int bonus, Rank win) {
        // given
        PurchasedLottos purchasedLottos = lottoMachine.issueLotto(money);
        WinningLotto winningLotto = winningLottoMake(numbers, bonus);

        // when
        LottoResult lottoResult = lottoMachine.winLotto(purchasedLottos, winningLotto);

        // then
        Assertions.assertThat(lottoResult.calculateProfit(money))
                .isEqualTo(((double) win.getPrize() / money) * 100.0);
    }

    private static Stream<Arguments> lottoArgsGenerate() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 20, 34, 5, 4, 3), 5, Rank.NO5),
                Arguments.of(Arrays.asList(1, 20, 34, 42, 4, 3), 5, Rank.NO4),
                Arguments.of(Arrays.asList(1, 20, 34, 42, 32, 3), 5, Rank.NO3),
                Arguments.of(Arrays.asList(1, 20, 34, 42, 32, 3), 6, Rank.NO2),
                Arguments.of(Arrays.asList(1, 20, 34, 42, 32, 6), 5, Rank.NO1)
        );
    }

    private WinningLotto winningLottoMake(List<Integer> numbers, int bonus) {
        Lotto lotto = new Lotto(numbers);
        BonusBall bonusBall = new BonusBall(bonus);
        return new WinningLotto(lotto, bonusBall);
    }


}