package lotto.service;

import java.util.List;
import lotto.Lotto;
import lotto.dto.LottoDto;
import lotto.dto.WinningDto;

public class LottoService {

    public WinningDto statisticsNumbers(LottoDto lottoDto) {
        int[] numbers = calculateLottoNumber(lottoDto, lottoDto.getLottos(), lottoDto.getWinningNumbers());
        WinningDto winningDto = WinningDto.of(numbers);
        winningDto.setPrice(totalPrice(winningDto, lottoDto.getLottosSize() * 1000));
        return winningDto;
    }

    private int[] calculateLottoNumber(LottoDto lottoDto, List<Lotto> lottos, List<Integer> winningNumbers) {
        int[] matchStatistics = new int[8];

        for (Lotto lotto : lottos) {
            int matchedCount = countMatchedNumbers(lotto.getSortNumbers(), winningNumbers);
            updateMatchStatistics(lottoDto, lotto, matchedCount, matchStatistics);
        }

        return matchStatistics;
    }

    private int countMatchedNumbers(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        return (int) winningNumbers.stream()
                .filter(lottoNumbers::contains)
                .count();
    }

    private static void updateMatchStatistics(LottoDto lottoDto, Lotto lotto, int matchedCount, int[] matchStatistics) {
        if (isBonusMatch(lottoDto, lotto, matchedCount)) {
            matchStatistics[6]++;
            return;
        }

        if (isValidMatchCount(matchedCount, matchStatistics)) {
            matchStatistics[matchedCount]++;
        }
    }

    private static boolean isValidMatchCount(int matchedCount, int[] matchStatistics) {
        return matchedCount > 0 && matchedCount < matchStatistics.length;
    }

    private static boolean isBonusMatch(LottoDto lottoDto, Lotto lotto, int matchedCount) {
        return matchedCount == 4 && matchedBonusNumber(lottoDto, lotto);
    }

    private static boolean matchedBonusNumber(LottoDto lottoDto, Lotto lotto) {
        return lotto.getSortNumbers().contains(lottoDto.getBonusNumber());
    }

    private double totalPrice(WinningDto winningDto, int buyPrice) {
        return calculateProfit(getTotalPrize(winningDto), buyPrice);
    }

    private static int getTotalPrize(WinningDto winningDto) {
        return winningDto.getWinningCount().entrySet().stream()
                .filter(entry -> entry.getValue() != 0)
                .mapToInt(entry -> entry.getKey().prizeMoney * entry.getValue())
                .sum();
    }

    private double calculateProfit(int totalPrize, int buyPrice) {
        return ((double) totalPrize / buyPrice) * 100;    // 수익률 계산: (당첨금 / 구매금액) * 100
    }

}
