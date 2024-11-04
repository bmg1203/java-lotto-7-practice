package lotto.ui;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoPayment;
import lotto.exception.LottoArgumentException;

public class InputController {

    private final InputUi inputUi;

    public InputController(final InputUi inputUi) {
        this.inputUi = inputUi;
    }

    public LottoPayment getPayment() {
        final String input = this.readTrimmedInput();
        validateNumber(input);
        return new LottoPayment(input);
    }

    public Lotto getLotto() {
        final String input = this.readTrimmedInput();
        final List<String> lottoNumbers = Arrays.stream(input.split(","))
                .map(number -> number.trim())
                .collect(Collectors.toList());
        for (final String number : lottoNumbers) {
            validateNumber(number);
        }
        return new Lotto(lottoNumbers.stream()
                .map(LottoNumber::new).collect(Collectors.toList()));
    }

    public LottoNumber getBonusNumber() {
        final String input = this.readTrimmedInput();
        this.validateNumber(input);
        return new LottoNumber(input);
    }

    private String readTrimmedInput() {
        return inputUi.readLine().trim();
    }

    private void validateNumber(final String numberInput) {
        isBlank(numberInput);
        isPositiveNumber(numberInput);
    }

    private void isBlank(final String numberInput) {
        if (numberInput.isBlank()) {
            throw new LottoArgumentException("공백은 허용되지 않습니다.");
        }
    }

    private void isPositiveNumber(final String numberInput) {
        for (int i = 0; i < numberInput.length(); i++) {
            if (!Character.isDigit(numberInput.charAt(i))) {
                throw new LottoArgumentException("숫자가 아닙니다.");
            }
        }
    }
}
