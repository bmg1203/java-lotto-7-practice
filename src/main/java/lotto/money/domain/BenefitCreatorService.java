package lotto.money.domain;

import lotto.lotto.domain.LottoTickets;
import lotto.lotto.domain.BonusNumber;
import lotto.lotto.domain.WinningLotto;

public interface BenefitCreatorService {
    Benefit create(LottoTickets lottoTickets, WinningLotto winningLotto, BonusNumber bonusNumber);

}
