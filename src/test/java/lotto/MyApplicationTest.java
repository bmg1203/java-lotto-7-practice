package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import lotto.constants.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MyApplicationTest extends NsTest {

    @Test
    @DisplayName("로또가 4개 맞았을 경우 제대로 카운트하는지 확인합니다.")
    void 기능_테스트_로또_4개_카운트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "8,21,23,41,10,9", "7");
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
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 1개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 625.0%입니다."
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
    @DisplayName("로또가 5개 맞았을 경우 제대로 카운트하는지 확인합니다.")
    void 기능_테스트_로또_5개_카운트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,3,5,14,22,9", "7");
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
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 1개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 18,750.0%입니다."
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
    @DisplayName("로또가 5개+보너스 한개 맞았을 경우 제대로 카운트하는지 확인합니다.")
    void 기능_테스트_로또_보너스_카운트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,3,5,14,22,9", "45");
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
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 375,000.0%입니다."
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
    @DisplayName("로또가 6개 맞았을 경우 제대로 카운트하는지 확인합니다.")
    void 기능_테스트_로또_6개_카운트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,3,5,14,22,45", "6");
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
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 1개",
                            "총 수익률은 25,000,000.0%입니다."
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
    @DisplayName("로또가 중복으로 맞았을 경우 제대로 카운트하는지 확인합니다.")
    void 기능_테스트_로또_중복_카운트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("7000", "1,2,3,4,5,6", "45");
                    assertThat(output()).contains(
                            "7개를 구매했습니다.",
                            "[1, 2, 3, 4, 5, 6]",
                            "[1, 2, 3, 4, 5, 45]",
                            "[1, 2, 3, 10, 11, 12]",
                            "[1, 2, 11, 12, 13, 14]",
                            "[1, 2, 3, 4, 5, 40]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 1개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                            "6개 일치 (2,000,000,000원) - 1개",
                            "총 수익률은 29,021,500.0%입니다."
                    );
                },
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 45),
                List.of(1, 2, 3, 10, 11, 12),
                List.of(1, 2, 11, 12, 13, 14),
                List.of(1, 2, 3, 4, 5, 40),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45)
        );
    }

    @ParameterizedTest
    @DisplayName("비어있는 금액입력을 테스트합니다.")
    @ValueSource(strings = {"\n", " ", "    "})
    void 금액_빈입력_테스트(String input) {
        assertSimpleTest(() -> {
            runException(input);
            assertThat(output()).contains(ErrorMessages.INVALID_USER_INPUT.getMessage());
        });
    }

    @ParameterizedTest
    @DisplayName("비어있는 로또입력을 테스트합니다.")
    @ValueSource(strings = {"\n", " ", "    "})
    void 로또_빈입력_테스트(String input) {
        assertSimpleTest(() -> {
            runException("8000", input);
            assertThat(output()).contains(ErrorMessages.INVALID_USER_INPUT.getMessage());
        });
    }

    @ParameterizedTest
    @DisplayName("비어있는 보너스입력을 테스트합니다.")
    @ValueSource(strings = {"\n", " ", "    "})
    void 보너스_빈입력_테스트(String input) {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6", input);
            assertThat(output()).contains(ErrorMessages.INVALID_USER_INPUT.getMessage());
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
