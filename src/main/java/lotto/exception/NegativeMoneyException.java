package lotto.exception;

public class NegativeMoneyException extends IllegalArgumentException {
    private final static String ERROR_MESSAGE = "[ERROR] 입력 금액은 양의 정수여야 합니다.";

    public NegativeMoneyException() {
        super(ERROR_MESSAGE);
    }
}