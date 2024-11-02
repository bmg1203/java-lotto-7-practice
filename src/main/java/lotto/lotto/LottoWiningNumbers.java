package lotto.lotto;

public class LottoWiningNumbers {

    private final WiningNumbers winingNumbers;
    private final LottoNumber bonusNumber;

    public LottoWiningNumbers(WiningNumbers winingNumbers, LottoNumber bonusNumber) {
        validate(winingNumbers, bonusNumber);
        this.winingNumbers = winingNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Rank match(Lotto lotto) {
        int countOfMatch = winingNumbers.countOfMatch(lotto);
        boolean matchBonus = winingNumbers.contains(bonusNumber);
        return Rank.determine(countOfMatch, matchBonus);
    }

    private void validate(WiningNumbers winingNumbers, LottoNumber bonusNumber) {
        if (winingNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
