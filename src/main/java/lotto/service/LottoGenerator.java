package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.exception.ValidateValues;
import lotto.model.Lotto;

import java.util.*;

public class LottoGenerator {

    public List<Lotto> generateLotto(String inputPurchaseAmount) {
        int purchaseAmount = ValidateValues.purchaseAmount(inputPurchaseAmount);
        int count = purchaseAmount / 1000;

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> mutableLottoNumbeers = new ArrayList<>(lottoNumbers);
            Collections.sort(mutableLottoNumbeers);
            lottos.add(new Lotto(mutableLottoNumbeers));
        }
        return lottos;
    }

    public void printLottoCount(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

}