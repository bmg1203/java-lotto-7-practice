package lotto.committee.drawsystem;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumbersTest {

    WinningNumbers winningNumbers = WinningNumbers.forTest();
    DrawMachine drawMachine = DrawMachine.forTest(winningNumbers);

    @BeforeEach
    public void setUp() {
    }

    @Test
    @DisplayName("당첨번호 중 일반번호는 6개이다.")
    void 당첨번호_중_일반번호는_6개이다() {
        List<Integer> mainNumbers = winningNumbers.getMainNumbers();
        Integer bonusNumber = winningNumbers.getBonusNumber();
        assertThat(mainNumbers.size()).isEqualTo(6);

    }
//
//    @Test
//    void 당첨번호_중_일반번호가_5개가_아니면_예외가_발생한다() {
////        assertThatThrownBy(() -> )
////                .isInstanceOf(IllegalArgumentException.class);
//    }
//
//    @Test
//    void 당첨번호_중_보너스번호는_1개이다() {
//
//    }
//
//    @Test
//    void 당첨번호_중_보너스번호가_1개가_아니면_예외가_발생한다() {
//
//    }
//
//    @Test
//    void 당첨번호가_총_6개가_아니면_예외가_발생한다() {
//
//    }
//
//    @Test
//    void 일반번호끼리는_겹치지_않는다() {
//
//    }
//
//    @Test
//    void 일반번호와_보너스번호는_겹치지_않는다() {
//
//    }
//
//    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
//    @Test
//    void 당첨번호에_중복된_숫자가_있으면_예외가_발생한다() {
//
//    }
//
//    @Test
//    void 당첨번호_중_일반번호묶음과_보너스번호의_개수는_각각_1개이다() {
//        //당첨번호는 오직 하나만 존재
//    }
//
//    @Test
//    void 당첨번호_중_일반번호묶음과_보너스번호의_개수가_각각_1개가_아니면_예외가_발생한다() {
//
//    }
//
//    @Test
//    void 일반번호묶음에는_1부터_45_사이의_정수만_존재한다() {
//
//    }
//
//    @Test
//    void 보너스번호는_1부터_45_사이의_정수이다() {
//
//    }
//
//    @Test
//    void 당첨번호에_1부터_45_사이의_정수가_아닌_수가_있으면_예외가_발생한다() {
//
//    }
}
