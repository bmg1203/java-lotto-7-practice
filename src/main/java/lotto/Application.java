package lotto;


import lotto.io.Input;
import lotto.io.View;

import java.util.Arrays;
import java.util.stream.Collectors;


public class Application {
    public static void main(String[] args) {
        Integer price = Integer.parseInt(Input.inputPrice());
        Lotto winningNumber = new Lotto(Arrays.stream(Input.inputWinningNumber().split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
        Integer bonusNumber = Integer.parseInt(Input.inputBonusNumber());

        LottoGenerator lottoGenerator = new LottoGenerator(price);
        Lottos lottos = new Lottos(lottoGenerator.generateLottos());

        LottoResult lottoResult = new LottoResult(winningNumber, bonusNumber);
        lottoResult.calculate(lottos);
        lottoResult.calculateTotalBenefit();

        printResults(lottos, lottoResult);
    }

    private static void printResults(Lottos lottos,LottoResult lottoResult) {
        View view = new View();
        view.printLotto(lottos.getLottoCount(), lottos.toString());
        view.printWinningResult(lottoResult.toString());
        view.printProfit(lottoResult.getProfitRate(lottos));
    }
}
