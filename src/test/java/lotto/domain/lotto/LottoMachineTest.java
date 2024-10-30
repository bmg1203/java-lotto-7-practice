package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.fake.FakeNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoMachineTest {

    LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        FakeNumberGenerator fakeNumberGenerator = new FakeNumberGenerator();
        fakeNumberGenerator.numbers = List.of(1, 2, 3, 4, 5, 6);
        lottoMachine = new LottoMachine(fakeNumberGenerator);
    }

    @Test
    @DisplayName("1개의 로또를 발급한다.")
    void givenOneCount_whenIssueLottos_thenSizeIsOne() {
        // given
        int count = 1;

        // when
        List<Lotto> lottos = lottoMachine.issueLottos(count);

        // then
        assertThat(lottos.size()).isOne();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("0개 미만 로또 요청시 빈 리스트를 반환한다.")
    void givenNegativeCount_whenIssueLottos_thenEmptyList(int count) {
        // given
        // when
        List<Lotto> lottos = lottoMachine.issueLottos(count);

        // then
        assertThat(lottos).isEmpty();
    }

    @Test
    @DisplayName("여러 개의 로또를 발급한다.")
    void givenMultipleCount_whenIssueLottos_thenSizeMatchesCount() {
        // given
        int count = 5;

        // when
        List<Lotto> lottos = lottoMachine.issueLottos(count);

        // then
        assertThat(lottos).hasSize(count);
    }

}