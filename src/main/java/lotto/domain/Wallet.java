package lotto.domain;

import static lotto.constant.ExceptionMessage.INVALID_MONEY_UNIT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lotto.constant.Rank;
import lotto.random.LottoRandom;

public class Wallet {

    private long money;
    private long originalMoney;
    private Map<Rank, Integer> ranks = new HashMap<>();
    private final List<Lotto> lottos = new ArrayList<>();

    public Wallet(long money) {
        validateMoney(money);
        this.money = money;
        originalMoney = money;
    }

    public void buyLottoTickets(LottoRandom strategy) {
        long ticketCount = money / 1000;
        money -= ticketCount * 1000;
        while (ticketCount-- > 0) {
            lottos.add(new Lotto(strategy.getLottoNumbers()));
        }
    }

    private void validateMoney(long money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_MONEY_UNIT.getMessage(1000));
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getLottoTicketCounts() {
        return lottos.size();
    }

    public void addRank(Rank rank) {
        ranks.merge(rank, 1, Integer::sum);
    }

    public double gain() {
        long totalPrice = ranks.entrySet().stream()
            .mapToLong(set -> set.getKey().getPrice() * set.getValue())
            .sum();
        return (double)totalPrice / originalMoney;
    }

    public Map<Rank, Integer> getRanks() {
        return ranks;
    }
}
