package lotto.factory;

import java.util.List;
import lotto.service.calculator.ResultCalculator;

public class ResultCalculatorFactory {

    public static ResultCalculator create(List<Integer> winningResult, List<Integer> bonusResult) {
        return new ResultCalculator(winningResult, bonusResult);
    }
}
