package lotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private Map<Rank, Integer> ranks = new HashMap<>();

    public Result(List<Rank> ranks) {
        for (Rank rank : ranks) {
            this.ranks.put(rank, this.ranks.getOrDefault(rank, 0) + 1);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Rank rank : Rank.values()) {
            sb.append(String.format("%s - %d개\n", rank, ranks.get(rank)));
        }
        return sb.toString();
    }

    public int getTotalPrize() {
        return Arrays.stream(Rank.values())
                .mapToInt(rank -> rank.getPrize() * ranks.getOrDefault(rank, 0))
                .sum();
    }
}
