package lotto.domain;

import lotto.enums.LottoPrice;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoPriceMapTest {
    @Test
    void prizes_초기화_테스트() {
        Map<String, Integer> prizes = new LinkedHashMap<>();
        prizes.put("3개 일치", LottoPrice.THREE_WINNING_PRICE.getPrice());
        prizes.put("4개 일치", LottoPrice.FOUR_WINNING_PRICE.getPrice());
        prizes.put("5개 일치", LottoPrice.FIVE_WINNING_PRICE.getPrice());
        prizes.put("5개 일치, 보너스 볼 일치", LottoPrice.FIVE_WINNING_WITH_BONUS_PRICE.getPrice());
        prizes.put("6개 일치", LottoPrice.SIX_WINNING_PRICE.getPrice());

        LottoPriceMap lottoPriceMap = new LottoPriceMap();

        assertEquals(prizes, lottoPriceMap.getPrizes());
    }
}