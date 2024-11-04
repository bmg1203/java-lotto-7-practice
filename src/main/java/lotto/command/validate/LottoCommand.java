package lotto.command.validate;

import static lotto.common.constant.Lotto.LOTTO_MAXIMUM_NUMBER;
import static lotto.common.constant.Lotto.LOTTO_MINIMUM_NUMBER;

import java.util.ArrayList;
import java.util.List;
import lotto.common.exception.ExceptionEnum;
import lotto.dto.UserInput;
import lotto.dto.WinningLottoUserInput;
import lotto.view.exception.InputException;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 31.
 */
public class LottoCommand implements ValidateCommand {
  private static final String DELIMITER = ", ";
  private static final String ASK = "당첨 번호를 입력해 주세요.";

  @Override
  public UserInput execute(String input) {
    try {
      return validate(input);
    } catch (IllegalArgumentException | IllegalStateException e) {
      view.displayOutput(e.getMessage());
      return redo();
    }
  }

  private WinningLottoUserInput validate(String input) {
    validateBlank(input);
    validateWhiteSpace(input);
    String[] rawNumbers = input.split(DELIMITER);
    return WinningLottoUserInput.from(validateNumbers(rawNumbers));
  }

  private List<Integer> validateNumbers(String[] rawNumbers) {
    List<Integer> lottoNumbers = validateLottoNumbers(rawNumbers);
    validateDistinct(lottoNumbers);
    return lottoNumbers;
  }

  private List<Integer> validateLottoNumbers(String[] rawNumbers) {
    List<Integer> numbers = new ArrayList<>();
    for (String rawNumber : rawNumbers) {
      int value = validateIntegerRange(rawNumber, LOTTO_MINIMUM_NUMBER, LOTTO_MAXIMUM_NUMBER);
      numbers.add(value);
    }
    return numbers;
  }

  private void validateDistinct(List<Integer> lottoNumbers) {
    long distinctCount = lottoNumbers.stream()
        .distinct()
        .count();
    if (distinctCount != lottoNumbers.size()) {
      throw new InputException(ExceptionEnum.IVALID_INPUT);
    }
  }

  @Override
  public String ask() {
    return ASK;
  }
}
