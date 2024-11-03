package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.dto.Lottos;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.*;

public class LottoService {

    public Lottos makeRandomLotto(Long money) {
        List<Lotto> createdLotto = new ArrayList<>();
        for (int i = 0; i < money / 1000; i++) {
            List<Integer> numbers = pickRandomUniqueSixNumbers()
                    .stream()
                    .sorted()
                    .toList();
            createdLotto.add(new Lotto(numbers));
        }

        return new Lottos(createdLotto);
    }

    public List<Integer> pickRandomUniqueSixNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<Integer> splitSixNumbers(String numbers) {
        String[] numbersArray = splitNumbers(numbers);
        return convertToIntegerList(numbersArray);
    }

    private static String[] splitNumbers(String numbers) {
        String[] numbersArray = numbers.split(",");
        if (numbersArray.length != 6) {
            throw new IllegalArgumentException(LottoServiceErrorConfig.COMMA_SPLIT_ERROR.getError());
        }

        Arrays.sort(numbersArray);
        return numbersArray;
    }

    private static List<Integer> convertToIntegerList(String[] numbersArray) {
        try {
            return Arrays.stream(numbersArray).map(LottoService::convertStringToInt).toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoServiceErrorConfig.STRING_TO_INT_CONVERT_ERROR.getError());
        }
    }

    public Integer getBonusNumber(String number) {
        try {
            return convertStringToInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoServiceErrorConfig.STRING_TO_INT_CONVERT_ERROR.getError());
        }
    }

    private static int convertStringToInt(String number) {
        return Integer.parseInt(number);
    }

    public List<Integer> calculateLottoResults(Lottos lottos, List<Integer> winningSixNumbers, Integer winningBonusNumber) {
        List<Integer> lottoMatchResults = new ArrayList<>(Collections.nCopies(5, 0));

        for (Lotto lotto : lottos.lottos()) {
            Integer result = calculateMatchingNumbers(lotto, winningSixNumbers, winningBonusNumber);

            if (!result.equals(LottoWinType.NO_MATCH.getType())) {
                lottoMatchResults.set(result, lottoMatchResults.get(result) + 1);
            }
        }

        return lottoMatchResults;
    }

    private Integer calculateMatchingNumbers(Lotto lotto, List<Integer> winningSixNumbers, Integer winningBonusNumber) {
        List<Integer> numbers = lotto.getNumbers();

        Set<Integer> nowNumber = new HashSet<>(numbers);
        Set<Integer> NowWinningNumber = new HashSet<>(winningSixNumbers);

        boolean winningBonusMatch = nowNumber.contains(winningBonusNumber);
        nowNumber.retainAll(NowWinningNumber);

        if (nowNumber.size() == 3) {
            return LottoWinType.THREE_MATCH.getType();
        } else if (nowNumber.size() == 4) {
            return LottoWinType.FOUR_MATCH.getType();
        } else if (nowNumber.size() == 5) {
            if (winningBonusMatch) {
                return LottoWinType.FIVE_MATCH_WITH_BONUS.getType();
            } else {
                return LottoWinType.FIVE_MATCH.getType();
            }
        } else if (nowNumber.size() == 6) {
            return LottoWinType.SIX_MATCH.getType();
        }
        return LottoWinType.NO_MATCH.getType();
    }

    public Double calculateEarningRate(Money money, List<Integer> lottoMatchResults) {
        BigInteger sumAllResults = BigInteger.ZERO;

        sumAllResults = sumAllResults.add(BigInteger.valueOf(lottoMatchResults.get(LottoWinType.THREE_MATCH.getType()) * LottoPrizeType.THREE_MATCH.getType()));
        sumAllResults = sumAllResults.add(BigInteger.valueOf(lottoMatchResults.get(LottoWinType.FOUR_MATCH.getType()) * LottoPrizeType.FOUR_MATCH.getType()));
        sumAllResults = sumAllResults.add(BigInteger.valueOf(lottoMatchResults.get(LottoWinType.FIVE_MATCH.getType()) * LottoPrizeType.FIVE_MATCH.getType()));
        sumAllResults = sumAllResults.add(BigInteger.valueOf(lottoMatchResults.get(LottoWinType.FIVE_MATCH_WITH_BONUS.getType()) * LottoPrizeType.FIVE_MATCH_WITH_BONUS.getType()));
        sumAllResults = sumAllResults.add(BigInteger.valueOf(lottoMatchResults.get(LottoWinType.SIX_MATCH.getType()) * LottoPrizeType.SIX_MATCH.getType()));

        BigDecimal sumAsDecimal = new BigDecimal(sumAllResults.multiply(BigInteger.valueOf(100)));
        BigDecimal divisor = new BigDecimal(money.getMoney());

        BigDecimal divide = sumAsDecimal.divide(divisor, 2, RoundingMode.HALF_UP);

        return divide.doubleValue();
    }
}
