package lotto.util.validator;

public abstract class Validator<T> {
    protected static final String ERROR_PREFIX = "[ERROR] ";

    abstract void validate(T input);
}
