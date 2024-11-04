package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.run.Lotto;
import lotto.run.ResultLotto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "8개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 62.5%입니다."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 구입_금액이_0일_경우_예외_테스트() {
        assertSimpleTest(() -> {
            runException("0");
            assertThat(output()).contains("구입 금액은 1,000원 단위여야 합니다.");
        });
    }

    @Test
    void 구입_금액이_1000의_배수가_아닐_예외_테스트() {
        assertSimpleTest(() -> {
            runException("2222");
            assertThat(output()).contains("구입 금액은 1,000원 단위여야 합니다.");
        });
    }

    @Test
    void 수익률_계산_테스트() {
        assertSimpleTest(() -> {
            long purchaseAmount = 12000;
            List<Lotto> lottos = List.of(
                    new Lotto(List.of(1,2,3,41,15,6)),
                    new Lotto(List.of(11,21,31,41,25,26)),
                    new Lotto(List.of(11,21,31,41,25,26)),
                    new Lotto(List.of(11,21,31,41,25,26)),
                    new Lotto(List.of(11,21,31,41,25,26)),
                    new Lotto(List.of(11,21,31,41,25,26)),
                    new Lotto(List.of(11,21,31,41,25,26)),
                    new Lotto(List.of(11,21,31,41,25,26)),
                    new Lotto(List.of(11,21,31,41,25,26)),
                    new Lotto(List.of(11,21,31,41,25,26)),
                    new Lotto(List.of(11,21,31,41,25,26)),
                    new Lotto(List.of(11,21,31,41,25,26)),
                    new Lotto(List.of(11,21,31,41,25,26))
            );
            List<Integer> winningNumbers = List.of(1,2,3,4,5,34);
            int bonusNumber = 7;
            ResultLotto lottoResults = new ResultLotto(purchaseAmount, lottos, winningNumbers, bonusNumber);
            lottoResults.calResult();
            double expectedValue = 41.7;
            double result = lottoResults.getTotalProfitRate();
            assertThat(result).isEqualTo(expectedValue);
        });
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
