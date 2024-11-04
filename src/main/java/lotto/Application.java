package lotto;

import java.util.ArrayList;
import java.util.List;

class PurchaseLotto {
	Lotto userLotto;
	int correctNumberCount;
	int winningGrade;

	public PurchaseLotto(Lotto newLotto) {
		this.userLotto = newLotto;
		this.correctNumberCount = 0;
		this.winningGrade = 0;
	}

	public Lotto getPurchasedLotto() {
		return this.userLotto;
	}

	public int getCorrectNumberCount() {
		return this.correctNumberCount;
	}

	public void setCorrectNumberCount(int correctNumberCount) {
		this.correctNumberCount = correctNumberCount;
	}

	public int getWinningGrade() {
		return this.winningGrade;
	}

	public void setWinningGrade(int winningGrade) {
		this.winningGrade = winningGrade;
	}
}

class WinningLottory {
	private Lotto winningLotto;
	private int bonusNumber;

	public WinningLottory(Lotto winningLotto, int bonusNumber) {
		this.winningLotto = winningLotto;
		this.bonusNumber = bonusNumber;
	}

	public Lotto getWinningLotto() {
		return this.winningLotto;
	}

	public int getBonusNumber() {
		return this.bonusNumber;
	}
}

class MainController {
	public static int insertMoney() {
		try {
			String amountOfMoney = camp.nextstep.edu.missionutils.Console.readLine();

			return Integer.parseInt(amountOfMoney);

		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[Error] 숫자가 아닌 값이 입력되었습니다.");
		}

	}

	public static int changeMoneyToCount(int money) {
		if (money % 1000 != 0) {
			throw new IllegalArgumentException("[Error] 로또는 1000원 단위로 구입할 수 있습니다.");
		}
		return money / 1000;
	}

	public static ArrayList<PurchaseLotto> makeUserLottoNumber(int purchaseCount) {
		ArrayList<PurchaseLotto> userLottoPackage = new ArrayList<PurchaseLotto>();

		for (int i = 0; i < purchaseCount; i++) {
			Lotto newPrintedLotto = new Lotto(
					camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange(1, 45, 6));
			userLottoPackage.add(new PurchaseLotto(newPrintedLotto));
		}

		return userLottoPackage;
	}

	public static Lotto inputWinnerNumber() {
		try {
			String winnerNumberInput = camp.nextstep.edu.missionutils.Console.readLine();
			String[] winnerNumberPackage = winnerNumberInput.split(",");
			List<Integer> winnerNumber = new ArrayList<Integer>();

			for (int i = 0; i < winnerNumberPackage.length; i++) {
				winnerNumber.add(Integer.parseInt(winnerNumberPackage[i]));
			}
			return new Lotto(winnerNumber);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[Error] 당첨 번호로 숫자를 입력하여야 합니다.");
		}
	}

	public static void checkLottoNumberRange(int lottoNumber) {
		if (lottoNumber == 0) {
			throw new IllegalArgumentException("[Error] 0은 입력할 수 없습니다.");
		}
		if (lottoNumber < 0) {
			throw new IllegalArgumentException("[Error] 음수는 입력할 수 없습니다.");
		}

		if (lottoNumber > 45) {
			throw new IllegalArgumentException("[Error] 45를 초과하는 수는 입력할 수 없습니다.");
		}
	}

	public static int inputBonusNumber() {
		try {
			int bonusNumber = Integer.parseInt(camp.nextstep.edu.missionutils.Console.readLine());
			return bonusNumber;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[Error] 보너스 번호로 숫자를 입력하여야 합니다.");
		}
	}

	public static int checkWinningNumber(Lotto lotto, WinningLottory winningLotto) { // 하나의 로또와 당첨 번호를 비교
		int winningNumberCount = 0;

		for (int i = 0; i < 6; i++) {
			if (lotto.getLottoNumber().contains(winningLotto.getWinningLotto().getLottoNumber().get(i))) {
				winningNumberCount += 1;
			}
		}

		return winningNumberCount;
	}

	public static int determineLottoGrade(PurchaseLotto userLotto, int bonusNumber) {
		if (userLotto.getCorrectNumberCount() == 6) {
			return 1;
		}

		if (userLotto.getCorrectNumberCount() == 5
				&& userLotto.getPurchasedLotto().getLottoNumber().contains(bonusNumber)) {
			return 2;
		}

		if (userLotto.getCorrectNumberCount() == 5) {
			return 3;
		}

		if (userLotto.getCorrectNumberCount() == 4) {
			return 4;
		}

		if (userLotto.getCorrectNumberCount() == 3) {
			return 5;
		}

		return 0;
	}

	public static void checkAllLottoNumber(ArrayList<PurchaseLotto> purchasedLottoPackage,
			WinningLottory winningLotto) {
		for (int i = 0; i < purchasedLottoPackage.size(); i++) {
			purchasedLottoPackage.get(i).setCorrectNumberCount(
					MainController.checkWinningNumber(purchasedLottoPackage.get(i).getPurchasedLotto(), winningLotto));
			purchasedLottoPackage.get(i).setWinningGrade(
					MainController.determineLottoGrade(purchasedLottoPackage.get(i), winningLotto.getBonusNumber()));
		}
	}

	public static int[] calculatingGrade(ArrayList<PurchaseLotto> purchasedLottoPackage) {
		int[] gradingCount = new int[7];
		for (int i = 0; i < purchasedLottoPackage.size(); i++) {
			gradingCount[purchasedLottoPackage.get(i).winningGrade]++;
		}

		return gradingCount;
	}

	public static String rateOfReturn(int[] gradingCount, int purchaseMoney) {
		double moneySum = gradingCount[5] * 5000 + gradingCount[4] * 50000 + gradingCount[3] * 1500000
				+ gradingCount[2] * 30000000 + gradingCount[1] * 2000000000;
		double profitRate = (moneySum / (double)purchaseMoney) * 100;
		
		return String.format("%.1f", profitRate);
	}
}

public class Application {
	public static void main(String[] args) {
		
	}
}
