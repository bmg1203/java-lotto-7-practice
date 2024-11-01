package lotto.controller;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.PurchasePrice;
import lotto.domain.WinningNumbers;
import lotto.service.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView = new InputView();
    private final LottoGenerator lottoGenerator = new LottoGenerator();
    private final OutputView outputView = new OutputView();

    public void run() {
        // 구매할 금액 입력 받기
        PurchasePrice purchasePrice = inputView.receivePurchasePrice();
//        System.out.println("This is the purchase price. " + purchasePrice.getPurchasePrice());

        // 구매 개수만큼 로또 생성
        List<Lotto> generatedLottoNumbers = lottoGenerator.generate(purchasePrice);
//        System.out.println(generatedLottoNumbers);

        outputView.printLottoNumbers(generatedLottoNumbers);

        // 당첨 번호 입력
        WinningNumbers winningNumbers = inputView.receiveWinningNumbers();

        // 보너스 번호 입력
        BonusNumber bonusNumber = inputView.receiveBonusNumber();

    }
}
