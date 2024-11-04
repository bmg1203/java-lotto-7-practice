package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.LottoService;
import lotto.model.Rank;
import lotto.model.StringParser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private InputView inputView;
    private OutputView outputView;
    private LottoGenerator lottoGenerator;
    private final String digitRegex = "^[0-9]+$";

    public LottoController(InputView inputView, OutputView outputView, LottoGenerator lottoGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoGenerator = lottoGenerator;
    }

    public int getPurchaseAmount() {
        while (true) {
            try {
                String input = inputView.readPurchaseAmount();
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 숫자만 입력해주세요.");
            }
        }
    }

    public List<Integer> getWinningNumbers() {
        while (true) {
            try {
                String input = inputView.readWinningNumbers();
                return StringParser.parseStringToWinningNumbers(input);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 숫자만 입력해주세요.");
            }
        }
    }

    public int getBonusNumber() {
        while (true) {
            try {
                String input = inputView.readBonusNumber();
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 숫자만 입력해주세요.");
            }
        }
    }

    public List<Lotto> buyLotties(){
        int purchaseAmount = getPurchaseAmount();
        List<Lotto> lotties = lottoGenerator.generate(purchaseAmount);
        outputView.showLotties(lotties);
        return lotties;
    }

    public List<Rank> draw(List<Lotto> lotties) {
        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber();
        validateDuplicatedBonusNumber(winningNumbers, bonusNumber);
        LottoService lottoService = new LottoService(winningNumbers, bonusNumber);
        List<Rank> ranks = new ArrayList<>();

        for (Lotto lotto : lotties) {
            Rank rank = lottoService.match(lotto);
            ranks.add(rank);
        }

        return ranks;
    }

    public void run() {
        List<Lotto> lotties = buyLotties();
        List<Rank> ranks = draw(lotties);
        outputView.showResult(ranks);
    }

    public void validateDuplicatedBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복없이 입력해야 합니다.");
        }
    }
}
