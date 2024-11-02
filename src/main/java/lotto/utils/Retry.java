package lotto.utils;

import java.util.function.Supplier;

public class Retry {

    private Retry(){
    }

    public static <T> T retryOnException(final Supplier<T> operation) {
        try {
            return operation.get();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return retryOnException(operation);
        }
    }
}