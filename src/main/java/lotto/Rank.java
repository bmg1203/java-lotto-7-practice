package lotto;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public enum Rank {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    NONE(0, false, 0);

	
	public static final List<Rank> SORTED_RANKS = List.of(FIFTH, FOURTH, THIRD, SECOND, FIRST);
	
    private static final Map<List<Object>, Rank> RANK_MAP;
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,###");

    
    static {// 당첨 순위와 매치 보너스를 기준으로 Rank를 매핑
        RANK_MAP = Arrays.stream(values())
                .collect(Collectors.toMap(
                        rank -> List.of(rank.matchCount, rank.matchBonus),
                        rank -> rank
                ));
    }

    
    private final int matchCount;
    private final boolean matchBonus;
    private final int prize;

    
    Rank(int matchCount, boolean matchBonus, int prize) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    
    public int getPrize() {
        return prize;
    }
    
    
    public String getFormattedPrize() {// 형식이 지정된 상금 금액을 문자열로 반환
        return DECIMAL_FORMAT.format(prize);
    }
    
    
    public int getMatchCount() {
        return matchCount;
    }
    

    public boolean isMatchBonus() {
        return matchBonus;
    }
    

    public static Rank calculateRank(int matchCount, boolean matchBonus) {// 당첨 순위를 계산하여 반환, 조건이 맞지 않으면 NONE 반환
        return RANK_MAP.getOrDefault(List.of(matchCount, matchBonus), NONE);
    }
}