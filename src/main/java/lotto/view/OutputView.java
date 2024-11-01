package lotto.view;

import lotto.constants.collection.ScoreSystemPrintForm;
import lotto.constants.string.OutputMessage;
import lotto.domain.Lotto;
import lotto.dto.LottosDto;
import lotto.dto.ScoreDto;

import java.util.List;

public class OutputView {

    private static OutputView instance;

    private OutputView() {
    }

    public static OutputView getInstance() {
        if (instance == null) {
            instance = new OutputView();
        }
        return instance;
    }

    public void printBoughtLottos(LottosDto lottosDto) {
        System.out.println();
        List<Lotto> lottos = lottosDto.lottos().getLottos();
        int boughtAmount = lottos.size();
        System.out.printf((OutputMessage.BOUGHT_AMOUNT.getInstance()) + "%n", boughtAmount);
        for (int i = 0; i < boughtAmount; i++) {
            System.out.println(lottos.get(i));
        }
    }

    public void printScoreResult(ScoreDto scoreDto) {
        System.out.println();
        System.out.println(OutputMessage.RESULT_START_LINE.getInstance());
        List<String> scoreSystemFormat = ScoreSystemPrintForm.DEFAULT.getInstance();
        List<Integer> scores = scoreDto.scores();
        for (int i = 0; i < scores.size(); i++) {
            System.out.printf((scoreSystemFormat.get(i)) + "%n", scores.get(i));
        }
        float rateOfReturn = scoreDto.rateOfReturn();
        System.out.printf((OutputMessage.RATE_OF_RETURN.getInstance()) + "%n", rateOfReturn);
    }
}
