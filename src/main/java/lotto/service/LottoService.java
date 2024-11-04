package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.dto.Purchase;
import lotto.model.Lotto;
import lotto.model.MyLotto;
import lotto.model.Winning;
import lotto.view.OutputView;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private final BigInteger FIRST_WINNING = BigInteger.valueOf(2000000000);
    private final BigInteger SECOND_WINNING = BigInteger.valueOf(30000000);
    private final BigInteger THIRD_WINNING = BigInteger.valueOf(1500000);
    private final BigInteger FOURTH_WINNING = BigInteger.valueOf(50000);
    private final BigInteger FIFTH_WINNING = BigInteger.valueOf(5000);

    public MyLotto buyLottos(Purchase purchase) {
        OutputView outputView = new OutputView();

        outputView.printLottoAmount(purchase.getAmount());
        return new MyLotto(makeLottoNumbers(purchase.getAmount()));
    }

    private List<Lotto> makeLottoNumbers(BigInteger amount) {
        OutputView outputView = new OutputView();
        List<Lotto> lottos = new ArrayList<>();

        for (BigInteger i = BigInteger.ZERO; i.compareTo(amount) < 0; i = i.add(BigInteger.ONE)) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).stream()
                    .sorted()
                    .toList();
            outputView.printMyLotto(randomNumbers);
            lottos.add(new Lotto(randomNumbers));
        }
        return lottos;
    }

    public void checkWinning(Purchase purchase, MyLotto myLotto, Winning winning) {
        for (Lotto lotto : myLotto.getLottos()) {
            Long sameCount = matchLottoNumbers(lotto.getNumbers(), winning.getWinNumbers().getNumbers());

            updatePlaces(myLotto, sameCount, matchBonusNumbers(lotto.getNumbers(), winning.getBonusNumber()));
        }
        OutputView outputView = new OutputView();
        outputView.printWinningPlaces(myLotto);
        outputView.printProfitability(purchase, calculateWinning(myLotto));
    }

    private Long matchLottoNumbers(List<Integer> lotto, List<Integer> winning) {
        return lotto.stream()
                .filter(winning::contains)
                .count();
    }

    private boolean matchBonusNumbers(List<Integer> lotto, BigInteger bonusNumber) {
        List<BigInteger> bigIntegerLotto = lotto.stream()
                .map(BigInteger::valueOf)
                .toList();

        return bigIntegerLotto.stream()
                .anyMatch(number -> number.equals(bonusNumber));
    }

    private void updatePlaces(MyLotto myLotto, Long sameCount, Boolean bonusMatch) {
        if (sameCount == 3L) {
            myLotto.updateFifthPlace();
        }
        if (sameCount == 4L) {
            myLotto.updateFourthPlace();
        }
        if (sameCount == 5L && !bonusMatch) {
            myLotto.updateThirdPlace();
        }
        if (sameCount == 5L && bonusMatch) {
            myLotto.updateSecondPlace();
        }
        if (sameCount == 6L) {
            myLotto.updateFirstPlace();
        }
    }

    private BigInteger calculateWinning(MyLotto myLotto) {
        return BigInteger.valueOf(myLotto.getFirstPlace() * FIRST_WINNING.longValue() + myLotto.getSecondPlace() * SECOND_WINNING.longValue() +
                myLotto.getThirdPlace() * THIRD_WINNING.longValue() + myLotto.getFourthPlace() * FOURTH_WINNING.longValue() +
                myLotto.getFifthPlace() * FIFTH_WINNING.longValue());
    }
}
