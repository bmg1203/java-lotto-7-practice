package lotto;

import convert.ListStringToNumConverter;
import lottoWinningNumber.LottoWinningNumberDelimiter;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lottoWinningNumber.LottoWinningNumberValidator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoWinningNumberTest {
    private String lottoWinningNumber;
    private LottoWinningNumberDelimiter lottoWinningNumberDelimiter;
    private ListStringToNumConverter listStringToNumConverter;
    private LottoWinningNumberValidator lottoWinningNumberValidator;

    @BeforeEach
    void setUp() {
        lottoWinningNumberDelimiter = new LottoWinningNumberDelimiter();
        lottoWinningNumberValidator = new LottoWinningNumberValidator();
    }

    @DisplayName("로또 당첨 번호들의 개수가 6개가 아니라면 예외가 발생한다.")
    @Test
    void 로또_당첨_번호들의_개수가_6개가_아니라면_예외가_발생한다() {
        // Given&When
        lottoWinningNumber = "1,2,3";
        List<String> seperatedLottoWinningNumbers = lottoWinningNumberDelimiter.runAndBringSeperatedLottoWinningNumbers(lottoWinningNumber);

        // Then
        assertThatThrownBy(() -> lottoWinningNumberValidator.validateAllThing(seperatedLottoWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 번호들 중 겹치는 것이 있다면 예외가 발생한다.")
    @Test
    void 로또_당첨_번호들_중_겹치는_것이_있다면_예외가_발생한다() {
        // Given&When
        lottoWinningNumber = "1,1,2,3,4,5";
        List<String> seperatedLottoWinningNumbers = lottoWinningNumberDelimiter.runAndBringSeperatedLottoWinningNumbers(lottoWinningNumber);

        // Then
        assertThatThrownBy(() -> lottoWinningNumberValidator.validateAllThing(seperatedLottoWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 번호들이 숫자 형식이 아니라면 예외가 발생한다.")
    @Test
    void 로또_당첨_번호들이_숫자_형식이_아니라면_예외가_발생한다() {
        // Given&When
        lottoWinningNumber = "1,2,3,a,5,6";
        List<String> seperatedLottoWinningNumbers = lottoWinningNumberDelimiter.runAndBringSeperatedLottoWinningNumbers(lottoWinningNumber);

        // Then
        assertThatThrownBy(() -> lottoWinningNumberValidator.validateAllThing(seperatedLottoWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 번호들의 범위가 1~45가 아니라면 예외가 발생한다.")
    @Test
    void 로또_당첨_번호들의_범위가_1이상_45이하가_아니라면_예외가_발생한다() {
        // Given&When
        lottoWinningNumber = "1,24,25,66,74,21";
        List<String> seperatedLottoWinningNumbers = lottoWinningNumberDelimiter.runAndBringSeperatedLottoWinningNumbers(lottoWinningNumber);

        // Then
        assertThatThrownBy(() -> lottoWinningNumberValidator.validateAllThing(seperatedLottoWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 번호를 쉼표 기준으로 구분한다.")
    @Test
    void 로또_당첨_번호를_쉼표_기준으로_구분한다() {
        // Given
        listStringToNumConverter = new ListStringToNumConverter();
        lottoWinningNumber = "1,2,3,4,5";
        List<String> seperatedLottoWinningNumbers = lottoWinningNumberDelimiter.runAndBringSeperatedLottoWinningNumbers(lottoWinningNumber);
        List<Integer> seperatedLottoWinningNumbersToInt = listStringToNumConverter.convert(seperatedLottoWinningNumbers);

        // Then
        Assertions.assertEquals(seperatedLottoWinningNumbersToInt, Arrays.asList(1, 2, 3, 4, 5));
    }
}
