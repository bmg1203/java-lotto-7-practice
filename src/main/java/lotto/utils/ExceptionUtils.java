package lotto.utils;

public class ExceptionUtils {
    private static final String ERROR_MESSAGE = "[ERROR] %s";

    private ExceptionUtils() {
    }

    public static void throwIllegalArgument(String message) {
        throw  new IllegalArgumentException(formatMessage(message));
    }

    public static void throwIllegalState(String message) {
        throw new IllegalStateException(formatMessage(message));
    }

    private static String formatMessage(String message) {
        return String.format(ERROR_MESSAGE, message);
    }
}
