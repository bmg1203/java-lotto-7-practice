package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@SuppressWarnings("NonAsciiCharacters")
class LottoPriceTest {

    @ParameterizedTest
    @CsvSource({
            "3, false, 5000",
            "4, false, 50000",
            "5, false, 1500000",
            "5, true, 30000000",
            "6, false, 2000000000",
    })
    void 유효한_등수는_당첨금을_반환한다(int lottoCount, boolean isBonus, int expected) {
        // when
        int actual = LottoPrice.getByLottoCount(lottoCount, isBonus);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
            "1, false, 0",
            "2, false, 0",
            "7, true, 0",
    })
    void 유효하지_않은_등수는_0원을_반환한다(int lottoCount, boolean isBonus, int expected) {
        // when
        int actual = LottoPrice.getByLottoCount(lottoCount, isBonus);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
