package lotto.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.view.InputView;
import lotto.view.OutputErrorView;

import lotto.validation.WinBonusValidation;

public class WinBonusController {

    private final InputView inputView;
    private final OutputErrorView outputErrorView;

    public WinBonusController() {
        this.inputView = new InputView();
        this.outputErrorView = new OutputErrorView();
    }

    public List<Integer> inputWinning() {
        String winNum = inputView.inputWinningNumber();
        List<String> winningNumbers = Arrays.asList(winNum.split(","));
        checkValidate(winningNumbers);
        List<Integer> winNumbers = inputNumbers(winningNumbers);
        return winNumbers;
    }

    private void checkValidate(List<String> winningNumbers) {
        try {
            WinBonusValidation.winningValidation(winningNumbers);
        } catch (IllegalArgumentException e) {
            outputErrorView.errorMessage(e);
            inputWinning();
        }
    }

    private List<Integer> inputNumbers(List<String> winningNumbers) {
        List<Integer> numbers = new ArrayList<>();
        for (String num : winningNumbers) {
            numbers.add(Integer.parseInt(num));
        }
        return numbers;
    }

    public int inputBonus(List<Integer> winNumbers) {
        String bonus = inputView.inputBonusNumber();
        WinBonusValidation.bonusValidation(bonus, winNumbers);
        int numBonus = Integer.parseInt(bonus);
        return numBonus;
    }

}
