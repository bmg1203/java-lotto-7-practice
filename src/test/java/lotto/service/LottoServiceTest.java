package lotto.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoServiceTest {
    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @Test
    void 구입금액_정상_입력_테스트() {
        assertThat(lottoService.calculateLottoCount("1000")).isEqualTo(1);
        assertThat(lottoService.calculateLottoCount("8000")).isEqualTo(8);
        assertThat(lottoService.calculateLottoCount("15000")).isEqualTo(15);
    }

    @ParameterizedTest
    @ValueSource(strings = { "100", "1500", "-1", "천원", "", " ", "0", "12345678000" })
    void 정상_입력이_아니면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> lottoService.calculateLottoCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}