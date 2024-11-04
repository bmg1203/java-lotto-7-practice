package lotto.controller;

public class LottoPolicy implements Policy {
    //TODO : validator
    public static int LOTTO_AMOUNT = 1000;
    public static int MIN_NUMBER = 1;
    public static int MAX_NUMBER = 45;
    public static int WINNING_NUMBER_COUNT = 6;
    public static String DELIMITER = ",";
    public static int ZERO = 0;
    public static String INTEGER_REGEX = "[-+]?\\d+";

    @Override
    public int getAmountPolicy() {
        return LOTTO_AMOUNT;
    }

    @Override
    public boolean isAmountPositive(int number) {
        if (number > ZERO) {
            return true;
        }
        return false;
    }

    @Override
    public int getMinNumberLimit() {
        return MIN_NUMBER;
    }

    @Override
    public int getMaxNumberLimit() {
        return MAX_NUMBER;
    }

    @Override
    public int getWinningNumberCount() {
        return WINNING_NUMBER_COUNT;
    }

    @Override
    public String getDelimiter() {
        return DELIMITER;
    }

    @Override
    public String getIntegerRegex() {
        return INTEGER_REGEX;
    }

    @Override
    public int getZero() {
        return ZERO;
    }
}
