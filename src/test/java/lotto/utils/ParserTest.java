package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class ParserTest {

    @Test
    void 문자를_숫자로_변환() {
        //given
        String input = "10";

        //when
        int result = Parser.parseStringToInt(input);

        //then
        assertThat(result).isEqualTo(10);
    }

    @Test
    void 문자를_숫자로_변환_예외() {
        //given
        String input = "10ㅛ";

        //when, then
        assertThatThrownBy(() -> Parser.parseStringToInt(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 문자리스트를_숫자리스트로_변환() {
        //given
        List<String> inputs = List.of("1", "2", "3");

        //when
        List<Integer> numbers = Parser.parseStringListToIntList(inputs);

        //then
        assertThat(numbers.size()).isEqualTo(3);
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @Test
    void 문자리스트를_숫자리스트로_변환_예외() {
        //given
        List<String> inputs = List.of("1", "2", "r");

        //when, then
        assertThatThrownBy(() -> Parser.parseStringListToIntList(inputs))
                .isInstanceOf(IllegalArgumentException.class);
    }
}