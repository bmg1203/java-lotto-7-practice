package lotto.Integration;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoIntegrationTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 통합_테스트_전체_당첨() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,5,20,25,40,45", "7");
                    assertThat(output()).contains(
                            "8개를 구매했습니다.",
                            "[1, 5, 20, 25, 40, 45]",
                            "[1, 5, 20, 25, 40, 44]",
                            "[1, 5, 20, 25, 43, 44]",
                            "[1, 5, 20, 24, 43, 44]",
                            "[1, 5, 23, 24, 43, 44]",
                            "[1, 4, 23, 24, 43, 44]",
                            "[2, 4, 23, 24, 43, 44]",
                            "[1, 5, 20, 25, 40, 7]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 1개",
                            "5개 일치 (1,500,000원) - 1개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 1개",
                            "총 수익률은 25394437.5%입니다."
                    );
                },
                List.of(1, 5, 20, 25, 40, 45),
                List.of(1, 5, 20, 25, 40, 44),
                List.of(1, 5, 20, 25, 43, 44),
                List.of(1, 5, 20, 24, 43, 44),
                List.of(1, 5, 23, 24, 43, 44),
                List.of(1, 4, 23, 24, 43, 44),
                List.of(2, 4, 23, 24, 43, 44),
                List.of(1, 5, 20, 25, 40, 7)
        );
    }

    @Test
    void 통합_테스트_예외_잘못된_단위_금액() {
        assertSimpleTest(() -> {
            runException("1300");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 통합_테스트_예외_잘못된_타입_금액() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 통합_테스트_예외_음수_금액() {
        assertSimpleTest(() -> {
            runException("-1000");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 통합_테스트_예외_당첨_번호_중복() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,5");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 통합_테스트_예외_당첨_번호_개수_다름() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 통합_테스트_예외_당첨_번호_1보다_작음() {
        assertSimpleTest(() -> {
            runException("1000", "0,2,3,4,5,6");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 통합_테스트_예외_당첨_번호_45보다_큼() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,46");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 통합_테스트_예외_당첨_번호_보너스_번호_중복() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "1");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 통합_테스트_예외_보너스_번호_1보다_작음() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "0");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 통합_테스트_예외_보너스_번호_45보다_큼() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "46");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
