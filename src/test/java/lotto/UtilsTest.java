package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import lotto.domain.Lotto;
import lotto.utils.Utils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UtilsTest {

    private final Utils utils = new Utils();

    @DisplayName("숫자가 아닌 다른 문자를 넣으면 예외가 발생한다.")
    @Test
    void 숫자가_아니면_예외가_발생한다() {
        String inputTest = "가나다";

        assertThatThrownBy(() -> utils.parseStringToInt(inputTest))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자를 넣으면 정상 로직")
    @Test
    void 숫자면_정상로직이다() {
        String inputTest = "123";

        assertDoesNotThrow(() -> utils.parseStringToInt(inputTest));
    }

    @DisplayName("로또를 구매하면 1000원당 1개의 로또를 받는 로직")
    @Test
    void 구매금액_단위_1000당_로또_1개() {
        int inputTest = 10000;

        List<Lotto> lottos = utils.generateRandomLottoNumbers(inputTest);

        assertThat(lottos.size()).isEqualTo(inputTest / 1000);
    }
}
