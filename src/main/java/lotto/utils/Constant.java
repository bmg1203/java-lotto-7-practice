package lotto.utils;

public class Constant {
    public final static String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    public final static String LOTTO_PURCHASE_COUNT_MESSAGE = "%d개를 구매했습니다.";
    public final static String WINNING_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";

    public static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    public static final String INTEGER_REGEX = "[0-9]+";

    public static final int MIN_PURCHASE_AMOUNT = 1000;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int MAX_LOTTO_NUMBER_COUNT = 6;

    private Constant() {
    }
}
