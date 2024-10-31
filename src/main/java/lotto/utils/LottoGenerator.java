package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.domain.LottoTickets;

public class LottoGenerator {

    public static LottoTickets generateLottoTickets(int lottoAmount) {
        List<Lotto> lottoList = Stream.generate(LottoGenerator::generateSortedLottoNumbers)
                .limit(lottoAmount)
                .map(Lotto::new)
                .toList();

        return new LottoTickets(lottoList);
    }

    private static List<Integer> generateSortedLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6).stream()
                .sorted()
                .toList();
    }
}
