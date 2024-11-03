package lotto;

import java.util.List;
import java.util.Set;

public class LottoGame {

    private final LottoPrice totalPrice;
    private final Lottos lottos;
    private final LottoNumbers winningNumbers;
    private final Integer bonusNumber;

    private LottoGame(LottoPrice totalPrice, Lottos lottos, LottoNumbers winningNumbers, Integer bonusNumber) {
        this.totalPrice = totalPrice;
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static LottoGame of(LottoPrice totalPrice, Lottos lottos, LottoNumbers winningNumbers, Integer bonusNumber) {
        return new LottoGame(totalPrice, lottos, winningNumbers, bonusNumber);
    }

    public Integer getTotalPrice() {
        return totalPrice.getValue();
    }

    public List<Lotto> getLottos() {
        return lottos.getValue();
    }

    public Set<LottoNumber> getWinningNumbers() {
        return winningNumbers.getValue();
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
