package lotto.model.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Player;

public class LottoService {
    public Lotto generateLotto() {
        List<Integer> numbers = generateRandomNumbers();

        Lotto lotto = new Lotto(numbers);
        lotto.sortNumbers();

        return lotto;
    }

    public List<Lotto> generateLottoTickets(Player player) {
        int ticketCount = calculateTicketCount(player.getPurchaseAmount());
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i ++) {
            Lotto lotto = generateLotto();
            player.addLotto(lotto);
        }
        return tickets;
    }

    public int calculateTicketCount(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            //TODO: 예외처리
        }
        return purchaseAmount / 1000;
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return numbers;
    }
}
