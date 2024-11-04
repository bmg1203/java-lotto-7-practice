package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		validate(numbers);
		this.numbers = numbers;
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != 6) {
			throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
		}
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	public int getLottoCount(int payment) {
		return payment / 1000;
	}

	public List<Lotto> getLotto(int lottoCount) {
		List<Lotto> lottos = new ArrayList<>();
		for (int i = 0; i < lottoCount; i++) {
			lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
		}
		return lottos;
	}

	public boolean isBonusMatch(List<Integer> lottos, int bonusNumber) {
		for (Integer num : lottos) {
			if (num == bonusNumber) {
				return true;
			}
		}
		return false;
	}

	public int compareNumbers(List<Integer> lottos, List<Integer> luckyNumber, int bonusNumber) {
		return (int) lottos.stream()
			.filter(luckyNumber::contains)
			.filter(num -> lottos.contains(bonusNumber))
			.count();
	}

	public long calculateTotalEarningRate(List<Lotto> lottos, List<Integer> luckyNumber, int bonusNumber) {
		long total = 0;
		for(Lotto lotto : lottos) {
			List<Integer> numbers = lotto.getNumbers();
			int matchCount = compareNumbers(numbers, luckyNumber, bonusNumber);
			total += Prize.getPrize(matchCount, isBonusMatch(numbers, bonusNumber)).getReward();
		}
		return total;
	}
}
