package lotto.service;

import lotto.exception.InputValidation;
import lotto.exception.ValidateValues;
import lotto.model.Lotto;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LottoInputHandler {

    public Lotto getWinningNumbers() {
        String inputWinningNumbers = InputView.getWinningNumbers();
        List<Integer> winningNumbers = new ArrayList<>();

        if(InputValidation.NOT_BLANK.validate(inputWinningNumbers)){
            StringTokenizer tokenizer = new StringTokenizer(inputWinningNumbers,",");
            while(tokenizer.hasMoreTokens()){
                String winnerNumber = tokenizer.nextToken();
                if(ValidateValues.winningNumberOrBonusNumber(winnerNumber)){
                    winningNumbers.add(Integer.parseInt(winnerNumber));
                }
            }
        }
        return new Lotto(winningNumbers);
    }

    public int getBonusNumbers() {
        String inputBonusNumber = InputView.getBonusNumbers();
        int bonusNumber = 0;
        if(InputValidation.NOT_BLANK.validate(inputBonusNumber)){
            if(ValidateValues.winningNumberOrBonusNumber(inputBonusNumber)){
                bonusNumber = Integer.parseInt(inputBonusNumber);
            }
        }
        return bonusNumber;
    }
}
