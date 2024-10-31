package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        IOController ioController = new IOController();

        Integer LottoCount = ioController.inputPurchaseAmount();

        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < LottoCount / LOTTO_PRICE; i++) {
            lottoList.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }

        ioController.printLottoList(lottoList);

        List<Integer> winningNumbers = ioController.inputWinningNumbers();
        Integer bonusNumber = ioController.inputBonusNumber(winningNumbers);

        List<LottoResult> lottoResultList = new ArrayList<>();
        for (Lotto lotto : lottoList) {
            lottoResultList.add(new LottoResult(lotto, winningNumbers, bonusNumber));
        }

        LottoStatistic lottoStatistic = new LottoStatistic(lottoResultList);
        ioController.printWinningStatistics(lottoStatistic);

    }
}
