package lotto.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class InputViewTest {

    private final InputStream originalIn = System.in;   // 원래의 System.in 저장

    @AfterEach
    void restoreSystemIn() {
        // 각 테스트 이후 원래 System.in 복원 및 Scanner 종료
        System.setIn(originalIn);
        Console.close();    // Scanner를 종료하여 초기화
    }

    @Test
    void 구매_금액_입력_정상_작동() {
        // given
        String validInput = "5000\n";
        System.setIn(new ByteArrayInputStream(validInput.getBytes()));

        // when, then
        assertEquals(5000, InputView.getPurchaseAmount());
    }

    @Test
    void 입력_값_없을시_에러_발생() {
        // given
        String invalidInput = "\n";
        System.setIn(new ByteArrayInputStream(invalidInput.getBytes()));

        // when, then
        assertThatThrownBy(InputView::getPurchaseAmount)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력값이 없습니다.");
    }

    @Test
    void 구매_금액_숫자_입력_아닐때_에러_발생() {
        // given
        String invalidInput = "hello\n";
        System.setIn(new ByteArrayInputStream(invalidInput.getBytes()));

        // when, then
        assertThatThrownBy(InputView::getPurchaseAmount)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자를 입력해야 합니다.");
    }
}
