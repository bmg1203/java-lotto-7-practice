package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import lotto.common.LottoConstants;
import lotto.util.RandomNumberUtil;

public class TicketGenerator {

    public List<Lotto> generateTickets(int ticketCount) {
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            tickets.add(new Lotto(generateLottoNumbers()));
        }
        return tickets;
    }

    private List<Integer> generateLottoNumbers() {
        TreeSet<Integer> uniqueNumbers = new TreeSet<>();
        while (uniqueNumbers.size() < LottoConstants.LOTTO_NUMBER_COUNT) {
            uniqueNumbers.add(RandomNumberUtil.generateLottoNumber());
        }
        return new ArrayList<>(uniqueNumbers);
    }
}
