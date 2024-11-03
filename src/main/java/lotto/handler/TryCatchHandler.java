package lotto.handler;

public class TryCatchHandler<T> {
    public T execute(Operation<T> operation) {
        T result = null;

        while (result == null) {
            try {
                result = operation.execute();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return result;
    }
}
