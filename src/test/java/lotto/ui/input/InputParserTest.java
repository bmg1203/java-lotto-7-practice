package lotto.ui.input;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.model.domain.BonusNumber;
import lotto.model.domain.PurchaseAmount;
import org.junit.jupiter.api.Test;

class InputParserTest {
    private final InputParser parser = new InputParser();

    @Test
    void 구매금액_파싱() {
        //given
        String amount = "50000";

        //when
        PurchaseAmount purchaseAmount = parser.parsePurchaseAmount(amount);

        //then
        assertThat(purchaseAmount.get()).isEqualTo(50000);
    }

    @Test
    void 구매금액_파싱_실패() {
        //given
        String amount = "5a0000";

        //then
        assertThrows(NumberFormatException.class, () -> parser.parsePurchaseAmount(amount));
    }

    @Test
    void 당첨금액_파싱() {
        //given
        String input = "1,2,3,4,5,6";

        //then
        List<Integer> winningNumbers = parser.parseWinningNumbers(",", input);

        //then
        assertThat(winningNumbers.size()).isEqualTo(6);
        assertThat(winningNumbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 당첨금액_파싱_실패() {
        //given
        String input = "1,2,3a,4,5,6";

        //then
        assertThrows(NumberFormatException.class, () -> parser.parseWinningNumbers(",", input));
    }

    @Test
    void 보너스_번호_파싱() {
        //given
        String input = "3";

        //when
        BonusNumber bonusNumber = parser.parseBonusNumber(input);

        //then
        assertThat(bonusNumber.get()).isEqualTo(3);
    }

    @Test
    void 보너스_번호_파싱_실패() {
        //given
        String input = "3a";

        //then
        assertThrows(NumberFormatException.class, () -> parser.parseBonusNumber(input));
    }

}