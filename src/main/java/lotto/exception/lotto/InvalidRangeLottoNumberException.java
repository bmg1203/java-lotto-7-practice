package lotto.exception.lotto;

public class InvalidRangeLottoNumberException extends IllegalArgumentException {
    private final static String ERROR_MESSAGE = "[ERROR] 로또 당첨 번호는 1~45 사이의 정수여야 합니다.";

    public InvalidRangeLottoNumberException() {
        super(ERROR_MESSAGE);
    }
}
