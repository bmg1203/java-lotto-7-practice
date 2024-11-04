package lotto.service;

import static lotto.config.LottoConstants.LOTTO_END_NUMBER;
import static lotto.config.LottoConstants.LOTTO_NUMBER_COUNT;
import static lotto.config.LottoConstants.LOTTO_PRICE;
import static lotto.config.LottoConstants.LOTTO_START_NUMBER;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.config.ErrorMessage;
import lotto.config.LottoRule;
import lotto.config.SystemConstants;
import lotto.model.Lotto;
import lotto.model.LottoReport;
import lotto.repository.LottoRepository;

public class LottoServiceImpl implements LottoService {
    private final LottoRepository lottoRepository;

    public LottoServiceImpl(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    @Override
    public void purchaseLotto(String purchaseAmount) {
        int numericPurchaseAmount = safeParsePurchaseAmount(purchaseAmount);

        lottoRepository.generateRandomLottos(numericPurchaseAmount);
    }

    @Override
    public List<String> generateLottoLogs() {
        return lottoRepository.findAll()
                .stream()
                .map(Lotto::toString)
                .toList();
    }

    @Override
    public LottoReport generateLottoReport(String purchaseAmount, String winningNumbers, String bonusNumber) {
        List<Integer> numericWinningNumbers = parseIntegerList(winningNumbers);
        int numericBonusNumber = safeParseBonusNumber(bonusNumber);
        validateLottoNumbers(numericWinningNumbers);
        validateLottoNumber(numericBonusNumber);

        List<LottoRule> lottoRuleList = lottoRepository.generatePrizeListBy(numericWinningNumbers, numericBonusNumber);
        List<String> winningReport = generateWinningReport(lottoRuleList);
        double profitRate = computeProfitRate(lottoRuleList, safeParsePurchaseAmount(purchaseAmount));

        return new LottoReport(winningReport, profitRate);
    }

    private List<String> generateWinningReport(List<LottoRule> lottoRuleList) {
        Map<LottoRule, Long> prizeCountMap = countPrizes(lottoRuleList);

        return Arrays.stream(LottoRule.values())
                .filter(i -> i != LottoRule.NONE)
                .sorted(Comparator.reverseOrder())
                .map(i -> formatPrizeReport(i, prizeCountMap))
                .toList();
    }

    private Map<LottoRule, Long> countPrizes(List<LottoRule> lottoRuleList) {
        return lottoRuleList.stream()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));
    }

    private String formatPrizeReport(LottoRule rule, Map<LottoRule, Long> prizeCountMap) {
        return String.format(SystemConstants.LOTTO_SERVICE_PRIZE_REPORT_FORMAT,
                rule.getMatchCount(),
                getBonusText(rule),
                formatPrize(rule),
                prizeCountMap.getOrDefault(rule, 0L));
    }

    private String getBonusText(LottoRule rule) {
        if (rule.isHasBonus()) {
            return SystemConstants.LOTTO_SERVICE_PRIZE_REPORT_HAS_BONUS;
        }
        return "";
    }

    private String formatPrize(LottoRule rule) {
        return String.format(SystemConstants.LOTTO_SERVICE_PRIZE_REPORT_INNER_FORMAT, rule.getPrize());
    }

    private double computeProfitRate(List<LottoRule> lottoRuleList, int purchaseAmount){
        return (double) calculateTotalPrize(lottoRuleList) / purchaseAmount;
    }

    private int calculateTotalPrize(List<LottoRule> lottoRuleList) {
        return lottoRuleList.stream()
                .map(LottoRule::getPrize)
                .mapToInt(Integer::intValue)
                .sum();
    }

    private int safeParsePurchaseAmount(String stringInput) {
        validateNullInput(stringInput);
        try {
            int amount = Integer.parseInt(stringInput);
            validatePositive(amount);
            validateDivisibleByLottoPrice(amount);
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_NOT_NUMERIC.getMessage(), e);
        }
    }

    private List<Integer> parseIntegerList(String stringInput) {
        validateNullInput(stringInput);
        List<String> splitList = Arrays.stream(
                stringInput.split(SystemConstants.LOTTO_SERVICE_WINNING_NUMBERS_SEPARATOR))
                .toList();
        splitList.forEach(this::validateNullInput);
        return splitList
                .stream()
                .map(Integer::parseInt)
                .toList();
    }

    private void validateNullInput(String stringInput) {
        if (stringInput == null || stringInput.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_PURCHASE_AMOUNT_EMPTY.getMessage());
        }
    }

    private void validatePositive(int amount) {
        if (amount < LOTTO_PRICE.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_PURCHASE_AMOUNT_LACK.getMessage());
        }
    }

    private void validateDivisibleByLottoPrice(int amount) {
        if (amount % LOTTO_PRICE.getValue() != 0) {
                throw new IllegalArgumentException(
                        ErrorMessage.INVALID_INPUT_PURCHASE_AMOUNT_CANNOT_DIVIDE.getMessage()
                );
        }
    }

    public void validateLottoNumbers(String inputString) {
        List<Integer> numericLottoNumbers = parseIntegerList(inputString);
        validateSize(numericLottoNumbers);
        numericLottoNumbers.forEach(this::validateLottoNumber);
    }

    private void validateLottoNumbers(List<Integer> numbers) {
        validateSize(numbers);
        numbers.forEach(this::validateLottoNumber);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_LOTTO_COUNT.getMessage());
        }
    }

    private int safeParseBonusNumber(String stringInput) {
        validateNullInput(stringInput);
        try {
            int amount = Integer.parseInt(stringInput);
            validateLottoNumber(amount);
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_NOT_NUMERIC.getMessage(), e);
        }
    }

    private void validateLottoNumber(Integer number) {
        if (number < LOTTO_START_NUMBER.getValue() || number > LOTTO_END_NUMBER.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_LOTTO_RANGE.getMessage());
        }
    }
}
