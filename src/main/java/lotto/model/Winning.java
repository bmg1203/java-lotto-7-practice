package lotto.model;

import java.util.Arrays;

public enum Winning {
	NONE(0, 0, false),
	FIFTH(3, 5000, false),
	FOURTH(4, 50000, false),
	THIRD(5, 1500000, false),
	SECOND(5, 30000000, true),
	FIRST(6, 2000000000, false);

	private static final int INITIAL_VALUE = 0;

	private final int count;
	private final int prize;
	private final boolean hasBonusNumber;

	Winning(int count, int prize, boolean hasBonusNumber) {
		this.count = count;
		this.prize = prize;
		this.hasBonusNumber = hasBonusNumber;
	}

	public static Winning getWinningResult(int count, boolean hasBonusNumber) {
		Winning result = Arrays.stream(Winning.values())
				.filter(winning -> winning.count == count)
				.findFirst()
				.orElse(NONE);
		result = checkIfSecond(result, hasBonusNumber);
		return result;
	}

	private static Winning checkIfSecond(Winning result, boolean hasBonusNumber) {
		if (result.count == SECOND.count && result.hasBonusNumber == SECOND.hasBonusNumber) {
			return SECOND;
		}
		return result;
	}
}
