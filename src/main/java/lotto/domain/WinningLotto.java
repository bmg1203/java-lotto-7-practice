package lotto.domain;

import lotto.Lotto;

public class WinningLotto {

    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto lotto, BonusNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public boolean contains(int number) {
        return lotto.contains(number);
    }

    public boolean equalsWithBonus(int number) {
        return bonusNumber.isSame(number);
    }
}
