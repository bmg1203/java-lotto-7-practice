package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.Optional;
import lotto.util.InputHandler;
import lotto.constant.Rank;

public class LottoGame {
    public static void start() {
        String amountInput = InputHandler.handleAmountInput();

        int amount = Integer.parseInt(amountInput);
        int lottoCount = amount / 1000;
        Lotto[] lottoArray = issueLotto(lottoCount);
        List<Integer> winningLotto = InputHandler.handleWinningLottoInput();
        int bonusNumber = InputHandler.handleBonusNumberInput();
        WinnerResult winnerResult = new WinnerResult(amount);
        for (Lotto eachLotto : lottoArray) {
            Optional<Rank> rank = eachLotto.match(winningLotto, bonusNumber);
            if (rank.isEmpty()) {
                continue;
            }

            winnerResult.add(rank.get());
        }

        winnerResult.display();
    }

    private static Lotto[] issueLotto(int lottoCount) {
        Lotto[] lottoArray = new Lotto[lottoCount];
        System.out.println(lottoCount + "개를 구매했습니다.");
        for (int lottoIndex = 0; lottoIndex < lottoCount; lottoIndex++) {
            Lotto lotto = issueRandomLotto();
            lottoArray[lottoIndex] = lotto;
            lotto.display();
        }

        return lottoArray;
    }

    private static Lotto issueRandomLotto() {
        boolean randomLottoNumbersValid = false;
        Lotto lotto = null;

        while (!randomLottoNumbersValid) {
            List<Integer> randomLottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            try {
                lotto = new Lotto(randomLottoNumbers);
                randomLottoNumbersValid = true;
            } catch (IllegalArgumentException ignored) {}
        }

        return lotto;
    }
}
