package lotto.util;

public class NumericConverter {

    private static final String ERROR_MESSAGE = "숫자로 변환할 수 없습니다. 입력: %s";

    public static Integer convert(String target) {
        try {
            return Integer.parseInt(target);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format(ERROR_MESSAGE, target), e);
        }
    }
}
