package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class SplitTest {

    @Test
    void 분리_테스트() {
        //given
        String input = "1,2,3,4,5";

        //when
        List<String> strings = Split.commaSplit(input);

        //then
        assertThat(strings.size()).isEqualTo(5);
    }
}