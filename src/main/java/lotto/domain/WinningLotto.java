package lotto.domain;

import static lotto.common.ErrorConstants.ERROR_HEADER;
import static lotto.common.LottoConstants.LOTTO_NUMBER_MAX;
import static lotto.common.LottoConstants.LOTTO_NUMBER_MIN;

import java.util.List;
import lotto.common.LottoRank;

public class WinningLotto {
    private static final int BONUS_NUMBER_MAX = LOTTO_NUMBER_MAX;
    private static final int BONUS_NUMBER_MIN = LOTTO_NUMBER_MIN;
    private static final String ERROR_MESSAGE_BONUS_NUMBER_RANGE = ERROR_HEADER + "보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String ERROR_MESSAGE_BONUS_NUMBER_DUPLICATE = ERROR_HEADER + "보너스 번호는 1부터 45 사이의 숫자여야 합니다.";

    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        this.winningLotto = Lotto.create(winningNumbers);
        validate(bonusNumber, this.winningLotto);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber, Lotto winningLotto) {
        if (bonusNumber < BONUS_NUMBER_MIN || bonusNumber > BONUS_NUMBER_MAX) {
            throw new IllegalArgumentException(ERROR_MESSAGE_BONUS_NUMBER_RANGE);
        }
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_BONUS_NUMBER_DUPLICATE);
        }
    }

    public LottoRank determineRank(Lotto userTicket) {
        int matchCount = userTicket.matchCount(winningLotto);
        boolean bonusMatch = userTicket.contains(bonusNumber);
        return LottoRank.valueOf(matchCount, bonusMatch);
    }
}
