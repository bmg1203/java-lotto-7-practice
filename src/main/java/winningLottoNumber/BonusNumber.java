package winningLottoNumber;

import constant.ErrorConst;

public class BonusNumber {

    private final int bonusNumber;

    private BonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }


    public static BonusNumber createBonusNumber(String bonusNumber) {

        int parsedBonusNumber = parseBonusNumber(bonusNumber);
        validateBonusNumberRange(parsedBonusNumber);
        return new BonusNumber(parsedBonusNumber);
    }


    public int getBonusNumber() {
        return bonusNumber;
    }


    private static int parseBonusNumber(String bonusNumber) {
        try {
            return Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorConst.ERROR_PARSING_NUMBER);
        }

    }


    private static void validateBonusNumberRange(int parsedBonusNumber) {

        if (parsedBonusNumber > 45 || parsedBonusNumber < 1) {
            throw new IllegalArgumentException(ErrorConst.ERROR_BONUS_NUMBER_RANGE);
        }

    }


}
