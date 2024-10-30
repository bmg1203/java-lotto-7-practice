package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.enums.LottoRank;
import lotto.domain.generator.RandomNumbers;
import lotto.util.converter.PurchaseCountConverter;
import lotto.util.converter.WinningNumberConverter;

import java.util.EnumMap;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        String inputPurchaseAmount = Console.readLine();

        PurchaseCountConverter purchaseCountConverter = new PurchaseCountConverter(inputPurchaseAmount);
        int purchaseCount = purchaseCountConverter.convert();

        RandomNumbers randomNumbers = new RandomNumbers();
        randomNumbers.addRandomNumber(purchaseCount);

        String inputWinningNumber = Console.readLine();
        String inputBonusNumber = Console.readLine();

        WinningNumberConverter winningNumberConverter = new WinningNumberConverter(inputWinningNumber);
        List<Integer> winningNumbers = winningNumberConverter.convertWinningNumber();
        int bonusNumber = winningNumberConverter.convertBonusNumber(inputBonusNumber);

        Lotto lotto = new Lotto(winningNumbers);
        EnumMap<LottoRank, Integer> rankCount = lotto.checkWinning(randomNumbers, bonusNumber);
    }
}
