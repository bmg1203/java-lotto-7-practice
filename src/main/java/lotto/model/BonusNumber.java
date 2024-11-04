package lotto.model;

public class BonusNumber {
    private final int bonusNumber;

    private BonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber from(int bonusNumber) {
        return new BonusNumber(bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
