package lotto.validator;

import java.util.InputMismatchException;
import lotto.domain.Lotto;

public class Validators {

    public void validatePurchaseAmountUnit(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위로 입력해주세요.");
        }
    }

    public void validateNumericInput(String number) {
        try {
            Integer.parseInt(number);
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요");
        }
    }

    public void validateBonusNotInWinningNumbers(Lotto lotto, int bonusNumber) {
        if(lotto.matchNumber(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호가 일치합니다.")
        }
    }
}
