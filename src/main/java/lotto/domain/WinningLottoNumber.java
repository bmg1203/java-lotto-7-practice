package lotto.domain;

import static lotto.constants.ErrorMessage.PUT_VALID_BONUS_NUMBER;
import static lotto.constants.ErrorMessage.PUT_VALID_LOTTO_NUMBERS;
import static lotto.constants.LottoConstant.REGEX;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinningLottoNumber {

    private Lotto winningNumber;
    private BonusNumber bonusNumber;

    public WinningLottoNumber(Lotto winningNumber, String bonusNumber){
        this.winningNumber = winningNumber;
        this.bonusNumber = parseBonusNumber(bonusNumber, this.winningNumber);
    }

    public static Lotto parseWinningNumber(String winningNumber) {
        List<String> list = new ArrayList<>(Arrays.asList(winningNumber.split(REGEX, -1)));
        List<Integer> winningNumbers = new ArrayList<>();

        for (String lottoNumber : list) {
            try {
                winningNumbers.add(Integer.parseInt(lottoNumber));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(PUT_VALID_LOTTO_NUMBERS.getMessage());
            }
        }
        return new Lotto(winningNumbers);
    }

    public static BonusNumber parseBonusNumber(String bonusNumber, Lotto winningNumber) {
        int bonus;
        try {
            bonus = Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PUT_VALID_BONUS_NUMBER.getMessage());
        }
        return new BonusNumber(bonus, winningNumber);
    }

    public List<Integer> getWinningNumber() {
        return winningNumber.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber.getBonus();
    }
}
