package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {
    @Test
    @DisplayName("결과 문자열 변환 테스트")
    void result_toStringTest() {
        List<Integer> sampleList = List.of(2, 1, 0, 0, 1);
        Map<Prize, Integer> sampleMap = new HashMap<>();
        for (Prize prize : Prize.values()) {
            sampleMap.put(prize, sampleList.get(prize.ordinal()));
        }
        Result sampleResult = new Result(sampleMap);

        assertThat(sampleResult.toString())
                .contains(
                        "3개 일치 (5,000원) - 2개",
                        "4개 일치 (50,000원) - 1개",
                        "5개 일치 (1,500,000원) - 0개",
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                        "6개 일치 (2,000,000,000원) - 1개"
                );
    }

    @ParameterizedTest(name = "{index}: {1}")
    @MethodSource("resultTest")
    @DisplayName("당첨 금액 테스트")
    void result_totalMoneyTest(List<Integer> prizeCount, String message, int totalMoney) {
        Map<Prize, Integer> sampleMap = new HashMap<>();
        for (Prize prize : Prize.values()) {
            sampleMap.put(prize, prizeCount.get(prize.ordinal()));
        }
        Result sampleResult = new Result(sampleMap);

        assertEquals(sampleResult.totalMoney(), totalMoney);
    }

    static Stream<Arguments> resultTest() {
        return Stream.of(
                Arguments.of(List.of(2, 1, 0, 0, 1), "당첨 금액 테스트 1", 2_000_060_000),
                Arguments.of(List.of(3, 0, 1, 1, 0), "당첨 금액 테스트 2", 31_515_000),
                Arguments.of(List.of(7, 7, 2, 0, 0), "당첨 금액 테스트 3", 3_385_000),
                Arguments.of(List.of(0, 0, 0, 0, 0), "당첨 금액 테스트 4", 0)
        );
    }

}
