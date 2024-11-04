package lotto.sevice;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputValidServiceTest {
    InputValidService inputValidService = new InputValidService();
    @Test
    void isMoneyTest() {
        //gievn
        String money = "1010";
        //when
        boolean res = inputValidService.isMoney(money);
        //then
        assertThat(res).isFalse();
    }

    @Test
    void isWinNumbersTest() {
        //given
        String str = "1,2,3,4,5,6";
        String str2 = "400,12";

        //when
        boolean res = inputValidService.isWinNumbers(str);
        boolean res2 = inputValidService.isWinNumbers(str2);

        //then
        assertThat(res).isTrue();
        assertThat(res2).isFalse();
    }

    @Test
    void isRangeTest(){
        //given
        int a = 100;
        int b = 0;
        int c = 45;
        //when
        boolean resA = inputValidService.isRange(a);
        boolean resB = inputValidService.isRange(b);
        boolean resC = inputValidService.isRange(c);
        //then
        assertThat(resA).isFalse();
        assertThat(resB).isTrue();
        assertThat(resC).isTrue();
    }
}