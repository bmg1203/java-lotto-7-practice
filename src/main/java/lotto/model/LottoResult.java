package lotto.model;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {

    private final Map<WinningStatus, Integer> result = new EnumMap<>(WinningStatus.class);

    public LottoResult() {
        for (WinningStatus status : WinningStatus.values()) {
            result.put(status, 0);
        }
    }

    public void add(WinningStatus winningStatus) {
        result.put(winningStatus, result.get(winningStatus) + 1);
    }

    public Map<WinningStatus, Integer> getResult() {
        result.remove(WinningStatus.NO_WIN);
        return result;
    }

    public double calculateProfit(int purchaseAmount) {
        int totalPrize = result.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        return Math.round(((double) totalPrize / purchaseAmount) * 1000) / 10.0;
    }
}
