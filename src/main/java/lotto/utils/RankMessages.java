package lotto.utils;

import java.util.HashMap;
import java.util.Map;

public class RankMessages {
    private static final Map<Integer, String> messages = new HashMap<>();

    static {
        messages.put(3, "3개 일치");
        messages.put(4, "4개 일치");
        messages.put(5, "5개 일치");
        messages.put(6, "6개 일치");
    }

    public static String getMessage(int matchCount, boolean matchBonus) {
        if (matchCount == 5 && matchBonus) {
            return "5개 일치, 보너스 볼 일치";
        }
        return messages.get(matchCount);
    }
}