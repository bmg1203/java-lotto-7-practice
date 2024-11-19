package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BonusTest {

    private Lotto lotto;

    @BeforeEach
    public void setLotto() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        lotto = new Lotto(numbers);
    }

    @Test
    void 정상_동작_테스트() {
        //given
        int number = 7;

        //when
        Bonus bonus = new Bonus(lotto, number);

        //then
        assertThat(bonus.getBonus()).isEqualTo(number);
    }

    @Test
    void 중복_숫자_예외() {
        //given
        int number = 3;

        //when, then
        assertThatThrownBy(() -> new Bonus(lotto, number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 최소범위_예외() {
        //given
        int number = 0;

        //when, then
        assertThatThrownBy(() -> new Bonus(lotto, number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 최대범위_예외() {
        //given
        int number = 46;

        //when, then
        assertThatThrownBy(() -> new Bonus(lotto, number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}