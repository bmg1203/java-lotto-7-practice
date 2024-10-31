package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    private LottoResult lottoResult;
    private List<Lotto> purchasedLotto;
    private List<Integer> winNumbers;
    private int bonusNumber;

    @BeforeEach
    void init() {
        lottoResult = new LottoResult();

        purchasedLotto = new ArrayList<>();
        purchasedLotto.add(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))));
        purchasedLotto.add(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7))));
        purchasedLotto.add(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 45))));
        purchasedLotto.add(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 44, 45))));
        purchasedLotto.add(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 43, 44, 45))));
        purchasedLotto.add(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 42, 43, 44, 45))));

        winNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        bonusNumber = 7;
    }

    @DisplayName("발행된 로또들과 당첨 번호를 비교한다.")
    @Test
    void 발행된_로또들과_당첨_번호_비교() {
        lottoResult.calculateLottoResult(purchasedLotto, winNumbers, bonusNumber);

        Map<LottoRank, Integer> calculatedResult = lottoResult.getLottoResult();
        Assertions.assertThat(calculatedResult.values()).containsExactly(1, 1, 1, 1, 1);
    }

    @DisplayName("로또 당첨 결과에 따른 수익률을 계산한다.")
    @Test
    void 로또_당첨_결과에_따른_수익률_계산() {
        lottoResult.calculateLottoResult(purchasedLotto, winNumbers, bonusNumber);
        lottoResult.calculateProfitRate(6_000);
        float profitRate = lottoResult.getProfitRate();
        Assertions.assertThat(profitRate).isEqualTo(33859250);
    }


}