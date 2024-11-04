package lotto.service;

import static lotto.eunm.LottoConstants.*;
import static lotto.eunm.WinningResult.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.dto.LottoDto;
import lotto.dto.WinningDto;

public class LottoService {

    private static final String FORMAT_PATTERN = "#,##0.0";
    private static final double ROUNDING_BASE = 100.0;
    private static final int INCREMENT_VALUE = 1;
    
    public WinningDto statisticsNumbers(LottoDto lottoDto) {
        List<Integer> matchStatistics = calculateLottoNumber(lottoDto, lottoDto.getLottos(),
                lottoDto.getWinningNumbers());
        WinningDto winningDto = WinningDto.of(matchStatistics);
        winningDto.setPrice(totalPrice(winningDto, lottoDto.getLottosSize() * TICKET_PRICE_UNIT.value));
        return winningDto;
    }

    private List<Integer> calculateLottoNumber(LottoDto lottoDto, List<Lotto> lottos, List<Integer> winningNumbers) {
        List<Integer> matchStatistics = initializeMatchStatistics();

        for (Lotto lotto : lottos) {
            processLotto(lottoDto, winningNumbers, matchStatistics, lotto);
        }

        return matchStatistics;
    }

    private List<Integer> initializeMatchStatistics() {
        return new ArrayList<>(
                List.of(MINIMUM_NUMBER.value, MINIMUM_NUMBER.value, MINIMUM_NUMBER.value, MINIMUM_NUMBER.value,
                        MINIMUM_NUMBER.value, MINIMUM_NUMBER.value, MINIMUM_NUMBER.value, MINIMUM_NUMBER.value));
    }

    private void processLotto(LottoDto lottoDto, List<Integer> winningNumbers, List<Integer> matchStatistics,
                              Lotto lotto) {
        int matchedCount = countMatchedNumbers(lotto.getSortNumbers(), winningNumbers);
        updateMatchStatistics(lottoDto, lotto, matchedCount, matchStatistics);
    }

    private static void updateMatchStatistics(LottoDto lottoDto, Lotto lotto, int matchedCount,
                                              List<Integer> matchStatistics) {
        if (isBonusMatch(lottoDto, lotto, matchedCount)) {
            matchStatistics.set(FIVE_AND_BONUS.index, matchStatistics.get(FIVE_AND_BONUS.index) + INCREMENT_VALUE);
            return;
        }

        if (isValidMatchCount(matchedCount, matchStatistics)) {
            matchStatistics.set(matchedCount, matchStatistics.get(matchedCount) + INCREMENT_VALUE);
        }
    }

    private int countMatchedNumbers(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        long matchedCount = winningNumbers.stream()
                .filter(lottoNumbers::contains)
                .count();

        if (matchedCount == SIX.winningCount) {
            return SIX.index;
        }

        return (int) matchedCount;
    }

    private static boolean isValidMatchCount(int matchedCount, List<Integer> matchStatistics) {
        return matchedCount > MINIMUM_NUMBER.value && matchedCount < matchStatistics.size();
    }

    private static boolean isBonusMatch(LottoDto lottoDto, Lotto lotto, int matchedCount) {
        return matchedCount == FIVE.winningCount && matchedBonusNumber(lottoDto, lotto);
    }

    private static boolean matchedBonusNumber(LottoDto lottoDto, Lotto lotto) {
        return lotto.getSortNumbers().contains(lottoDto.getBonusNumber());
    }

    private String totalPrice(WinningDto winningDto, int buyPrice) {
        return calculateProfit(getTotalPrize(winningDto), buyPrice);
    }

    private static int getTotalPrize(WinningDto winningDto) {
        return winningDto.getWinningCount().entrySet().stream()
                .filter(entry -> entry.getValue() != MINIMUM_NUMBER.value)
                .mapToInt(entry -> entry.getKey().prizeMoney * entry.getValue())
                .sum();
    }

    private static String calculateProfit(int totalPrize, int buyPrice) {
        double profitPercentage = calculateProfitPercentage(totalPrize, buyPrice);
        return formatProfitPercentage(profitPercentage);
    }

    private static double calculateProfitPercentage(int totalPrize, int buyPrice) {
        return ((double) totalPrize / buyPrice) * PERCENTAGE_BASE.value;
    }

    private static String formatProfitPercentage(double profitPercentage) {
        profitPercentage = Math.round(profitPercentage * PERCENTAGE_BASE.value) / ROUNDING_BASE;
        DecimalFormat decimalFormat = new DecimalFormat(FORMAT_PATTERN);
        return decimalFormat.format(profitPercentage);
    }
}