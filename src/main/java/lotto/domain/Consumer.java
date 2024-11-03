package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.validation.Validation.*;

public class Consumer {

    private final static int MAX_COST = 100000;
    private final static int MIN_COST = 1000;
    private final static int ZERO = 0;
    private final ArrayList<Lotto> lottoes = new ArrayList<>();
    private final HashMap<LottoRank, Integer> lottoRankResult = new HashMap<>();
    private final int money;

    public Consumer(int money) {
        validateMoney(money);
        this.money = money;
        initLottoRank();
    }

    private void validateMoney(int money) {
        checkMoneyMinCost(money, MIN_COST);
        checkMoneyMaxCost(money, MAX_COST);
    }

    public int getMoney() {
        return money;
    }


    public void buyLotto(Lotto lotto) {
        lottoes.add(lotto);
    }

    public ArrayList<Lotto> getLottoes() {
        return lottoes;
    }

    public void initLottoRank() {
        for (LottoRank rank : LottoRank.values()) {
            lottoRankResult.put(rank, ZERO);
        }
    }



}
