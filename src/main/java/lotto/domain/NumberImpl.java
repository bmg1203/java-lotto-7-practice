package lotto.domain;

import static lotto.common.ErrorMessage.ERROR_MESSAGE;

public abstract class NumberImpl implements Number {

    public void validateBlank(String number, String message) {
        if (hasContent(number)) return;
        throw new IllegalArgumentException( ERROR_MESSAGE + " " +message +"은 공백일 수 없습니다.");
    }

    public void validateNumber(String number, String message) {
        if (isPositive(number))
            return;
        throw new IllegalArgumentException(ERROR_MESSAGE + " " +message +"은 양수여야 합니다.");
    }

    public void validateRange(Integer money, String message) {
        if (isInRange(money))
            return;
        throw new IllegalArgumentException(ERROR_MESSAGE + " " +message +"는 1~45 사이의 숫자여야 합니다.");
    }

    public boolean hasContent(String number ) {
        return number != null && !number.isEmpty();
    }

    public boolean isPositive(String number) {
        return number.matches("\\d+");
    }

    public boolean isInRange(Integer number) {
        return number >= 1 && number <= 45;
    }

    abstract String getDomain();
}
