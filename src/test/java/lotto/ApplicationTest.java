package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @DisplayName("유효한 구입 금액 입력 테스트")
    void testValidPurchaseAmount() {
        assertEquals(1000, Application.validatePurchaseAmount("1000"));
    }

    @Test
    @DisplayName("구입 금액 숫자가 아닐 때 예외 테스트")
    void testInvalidPurchaseAmountNonInteger() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Application.validatePurchaseAmount("abcd")
        );
        assertEquals("[ERROR] 구입금액은 정수여야합니다", exception.getMessage());
    }

    @Test
    @DisplayName("구입 금액이 1000원 단위가 아닌 경우 예외 테스트")
    void testInvalidPurchaseAmountNotMultipleOfThousand() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Application.validatePurchaseAmount("1500")
        );
        assertEquals("[ERROR] 구입금액은 1,000원 단위여야합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("구입 금액이 0 이하일 때 예외 테스트")
    void testInvalidPurchaseAmountNegativeOrZero() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Application.validatePurchaseAmount("0")
        );
        assertEquals("[ERROR] 구입금액은 1,000원 단위여야합니다.", exception.getMessage());

        exception = assertThrows(
                IllegalArgumentException.class,
                () -> Application.validatePurchaseAmount("-1000")
        );
        assertEquals("[ERROR] 구입금액은 1,000원 단위여야합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("정수 리스트가 오름차순으로 정렬이 되었는지 테스트")
    void testIntegerNumberAreSorted() {
        List<Integer> intNumbers = Arrays.asList(6, 3, 5, 1, 4, 2);
        intNumbers = Application.sortAscendingInteger(intNumbers);

        for (int i = 0; i < intNumbers.size() - 1; i++) {
            assertTrue(intNumbers.get(i) <= intNumbers.get(i + 1), "숫자들이 오름차순으로 정렬되어야 합니다.");
        }

    }

    @Test
    @DisplayName("문자열 리스트가 정수형 리스트로 변환이 되었는지 테스트")
    void testStringListToIntegerList() {
        List<String> stringNumbers = Arrays.asList("1", "2", "3", "4", "5", "6");
        List<Integer> expectedIntegers = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Integer> result = Application.stringListToIntegerList(stringNumbers);

        assertEquals(expectedIntegers, result, "정수 리스트 변환이 예상과 다릅니다.");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
