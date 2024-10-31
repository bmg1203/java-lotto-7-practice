package lotto.validation;

import java.util.HashSet;
import java.util.List;
import lotto.enums.ErrorMessage;

public class LottoNumberValidator {
  private static final int MINIMUM_RANDOM_NUMBER = 1;
  private static final int MAXIMUM_RANDOM_NUMBER = 45;
  private static final int QUANTITY_OF_LOTTO_NUMBERS = 6;

  public static void mainValidator(List<Integer> lottoNumbers) {
    validateNumbers(lottoNumbers);
    validateDuplicate(lottoNumbers);
  }

  public static void validateNumbers(List<Integer> lottoNumbers) {
    if (lottoNumbers.size() != QUANTITY_OF_LOTTO_NUMBERS) {
      throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_QUANTITY.getMessage());
    }
    for (Integer number : lottoNumbers) {
      if (number < MINIMUM_RANDOM_NUMBER || number > MAXIMUM_RANDOM_NUMBER) {
        throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER.getMessage());
      }
    }
  }

  private static void validateDuplicate(List<Integer> lottoNumbers) {
    HashSet<Integer> uniqueNumbers = new HashSet<>();
    for (Integer number : lottoNumbers) {
      if (!uniqueNumbers.add(number)) {
        throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
      }
    }
  }
}
