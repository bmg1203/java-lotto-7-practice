package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoOutput {

	private int amount;
	private int lottoCount;
	private List<Integer> randoms;
	private List<List<Integer>> randomsList = new ArrayList<>();

	public LottoOutput(int amount) {
		this.amount = amount;
		output();
	}

	private void output() {
		lottoCount();
		lottoCountOutput();
		for (int i = 0; i < lottoCount; i++) {
			lottoNumberRandoms();
			addRandomsList();
			lottoNumberOutput();
		}
	}

	private void lottoCount() {
		this.lottoCount = amount / 1000;
	}

	private void lottoCountOutput() {
		System.out.println();
		System.out.println(lottoCount + "개를 구매했습니다.");
	}

	private void lottoNumberRandoms() {
		randoms = Randoms.pickUniqueNumbersInRange(1, 45, 6);
	}

	private void lottoNumberOutput() {
		Collections.sort(randoms);
		System.out.println(randoms.toString());
	}
	
	private void addRandomsList() {
			randomsList.add(randoms);
	}

	public List<List<Integer>> getRandoms() {
		return randomsList;
	}

}
