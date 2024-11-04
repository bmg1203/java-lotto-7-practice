package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.Result;
import lotto.model.User;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoSimulator {

    private User user;
    private Result result;
    private List<Lotto> lottos;

    public void run() {
        init();
        getCorrectInput(() -> user.setPrice(InputView.inputPurchasePrice()));
        publishLottos();
        displayPublishedLottos();
        getCorrectInput(() -> user.setLotto(new Lotto(InputView.inputWinningNumbers())));
        getCorrectInput(() -> user.setBonusNumber(InputView.inputBonusNumber()));
        matchUserLotto();
    }

    private void init() {
        user = new User();
        result = new Result();
        lottos = new ArrayList<>();
    }

    private void publishLottos() {
        int cnt = user.getPrice() / Lotto.LOTTO_PRICE;
        for (int i = 0; i < cnt; i++) {
            lottos.add(new Lotto());
        }
    }

    private void displayPublishedLottos() {
        List<List<Integer>> lottosNumbers = lottos.stream()
                .map(Lotto::getNumbers)
                .toList();
        OutputView.outputPublishedLotto(lottos.size(), lottosNumbers);
    }

    private void getCorrectInput(Runnable function) {
        while (true) {
            try {
                function.run();
                break;
            } catch (IllegalArgumentException e) {
                OutputView.outputMessage(e.getMessage());
            }
        }
    }

    private void matchUserLotto() {
        for (Lotto lotto : lottos) {
            int matchedNumbers = lotto.matchNumbers(user.getLotto());
            boolean matchedBonus = lotto.matchBonusNumber(user.getBonusNumber());
            Rank rank = Rank.getMatchedRank(matchedNumbers, matchedBonus);
            result.updateMatchedRank(rank);
        }
    }
}
