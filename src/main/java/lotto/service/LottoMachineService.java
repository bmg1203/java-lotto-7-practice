package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Member;
import lotto.util.LottoParser;
import lotto.util.LottoValidator;

public class LottoMachineService {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    private final LottoMachine lottoMachine = LottoMachine.getInstance();
    private final Member member = Member.getInstance();

    public void inputLottoPurchaseAmount(String purchaseAmount) {
        int validPrice = LottoValidator.validNumber(purchaseAmount);
        LottoValidator.validatePriceUnit(validPrice);
        lottoMachine.savePurchaseAmount(validPrice);
    }

    public void inputBonusNumber(String bonusNumber) {
        int validBonusNumber = LottoValidator.validNumber(bonusNumber);
        lottoMachine.saveBonusNumber(validBonusNumber);
    }

    public void inputWinningNumbers(String numbers) {
        List<Integer> winningNumbers = LottoParser.parsingNumber(numbers);
        lottoMachine.saveWinningNumbers(winningNumbers);
    }

    public void issueLottos() {
        int numberOfIssues = LottoParser.parsingPrice(lottoMachine.getPurchaseAmount());
        for (int number = 0; number < numberOfIssues; number++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_SIZE);
            member.saveIssuedLotto(new Lotto(numbers));
        }
    }

    // TODO: 사용자의 로또 번호와 비교한다.

    // TODO: 맞춘 개수와 금액을 사용자에게 전달한다.
}
