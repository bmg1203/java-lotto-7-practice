package lotto.domain;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoManagerTest {

    static Stream<Arguments> provideLottoManagerCases() {
        return Stream.of(
                Arguments.of(
                        List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(7, 8, 9, 10, 11, 12))),
                        new WinnerLotto(List.of(1, 2, 3, 4, 5, 6)).addBonusNumber("7"),
                        "1등 1개 - 모든 번호 일치",
                        Map.of(Prize.FIRST, 1)
                ),
                Arguments.of(
                        List.of(new Lotto(List.of(1, 2, 3, 4, 5, 8))),
                        new WinnerLotto(List.of(1, 2, 3, 4, 5, 6)).addBonusNumber("8"),
                        "2등 1개 - 5개 번호 일치 + 보너스 번호 일치",
                        Map.of(Prize.SECOND, 1)
                ),
                Arguments.of(
                        List.of(new Lotto(List.of(1, 2, 3, 4, 5, 9))),
                        new WinnerLotto(List.of(1, 2, 3, 4, 5, 6)).addBonusNumber("7"),
                        "3등 1개 - 5개 번호 일치, 보너스 번호 불일치",
                        Map.of(Prize.THIRD, 1)
                ),
                Arguments.of(
                        List.of(new Lotto(List.of(1, 2, 3, 4, 10, 11))),
                        new WinnerLotto(List.of(1, 2, 3, 4, 5, 6)).addBonusNumber("9"),
                        "4등 1개 - 4개 번호 일치",
                        Map.of(Prize.FOURTH, 1)
                ),
                Arguments.of(
                        List.of(new Lotto(List.of(1, 2, 3, 7, 8, 9)), new Lotto(List.of(4, 5, 6, 7, 8, 9))),
                        new WinnerLotto(List.of(1, 2, 3, 4, 5, 6)).addBonusNumber("10"),
                        "5등 2개 - 3개 번호 일치",
                        Map.of(Prize.FIFTH, 2)
                ),
                Arguments.of(
                        List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(7, 8, 9, 10, 11, 12))),
                        new WinnerLotto(List.of(1, 2, 3, 7, 8, 9)).addBonusNumber("4"),
                        "5등 2개 - 보너스 볼 일치해도 5등",
                        Map.of(Prize.FIFTH, 2) // 예상 결과
                )

        );
    }

    @ParameterizedTest(name = "{index}: {2}")
    @MethodSource("provideLottoManagerCases")
    void 로또_당첨_결과_성공(List<Lotto> lottos, WinnerLotto winnerLotto, String testName, Map<Prize, Integer> expected) {
        // given
        LottoManager lottoManager = new LottoManager(lottos);
        lottoManager = lottoManager.withWinningLotto(winnerLotto);

        // when
        Map<Prize, Integer> result = lottoManager.getPrizeResult();

        // then
        assertThat(result).isEqualTo(expected);

    }
}