package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UserTest {

    @Test
    void 발행_횟수_만큼_로또_발행_되는지_테스트() {
        User user = new User("8000");
        user.publishLotto(user.getMoney());

        int actual = user.getLotteryTickets().size();

        Assertions.assertThat(actual).isEqualTo(8);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1000", "1234", " ", "천만원", " 1000 "})
    void 공백없이_0원_이상의_1000원_단위로_나누어_떨어지는_숫자가_아니라면_예외가_발생한다(String value) {
        assertThatThrownBy(() -> new User(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-7", "50", " ", "칠", " 50 "})
    void 공백없이_1부터_45까지의_숫자가_아니라면_예외가_발생한다(String value) {
        User user = new User("1000");
        assertThatThrownBy(() -> user
                .specifyBonusNumber(value, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호와_중복_되는_보너스_번호일_경우_예외가_발생한다() {
        User user = new User("1000");
        assertThatThrownBy(() -> user
                .specifyBonusNumber("4", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 수익률() {
        User user = new User("9000"); // 8장 발행 한다고 치고
        user.lotteryTickets = new ArrayList<>();
        user.getLotteryTickets().add(List.of(8, 9, 10, 11, 12, 13));
        user.getLotteryTickets().add(List.of(8, 9, 10, 11, 12, 13));
        user.getLotteryTickets().add(List.of(8, 9, 10, 11, 12, 13));
        user.getLotteryTickets().add(List.of(8, 9, 10, 11, 12, 13));
        user.getLotteryTickets().add(List.of(8, 9, 10, 11, 12, 13));
        user.getLotteryTickets().add(List.of(8, 9, 10, 11, 12, 13));
        user.getLotteryTickets().add(List.of(8, 9, 10, 11, 12, 13));
        user.getLotteryTickets().add(List.of(1, 2, 3, 11, 12, 13));      //이거 5등 당첨 = 5000원

        Lotto lotto = new Lotto("1,2,3,4,5,6");
        user.specifyBonusNumber("7", lotto.getNumbers());

        // 일치 확인
        lotto.matcheNumber(user.getLotteryTickets(), user.getBonusNumber());
        double expected = 55.6;

        Assertions.assertThat(user.lateOfReturn()).isEqualTo(expected);
    }
}
