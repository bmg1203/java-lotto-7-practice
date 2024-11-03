package lotto;

import java.util.List;
import lotto.Console.InputConsole;
import lotto.Console.OutputConsole;

public class LottoProgress {

    public static void lottoProgress() {
        int inputMoney = InputConsole.intputMoney();
        List<Lotto> lottoList = buyLotto(inputMoney);

        Lotto winningLottoNumbers = InputConsole.inputWinningNumbers();
        int bonusNum = InputConsole.inputBonusNumbers(winningLottoNumbers);

        OutputConsole.outputWinningStatics(winningLottoNumbers, lottoList, bonusNum);
        OutputConsole.outputProfit(inputMoney);
    }

    private static List<Lotto> buyLotto(int inputMoney) {
        int lottoNum = LottoList.lottoNumber(inputMoney);
        System.out.println("\n" + lottoNum + "개를 구매했습니다.");

        List<Lotto> lottoList = LottoList.drawingLotto(lottoNum);
        OutputConsole.outputLottoList(lottoList);

        return lottoList;
    }
}
