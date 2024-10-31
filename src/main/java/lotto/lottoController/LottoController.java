package lotto.lottoController;

import java.util.List;
import lotto.lottoModel.LotteryDAO;
import lotto.lottoModel.LotteryDTO;
import lotto.lottoModel.Lotto;
import lotto.lottoView.InputView;
import lotto.lottoView.OutputView;
import lotto.Utility.LottoNumberGenerator;

public class LottoController {
    private LotteryDAO lotteryDAO;
    private LotteryDTO lotteryDTO;
    private InputView inputView;
    private OutputView outputView;
    private LottoNumberGenerator lottoNumberGenerator;

    public LottoController() {
        this.lotteryDAO = new LotteryDAO();
        this.inputView = new InputView();
        this.outputView = new OutputView();

    }

    public void run() {
        String Cost = inputView.PrintStartMsg();
        //여기에 유효성 검증

        buyLotto(Cost);
        List<Lotto> allLottos = lotteryDAO.getAll();

        for (Lotto lotto : allLottos) { //todo:추후 메서드로 빼낼것
            LotteryDTO dto = new LotteryDTO(lotto.getNumbers());
            System.out.println(dto.getNumbers()); //todo 아웃뷰?
        }

        String hitLotto= inputView.PrintLottoInputMsg();
        String bonusNumber = inputView.PrintLottoInputMsg();


    }


    public void buyLotto(String cost) {
        long calcCost = Long.parseLong(cost);
        long numberOfBuy = calcCost/1000;
        outputView.howManyBuy(numberOfBuy);
        for (int j=0;j<numberOfBuy;j++){
            Lotto Lotto = new Lotto(LottoNumberGenerator.generateLottoNumbers());
            lotteryDAO.save(Lotto);
        }

    }


}
