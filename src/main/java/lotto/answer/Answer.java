package lotto.answer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.Lotto;

public class Answer {
	private Lotto answerLotto;
	private int bonusLotto;

	public Answer(String answerLotto, String bonusLotto) {
		this.answerLotto = new Lotto(from(answerLotto));
		this.bonusLotto = Integer.parseInt(bonusLotto);
	}

	private static List<Integer> from(String answerLotto) {
		return Arrays.asList(answerLotto.split(","))
			.stream()
			.map(Integer::parseInt)
			.collect(Collectors.toList()); 
	}

	public Lotto getAnswerLotto() {
		return answerLotto;
	}

	public int getBonusLotto() {
		return bonusLotto;
	}
}
