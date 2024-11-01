package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.io.InputStream;
import lotto.enums.ErrorMessage;
import lotto.enums.LottoConstants;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputViewTest {

    private final InputStream originalIn = System.in;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
        System.setIn(originalIn);
    }

    private void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }


    @Test
    @DisplayName("올바른 구입 금액 입력 테스트")
    void shouldReturnCorrectPurchaseAmount() {
        // Given
        setInput("5000"); // 1000원 단위

        // When
        int purchaseAmount = InputView.getPurchaseAmount();

        // Then
        assertEquals(5000, purchaseAmount);
    }


}
