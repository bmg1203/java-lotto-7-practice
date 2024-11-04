package lotto.model;

import lotto.entity.BonusNumber;
import lotto.entity.Lotto;
import lotto.entity.Price;
import lotto.entity.WinningNumber;
import lotto.enums.ExceptionMessage;
import lotto.enums.LottoPrize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    private static final String TEST_TITLE_HEADER = "[LottoResultTest] ";
    @DisplayName(TEST_TITLE_HEADER + "구입 금액에 빈 값이 입력되면 예외가 발생한다")
    @ParameterizedTest
    @MethodSource
    void 구입_금액에_빈_값이_입력되면_예외가_발생한다(
            String price,
            List<Lotto> lottos,
            String winningNumber,
            String bonusNumber
    ) {
        String errorMessage = ExceptionMessage.PRICE_IS_NULL.getMessage();
        compareResult(price, lottos, winningNumber, bonusNumber, errorMessage);
    }

    @DisplayName(TEST_TITLE_HEADER + "구입 금액에 숫자 외의 문자가 있으면 예외가 발생한다")
    @ParameterizedTest
    @MethodSource
    void 구입_금액에_숫자_외의_문자가_있으면_예외가_발생한다(
            String price,
            List<Lotto> lottos,
            String winningNumber,
            String bonusNumber
    ) {
        String errorMessage = ExceptionMessage.PRICE_NOT_VALID_FORMAT.getMessage();
        compareResult(price, lottos, winningNumber, bonusNumber, errorMessage);
    }

    @DisplayName(TEST_TITLE_HEADER + "구입 금액에 음수를 입력하면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource
    void 구입_금액에_음수를_입력하면_예외가_발생한다(
            String price,
            List<Lotto> lottos,
            String winningNumber,
            String bonusNumber
    ) {
        String errorMessage = ExceptionMessage.PRICE_NOT_VALID_FORMAT.getMessage();
        compareResult(price, lottos, winningNumber, bonusNumber, errorMessage);
    }

    @DisplayName(TEST_TITLE_HEADER + "구입 금액이 정수 범위를 벗어나면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource
    void 구입_금액이_정수_범위를_벗어나면_예외가_발생한다(
            String price,
            List<Lotto> lottos,
            String winningNumber,
            String bonusNumber
    ) {
        String errorMessage = ExceptionMessage.PRICE_OUT_OF_RANGE.getMessage();
        compareResult(price, lottos, winningNumber, bonusNumber, errorMessage);
    }

    @DisplayName(TEST_TITLE_HEADER + "구입 금액이 천 단위 숫자가 아니면 예외가 발생한다")
    @ParameterizedTest
    @MethodSource
    void 구입_금액이_천_단위_숫자가_아니면_예외가_발생한다(
            String price,
            List<Lotto> lottos,
            String winningNumber,
            String bonusNumber
    ) {
        String errorMessage = ExceptionMessage.PRICE_NOT_MULTIPLE_OF_THOUSAND.getMessage();
        compareResult(price, lottos, winningNumber, bonusNumber, errorMessage);
    }

    @DisplayName(TEST_TITLE_HEADER + "로또 번호의 개수가 6개가 아니면 예외가 발생한다")
    @ParameterizedTest
    @MethodSource
    void 로또_번호의_개수가_6개가_아니면_예외가_발생한다(
            String price,
            List<Integer> lottos,
            String winningNumber,
            String bonusNumber
    ) {
        assertThatThrownBy(() -> new LottoResult(
                new Price(price),
                List.of(new Lotto(lottos)),
                new WinningNumber(winningNumber),
                new BonusNumber(bonusNumber))
        )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.LOTTO_NUMBER_NOT_VALID_COUNT.getMessage());
    }

    @DisplayName(TEST_TITLE_HEADER + "로또 번호에 중복된 숫자가 있으면 예외가 발생한다")
    @ParameterizedTest
    @MethodSource
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다(
            String price,
            List<Integer> lottos,
            String winningNumber,
            String bonusNumber
    ) {
        assertThatThrownBy(() -> new LottoResult(
                new Price(price),
                List.of(new Lotto(lottos)),
                new WinningNumber(winningNumber),
                new BonusNumber(bonusNumber))
        )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.LOTTO_NUMBER_DUPLICATED.getMessage());
    }

    @DisplayName(TEST_TITLE_HEADER + "로또 번호가 1 과 45 사이의 숫자가 아닐 경우 예외가 발생한다")
    @ParameterizedTest
    @MethodSource
    void 로또_번호가_1_과_45_사이의_숫자가_아니면_예외가_발생한다(
            String price,
            List<Integer> lottos,
            String winningNumber,
            String bonusNumber
    ) {
        assertThatThrownBy(() -> new LottoResult(
                new Price(price),
                List.of(new Lotto(lottos)),
                new WinningNumber(winningNumber),
                new BonusNumber(bonusNumber))
        )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
    }

    @DisplayName(TEST_TITLE_HEADER + "당첨 번호에 빈 값이 입력되면 예외가 발생한다")
    @ParameterizedTest
    @MethodSource
    void 당첨_번호에_숫자_빈_값이_입력되면_예외가_발생한다(
            String price,
            List<Lotto> lottos,
            String winningNumber,
            String bonusNumber
    ) {
        String errorMessage = ExceptionMessage.WINNING_NUMBER_IS_NULL.getMessage();
        compareResult(price, lottos, winningNumber, bonusNumber, errorMessage);
    }

    @DisplayName(TEST_TITLE_HEADER + "당첨 번호에 숫자 외의 값이 입력되면 예외가 발생한다")
    @ParameterizedTest
    @MethodSource
    void 당첨_번호에_숫자_외의_값이_입력되면_예외가_발생한다(
            String price,
            List<Lotto> lottos,
            String winningNumber,
            String bonusNumber
    ) {
        String errorMessage = ExceptionMessage.WINNING_NUMBER_NOT_VALID_FORMAT.getMessage();
        compareResult(price, lottos, winningNumber, bonusNumber, errorMessage);
    }

    @DisplayName(TEST_TITLE_HEADER + "당첨 번호가 쉼표로 시작하거나 끝나면 예외가 발생한다")
    @ParameterizedTest
    @MethodSource
    void 당첨_번호가_쉼표로_시작하거나_끝나면_예외가_발생한다(
            String price,
            List<Lotto> lottos,
            String winningNumber,
            String bonusNumber
    ) {
        String errorMessage = ExceptionMessage.WINNING_NUMBER_START_OR_END_WITH_COMMA.getMessage();
        compareResult(price, lottos, winningNumber, bonusNumber, errorMessage);
    }

    @DisplayName(TEST_TITLE_HEADER + "당첨 번호에 연속된 쉼표가 있다면 예외가 발생한다")
    @ParameterizedTest
    @MethodSource
    void 당첨_번호에_연속된_쉼표가_있다면_예외가_발생한다(
            String price,
            List<Lotto> lottos,
            String winningNumber,
            String bonusNumber
    ) {
        String errorMessage = ExceptionMessage.WINNING_NUMBER_HAS_CONTINUOUS_COMMA.getMessage();
        compareResult(price, lottos, winningNumber, bonusNumber, errorMessage);
    }

    @DisplayName(TEST_TITLE_HEADER + "당첨 번호에 정수 범위를 벗어난 값을 입력하면 예외가 발생한다")
    @ParameterizedTest
    @MethodSource
    void 당첨_번호에_정수_범위를_벗어난_값을_입력하면_예외가_발생한다(
            String price,
            List<Lotto> lottos,
            String winningNumber,
            String bonusNumber
    ) {
        String errorMessage = ExceptionMessage.WINNING_NUMBER_OUT_OF_RANGE.getMessage();
        compareResult(price, lottos, winningNumber, bonusNumber, errorMessage);
    }

    @DisplayName(TEST_TITLE_HEADER + "당첨 번호의 개수가 여섯개가 아니면 예외가 발생한다")
    @ParameterizedTest
    @MethodSource
    void 당첨_번호의_개수가_여섯개가_아니면_예외가_발생한다(
            String price,
            List<Lotto> lottos,
            String winningNumber,
            String bonusNumber
    ) {
        String errorMessage = ExceptionMessage.LOTTO_NUMBER_NOT_VALID_COUNT.getMessage();
        compareResult(price, lottos, winningNumber, bonusNumber, errorMessage);
    }

    @DisplayName(TEST_TITLE_HEADER + "당첨 번호에 중복된 숫자가 있으면 예외가 발생한다")
    @ParameterizedTest
    @MethodSource
    void 당첨_번호에_중복된_숫자가_있으면_예외가_발생한다(
            String price,
            List<Lotto> lottos,
            String winningNumber,
            String bonusNumber
    ) {
        String errorMessage = ExceptionMessage.LOTTO_NUMBER_DUPLICATED.getMessage();
        compareResult(price, lottos, winningNumber, bonusNumber, errorMessage);
    }

    @DisplayName(TEST_TITLE_HEADER + "당첨 번호가 1과 45 사이의 숫자가 아니면 예외가 발생한다")
    @ParameterizedTest
    @MethodSource
    void 당첨_번호가_1과_45_사이의_숫자가_아니면_예외가_발생한다(
            String price,
            List<Lotto> lottos,
            String winningNumber,
            String bonusNumber
    ) {
        String errorMessage = ExceptionMessage.LOTTO_NUMBER_OUT_OF_RANGE.getMessage();
        compareResult(price, lottos, winningNumber, bonusNumber, errorMessage);
    }

    @DisplayName(TEST_TITLE_HEADER + "보너스 번호에 빈 값이 입력되면 예외가 발생한다")
    @ParameterizedTest
    @MethodSource
    void 보너스_번호에_빈_값이_입력되면_예외가_발생한다(
            String price,
            List<Lotto> lottos,
            String winningNumber,
            String bonusNumber
    ) {
        String errorMessage = ExceptionMessage.BONUS_NUMBER_IS_NULL.getMessage();
        compareResult(price, lottos, winningNumber, bonusNumber, errorMessage);
    }

    @DisplayName(TEST_TITLE_HEADER + "보너스 번호에 숫자 외의 값이 입력되면 예외가 발생한다")
    @ParameterizedTest
    @MethodSource
    void 보너스_번호에_숫자_외의_값이_입력되면_예외가_발생한다(
            String price,
            List<Lotto> lottos,
            String winningNumber,
            String bonusNumber
    ) {
        String errorMessage = ExceptionMessage.BONUS_NUMBER_NOT_VALID_FORMAT.getMessage();
        compareResult(price, lottos, winningNumber, bonusNumber, errorMessage);
    }

    @DisplayName(TEST_TITLE_HEADER + "보너스 번호가 1 과 45 사이의 숫자가 아니면 예외가 발생한다")
    @ParameterizedTest
    @MethodSource
    void 보너스_번호가_1_과_45_사이의_숫자가_아니면_예외가_발생한다(
            String price,
            List<Lotto> lottos,
            String winningNumber,
            String bonusNumber
    ) {
        String errorMessage = ExceptionMessage.BONUS_NUMBER_OUT_OF_RANGE.getMessage();
        compareResult(price, lottos, winningNumber, bonusNumber, errorMessage);
    }

    @DisplayName(TEST_TITLE_HEADER + "당첨 번호와 보너스 번호가 중복되면 예외가 발생한다")
    @ParameterizedTest
    @MethodSource
    void 당청_번호와_보너스_번호가_중복되면_예외가_발생한다(
            String price,
            List<Lotto> lottos,
            String winningNumber,
            String bonusNumber
    ) {
        String errorMessage = ExceptionMessage.WINNING_BONUS_NUMBER_DUPLICATED.getMessage();
        compareResult(price, lottos, winningNumber, bonusNumber, errorMessage);
    }

    @DisplayName(TEST_TITLE_HEADER + "정상 동작 테스트")
    @ParameterizedTest
    @MethodSource
    void 정상_동작_테스트(
            String price,
            List<Lotto> lottos,
            String winningNumber,
            String bonusNumber
    ) {
        LottoResult lottoResult = new LottoResult(
                new Price(price),
                lottos,
                new WinningNumber(winningNumber),
                new BonusNumber(bonusNumber)
        );

        assertThat(lottoResult.getWinningHistory().get(LottoPrize.FIFTH_PRIZE)).isEqualTo(1);
        assertThat(lottoResult.getRateOfReturn()).isEqualTo(62.5);
    }

    private void compareResult(
            String price,
            List<Lotto> lottos,
            String winningNumber,
            String bonusNumber,
            String errorMessage
    ) {
        assertThatThrownBy(() -> new LottoResult(
                new Price(price),
                lottos,
                new WinningNumber(winningNumber),
                new BonusNumber(bonusNumber))
        )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage);
    }

    private static Stream<Arguments> 구입_금액에_빈_값이_입력되면_예외가_발생한다() {
        return Stream.of(
                Arguments.arguments(null, List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))), "4,5,6,7,8,9", "10")
        );
    }

    private static Stream<Arguments> 구입_금액에_숫자_외의_문자가_있으면_예외가_발생한다() {
        return Stream.of(
                Arguments.arguments("123asd@#$", List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))), "4,5,6,7,8,9", "10")
        );
    }

    private static Stream<Arguments> 구입_금액에_음수를_입력하면_예외가_발생한다() {
        return Stream.of(Arguments.arguments(
                "-1", List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))), "4,5,6,7,8,9", "10")
        );
    }

    private static Stream<Arguments> 구입_금액이_정수_범위를_벗어나면_예외가_발생한다() {
        return Stream.of(
                Arguments.arguments("2147483648", List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))), "4,5,6,7,8,9", "10")
        );
    }

    private static Stream<Arguments> 구입_금액이_천_단위_숫자가_아니면_예외가_발생한다() {
        return Stream.of(
                Arguments.arguments("1001", List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))), "4,5,6,7,8,9", "10")
        );
    }

    private static Stream<Arguments> 로또_번호의_개수가_6개가_아니면_예외가_발생한다() {
        return Stream.of(
                Arguments.arguments("1000", List.of(1, 2, 3, 4, 5), "4,5,6,7,8,9", "10"),
                Arguments.arguments("1000", List.of(1, 2, 3, 4, 5, 6, 7), "4,5,6,7,8,9", "10")
        );
    }

    private static Stream<Arguments> 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        return Stream.of
                (Arguments.arguments("1000", List.of(1, 2, 3, 4, 5, 5), "4,5,6,7,8,9", "10")
                );
    }

    private static Stream<Arguments> 로또_번호가_1_과_45_사이의_숫자가_아니면_예외가_발생한다() {
        return Stream.of(
                Arguments.arguments("1000", List.of(1, 2, 3, 4, 5, 46), "4,5,6,7,8,9", "10"),
                Arguments.arguments("1000", List.of(1, 2, 3, 4, 5, 0), "4,5,6,7,8,9", "10")
        );
    }

    private static Stream<Arguments> 당첨_번호에_숫자_빈_값이_입력되면_예외가_발생한다() {
        return Stream.of(
                Arguments.arguments("1000", List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))), null, "10")
        );
    }

    private static Stream<Arguments> 당첨_번호에_숫자_외의_값이_입력되면_예외가_발생한다() {
        return Stream.of(
                Arguments.arguments("1000", List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))), "@,5,6,7,8,9", "10"),
                Arguments.arguments("1000", List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))), "4,5,6,a,8,9", "10"),
                Arguments.arguments("1000", List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))), "as224!#@", "10")
        );
    }

    private static Stream<Arguments> 당첨_번호가_쉼표로_시작하거나_끝나면_예외가_발생한다() {
        return Stream.of(
                Arguments.arguments("1000", List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))), ",4,5,6,7,8,9", "10"),
                Arguments.arguments("1000", List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))), "4,5,6,7,8,9,", "10"),
                Arguments.arguments("1000", List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))), ",4,5,6,7,8,9,", "10")
        );
    }

    private static Stream<Arguments> 당첨_번호에_연속된_쉼표가_있다면_예외가_발생한다() {
        return Stream.of(
                Arguments.arguments("1000", List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))), "4,5,,6,7,8,9", "10")
        );
    }

    private static Stream<Arguments> 당첨_번호에_정수_범위를_벗어난_값을_입력하면_예외가_발생한다() {
        return Stream.of(
                Arguments.arguments("1000", List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))), "2147483648", "10")
        );
    }

    private static Stream<Arguments> 당첨_번호의_개수가_여섯개가_아니면_예외가_발생한다() {
        return Stream.of(
                Arguments.arguments("1000", List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))), "1,2,3,4,5", "10"),
                Arguments.arguments("1000", List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))), "1,2,3,4,5,6,7", "10")
        );
    }

    private static Stream<Arguments> 당첨_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        return Stream.of(
                Arguments.arguments("1000", List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))), "1,2,3,4,5,5", "10")
        );
    }

    private static Stream<Arguments> 당첨_번호가_1과_45_사이의_숫자가_아니면_예외가_발생한다() {
        return Stream.of(
                Arguments.arguments("1000", List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))), "1,2,3,4,5,46", "10"),
                Arguments.arguments("1000", List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))), "1,2,3,4,5,0", "10")
        );
    }

    private static Stream<Arguments> 보너스_번호에_빈_값이_입력되면_예외가_발생한다() {
        return Stream.of(
                Arguments.arguments("1000", List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))), "4,5,6,7,8,9", null)
        );
    }

    private static Stream<Arguments> 보너스_번호에_숫자_외의_값이_입력되면_예외가_발생한다() {
        return Stream.of(
                Arguments.arguments("1000", List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))), "4,5,6,7,8,9", "a#")
        );
    }

    private static Stream<Arguments> 보너스_번호가_1_과_45_사이의_숫자가_아니면_예외가_발생한다() {
        return Stream.of(
                Arguments.arguments("1000", List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))), "4,5,6,7,8,9", "46"),
                Arguments.arguments("1000", List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))), "4,5,6,7,8,9", "0")
        );
    }

    private static Stream<Arguments> 당청_번호와_보너스_번호가_중복되면_예외가_발생한다() {
        return Stream.of(
                Arguments.arguments("1000", List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))), "4,5,6,7,8,9", "9")
        );
    }

    private static Stream<Arguments> 정상_동작_테스트() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(10, 11, 12, 13, 14, 15)),
                new Lotto(List.of(10, 11, 12, 13, 14, 15)),
                new Lotto(List.of(10, 11, 12, 13, 14, 15)),
                new Lotto(List.of(10, 11, 12, 13, 14, 15)),
                new Lotto(List.of(10, 11, 12, 13, 14, 15)),
                new Lotto(List.of(10, 11, 12, 13, 14, 15)),
                new Lotto(List.of(10, 11, 12, 13, 14, 15))
        );

        return Stream.of(
                Arguments.arguments("8000", lottos, "4,5,6,7,8,9", "10")
        );
    }
}
