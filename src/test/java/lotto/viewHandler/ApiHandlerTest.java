package lotto.viewHandler;

import lotto.viewHandler.api.Api;
import lotto.viewHandler.api.dto.BonusNumberDto;
import lotto.viewHandler.api.dto.MoneyDto;
import lotto.viewHandler.api.dto.WinningLottoNumbersDto;
import lotto.viewHandler.api.message.ServerMessage;
import lotto.viewHandler.validator.LottoNumberRangeValidator;
import lotto.viewHandler.validator.LottoNumberSplit;
import lotto.viewHandler.validator.LottoPurchaseUnitValidator;
import lotto.viewHandler.validator.ParseInt;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ApiHandlerTest {
    private final ApiHandler apiHandler;

    public ApiHandlerTest() {
        ValidatorImpl validator = new ValidatorImpl(new ParseInt(),
                new LottoNumberRangeValidator(),
                new LottoPurchaseUnitValidator(),
                new LottoNumberSplit());
        this.apiHandler = new ApiHandler(validator);
    }

    @Test
    void 로또_구입_돈_API_변환_확인() {
        String input = "10000";
        Api<MoneyDto> expect = new Api<>(ServerMessage.클라이언트_성공, new MoneyDto(10_000));
        Api<MoneyDto> result = apiHandler.transformMoneyDto(input);

        assertThat(result.getData().getMoney()).isEqualTo(expect.getData().getMoney());
    }

    @Test
    void 로또_당첨_번호_API_변환_확인() {
        String input = "1,2,3,4,5,6";
        Api<WinningLottoNumbersDto> expect = new Api<>(ServerMessage.클라이언트_성공, new WinningLottoNumbersDto(List.of(1,2,3,4,5,6)));
        Api<WinningLottoNumbersDto> result = apiHandler.transformLottoNumbers(input);

        assertThat(result.getData().getNumbers()).isEqualTo(expect.getData().getNumbers());
    }

    @Test
    void 보너스_번호_API_변환_확인() {
        String input = "39";
        Api<BonusNumberDto> expect = new Api<>(ServerMessage.클라이언트_성공, new BonusNumberDto(39));
        Api<BonusNumberDto> result = apiHandler.transformLottoBonusNumber(input);

        assertThat(result.getData().getNumber()).isEqualTo(expect.getData().getNumber());
    }
}