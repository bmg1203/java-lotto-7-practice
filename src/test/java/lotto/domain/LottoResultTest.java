package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @Test
    @DisplayName("당첨 번호와 로또 번호를 비교하여 당첨 결과를 순서대로 반환한다")
    void calculateResults() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        LottoResult lottoResult = new LottoResult(winningNumbers, bonusNumber);

        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),  // 1등
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),  // 2등 (5개 일치 + 보너스 번호 일치)
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)),  // 3등 (5개 일치)
                new Lotto(Arrays.asList(1, 2, 3, 4, 10, 11)), // 4등 (4개 일치)
                new Lotto(Arrays.asList(1, 2, 3, 9, 10, 11))  // 5등 (3개 일치)
        );

        String result = lottoResult.calculateResults(lottos);
        assertThat(result).containsSubsequence(
                "3개 일치 (5,000원) - 1개",
                "4개 일치 (50,000원) - 1개",
                "5개 일치 (1,500,000원) - 1개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                "6개 일치 (2,000,000,000원) - 1개"
        );
    }
}