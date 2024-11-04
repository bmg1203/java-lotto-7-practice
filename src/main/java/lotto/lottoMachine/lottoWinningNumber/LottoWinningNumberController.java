package lotto.lottoMachine.lottoWinningNumber;

import java.util.List;
import lotto.utils.StaticFinalMessages;

public class LottoWinningNumberController {
    private final LottoWinningNumberInputter lottoWinningNumberInputter;
    private final LottoWinningNumberDelimiter lottoWinningNumberDelimiter;
    private final LottoWinningNumberValidator lottoWinningNumberValidator;

    public LottoWinningNumberController() {
        this.lottoWinningNumberInputter = new LottoWinningNumberInputter();
        this.lottoWinningNumberDelimiter = new LottoWinningNumberDelimiter();
        this.lottoWinningNumberValidator = new LottoWinningNumberValidator();
    }

    public List<Integer> getWinningNumbers() {
        while (true) {
            String lottoWinningNumber = lottoWinningNumberInputter.getInput();
            List<String> seperatedLottoWinningNumbers = lottoWinningNumberDelimiter.getSeperatedLottoWinningNumbers(
                    lottoWinningNumber);
            if (lottoWinningNumberValidator.validateAllThing(seperatedLottoWinningNumbers)) {
                return lottoWinningNumberValidator.convertToCompareNumbers(seperatedLottoWinningNumbers);
            } else {
                System.out.println(StaticFinalMessages.ERROR_TEXT_INFRONT_OF_DETAILS
                        + StaticFinalMessages.RECOMMAND_MESSAGE_FOR_ENTERING_CORRECT_LOTTO_WINNING_NUMBER);
            }
        }
    }
}
