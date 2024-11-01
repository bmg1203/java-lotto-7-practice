package lotto.application.out;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorPortTest {

    private final LottoGeneratorPort lottoGeneratorPort;

    public LottoGeneratorPortTest() {
        /* Todo: 추후 구현체로 변경 */
        lottoGeneratorPort = null;
    }

    @Test
    @DisplayName("생성된 로또 번호는 6자리이다.")
    void 생성된_로또_번호는_6자리이다() {
        // When
        Lotto generated = lottoGeneratorPort.generate();

        // Then
        assertThat(generated).isNotNull();
        assertThat(generated.getNumbers()).hasSize(6);
    }

    @Test
    @DisplayName("생성된 로또 번호는 겹치지 않는다.")
    void 생성된_로또_번호는_겹치지_않는다() {
        // When
        Lotto generated = lottoGeneratorPort.generate();

        // Then
        assertThat(generated).isNotNull();
        assertThat(generated.getNumbers()).hasSameSizeAs(Set.copyOf(generated.getNumbers()));
    }
}