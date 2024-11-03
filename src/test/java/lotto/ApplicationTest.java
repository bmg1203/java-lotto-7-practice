package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
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
    void 입력_테스트() {
        assertSimpleTest(() -> {
            run("1000000","1,2,3,4,5,6","12");
        });
    }

    @DisplayName("예외가 발생하면 값을 다시 받아야한다.")
    @Test
    void 예외_발생_없을때까지_값_받기() {
        assertSimpleTest(() -> {
            run("40","100000","1,2,3,4,5,6","12");
        });
    }

    @DisplayName("보너스번호 혹은 당첨번호 입력에서 예외가 발생해도 재입력을 받는다.")
    @Test
    void 보너스번호_혹은_당첨번호_예외발생시_재입력() {
        assertSimpleTest(() -> {
            run("10000","1,2,400,4,5,6","1,2,3,4,5,6","10");
        });
    }

    @DisplayName("보너스 번호와 당첨번호가 같으면 예외 발생 후 보너스번호를 다시 입력받는다.")
    @Test
    void 보너스_당첨_번호가_같으면_재입력() {
        assertSimpleTest(() -> {
            run("100000","1,2,3,4,5,6","6","7");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
