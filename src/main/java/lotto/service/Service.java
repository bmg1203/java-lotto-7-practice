package lotto.service;

import lotto.domain.LottoGame;
import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.utils.Utils;
import lotto.domain.Rank;
import lotto.validation.Validation;
import lotto.view.InputMessage;
import lotto.view.OutputMessage;

import java.util.List;
import java.util.Arrays;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Service {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_LAST_NUMBER = 45;
    private static final int LOTTO_LENGTH = 6;
    private static final int LOTTO_LEAST_AMOUNT = 1_000;
    private static final int LOTTO_MAX_AMOUNT = 100_000;

    Buyer buyer;
    LottoGame lottoGame;

    public void initBuyer() {
        buyer = new Buyer(getInputAmount());
    }

    public int getInputAmount() {
        InputMessage.inputAmount();
        int amount = Integer.parseInt(readLine().trim());
        Validation.validateMultipleNumber(amount, LOTTO_LEAST_AMOUNT);
        Validation.validateExceedNumber(amount, LOTTO_MAX_AMOUNT);
        return amount;
    }

    public void buyOneLotto() {
        Lotto lotto = generateLottoNumber();
        buyer.buyLotto(lotto);
    }

    public void buyAllLotto() {
        int count = buyer.getPurchaseAmount() / LOTTO_LEAST_AMOUNT;
        for (; count > 0; count--) {
            buyOneLotto();
        }
    }

    public void showBuyingResult() {
        OutputMessage.purchaseComplete(buyer.getPurchaseAmount() / LOTTO_LEAST_AMOUNT);
        for (Lotto lotto : buyer.getPurchasedLotteries()) {
            OutputMessage.lottoNumbers(lotto.getNumbers());
        }
    }

    public Lotto generateLottoNumber() {
        List<Integer> numbers = Utils.randomUniqueNumberGenerate(LOTTO_START_NUMBER, LOTTO_LAST_NUMBER, LOTTO_LENGTH);
        Validation.validateLengthOfList(numbers, LOTTO_LENGTH);
        Validation.validateDuplicationList(numbers);
        Validation.validateListNumberInRange(numbers, LOTTO_START_NUMBER, LOTTO_LAST_NUMBER);
        Utils.sortListNaturalOrder(numbers);
        return new Lotto(numbers);
    }

    public List<Integer> getInputWinningNumbers() {
        InputMessage.inputWinningNumbers();
        String userInput = readLine().trim();
        Validation.validateListStringToInteger(Arrays.asList(userInput.split(",")));
        List<Integer> winningNumbers = Utils.stringToIntegerList(userInput);
        Validation.validateLengthOfList(winningNumbers, LOTTO_LENGTH);
        Validation.validateDuplicationList(winningNumbers);
        Validation.validateListNumberInRange(winningNumbers, LOTTO_START_NUMBER, LOTTO_LAST_NUMBER);
        return winningNumbers;
    }

    public int getInputBonusNumber() {
        InputMessage.inputBonusNumber();
        String userInput = readLine().trim();
        Validation.validateStringToInteger(userInput);
        int bonusNumber = Integer.parseInt(userInput);
        Validation.validateNumberInRange(bonusNumber, LOTTO_START_NUMBER, LOTTO_LAST_NUMBER);
        return bonusNumber;
    }

    public void playLottoGame() {
        lottoGame = new LottoGame(getInputWinningNumbers());
        int bonusNumber = getInputBonusNumber();
        Validation.validateDuplicatedNumberInList(lottoGame.getWinningNumbers(), bonusNumber);
        lottoGame.setBonusNumber(bonusNumber);
    }

    public int countCorrectLottoNumbers(Lotto lotto) {
        return Utils.countSameElements(lottoGame.getWinningNumbers(), lotto.getNumbers());
    }

    public boolean containsBonusNumber(Lotto lotto) {
        return lotto.getNumbers().contains(lottoGame.getBonusNumber());
    }

    public Rank determineLottoRank(Lotto lotto) {
        int correctCount = countCorrectLottoNumbers(lotto);
        boolean correctBonusNumber = containsBonusNumber(lotto);
        for (Rank rank : Rank.values()) {
            if (correctCount == rank.getCount() && correctBonusNumber == rank.getIsBonus()) {
                return rank;
            }
        }
        return Rank.NO_RANK;
    }
}
