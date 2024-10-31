package lotto.model;

import java.util.List;
import lotto.common.ErrorMessage;
import lotto.dto.InputMoneyDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoSellerTest {

    private LottoSeller lottoSeller;

    @BeforeEach
    void init(){
        lottoSeller = new LottoSeller();
    }
    @Test
    void 로또_구입_금액은_1000원_단위이다(){
        long money = 10000;
        List<Lotto> lottos = lottoSeller.sell(InputMoneyDTO.from(money));
        Assertions.assertThat(lottos.size()).isEqualTo(money / LottoSeller.SELL_UNIT);
    }

    @ParameterizedTest
    @ValueSource(longs = {1200, 800, 1004})
    void 로또_구입_금액이_아닐_경우_예외가_발생한다(long money){
        Assertions.assertThatThrownBy(() -> lottoSeller.sell(InputMoneyDTO.from(money)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INPUT_MONEY_IS_MULTIPLE_1000.getMessage());
    }
}