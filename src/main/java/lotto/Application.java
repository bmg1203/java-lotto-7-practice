package lotto;


import controller.Controller;
import lottoManager.LottoWinningResult;
import repository.PurchasedLottoRepository;
import repository.WinningNumberRepository;
import service.LottoService;
import service.LottoServiceImpl;
import view.InputView;
import view.InputViewImpl;
import view.OutputView;
import view.OutputViewImpl;


public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputViewImpl();
        OutputView outputView = new OutputViewImpl();
        PurchasedLottoRepository purchasedLottoRepository = new PurchasedLottoRepository();
        WinningNumberRepository winningNumberRepository = new WinningNumberRepository();
        LottoWinningResult lottoWinningResult = new LottoWinningResult();
        LottoService lottoService = new LottoServiceImpl(purchasedLottoRepository,winningNumberRepository,lottoWinningResult);

        Controller controller = new Controller(inputView,outputView, lottoService);
        controller.play();

    }
}
