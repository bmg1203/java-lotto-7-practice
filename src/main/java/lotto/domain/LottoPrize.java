package lotto.domain;

public enum LottoPrize {
  THREE_MATCH(3, 5000),
  FOUR_MATCH(4, 50000),
  FIVE_MATCH(5, 1500000),
  FIVE_MATCH_BONUS(5, 30000000),
  SIX_MATCH(6, 2000000000);

  private final int matchCount; // 일치 개수
  private final int prize; // 상금

  LottoPrize(int matchCount, int prize) {
    this.matchCount = matchCount;
    this.prize = prize;
  }

  public int getMatchCount() {
    return matchCount;
  }

  public int getPrize() {
    return prize;
  }
}
