package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.User;
import lotto.view.LottosView;

public class LottoService {

    private final User user;
    private static final Lottos lottos = new Lottos();

    public LottoService(User user) {
        this.user = user;
    }

    public void run() {
        makeLottoNumber(user, lottos);
        LottosView.displayLottoNumbers(lottos);
    }

    public static void makeLottoNumber(User user, Lottos lottos) {
        int lottoAmount = user.getNumOfLottos();

        for (int lotto = 0; lotto < lottoAmount; lotto++) {
            List<Integer> lottoNumbers = getRandomLottoNumber();
            lottos.addLottoToList(new Lotto(lottoNumbers));
        }
    }

    public static List<Integer> getRandomLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public static void sortAscending(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);
    }


}
