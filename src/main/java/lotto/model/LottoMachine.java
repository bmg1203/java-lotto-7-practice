package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.dto.LottoMachineDto;
import lotto.dto.WinningNumberDto;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoMachine {
    private final List<Lotto> lottos;
    private final int money;

    public LottoMachine(int money) {
        validateMoney(money);
        this.lottos = createLottos(money);
        this.money = money;
    }

    // Test용 생성자
    public LottoMachine(List<Lotto> lottos) {
        this.lottos = lottos;
        this.money = lottos.size() * LottoIntConst.PRICE.getValue();
    }

    private void validateMoney(int money) {
        if (money % LottoIntConst.PRICE.getValue() != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1,000원 단위여야 합니다.");
        }
    }

    private List<Lotto> createLottos(int money) {
        List<Lotto> lottos = new ArrayList<>();
        int quantity = money / LottoIntConst.PRICE.getValue();
        for (int i = 0; i < quantity; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                    LottoIntConst.MIN_LOTTO_NUM.getValue(),
                    LottoIntConst.MAX_LOTTO_NUM.getValue(),
                    LottoIntConst.LOTTO_SIZE.getValue()
            );
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    public List<String> toSortedLottoStrings() {
        return lottos.stream()
                .map(Lotto::toLottoDto)
                .map(lotto -> lotto.numbers().stream()
                        .sorted()
                        .toList()
                        .toString()
                )
                .collect(Collectors.toList());
    }

    public Map<Prize, Integer> calculateWinningCounts(WinningNumberDto winningNumber) {
        Map<Prize, Integer> prizeCount = new EnumMap<>(Prize.class);
        for (Lotto lotto : lottos) {
            Prize prize = lotto.determinePrize(winningNumber.lotto(), winningNumber.bonus());
            prizeCount.put(prize, prizeCount.getOrDefault(prize, 0) + 1);
        }
        return prizeCount;
    }

    public double calculateReturnRate(Map<Prize, Integer> prizeCount) {
        long totalPrize = calculateTotalPrize(prizeCount);
        return (double) totalPrize / money * 100;
    }

    private long calculateTotalPrize(Map<Prize, Integer> prizeCount) {
        return prizeCount.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getMoney() * entry.getValue())
                .sum();
    }

    public LottoMachineDto toLottoMachineDto() {
        return new LottoMachineDto(lottos, money);
    }
}
