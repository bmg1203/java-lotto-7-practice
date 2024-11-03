package lotto.utils;

import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UtilsTest {

    @DisplayName("문자열이 숫자로 구성되었는지 확인한다")
    @Test
    void isDigitOnly() {
        assertTrue(Utils.isDigitOnly("123123"));
        assertTrue(Utils.isDigitOnly("1"));
        assertTrue(Utils.isDigitOnly("2147483647"));
    }

    @DisplayName("숫자가 min ~ max 범위에 들어 오는지 확인한다. [int 버전]")
    @Test
    void isInRange() {
        assertTrue(Utils.isInRange(1, 45, 1));
        assertTrue(Utils.isInRange(1, 45, 45));
        assertTrue(Utils.isInRange(1, 45, 10));
    }

    @DisplayName("숫자가 min ~ max 범위에 들어 오는지 확인한다. [BigDecimal 버전]")
    @Test
    void isInRangeBigDecimalType() {
        BigDecimal min = new BigDecimal(1);
        BigDecimal max = new BigDecimal(45);
        BigDecimal num = new BigDecimal(10);

        assertTrue(Utils.isInRange(min, max, num));
    }
}