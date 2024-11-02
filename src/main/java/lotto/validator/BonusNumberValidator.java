package lotto.validator;

import lotto.model.Lotto;

public class BonusNumberValidator {

    public static final int MAX_BONUS_NUMBER = 45;
    public static final int MIN_BONUS_NUMBER = 1;

    public static void validateBonusNumber(Lotto lotto, int bonusNumber) {
        validateBonusNumberRange(bonusNumber);
        validateBonusNumberNotInLotto(lotto, bonusNumber);
    }

    private static void validateBonusNumberRange(int bonusNumber) {
        if (isOutOfRange(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45까지의 숫자여야 합니다.");
        }
    }

    private static boolean isOutOfRange(int bonusNumber) {
        return bonusNumber > MAX_BONUS_NUMBER || bonusNumber < MIN_BONUS_NUMBER;
    }

    private static void validateBonusNumberNotInLotto(Lotto lotto, int bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 당첨 번호와 중복되지 않는 번호를 입력해야 합니다.");
        }
    }
}
