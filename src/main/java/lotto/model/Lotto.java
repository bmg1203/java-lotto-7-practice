package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.utilities.Sorter;
import lotto.validation.LottoNumberValidator;

public class Lotto {
  private static final String LOTTO_NUMBERS_SEPARATER = ", ";
  private final List<Integer> numbers;

  public Lotto(List<Integer> numbers) {
    validate(numbers);
    this.numbers = numbers;
  }

  private void validate(List<Integer> numbers) {
    LottoNumberValidator.mainValidator(numbers);
  }

  public String numbersToString() {
    Sorter.inAscendingOrder(numbers);
    return numbers.stream()
        .map(String::valueOf)
        .collect(Collectors.joining(LOTTO_NUMBERS_SEPARATER));
  }

  public int compareWinningNumbers(List<Integer> winningNumbers) {
    Set<Integer> setOfWinningNumbers = new HashSet<>(winningNumbers);
    Set<Integer> setOfLottoNumbers = new HashSet<>(numbers);

    setOfWinningNumbers.retainAll(setOfLottoNumbers);
    return setOfWinningNumbers.size();
  }

  public boolean compareBonusNumber(Integer bonusNumber) {
    if (numbers.contains(bonusNumber)) {
      return true;
    }
    return false;
  }
}
