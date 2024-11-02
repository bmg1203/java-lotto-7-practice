package lotto.commons.handler;

import java.util.function.Supplier;
import lotto.commons.logger.Logger;

public class Handler {

    public static <T> T runCatchingIllegalArgumentException(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            Logger.error(e);
            return null;
        }
    }

    public static <T> T runCatching(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (Throwable t) {
            Logger.error(t);
            return null;
        }
    }
}
