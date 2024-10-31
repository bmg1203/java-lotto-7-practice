package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.Lotto;
import lotto.constant.LottoConstant;

public class LottoService {
    public Lotto createLotto(){
        Lotto lotto = new Lotto(createLottoNumbers());
        lotto.sort();
        return lotto;
    }

    private List<Integer> createLottoNumbers(){
        return Randoms.pickUniqueNumbersInRange(
                LottoConstant.LOTTO_NUMBER_MIN,
                LottoConstant.LOTTO_NUMBER_MAX,
                LottoConstant.LOTTO_NUMBER_SIZE);
    }

}
