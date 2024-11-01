package lotto.store;

import lotto.basic.NumbersGeneratorStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다")
    @Test
    void test1() {

        assertThatThrownBy(() -> new Lotto(toLottoNumbers(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void test2() {
        assertThatThrownBy(() -> new Lotto(toLottoNumbers(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1~45 범위 밖에 있다면 예외가 발생한다.")
    @Test
    void test3() {
        assertThatThrownBy(() -> new Lotto(toLottoNumbers(1, 2, 3, 999, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static List<LottoNumber> toLottoNumbers(int... numbers) {
        return Arrays.stream(numbers).boxed().map(LottoNumber::new).toList();
    }

}
