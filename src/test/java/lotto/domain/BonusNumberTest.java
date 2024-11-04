package lotto.domain;

import lotto.domain.lottoForm.WinningNumbers;
import lotto.domain.number.BonusNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static lotto.message.ErrorMessage.BONUS_NUMBER_DUPLICATE;
import static lotto.message.ErrorMessage.LOTTO_SCOPE_ERROR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {

    @DisplayName("보너스 번호가 로또 번호 범위 안의 수이고, 당첨 번호와 중복되지 않으면 성공적으로 객체를 생성한다.")
    @ParameterizedTest
    @CsvSource({
            "'23,7,  24, 9, 10, 12', 30",
            "'39, 14, 44  , 18, 29,    40', 15",
            "'1, 12, 34, 45,9, 7', 8"
    })
    void bonusNumberSuccessTest(String winningInput, int bonusInput) {
        // given
        WinningNumbers winningNumbers = WinningNumbers.from(winningInput);

        // when
        BonusNumber bonusNumber = new BonusNumber(bonusInput, winningNumbers);

        // then
        assertThat(bonusNumber.getNumber()).isEqualTo(bonusInput);
    }

    @DisplayName("보너스 번호가 로또 번호 범위 안의 수이면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({
            "'6,7,8,9,10,21', 74",
            "'13,14,15,16,12,17', 46",
            "'30,37,40,39,45,11', 0"
    })
    void scopeExceptionTest(String winningInput, int bonusInput) {
        // given
        WinningNumbers winningNumbers = WinningNumbers.from(winningInput);

        // when & then
        assertThatThrownBy(() -> new BonusNumber(bonusInput, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_SCOPE_ERROR.getMessage());
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({
            "'6,7,8,9,10,21', 21",
            "'13,14,15,16,12,17', 17",
            "'30,37,40,39,45,11', 30"
    })
    void duplicateExceptionTest(String winningInput, int bonusInput) {
        // given
        WinningNumbers winningNumbers = WinningNumbers.from(winningInput);

        // when & then
        assertThatThrownBy(() -> new BonusNumber(bonusInput, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BONUS_NUMBER_DUPLICATE.getMessage());
    }
}
