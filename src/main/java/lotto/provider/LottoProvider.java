package lotto.provider;

import static lotto.exception.ExceptionMessage.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

public class LottoProvider {
	private static final int THOUSAND = 1000;
	private static final int MIN_LOTTO_NUMBER = 1;
	private static final int MAX_LOTTO_NUMBER = 45;
	private static final int LOTTO_DRAW_COUNT = 6;
	private static final String LOTTO_PURCHASE_AMOUNT_MESSAGE = "개를 구매했습니다.";
	private final int numberOfLottos;
	private final int lottoPurchaseAmount;

	private List<Lotto> pickedLottos = new ArrayList<>();

	public LottoProvider(String lottoPurchaseAmount) {
		int lottoPurchaseAmountNum = Integer.parseInt(lottoPurchaseAmount);
		validateLottoPurchaseAmount(lottoPurchaseAmountNum);
		this.lottoPurchaseAmount = lottoPurchaseAmountNum;
		this.numberOfLottos = lottoPurchaseAmountNum / THOUSAND;
	}

	private void validateLottoPurchaseAmount(int lottoPurchaseAmount) {
		if (lottoPurchaseAmount % THOUSAND != 0) {
			throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT_INPUT.getMessage());
		}
	}

	public void pickLottoNumbers() {
		for (int i = 0; i < numberOfLottos; i++) {
			List<Integer> pickedLottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_DRAW_COUNT);
			pickedLottoNumbers = pickedLottoNumbers.stream().sorted().collect(Collectors.toList());
			pickedLottos.add(new Lotto(pickedLottoNumbers));
		}
	}

	public void printPickedLottoResults() {
		System.out.println(numberOfLottos + LOTTO_PURCHASE_AMOUNT_MESSAGE);
		for (Lotto pickedLotto : pickedLottos) {
			pickedLotto.printLottoNumbers();
		}
	}

	public List<Lotto> getPickedLottos() {
		return pickedLottos;
	}

	public int getLottoPurchaseAmount() {
		return lottoPurchaseAmount;
	}
}
