package lotto.model.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusBallTest {

    @DisplayName("보너스 당첨 번호와 당첨 번호가 겹치면 예외를 반환한다.")
    @Test
    void test1() {
        assertThatThrownBy(() ->  BonusBall.of(6, new WinningBalls(List.of(1, 2, 3, 4, 5, 6))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 1 ~ 45 가 아닐 시 예외 반환한다")
    @Test
    void test2() {
        WinningBalls winningBalls = new WinningBalls(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> BonusBall.of(1000, winningBalls))
                .isInstanceOf(IllegalArgumentException.class);
    }
}