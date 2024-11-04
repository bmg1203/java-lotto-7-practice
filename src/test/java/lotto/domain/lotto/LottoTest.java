package lotto.domain.lotto;

import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void lottoSize_outOfRange_throwException() {
        List<LottoNumber> lottoNumbers = IntStream.rangeClosed(1, 7)
                .mapToObj(LottoNumber::new)
                .toList();
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void lottoNumber_duplicate_throwException() {
        List<LottoNumber> lottoNumbers = IntStream.rangeClosed(1, 5)
                .mapToObj(LottoNumber::new)
                .toList();
        assertThatThrownBy(() -> new Lotto(List.of(lottoNumbers.get(0), lottoNumbers.get(1), lottoNumbers.get(2), lottoNumbers.get(3), lottoNumbers.get(4), lottoNumbers.get(4))))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
