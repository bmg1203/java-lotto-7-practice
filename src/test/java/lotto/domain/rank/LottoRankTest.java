package lotto.domain.rank;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@SuppressWarnings("NonAsciiCharacters")
class LottoRankTest {

    @ParameterizedTest
    @CsvSource({
            "3, false",
            "4, false",
            "5, true",
            "6, false"
    })
    void 로또_등수_및_보너스_값을_확인한다(int lottoCount, boolean isBonus) {
        // given
        LottoRank lottoRank = new LottoRank(lottoCount, isBonus);

        // then
        assertThat(lottoRank.getLottoCount()).isEqualTo(lottoCount);
        assertThat(lottoRank.getPrice()).isEqualTo(lottoCount);
    }

    @ParameterizedTest
    @CsvSource({
            "1, true, 0",
            "3, false, 3000",
            "4, false, 50000",
            "5, false, 1500000",
            "5, true, 30000000",
            "6, false, 2000000000"})
    void 로또_당첨에_개수에_따라_상금이_달라진다(int lottoCount, boolean isBonus, int lottoPrice) {
        // given
        LottoRank lottoRank = new LottoRank(lottoCount, isBonus);

        // when
        int actual = lottoRank.getPrice();

        // then
        assertThat(actual).isEqualTo(lottoPrice);
    }
}
