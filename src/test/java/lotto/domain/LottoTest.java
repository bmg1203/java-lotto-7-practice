package lotto.domain;

import camp.nextstep.edu.missionutils.test.Assertions;
import lotto.service.RandomUniqueLottoNumGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호_오름차순_정렬() {
        String sortedLotto = "[1, 2, 3, 4, 5, 6]";
        Assertions.assertRandomUniqueNumbersInRangeTest(() -> {
                    Lotto lotto = new Lotto(new RandomUniqueLottoNumGenerator());
                    assertThat(lotto.toString()).isEqualTo(sortedLotto);
                },
                new ArrayList<>(List.of(6, 2, 1, 3, 5, 4))  // List.of는 ImmutableCollections라 리스트 메서드 지원 X
        );
    }

}
